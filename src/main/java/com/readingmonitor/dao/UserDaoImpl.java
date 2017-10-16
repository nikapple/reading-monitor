package com.readingmonitor.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.User;


@Repository
public class UserDaoImpl extends DaoImpl implements UserDao {

	@Override
	public boolean validateUser(User user) {
		if (checkPasswordMatch(user)) {
			return true;
		}
		return false;
	}

	private boolean checkPasswordMatch(User user) {
		String sql = "SELECT email "
				+ "FROM user_details "
				+ "WHERE email = :email "
					+ "AND pwd =:password";
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			parameters.put("email", user.getEmail());
			parameters.put("password", user.getPassword());
			String email = getJdbcTemplate().queryForObject(sql, parameters,
					String.class);
			return email != null;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

	}

	@Override
	public int insertUser(User user) {
		String sql = "INSERT INTO " + "user_details "
				+ "(email,username,first_name,last_name,phone,pwd)"
				+ "VALUES"
				+ "(:email,:username,:first_name,:last_name,:phone,:password)";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", user.getEmail());
		parameters.put("username", user.getUsername());
		parameters.put("first_name", user.getFirstName());
		parameters.put("last_name", user.getLastName());
		parameters.put("phone", user.getPhone());
		parameters.put("password", user.getPassword());

		return getJdbcTemplate().update(sql, parameters);
	}

	@Override
	public boolean checkUserExists(User user) {
		String sql = "SELECT email "
				+ "FROM user_details "
				+ "WHERE email = :email";
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			parameters.put("email", user.getEmail());
			String email = getJdbcTemplate().queryForObject(sql, parameters,
					String.class);
			return email != null;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

	}

	@Override
	public User getUserInfo(User user) {
		String sql = "SELECT id,email,first_name,last_name,phone,username "
				+ "FROM user_details "
				+ "WHERE email = :email";
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			parameters.put("email", user.getEmail());
			user = getJdbcTemplate().queryForObject(
					sql,
					parameters,
					(rs, rowNum) -> new User(rs.getInt("id"),rs.getString("username"), rs
							.getString("email"), rs.getString("first_name"), rs
							.getString("last_name"), rs.getString("phone")));
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
