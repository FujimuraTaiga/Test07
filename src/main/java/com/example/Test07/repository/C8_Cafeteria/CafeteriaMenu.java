package com.example.Test07.repository.C8_Cafeteria;

/**
 * 2022/06/21
 * 学食メニューのデータを保持するデータレコード
 * @param id メニューID
 * @param name メニュー名
 * @param explain メニュー説明
 * @param image メニュー画像のファイル名
 * @author FujimuraTaiga
 * ver. 1.0.0
 */

public record CafeteriaMenu(String id,String name,String explain,String image){}
