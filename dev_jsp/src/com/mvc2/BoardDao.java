package com.mvc2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
/* 단점)
 * Mybatis의 전신인 iBatis의 경우에는 스레드에 안전한 sqlMaoClient 클래스가 사라졌다.
 * SqlMapClient객체 대신 스레드에 안전하지 않은 SqlSession객체를 사용하여 질의를 수행함.
 * SqlSession이 스레드에 안전하지 않은 이유는 요청(request) 또는 메소드 범위의 객체이기 때문이다.
 * 또 SqlSession은 SqlMapClient와 달리 반드시 사용한 자원을 해제해야 한다.
 * 장점)
 * 트랜잭션을 시작하는 메소드가 없이도 트랜잭션을 처리할 수 있다.
 * HOW?
 * 왜 자원 해제의 누락으로 애플리케이션의 안전성을 해칠 수도 있는 로직을 개발자에게 떠 넘긴 걸까?
 * 
 * MyBatis 프레임워크를 Spring프레임워크와 결합하여 SqlSessionTemplate클래스를
 * 사용하면 자원 해제에 대한 문제는 고려하지 않아도 된다.
 */
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public BoardDao() {
		  sqlSessionFactory =
				  MyBatisCommonFactory.getSqlSessionFactory();
	}
	/***************INSERT***************/
	public int boardSubAdd(BoardSubVO bsVO) {
		logger.info("boardSubAdd 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardSubAdd",bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;		
	}
	public int boardMasterAdd(BoardMasterVO bmVO) {
		logger.info("boardMasterAdd 호출");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMasterAdd",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	/***************UPDATE***************/
	public int boardSubUpd(BoardSubVO bsVO) {
		logger.info("boardSubUpd 호출");
		// TODO Auto-generated method stub
		return 0;
	}
	public int boardMasterUpd(BoardMasterVO bmVO) {
		logger.info("boardMasterUpd 호출");
		int result = 0;
		try {
			//onpenSession(),openSession(boolean autocommit);
			/*
			 * con.setAutoCommit(false);
			 * con.commit();
			 */
			sqlSession = sqlSessionFactory.openSession(false);
			result = sqlSession.update("boardMasterUpd",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//사용한 자원 반납하기
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	/***************DELETE***************/
	public int boardSubDel(BoardSubVO bsVO) {
		logger.info("boardSubDel 호출성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardSubDel",bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	public int boardMasterDel(BoardMasterVO bmVO) {
		logger.info("boardMasterDel 호출성공");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMasterDel",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	public int getTotal(BoardMasterVO bmVO) {
		logger.info("getTotal 호출");
		int tot = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			tot = sqlSession.selectOne("getTotal",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return tot;
	}
	public int hitCount(int bm_no) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			bm_no = sqlSession.update("hitCount",bm_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	public int getBmno() {
		int bm_no = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			bm_no = sqlSession.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return bm_no;
	}
	public int bmStepUpdate(BoardMasterVO bmVO) {
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bmStepUpdate",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}
	public int getBmgroup() {
		int bm_group = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			bm_group = sqlSession.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return bm_group;
	}
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("boardList(bmVO) 호출");
		List<Map<String, Object>> boardList = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return boardList;
	}
	public String tansactionTest() {
		String msg = null;
		int result = 0;
		int result2 = 0;
		try {
			sqlSession = sqlSessionFactory.openSession(false);
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("deptno", 67);
			pMap.put("dname", "기술영업");
			pMap.put("loc", "서울");
			pMap.put("empno", 9100);
			pMap.put("ename", "이순신");
			pMap.put("job", "SALESMAN");
			pMap.put("mgr", 4100);
			pMap.put("sal", 4500.0);
			pMap.put("comm", 350.0);
			result = sqlSession.update("depInsert",pMap);
			result2 = sqlSession.update("empInsert",pMap);
			if(result == 1 && result2 == 1) {
				msg = "모두 정상처리 되었습니다";
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null)sqlSession.close();
		}
		return msg;
	}
}
