package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HotelService;

@Controller
@RequestMapping("/ex02")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@RequestMapping("")
	public String index() {
		
		return "hotel-search";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "hotel-search";
	}
}
