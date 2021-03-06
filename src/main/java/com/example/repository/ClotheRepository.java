package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothe;

/**
 * clothesテーブルを操作するリポジトリ.
 * 
 * @author yoshiki.morimoto
 *
 */
@Repository
public class ClotheRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER = (rs, i) -> {
		Clothe clothe = new Clothe();
		clothe.setId(rs.getInt("id"));
		clothe.setCategory(rs.getString("category"));
		clothe.setGenre(rs.getString("genre"));
		clothe.setGender(rs.getInt("gender"));
		clothe.setColor(rs.getString("color"));
		clothe.setPrice(rs.getInt("price"));
		clothe.setSize(rs.getString("size"));
		return clothe;
	};
	
	/**
	 * 衣類情報を検索する.
	 * 
	 * @param color 色
	 * @param gender 性別
	 * @return 衣類情報
	 */
	public List<Clothe> searchByColorAndGender(String color, Integer gender) {
		String sql = "SELECT id, category, genre, gender,color, price, size "
				+ "FROM clothes WHERE color=:color AND gender=:gender;";
		SqlParameterSource source = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		return template.query(sql, source, CLOTHE_ROW_MAPPER);
	}
}
