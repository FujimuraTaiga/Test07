package com.example.Test07.repository.C8_Cafeteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CafeteriaDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CafeteriaDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    public void createPost(CafeteriaPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("cafeteria_post");
        insert.execute(param);
    }

    public List<CafeteriaPost> readPost(String menuId){
        String query = "SELECT * FROM cafeteria_post WHERE menuId = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query,menuId);

        List<CafeteriaPost> cafeteriaPosts = result.stream()
                .map((Map<String,Object> row) -> new CafeteriaPost(
                        row.get("postId").toString(),
                        row.get("menuId").toString(),
                        (int)row.get("evaluation"),
                        row.get("comment").toString()
                )).toList();

        return cafeteriaPosts;
    }

    public List<CafeteriaMenu> readMenu(){
        String query = "SELECT * FROM cafeteria_menu";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<CafeteriaMenu> cafeteriaMenus = result.stream()
                .map((Map<String,Object> row) -> new CafeteriaMenu(
                        row.get("id").toString(),
                        row.get("name").toString(),
                        row.get("explain").toString(),
                        (byte[]) row.get("image")
                )).toList();

        return cafeteriaMenus;
    }

    public CafeteriaMenu findMenuById(String id){

        String query = "SELECT * FROM cafeteria_menu WHERE id = ?";

        Map<String, Object> result = jdbcTemplate.queryForMap(query,id);

        CafeteriaMenu menu = new CafeteriaMenu(
                result.get("id").toString(),
                result.get("name").toString(),
                result.get("explain").toString(),
                (byte[]) result.get("image")
        );

        return menu;
    }
}
