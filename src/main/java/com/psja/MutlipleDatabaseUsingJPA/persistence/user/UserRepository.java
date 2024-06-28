package com.psja.MutlipleDatabaseUsingJPA.persistence.user;

import org.springframework.stereotype.Repository;

import com.psja.MutlipleDatabaseUsingJPA.entity.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

}
