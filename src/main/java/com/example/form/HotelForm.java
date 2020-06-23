package com.example.form;

import javax.validation.constraints.Pattern;

/**
 * ホテル検索に使用するフォーム.
 * 
 * @author yoshiki.morimoto
 *
 */
public class HotelForm {
	/** 価格 */
	@Pattern(regexp = "^[1-9][0-9]*$|\\s*", message = "金額の形式が不正です")
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
