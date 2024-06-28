package com.psja.MutlipleDatabaseUsingJPA.service;

public interface ApplicationService {

	default public void saveUserData(String userName, String userAddress) {
		System.out.println("The default save user data");
	};
	
	default public void saveEmployeeData(String empName, String empAddress) {
		System.out.println("The default save employee data");
	};
}
