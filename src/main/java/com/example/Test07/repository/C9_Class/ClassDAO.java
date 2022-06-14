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
    public ClassDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    public void createPost(ClassPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("class_post");
        insert.execute(param);
    }
    //仮実装
    //今手入力してるデータをDBから持って来て、classListに追加して返すように実装してほしい
    public List<ClassPost> readPost(String classId){
        String query = "SELECT * FROM class_post WHERE classId = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query,classId);

        List<ClassPost> classPosts = result.stream()
                .map((Map<String,Object> row) -> new ClassPost(
                        row.get("postId").toString(),
                        row.get("classId").toString(),
                        (int)row.get("evaluation"),
                        row.get("comment").toString()
                )).toList();

        return classPosts;
    }

    public List<Class> readMenu(){
        String query = "SELECT * FROM class";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<Class> classMenus = result.stream()
                .map((Map<String,Object> row) -> new Class(
                        row.get("id").toString(),
                        row.get("department").toString(),
                        row.get("major").toString(),
                        row.get("name").toString()
                )).toList();

        return classMenus;
    }
    public Class findMenuById(String id){

        String query = "SELECT * FROM class WHERE id = ?";

        Map<String, Object> result = jdbcTemplate.queryForMap(query,id);

        Class menu = new Class(
                result.get("id").toString(),
                result.get("department").toString(),
                result.get("major").toString(),
                result.get("name").toString()
        );

        return menu;
    }

    public double findEvaluationAVG(String classId) throws NullPointerException{
        String query = "SELECT AVG(evaluation) FROM class_post WHERE classId = ?";
        Map<String,Object> result = jdbcTemplate.queryForMap(query,classId);
        return (double) result.get("AVG(evaluation)");
    }
}