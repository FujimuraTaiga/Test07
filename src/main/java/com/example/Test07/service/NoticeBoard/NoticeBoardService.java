package com.example.Test07.service.NoticeBoard;

import com.example.Test07.repository.C10_NoticeBoard.NoticeBoard;
import com.example.Test07.repository.C10_NoticeBoard.NoticeBoardDAO;
import com.example.Test07.repository.C10_NoticeBoard.ThreadPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2022/06/21
 * NoticeBoardDAOで読み取ったデータに対し、加工やエラー処理を行うクラス。
 * @author FujimuraTaiga
 * ver. 1.0.0
 */

@Service
public class NoticeBoardService {
    
    final NoticeBoardDAO dao;
    
    @Autowired
    NoticeBoardService(NoticeBoardDAO dao){ this.dao = dao; }
    
    public void createPost(ThreadPost post){dao.createPost(post);}
    
    public List<ThreadPost> readPost(String threadId){return dao.readPost(threadId);}
    
    public List<NoticeBoard> readThread(){return dao.readThread();}
    
    public void createThread(NoticeBoard noticeBoard){dao.createThread(noticeBoard);}
}
