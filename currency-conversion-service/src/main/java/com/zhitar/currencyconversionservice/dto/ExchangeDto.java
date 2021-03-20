package com.zhitar.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
