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



public class NoticeBoardDAO {
    /**
     * Noticeboard
     * 掲示板のスレッドを作ることや読み取ること、スレッドに投稿することや投稿を読み取るためのクラス。
     */
    private final JdbcTemplate jdbcTemplate;

    public NoticeBoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 投稿情報をDB(投稿Id,スレッドId,コメント)をDB(thread_post)に登録する。
     * ＠param ThreadPost スレッドへの投稿情報を登録するためのpostId,threadId,commentを持つ。
     */
    public void createPost(ThreadPost post) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("thread_post");
        insert.execute(param);
    }


    /**
     * 投稿情報をDB(投稿Id,スレッドId,コメント)をDB(thread_post)から読み取る。
     * ＠param threadId 投稿を識別するId
     */
    public List<ThreadPost> readPost(String threadId) {

        String query = "SELECT * FROM thread_post WHERE threadId = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query, threadId);

        List<ThreadPost> threadPosts = result.stream()
                .map((Map<String, Object> row) -> new ThreadPost(
                        row.get("postId").toString(),
                        row.get("threadId").toString(),
                        row.get("comment").toString()
                )).toList();

        return threadPosts;
    }


    /**
     * スレッド情報（id,スレッド名）をDB(thread)に登録する。
     *
     * @param post スレッド情報を登録するためのidとnameを持つ。
     */
    public void createThread(NoticeBoard post) {

        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("thread");
        insert.execute(param);
    }


    /**
     * スレッド情報（id,スレッド名）をDB(thread)から読み取る。
     *
     * @return NoticeBoard スレッド情報を返す。
     */
    public List<NoticeBoard> readThread() {
        String query = "SELECT * FROM thread";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<NoticeBoard> noticeBoardList = result.stream()
                .map((Map<String, Object> row) -> new NoticeBoard(
                        row.get("id").toString(),
                        row.get("name").toString()
                )).toList();

        return noticeBoardList;
    }
}