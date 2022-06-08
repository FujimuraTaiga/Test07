package com.example.Test07.repository.C8_Cafeteria;

/**
 * 食堂メニューのデータを保持するデータレコード
 * @param id　メニューID
 * @param name　メニュー名
 * @param explain　メニュー説明
 * @param image　メニュー画像
 */
public record CafeteriaMenu(String id,String name,String explain,String image){}
