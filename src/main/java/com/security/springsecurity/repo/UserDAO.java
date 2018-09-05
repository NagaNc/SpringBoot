package com.security.springsecurity.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.security.springsecurity.model.UserModel;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*@Autowired
	PasswordEncoder passwordEncoder;*/

	public UserModel getUserDetails(String username) {

		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM USER WHERE USERNAME= '" + username + "'";
		List<UserModel> list = jdbcTemplate.query(sqlQuery, new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel userModel = new UserModel();
				userModel.setUsername(rs.getString(1));
				userModel.setPassword(/*passwordEncoder.encode(*/rs.getString(2)/*)*/);
				return userModel;
			}
		});

		if (list != null && list.size() > 0) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			grantedAuthoritiesList.add(grantedAuthority);
			list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
			return list.get(0);
		}

		return null;
	}
}
