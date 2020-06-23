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

@Controller
@RequestMapping("/ex02")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}
	
	@RequestMapping("")
	public String index() {
		
		return "hotel-search";
	}
	
	@RequestMapping("/search")
	public String search(@Validated HotelForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		}
		System.out.println(form.getPrice());
		List<Hotel> hotelList = service.findByPrice(form.getPrice());
		System.out.println(hotelList.size());
		model.addAttribute("hotelList", hotelList);
		return "hotel-search";
	}
}
