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

    public void createClassPost(ClassPost postId){
        dao.createClassPost(postId);
    }
    public List<ClassPost> readClassPost(String classId){
        return dao.readClassPost(classId);
    }
    public List<Class> readClassMenu(){
        return dao.readClassMenu();
    }
    public Class findClassMenuById(String id){
        return dao.findClassMenuById(id);
    }
    public String findClassEvaluationAVG(String classId) {
        try {
            double avg = dao.findClassEvaluationAVG(classId);
            return "★" + String.valueOf((double) Math.round(avg*10) /10);
        }
    catch(NullPointerException e){
         return "★なし";

        }
    }
}
