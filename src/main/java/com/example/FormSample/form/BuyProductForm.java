package com.example.FormSample.form;

import lombok.Data;

@Data
public class BuyProductForm {
    private Integer userId;
    private String productName;
    private Integer productPrice;
}
