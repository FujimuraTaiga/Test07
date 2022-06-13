package com.example.Test07.service.C2_CafeteriaPost;

import com.example.Test07.repository.C3_Ranking.CafeteriaRanking;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaMenu;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * CafeteriaDAOで読み取ったデータを加工する事を目的とするクラス。
 * @author FujimuraTaiga
 */
@Service
public class CafeteriaPostService {
    private final CafeteriaDAO dao;

    @Autowired
    CafeteriaPostService(CafeteriaDAO dao){this.dao = dao;}

    public void createPost(String postId, String menuId, int evaluation, String comment) throws DataAccessException {
        dao.createPost(new CafeteriaPost(postId, menuId, evaluation, comment));
    }

    public  List<CafeteriaPost> readPost(String menuId) {return dao.readPost(menuId);}

    public List<CafeteriaMenu> readMenu() {
        List<CafeteriaMenu> menuList = new ArrayList<>();
        List<CafeteriaRanking> ranking = dao.ranks();
        for(CafeteriaRanking id:ranking){
            menuList.add(dao.findMenuById(id.menuId()));
        }
        return menuList;
    }

    public CafeteriaMenu findMenuById(String menuId){return dao.findMenuById(menuId);}

    /**
     * @param menuId 評価を知りたいメニューのID
     * @return 評価の平均値を小数点第二位で四捨五入して返す。
     */
    public String findEvaluationAVG(String menuId){
        try{
            double avg = dao.findEvaluationAVG(menuId);
            return String.valueOf((double) Math.round(avg*10) /10);
        }catch (NullPointerException e){
            return "評価なし";
        }
    }
}
