package com.autonationUSA.AutonationUSA.model;

public class PayementUser {

	private double amount;
	private String currency;
	private String receipt;


	public PayementUser(double amount, String currency, String receipt) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.receipt = receipt;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getReceipt() {
		return receipt;
	}


	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}


	@Override
	public String toString() {
		return "PaymentUser [amount=" + amount + ", currency=" + currency + ", receipt=" + receipt + "]";
	}
}
