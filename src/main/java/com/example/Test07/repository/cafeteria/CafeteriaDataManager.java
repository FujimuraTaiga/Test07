package com.example.Test07.repository.cafeteria;

import java.util.ArrayList;
import java.util.List;

/**
 * 学食メニューDB、学食投稿DBとデータのやり取りをするクラス。
 * @author FujimuraTaiga
 */
public class CafeteriaDataManager {
    /**
     * メニューデータを保存するList
     */
    List<CafeteriaMenu> menus = new ArrayList<>();
    /**
     * 投稿データを保存するList
     */
    List<CafeteriaPost> posts = new ArrayList<>();

    /**
     * 学食メニューDBからメニューデータを読み取り、menusに保存する
     */
    void readMenu(){

    }

    /**
     * メニューデータを返す
     * @return クラス変数menus
     */
    List<CafeteriaMenu> getMenus(){
        return menus;
    }

    /**
     * 学食投稿DBから投稿データを読み取り、postsに保存する
     */
    void readPost(){

    }

    /**
     * 投稿データを返す
     * @return クラス変数posts
     */
    List<CafeteriaPost> getPosts(){
        return posts;
    }

    /**
     * 投稿内容をクラス変数menus及び学食投稿DBに登録する
     * @param postId 投稿ID
     * @param menuId メニューID
     * @param evaluation 評価
     * @param comment コメント
     */
    void post(String postId,String menuId,double evaluation,String comment){
        CafeteriaPost post = new CafeteriaPost(postId,menuId,evaluation,comment);
        posts.add(post);
        //DBにpostを登録
    }
}
