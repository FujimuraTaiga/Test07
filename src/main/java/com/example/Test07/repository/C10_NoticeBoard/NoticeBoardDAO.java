package com.example.Test07.repository.C10_NoticeBoard;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoardDAO{
    private final JdbcTemplate jdbcTemplate;

    public NoticeBoardDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    public List<NoticeBoard> readNoticeBoardList(){
        List<NoticeBoard> threadList = new ArrayList<>();
        threadList.add(new NoticeBoard("00000001","学食のカレーが美味すぎる件"));
        return threadList;
    }
    
    public NoticeBoard findNoticeBoardById(String noticeBoardId){
        return new NoticeBoard("00000002","学食の竜田丼が美味すぎる件");
    }
    
    public void createPost(String classId){
        
    }
}