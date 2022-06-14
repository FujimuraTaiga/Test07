package com.example.Test07.repository.C10_NoticeBoard;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Service
public class NoticeBoardDAO{
    private final JdbcTemplate jdbcTemplate;

    public NoticeBoardDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
  
    public void createPost(ThreadPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("thread_post");
        insert.execute(param);
    }

    public List<ThreadPost> readPost(String threadId){
        String query = "SELECT * FROM thread_post WHERE threadId = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query,threadId);

        List<ThreadPost> threadPosts = result.stream()
                .map((Map<String,Object> row) -> new ThreadPost(
                        row.get("postId").toString(),
                        row.get("threadId").toString(),
                        row.get("comment").toString()
                )).toList();

        return threadPosts;
    }


    public List<NoticeBoard> readThread(){
        String query = "SELECT * FROM thread";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<NoticeBoard> NoticeBoard= result.stream()
                .map((Map<String,Object> row) -> new NoticeBoard(
                        row.get("id").toString(),
                        row.get("name").toString()
                )).toList();

        return NoticeBoard;
    }

    public void createThread(NoticeBoard post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("thread");
        insert.execute(param);
    }
}