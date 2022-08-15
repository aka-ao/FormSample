package com.example.FormSample.entity.user;

public class NormalUser extends User {
    private final Integer postage = 500;

    public NormalUser(Integer userId, String userName, UserStatus status) {
        super(userId, userName, status);
    }

    @Override
    public String buyProduct(String name, Integer price) {
        Integer totalPrice = price + postage;
        return "あなたは一般ユーザです。商品" + name + "は" + price + "円です。送料は" + postage + "円です。合計" + totalPrice + "円になります。";
    }
}
