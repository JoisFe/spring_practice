package com.example.TacoCloud.config.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "taco.orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class OrderProps {

    @Min(value = 5, message = "must be between 5 and 25")
    @Max(value = 25, message = "must be between 5 and 25")
    private int pageSize = 20;
}
