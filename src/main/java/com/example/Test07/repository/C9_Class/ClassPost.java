package com.example.Test07.repository.C9_Class;

/**
 * 2022/06/21
 * 食堂の投稿に関するデータを保持するデータレコード
 * @param postId 投稿ID
 * @param classId 授業ID
 * @param evaluation 評価
 * @param comment コメント
 */
public record ClassPost(String postId, String classId, int evaluation, String comment) {}
