package com.example.form;

import javax.validation.constraints.Pattern;

public class HotelForm {
//	または空白を付けたい
	@Pattern(regexp = "(^[1-9][0-9]*$ | \\s+)", message = "金額の形式が不正です")
//	@Pattern(regexp = "\\S", message = "金額の形式が不正です")
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}
	
}
