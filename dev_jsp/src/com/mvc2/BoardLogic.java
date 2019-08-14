package com.mvc2;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	BoardDao bDao = null;
	//전역변수 total
	//값을 어디서 가져오지? - getTot():int
	//getTot에서 반환된 값을 어디서 사용해야되지? - boardList()
	int total = 0;
	public BoardLogic() {
		bDao = new BoardDao();
	}
	public int getTot(BoardMasterVO bmVO) {
		total = 0;
		total = bDao.getTotal(bmVO);
		return total;
	}
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO){
		logger.info("boardList 호출");
		List<Map<String, Object>> boardList = null;
		total = getTot(bmVO);
		//현재 바라보는 페이지 번호
		int pageNumber = 0;//2
		//한 페이지에 뿌려질 수
		int pageSize = 0;//2
		//시작번호
		int start = 0;
		//끝 번호
		int end = 0;
		if(bmVO.getPageNumber()>0) {
			pageNumber = bmVO.getPageNumber();
		}
		if(bmVO.getPageSize()>0) {
			pageSize = bmVO.getPageSize();
		}
		if(pageNumber>0) {
			start = ((pageNumber-1)*pageSize)+1; //3
			end = pageNumber * pageSize; //4
			bmVO.setStart(start);
			if(end>total) {
				bmVO.setEnd(total);
			}else {
				bmVO.setEnd(end);
			}
		}
		boardList = bDao.boardList(bmVO);
/*
 * 클래스 설계시 전체 조회 혹은 조건 검색 그리고 상세조회로 나누어 처리한다.
 * 전체조회 조건검색, 상세조회 모두 같은 프로세스를 태워도 상관 없으나
 * 이렇게 처리할 경우 메소드 안에 분기문 처리를 해야 하고 이것은 가독을 떨어뜨리고
 * 업무에 대한 처리 메소드가 밖으로 드러나지 않게 된다.
 * 유지 보수 업무에 경우 기존 개발자 보다 적은 개발자가 통합 관리하게 되므로
 * 유지 보수를 생각 한다면 업무에 따른 메소드 구분이나 클래스 설계시 이러한 부분을 고려하여
 * 설계하는 것이 기본이다.
 * 여기서도 3가지가 모두 비슷한 업무이지만 Logic과 Dao는 공유하되 Controller는 분리시킴으로써
 * 응답화면을 분리하여 관리하도록 설계하였다.
 */
		//size가 1이면 한건 조회가 성공한 경우 이믈 이때만 조회수를 카운트 하여 처리한다.
		//결함 - 만일 조건 검색으로 인한 결과가 똑같이 한 건일때는 어떻게 분리해야 할까요?
		if(boardList.size()==1 && "detail".equals(bmVO.getGubun())) {
			int bm_no = bmVO.getBm_no();
			bDao.hitCount(bm_no);
		}
		return boardList;
	}
	public int boardAdd(Map<String, Object> pMap){
		logger.info("boardAdd 호출");
		int bm_no = 0;
		int bm_group = 0;
		logger.info("pMap.get(\"bm_group\"): "+pMap.get("bm_group"));
		if(pMap.get("bm_group")!=null) {//NullPointerException을 방어하는 코드
			bm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		int mresult = 0;
		int sresult = 0;
		bm_no = bDao.getBmno();
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		bmVO.setBm_no(bm_no);
		bmVO.setBm_title(pMap.get("bm_title").toString());
		bmVO.setBm_writer(pMap.get("bm_writer").toString());
		bmVO.setBm_content(pMap.get("bm_content").toString());
		bmVO.setBm_pw(pMap.get("bm_pw").toString());
		bmVO.setBm_email(pMap.get("bm_email").toString());
		bmVO.setBm_group(bm_group);
		bmVO.setBm_pos(Integer.parseInt(pMap.get("bm_pos").toString()));
		bmVO.setBm_step(Integer.parseInt(pMap.get("bm_step").toString()));
		if(bm_group>0) {//댓글 일 때
			bDao.bmStepUpdate(bmVO);
			bmVO.setBm_pos(bmVO.getBm_pos()+1);			
			bmVO.setBm_step(bmVO.getBm_step()+1);			
		}
		else {//새글 일때
			bm_group = bDao.getBmgroup();
			bmVO.setBm_group(bm_group);
			bmVO.setBm_pos(0);
			bmVO.setBm_step(0);
		}
		//공통 처리부분
		mresult = bDao.boardMasterAdd(bmVO);
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			bsVO.setBm_no(bm_no);
			bsVO.setBs_file(pMap.get("bs_file").toString());
			bsVO.setBs_size(Double.parseDouble(pMap.get("bs_size").toString()));
			
			sresult = bDao.boardSubAdd(bsVO);
			return sresult;
		}
		return mresult;
	}
	public int boardUpd(Map<String, Object> pMap) {
		logger.info("boardUpd 호출");
		int mresult = 0;
		BoardMasterVO bmVO = new BoardMasterVO();
		bmVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
		bmVO.setBm_title(pMap.get("bm_title").toString());
		bmVO.setBm_writer(pMap.get("bm_writer").toString());
		bmVO.setBm_content(pMap.get("bm_content").toString());
		bmVO.setBm_pw(pMap.get("bm_pw").toString());
		bmVO.setBm_email(pMap.get("bm_email").toString());
		mresult = bDao.boardMasterUpd(bmVO);
		return mresult;
	}
	public int boardDel(Map<String, Object> pMap) {
		logger.info("boardDel 호출");
		int result = 0;
		int mresult = 0;
		int sresult = 0;
		String filePath = "D:\\workspace_jsp\\dev_jsp\\WebContent\\pds\\";
		//file객체 생성시 경로정보가 필수 이므로
		String filename = null;
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		if(pMap.get("bm_no")!=null) {
			bsVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
			bsVO.setBs_seq(1);
			bmVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
		}
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			filename = pMap.get("bs_file").toString();
			String fullPath = filePath+filename;
			File file = new File(fullPath);
			if(file.exists()) {//그 파일이 서버에 존재하니?
				boolean isOk = file.delete();
				logger.info("삭제유무: "+isOk);
				int ibm_no = 0;
				sresult = bDao.boardSubDel(bsVO);
			}
		}
		//첨부파일이 없을 때
		
		//공통 처리부분
		mresult = bDao.boardMasterDel(bmVO);
		return mresult;
	}
	public String tansactionTest() {
		String msg = null;
		msg = bDao.tansactionTest();
		return msg;
	}
}
