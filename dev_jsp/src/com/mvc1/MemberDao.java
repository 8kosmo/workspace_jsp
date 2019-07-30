package com.mvc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	public MemberDao() {
		//insert here
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public String currentTime() {
		//DML 호출 뿐 아니라 커밋과 롤백도 처리 할 수 있음.
		/*
		 * select 할 때
		 * sqlSession.selectList()==>List로 반환
		 * sqlSession.selectOne()==> 여기서 One은 Object임
		 * sqlSession.selectMap()==> Map으로 반환
		 * insert 할 때 ->리턴 타입은 Object임.
		 * sqlSession.insert("아이디",파라미터);
		 * update 할 때  ->리턴 타입은 int임
		 * sqlSession.update("아이디",파라미터);
		 * delete 할 때 ->리턴 타입은 int임
		 * sqlSession.delete("아이디",파라미터);
		 * 
		 * 과제
		 * MemberDao를 단위 테스트 할 수 있는 클래스를 선언하고
		 * currentTime메소드를 호출 하여 현재 시간 정보(오라클 서버가 제공)를
		 * 출력하는 문장을 작성해 보시오. 
		 */
		String time = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			time = sqlSession.selectOne("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	/*
	 * 입력, 수정, 삭제시 주의사항
	 * 자바에서 JDBC API를 활용할 때는 con.setAutocommit(true)가 디폴트임
	 * 따라서 별도로 끄지 않으면 커밋이 되었으나
	 * myBatis에서는 false가 디폴트 이므로 반드시 커밋 처리 할 것.
	 * 관찰하기
	 * 요청 파라미터의 이름과 메소드 이름 그리고 myBatis의 아이디는 무조건 통일하여 사용할 것.
	 */
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출 성공");
		logger.info("pMap.get(mem_id)==>"+pMap.get("mem_id"));
		logger.info("pMap.get(mem_name)==>"+pMap.get("mem_name"));
		logger.info("pMap.get(mem_addr)==>"+pMap.get("mem_addr"));
		logger.info("pMap.get(mem_zipcode)==>"+pMap.get("mem_zipcode"));
		logger.info("pMap.get(mem_pw)==>"+pMap.get("mem_pw"));
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("memberInsert", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Map<String, Object>> memberList() {
		/*
		 * 웹페이지는 Exception이 발생하면 화면을 확인할 수가 없다.
		 * 따라서 에러상황을 파악하는데 화면이 필요할 때는 초기화를 반드시 해줌
		 */
		List<Map<String, Object>> memList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			memList = sqlSession.selectList("memberList");
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memList;
	}
	public String isId(MemberVO pmVO) {
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("isId",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}
	public String login(MemberVO pmVO) {
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("login",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}
	public MemberVO proc_login(MemberVO pmVO) {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
/*
 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 out속성의 값이 담긴다는 사실이다.
 */
			sqlSession.selectOne("proc_login",pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	
/*
* 리턴타입과 파라미터 타입이 서로 같은 객체
* 커서 사용시 조인이 있을 때는 map 사용
* 테이블이 2개 이상이므로  파라미터에 두개를 처리 불가 (vo타입 사용 안됨)
*/	
	public MemberVO MY_PROC(MemberVO pmVO) {
		try {
			/*
			 * 138번 Line NullPointerException
			 * 원시적 방법에는 문제해결이 비교적 쉽다
			 * SQLException
			 * 1)커넥션 설정
			 * 2)xml문서 경로
			 * 3)같은 아이디 존재
			 * 4)아이디 대소문자 구분
			 * 5)parameter#1, #2, #3 부적합한 열 유형 1111
			 */
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("MY_PROC",pmVO);
			logger.info(pmVO);
			logger.info(pmVO.getClass());
			logger.info(pmVO.getMem_id());
			logger.info(pmVO.getMem_name());
			logger.info(pmVO.getMem_pw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	public Map<String, Object> MY_PROC2(Map<String, Object> pMap) {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("MY_PROC",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pMap;
	}
}
