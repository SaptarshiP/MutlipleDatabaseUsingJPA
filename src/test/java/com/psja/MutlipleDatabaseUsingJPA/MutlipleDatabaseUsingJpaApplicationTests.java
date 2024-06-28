package com.psja.MutlipleDatabaseUsingJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psja.MutlipleDatabaseUsingJPA.service.ApplicationService;

@SpringBootTest
class MutlipleDatabaseUsingJpaApplicationTests {

	@Autowired
	private ApplicationService applicationService;
	
	@Test
	public void SaveUserData() {
		applicationService.saveUserData("test", "user_date");
	}

	@Test
	public void SaveEmployeeData() {
		applicationService.saveEmployeeData("test_employee", "test_employee_data");
	}

}
