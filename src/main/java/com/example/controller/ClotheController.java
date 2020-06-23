package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;

@Controller
@RequestMapping("/ex03")
public class ClotheController {
	@Autowired
	private ClotheService service;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 検索に使用するフォームのインスタンス化する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public ClotheForm setUpClothForm() {
		return new ClotheForm();
	}
	
	/**
	 * 衣類検索画面を表示する.
	 * 
	 * @param model リクエストパラメータ
	 * @return 衣類検索画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<String> genderList = (List<String>)session.getAttribute("genderList");
		if (genderList == null) {
			genderList = new ArrayList<>();
			genderList.add("Man");
			genderList.add("Woman");
			session.setAttribute("genderList", genderList);			
		}
		
		List<String> colorList = (List<String>)session.getAttribute("colorList");
		if (colorList == null) {
			colorList = new ArrayList<>();
			String[] colors = {"赤", "青", "白", "黄"};
			for (String color : colors) {
				colorList.add(color);
			}
			session.setAttribute("colorList", colorList);
		}
		model.addAttribute("check", true);
		return "clothe-list";
	}
	
	/**
	 * 衣類を検索する.
	 * 
	 * @param clotheForm 検索フォーム
	 * @param model リクエストスコープ
	 * @return 検索結果画面
	 */
	@RequestMapping("/search")
	public String search(ClotheForm clotheForm, Model model) {
		System.out.println(clotheForm.getGender() + clotheForm.getColor());
		List<Clothe> clotheList = service.searchByColorAndGender(clotheForm.getColor(), clotheForm.getGender());
		if (clotheList.size() == 0) {
			model.addAttribute("check", false);
		} else {
			model.addAttribute("check", true);			
		}
		model.addAttribute("clotheList", clotheList);			
//		return "clothe-List";
		return index(model);
	}
}
