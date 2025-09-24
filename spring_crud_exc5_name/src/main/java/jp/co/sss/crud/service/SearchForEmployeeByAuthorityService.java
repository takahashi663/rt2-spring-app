package jp.co.sss.crud.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;

@Service
public class SearchForEmployeeByAuthorityService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public List<EmployeeBean> execute(Integer authority) {

		List<Employee> empList = repository.findByAuthority(authority);
		List<EmployeeBean> returnEmployeeBeans  = BeanManager.copyEntityListToBeanList(empList);

		return returnEmployeeBeans;
	}
}
