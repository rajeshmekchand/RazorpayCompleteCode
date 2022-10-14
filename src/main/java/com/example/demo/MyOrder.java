package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.User;

@Entity
@Table(name="Orders")
public class MyOrder {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long OrderId;
private String PaymentId;
private String amount;
private String receipt;
private String status;
@ManyToOne
private User user;
private String paymenId;
public long getMyorderId() {
	return OrderId;
}
public void setMyorderId(long myorderId) {
	this.OrderId = myorderId;
}
public String getPaymentId() {
	return PaymentId;
}
public void setPaymentId(String paymentId) {
	PaymentId = paymentId;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getReceipt() {
	return receipt;
}
public void setReceipt(String receipt) {
	this.receipt = receipt;
}
public String getStatus() {
	return status;
}
public void setStatus(String object) {
	this.status = object;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getPaymenId() {
	return paymenId;
}
public void setPaymenId(String paymenId) {
	this.paymenId = paymenId;
}
@Override
public String toString() {
	return "MyOrder [myorderId=" + OrderId + ", PaymentId=" + PaymentId + ", amount=" + amount + ", receipt="
			+ receipt + ", status=" + status + ", user=" + user + ", paymenId=" + paymenId + "]";
}



}
