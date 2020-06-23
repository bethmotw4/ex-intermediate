package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothe;
import com.example.repository.ClotheRepository;

/**
 * 衣類検索に関する業務処理を行うサービス.
 * 
 * @author yoshiki.morimoto
 *
 */
@Service
@Transactional
public class ClotheService {
	@Autowired
	private ClotheRepository repository;
	
	/**
	 * 衣類情報を検索する.
	 * 
	 * @param color 色
	 * @param gender 性別
	 * @return 衣類情報
	 */
	public List<Clothe> searchByColorAndGender(String color, Integer gender) {
		return repository.searchByColorAndGender(color, gender);
	}
}
