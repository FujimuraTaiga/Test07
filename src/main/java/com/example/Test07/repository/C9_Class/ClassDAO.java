package com.example.Test07.repository.C9_Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClassDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    public List<Class> readClass(){
        String query = "SELECT * FROM class";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<Class> classList = result.stream()
                .map((Map<String, Object> row) -> new Class(
                                row.get("id").toString(),
                                row.get("department").toString(),
                                row.get("major").toString(),
                                row.get("name").toString()
                        )
                ).toList();
        return classList;
    }

    public Class findClassById(String classId){
        String query = "SELECT * FROM class WHERE id = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(query,classId);

        Class _class = new Class(
                result.get("id").toString(),
                result.get("department").toString(),
                result.get("major").toString(),
                result.get("name").toString()
        );

        return _class;
    }

    public void createPost(ClassPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("class_post");
        insert.execute(param);
    }
}
