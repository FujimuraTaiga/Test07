package com.example.Test07.repository.cafeteria;

public class CafeteriaPost {
    String postId;
    String menuId;
    double evaluation;
    String comment;

    CafeteriaPost(String postId,String menuId,double evaluation,String comment){
        this.postId = postId;
        this.menuId = menuId;
        this.evaluation = evaluation;
        this.comment = comment;
    }
}
