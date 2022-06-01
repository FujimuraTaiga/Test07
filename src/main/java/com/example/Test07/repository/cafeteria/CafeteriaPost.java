package com.example.Test07.repository.cafeteria;

/**
 * 学食投稿の情報を持つデータクラス
 * @author FujimuraTaiga
 */
public class CafeteriaPost {
    /**
     * 投稿ID
     */
    String postId;
    /**
     * メニューID
     */
    String menuId;
    /**
     * 評価
     */
    double evaluation;
    /**
     * コメント
     */
    String comment;

    /**
     * コンストラクタ
     * @param postId 投稿ID
     * @param menuId メニューID
     * @param evaluation 評価
     * @param comment コメント
     */
    CafeteriaPost(String postId,String menuId,double evaluation,String comment){
        this.postId = postId;
        this.menuId = menuId;
        this.evaluation = evaluation;
        this.comment = comment;
    }
}
