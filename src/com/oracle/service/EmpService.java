package com.oracle.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.dao.EmpDao;
import com.oracle.util.MybatisUtil;
import com.oracle.vo.Emp;

public class EmpService {
	public Emp getEmp(String empname, String password) {
		try (SqlSession session = MybatisUtil.getSession()) {
			EmpDao ed = session.getMapper(EmpDao.class);
			Emp emp = ed.getEmp(empname, password);
			session.commit();
			return emp;
		}
	}

	public List<Emp> getAll() {
		List<Emp> list = null;
		try (SqlSession session = MybatisUtil.getSession()) {
			EmpDao ed = session.getMapper(EmpDao.class);
			list = ed.getAll();
			session.commit();
		}
		return list;
	}

	public Emp getEmpById(int empid) {
		try (SqlSession session = MybatisUtil.getSession()) {
			EmpDao ed = session.getMapper(EmpDao.class);
			Emp emp = (Emp)ed.getEmpById(empid);
			session.commit();
			return emp;
		}
	}
}
