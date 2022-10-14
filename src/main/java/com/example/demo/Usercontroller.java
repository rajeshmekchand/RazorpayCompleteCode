package com.example.demo;

import java.security.Principal;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
@Controller
public class Usercontroller {
@Autowired
private MyOrderrepository myOrderrepository;
@Autowired
private Userrepository userrepository;

@RequestMapping("/")
public ModelAndView f1() {
	ModelAndView mv=new ModelAndView("ordercreate");
	return mv;
}

@PostMapping("/ordercreate")
@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data,Principal principal) throws Exception
	{
		//System.out.println("Hey order function ex.");
		System.out.println(data);

		int amt=Integer.parseInt(data.get("amount").toString());

		var client=new RazorpayClient("rzp_test_g2haAu0IvCErbO","RT6FBzgisOsQ8AjExMh3BbYn");

		JSONObject ob=new JSONObject();
		ob.put("amount", amt*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_235425");

		//creating new order

		Order order = client.orders.create(ob);
		System.out.println(order);

	    //save the order in database
		MyOrder myOrder= new MyOrder();
		myOrder.setAmount(order.get("amount"));
		myOrder.setPaymenId(null);
		myOrder.setMyorderId(order.get("myorderid"));
		myOrder.setStatus("created");
		myOrder.setUser(this.userrepository.getuserbyuserName(principal.getName()));
	    myOrder.setReceipt(order.get("receipt"));
	    this.myOrderrepository.save(myOrder);

		//if you want you can save this to your data..
		return order.toString();
	}
@PostMapping("/update_order")
public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object > data ){
MyOrder myorder =this.myOrderrepository.findByOrderId(data.get("order_id").toString());
	myorder.setPaymenId(data.get("payment_id").toString());
	myorder.setStatus(data.get("status").toString());
	this.myOrderrepository.save(myorder);
	System.out.println();
	return ResponseEntity.ok(Map.of("msg","updated"));
	
}
}


