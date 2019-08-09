package com.mvc2;

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
		int sresult = 0;
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		//첨부파일이 있을 때
		sresult = bDao.boardSubUpd(bsVO);
		//첨부파일이 없을 때
		
		//공통 처리부분
		mresult = bDao.boardMasterUpd(bmVO);
		return mresult;
	}
	public int boardDel(Map<String, Object> pMap) {
		logger.info("boardDel 호출");
		int result = 0;
		int mresult = 0;
		int sresult = 0;
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		//첨부파일이 있을 때
		sresult = bDao.boardSubDel(bsVO);
		//첨부파일이 없을 때
		
		//공통 처리부분
		mresult = bDao.boardMasterDel(bmVO);
		return result;
	}
}
