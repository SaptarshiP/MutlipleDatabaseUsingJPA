package com.psja.MutlipleDatabaseUsingJPA.entity.user;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "USER_TABLE")
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_ADDRESS")
	private String userAddress;
	
	public Integer getId() {
		return this.id;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getUserAddress() {
		return this.userAddress;
	}
	public void setUserAddress( String userAddress ) {
		this.userAddress = userAddress;
	}
}
