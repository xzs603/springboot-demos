package com.mttsui.easyui.dao;

import com.mttsui.easyui.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<SysUser> findAll() {
        return jdbcTemplate.query("select * from sys_user", new UserRowMapper());
    }

    class UserRowMapper implements RowMapper<SysUser> {

        @Override
        public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            SysUser user = new SysUser();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            return user;
        }
    }
}