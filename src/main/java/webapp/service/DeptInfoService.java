package webapp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import webapp.dao.DeptDao;
import webapp.exception.ConnectionFailException;
import webapp.exception.DeptAccessException;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.util.EmployeeDataSource;
import webapp.util.GlobalVars;

public class DeptInfoService {
	DeptDao deptdao;
	DataSource dataSource;

	public void setDeptdao(DeptDao deptdao) {
		this.deptdao = deptdao;
	}

	public void setDatasource(DataSource datasource) {
		this.dataSource = datasource;
	}

	public Dept getDeptInfo(Integer deptno) {

		Dept dept = deptdao.selectByDeptno(deptno);


		return dept;
	}
	
	public Dept getDeptInfoWithEmps(Integer deptno){
			
		Dept dept = deptdao.selectByDeptnoWithEmps(deptno);
	
		return dept;
	}
	
	public List<Dept> getDeptInfoAll(){
		
		List<Dept> list = deptdao.selectAll();
		
		return list;
	}

}
