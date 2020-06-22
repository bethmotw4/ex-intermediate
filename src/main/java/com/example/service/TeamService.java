package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チームに関する業務処理を行うサービス.
 * 
 * @author yoshiki.morimoto
 *
 */
@Service
@Transactional
public class TeamService {
	@Autowired
	private TeamRepository repository;
	
	/**
	 * チーム一覧を取得する.
	 * 
	 * @return チーム一覧
	 */
	public List<Team> showList() {
		return repository.findAll();
	}
	
	/**
	 * チーム情報を取得する.
	 * 
	 * @param id ID
	 * @return チーム情報
	 */
	public Team showDetail(Integer id) {
		return repository.load(id);
	}
}
