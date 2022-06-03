package com.example.Test07.repository.C8_Cafeteria;

/**
 * 学食メニューの情報を持つデータクラス
 * @author FujimuraTaiga
 */
public class CafeteriaMenu {
    /**
     * メニューID
     */
    String id;
    /**
     * メニュー名
     */
    String name;
    /**
     * メニュー説明
     */
    String explain;
    /**
     * メニュー画像
     */
    byte[] image;

    /**
     * コンストラクタ
     * @param id　メニューID
     * @param name　メニュー名
     * @param explain　メニュー説明
     * @param image　メニュー画像
     */
    CafeteriaMenu(String id,String name,String explain,byte[] image){
        this.id = id;
        this.name = name;
        this.explain = explain;
        this.image = image;
    }
}
