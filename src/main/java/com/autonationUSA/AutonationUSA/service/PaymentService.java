package com.autonationUSA.AutonationUSA.service;


import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;



@Service
public class PaymentService {
	
	private String key_id = "rzp_test_3Ykoc5fkgZWrW5";
	private String Key_secret = "YuqGBEF1TSJg9Yq3loPX9YNW";
	
	public Object createOrder(double amount, String currency, String reciept) {
		
		try {
			RazorpayClient razorpayClient = new RazorpayClient(key_id, Key_secret);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", amount * 100);
			jsonObject.put("currency", currency);
			jsonObject.put("receipt", reciept);
			Order order = razorpayClient.orders.create(jsonObject);
			return order.toString();
			
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		
		return "Payment Order Not created : Some Exception Occurs";
		
	}
	

}
