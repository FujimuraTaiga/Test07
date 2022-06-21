package com.example.Test07.repository.C9_Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 2022/06/21
 * C6 授業データ処理
 * 授業データについてDBとやり取りをするクラス
 * @author WataruIbe
 * ver. 1.0.0
 */
@Service
public class ClassDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    /**
     * 評価・口コミの投稿をDBに登録する関数
     * @param post 投稿データ（投稿Id,授業Id,評価,コメント）を持つレコード
     */
    public void createClassPost(ClassPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("class_post");
        insert.execute(param);
    }
    //仮実装
    //今手入力してるデータをDBから持って来て、classListに追加して返すように実装してほしい
    /**
     * メニューIdの一致する投稿データをListにして返す関数
     * @param classId メニューを識別するId
     * @return 投稿データ（投稿Id,授業Id,評価,コメント）を持つレコードのList
     */
    public List<ClassPost> readClassPost(String classId){
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
    /**
     * 全ての授業データを返す関数
     * @return 授業データ（授業Id,学部名,学科名,授業名）のList
     */
    public List<Class> readClassMenu(){
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
    /**
     * Idの一致する授業データを返す関数
     * @param id 授業一覧を識別するId
     * @return 授業一覧データ（授業Id,学部名,学科名,授業名）を持つレコード
     */
    public Class findClassMenuById(String id){

        String query = "SELECT * FROM class WHERE id = ?";

        Map<String, Object> result = jdbcTemplate.queryForMap(query,id);

        Class classMenu = new Class(
                result.get("id").toString(),
                result.get("department").toString(),
                result.get("major").toString(),
                result.get("name").toString()
        );

        return classMenu;
    }

    /**
     * 授業の平均評価を返す関数
     * @param classId 授業を識別するId
     * @return 評価の平均値
     * @throws NullPointerException 投稿データがない場合、平均評価を求められないのでエラーを投げる
     */
    public double findClassEvaluationAVG(String classId) throws NullPointerException{
        String query = "SELECT AVG(evaluation) FROM class_post WHERE classId = ?";
        Map<String,Object> result = jdbcTemplate.queryForMap(query,classId);
        return (double) result.get("AVG(evaluation)");
    }
}