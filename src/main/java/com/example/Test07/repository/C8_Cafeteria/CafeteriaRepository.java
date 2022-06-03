package com.example.Test07.repository.C8_Cafeteria;

import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

/**
 * 学食メニューDB、学食投稿DBとデータのやり取りをするクラス。
 * @author FujimuraTaiga
 */
public class CafeteriaRepository {
    /**
     * メニューデータを保存するList
     */
    private final List<CafeteriaMenu> menus = new ArrayList<>();
    /**
     * 投稿データを保存するList
     */
    private final List<CafeteriaPost> posts = new ArrayList<>();

    /**
     * 学食メニューDBからメニューデータを読み取り、menusに保存する
     * @throws org.springframework.dao.DataAccessException メニューデータの読み取りに失敗した時、エラーを投げます。
     */
    public void readMenu() throws DataAccessException{

    }

    /**
     * メニューデータを返す
     * @return クラス変数menus
     */
    public List<CafeteriaMenu> getMenus(){
        return menus;
    }

    /**
     * 学食投稿DBから投稿データを読み取り、postsに保存する
     */
    public void readPost() throws DataAccessException{

    }

    /**
     * 投稿データを返す
     * @return クラス変数posts
     */
    public List<CafeteriaPost> getPosts(){
        return posts;
    }

    /**
     * 投稿内容をクラス変数menus及び学食投稿DBに登録する
     * @param postId 投稿ID
     * @param menuId メニューID
     * @param evaluation 評価
     * @param comment コメント
     * @throws org.springframework.dao.DataAccessException 投稿データの登録に失敗した場合、エラーを投げます。
     */
    public void post(String postId, String menuId, double evaluation, String comment) throws DataAccessException {
        CafeteriaPost post = new CafeteriaPost(postId,menuId,evaluation,comment);
        posts.add(post);
        //DBにpostを登録
    }
}
