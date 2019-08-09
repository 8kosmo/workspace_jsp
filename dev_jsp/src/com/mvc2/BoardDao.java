package com.mvc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	public BoardDao() {
		  sqlSessionFactory =
				  MyBatisCommonFactory.getSqlSessionFactory();
	}
	/***************INSERT***************/
	public int boardSubAdd(BoardSubVO bsVO) {
		logger.info("boardSubAdd 호출");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardSubAdd",bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	public int boardMasterAdd(BoardMasterVO bmVO) {
		logger.info("boardMasterAdd 호출");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMasterAdd",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
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
		// TODO Auto-generated method stub
		return 0;
	}
	/***************DELETE***************/
	public int boardSubDel(BoardSubVO bsVO) {
		logger.info("boardSubDel 호출성공");
		// TODO Auto-generated method stub
		return 0;
	}
	public int boardMasterDel(BoardMasterVO bmVO) {
		logger.info("boardMasterDel 호출성공");
		// TODO Auto-generated method stub
		return 0;
	}
	public int getTotal(BoardMasterVO bmVO) {
		logger.info("getTotal 호출");
		int tot = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			tot = sqlSession.selectOne("getTotal",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tot;
	}
	public int getBmno() {
		int bm_no = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			bm_no = sqlSession.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_no;
	}
	public int bmStepUpdate(BoardMasterVO bmVO) {
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bmStepUpdate",bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getBmgroup() {
		int bm_group = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			bm_group = sqlSession.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_group;
	}
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("boardList(bmVO) 호출");
		List<Map<String, Object>> boardList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
}
