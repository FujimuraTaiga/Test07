package com.example.Test07.service.ClassService;

import com.example.Test07.repository.C9_Class.Class;
import com.example.Test07.repository.C9_Class.ClassDAO;
import com.example.Test07.repository.C9_Class.ClassPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    ClassDAO dao;

    @Autowired
    ClassService(ClassDAO dao){this.dao=dao;}

    public void createPost(ClassPost postId){
        dao.createPost(postId);
    }
    public List<ClassPost> readPost(String classId){
        return dao.readPost(classId);
    }
    public List<Class> readMenu(){
        return dao.readMenu();
    }
    public Class findMenuById(String id){
        return dao. findMenuById(id);
    }
    public String findEvaluationAVG(String classId) {
        try {
            double avg = dao.findEvaluationAVG(classId);
            return String.valueOf((double) Math.round(avg*10) /10);
        }
    catch(NullPointerException e){
         return "評価なし";

        }
    }
}
