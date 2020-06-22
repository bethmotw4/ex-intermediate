package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チームに関する制御を行うコントローラ.
 * 
 * @author yoshiki.morimoto
 *
 */
@Controller
@RequestMapping("/ex01")
public class TeamController {
	@Autowired
	private TeamService service;
	
	/**
	 * チーム一覧画面を表示する.
	 * 
	 * @param model リクエストパラメータ.
	 * @return チーム一覧画面
	 */
	@RequestMapping("")
	public String showList(Model model) {
		List<Team> teamList = service.showList();
		model.addAttribute("teamList", teamList);
		return "list";
	}
	
	/**
	 * チーム情報を表示する.
	 * 
	 * @param id ID
	 * @param model リクエストパラメータ
	 * @return チーム情報画面
	 */
	@RequestMapping("/detail")
	public String showDetail(String id, Model model) {
		Team team = service.showDetail(Integer.parseInt(id));
		model.addAttribute("team", team);
		return "detail";
	}
}
