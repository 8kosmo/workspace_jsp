package com.mvc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;

public class MyProcSimulation {
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public MyProcSimulation() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Map<String, Object> pMap = new HashMap<>();
			sqlSession.selectOne("MY_PROC",pMap);
			Object keys[] = pMap.keySet().toArray(); // 키값을 배열로 담음
			// sys_refcursor가 어떤 자료형으로 담아주는지 반드시 체크
			// 파라미터 타입을 Map으로 하였으나 그안에 자료구조가 List형인지 반드시 점검

			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Iterator iter2 = list.iterator();
			while(iter2.hasNext()) {
				String s= (String)iter2.next();
				DeptVO dVO = (DeptVO)iter2.next();
				System.out.println(dVO.getDeptno());
				System.out.println(dVO.getDname());
				System.out.println(dVO.getLoc());
			}
			for(int i=0; i<keys.length; i++) {
				String value = (String) pMap.get(keys[i]);
				System.out.println(value); //Object출력 or 주소번지출력
			}
			if(pMap instanceof HashMap) {
				System.out.println("여기");
			}
			System.out.println(pMap.getClass()); // 실제 타입 확인 가능
			System.out.println(pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MyProcSimulation();
	}

}
