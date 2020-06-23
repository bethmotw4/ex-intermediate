package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテル検索に関する制御を行うコントローラ.
 * 
 * @author yoshiki.morimoto
 *
 */
@Controller
@RequestMapping("/ex02")
public class HotelController {
	@Autowired
	private HotelService service;
	
	/**
	 * 検索に使用するフォームのインスタンス化.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}
	
	/**
	 * 検索画面を表示する.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "hotel-search";
	}
	
	/**
	 * 検索結果を表示する.
	 * 
	 * @param form フォーム
	 * @param result エラーメッセージ
	 * @param model リクエストスコープ
	 * @return 成功：検索結果画面, 失敗：検索画面
	 */
	@RequestMapping("/search")
	public String search(@Validated HotelForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		}
		System.out.println(form.getPrice());
		List<Hotel> hotelList = service.searchByLessThanPrice(form.getPrice());
		System.out.println(hotelList.size());
		model.addAttribute("hotelList", hotelList);
		return "hotel-search";
	}
}
