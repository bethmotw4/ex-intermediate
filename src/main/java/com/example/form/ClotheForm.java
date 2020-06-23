package com.example.form;

/**
 * 検索に使用するフォーム.
 * 
 * @author yoshiki.morimoto
 *
 */
public class ClotheForm {
	/**	性別 */
	private Integer gender;
	/**	色 */
	private String color;
	
	
	public ClotheForm() {
		super();
		gender = 0;
	}
	
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ClotheForm [gender=" + gender + ", color=" + color + "]";
	}
	
}
