package com.mvc1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.ZipCodeVO;

public class ZipCodeDao {
	Logger logger = Logger.getLogger(ZipCodeDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	/*******************************************************
	 * 
	 * @param dong 사용자로부터 동 정보는 입력 받아서 처리함
	 * @return 조회결과가 n건인 경우도 있을수 있으니깐 List<ZipCodeVO>로 함
	 ******************************************************/
	public ZipCodeDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		// 테스트시 Exception발생하면 화면을 볼 수 없으므로 초기화 진행함
		List<ZipCodeVO> zipcodeList = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			zipcodeList = sqlSession.selectList("zipcodeList", zVO);
			logger.info(""+zipcodeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}
}
