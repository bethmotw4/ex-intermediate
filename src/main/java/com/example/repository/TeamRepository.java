package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author yoshiki.morimoto
 *
 */
@Repository
public class TeamRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeaguename(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * チーム一覧を取得する.
	 * 
	 * @return チーム一覧
	 */
	public List<Team> findAll() { 
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams ORDER BY inauguration;";
		return template.query(sql, TEAM_ROW_MAPPER);
	}
	
	/**
	 * チームを検索する.
	 * 
	 * @param id ID
	 * @return チーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams WHERE id=:id;";
		SqlParameterSource source = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, source, TEAM_ROW_MAPPER);
	}
}
