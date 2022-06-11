package com.example.Test07.repository.C9_Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClassDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClassDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    //仮実装
    //今手入力してるデータをDBから持って来て、classListに追加して返すように実装してほしい
    public List<Class> readClass(){
        List<Class> classList = new ArrayList<>();
        Class class1 = new Class("00000001","工学部","情報工学科","高度情報演習IB");
        Class class2 = new Class("00000002","システム理工学部","数理科学科","数理最適化");
        classList.add(class1);
        classList.add(class2);
        return classList;
    }

    //仮実装
    //idが一致する授業データを返すように実装してほしい。
    public Class findClassById(String classId){
        Class classInfo = new Class("00000001","工学部","情報工学科","高度情報演習IB");
        return classInfo;
    }
    
    public void createPost(ClassPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("class_post");
        insert.execute(param);
    }
}
