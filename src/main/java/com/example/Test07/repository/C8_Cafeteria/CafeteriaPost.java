package com.example.Test07.repository.C8_Cafeteria;

/**
 * 2022/06/21
 * 食堂の投稿に関するデータを保持するデータレコード
 * @param postId 投稿ID
 * @param menuId メニューID
 * @param evaluation 評価
 * @param comment コメント
 */
public record CafeteriaPost(String postId, String menuId, int evaluation, String comment){}
