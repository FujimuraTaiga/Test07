package com.example.Test07.repository.C9_Class;

/**
 * 2022/06/21
 * 授業投稿データを持つレコード
 * @param postId 授業投稿を識別するId
 * @param classId 授業を識別するId
 * @param evaluation 評価の数値
 * @param comment コメント
 * ver. 1.0.0
 */

public record ClassPost(String postId, String classId, int evaluation, String comment) {}
