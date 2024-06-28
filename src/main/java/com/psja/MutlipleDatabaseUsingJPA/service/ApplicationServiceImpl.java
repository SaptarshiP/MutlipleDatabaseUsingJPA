package com.psja.MutlipleDatabaseUsingJPA.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.psja.MutlipleDatabaseUsingJPA.entity.employee.EmployeeEntity;
import com.psja.MutlipleDatabaseUsingJPA.entity.user.UserEntity;
import com.psja.MutlipleDatabaseUsingJPA.persistence.employee.EmployeeRepository;
import com.psja.MutlipleDatabaseUsingJPA.persistence.user.UserRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	private EmployeeRepository empRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional("userTransactionManager")
	public void saveUserData( String userName, String userAddress ) {
		try {
			UserEntity userEntity = new UserEntity();
			//userEntity.setId("test001");
			userEntity.setUserAddress(userAddress);
			userEntity.setUserName(userName);
		
			userRepository.save( userEntity );
		}catch( Exception exp ) {
			System.out.println(exp.getMessage());
		}
	}
	
	@Override
	@Transactional("employeeTransactionManager")
	public void saveEmployeeData(String empName, String empAddress) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeAddress(empAddress);
		employeeEntity.setEmployeeName(empName);
		
		empRepository.save( employeeEntity );
	}
}
