package com.example.TacoCloud.domain;

import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
public class Order {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
