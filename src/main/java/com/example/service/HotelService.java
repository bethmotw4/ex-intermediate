package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル検索に関する業務処理を行うリポジトリ.
 * 
 * @author yoshiki.morimoto
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	/**
	 * ホテル一覧を取得する.
	 * 
	 * @return ホテル一覧
	 */
	public List<Hotel> findAll() {
		return repository.findAll();
	}
	
	/**
	 * ホテル情報を取得する.
	 * 
	 * @param price 価格
	 * @return
	 */
	public List<Hotel> findByPrice(Integer price) {
		return repository.findByPrice(price);
	}
}
