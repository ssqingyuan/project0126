package com.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.Emp;

public interface EmpDao {
	public Emp getEmpById(int empid);

	public List<Emp> getAll();

	public Emp getEmp(@Param("empName") String empName, @Param("password") String password);

}
