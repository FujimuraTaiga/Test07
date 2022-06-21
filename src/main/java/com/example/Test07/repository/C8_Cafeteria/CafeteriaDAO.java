package com.example.Test07.repository.C8_Cafeteria;

import com.example.Test07.repository.C3_Ranking.CafeteriaRanking;
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
 * C5 学食データ処理
 * 学食データについてDBとやり取りをするクラス
 * @author FujimuraTaiga,SyojiAyumu
 * ver. 1.0.0
 */

@Service
public class CafeteriaDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CafeteriaDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    /**
     * 評価・口コミの投稿をDBに登録する関数
     * @param post 投稿データ（投稿Id,メニューId,評価,コメント）を持つレコード
     */
    public void createPost(CafeteriaPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("cafeteria_post");
        insert.execute(param);
    }

    /**
     * メニューIdの一致する投稿データをListにして返す関数
     * @param menuId メニューを識別するId
     * @return 投稿データ（投稿Id,メニューId,評価,コメント）を持つレコードのList
     */
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

    /**
     * 全てのメニューデータを返す関数
     * @return メニューデータ（メニューId,メニュー名,メニュー説明,メニュー画像のファイル名）のList
     */
    public List<CafeteriaMenu> readMenu(){
        String query = "SELECT * FROM cafeteria_menu";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<CafeteriaMenu> cafeteriaMenus = result.stream()
                .map((Map<String,Object> row) -> new CafeteriaMenu(
                        row.get("id").toString(),
                        row.get("name").toString(),
                        row.get("explain").toString(),
                        row.get("image").toString()
                )).toList();

        return cafeteriaMenus;
    }

    /**
     * Idの一致するメニューデータを返す関数
     * @param id 学食メニューを識別するId
     * @return 学食メニューデータ（メニューId,メニュー名,メニュー説明,メニュー画像のファイル名）を持つレコード
     */
    public CafeteriaMenu findMenuById(String id){

        String query = "SELECT * FROM cafeteria_menu WHERE id = ?";

        Map<String, Object> result = jdbcTemplate.queryForMap(query,id);

        CafeteriaMenu menu = new CafeteriaMenu(
                result.get("id").toString(),
                result.get("name").toString(),
                result.get("explain").toString(),
                result.get("image").toString()
        );

        return menu;
    }

    /**
     * メニューの平均評価を返す関数
     * @param menuId メニューを識別するId
     * @return 評価の平均値
     * @throws NullPointerException 投稿データがない場合、平均評価を求められないのでエラーを投げる
     */
    public double findEvaluationAVG(String menuId) throws NullPointerException{
        String query = "SELECT AVG(evaluation) FROM cafeteria_post WHERE menuId = ?";
        Map<String,Object> result = jdbcTemplate.queryForMap(query,menuId);
        return (double) result.get("AVG(evaluation)");
    }

    /**
     * 2022/06/22
     * C3 学食ランキング処理
     * @return メニューIDをランキング順リスト化
     * @author ShojiAyumu
     * ver. 1.0.0
     */
    public List<CafeteriaRanking> ranks(){
        String query = "SELECT menuId,FROM cafeteria_post group by menuId order by AVG(evaluation) desc ";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<CafeteriaRanking> cafeteriaRanks = result.stream()
                .map((Map<String,Object> row) -> new CafeteriaRanking(
                        row.get("menuId").toString()
                )).toList();
        System.out.println(cafeteriaRanks);
        return cafeteriaRanks;
    }

}
