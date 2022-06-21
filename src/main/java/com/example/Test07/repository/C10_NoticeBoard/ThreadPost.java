package com.example.Test07.repository.C10_NoticeBoard;

/**
 * 2022/06/21
 * 掲示板投稿データを保持するレコード
 * @param postId 投稿を識別するId
 * @param threadId 掲示板を識別するId
 * @param comment コメント
 * @author FujimuraTaiga
 * ver. 1.0.0
 */
public record ThreadPost(String postId, String threadId, String comment) {}
