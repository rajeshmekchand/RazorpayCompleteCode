package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderrepository extends JpaRepository<MyOrder, Long> {
public MyOrder findByOrderId(String object);

}
