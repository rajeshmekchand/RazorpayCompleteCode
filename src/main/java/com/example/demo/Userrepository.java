package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long> {

	org.apache.catalina.User getuserbyuserName(String string);

}
