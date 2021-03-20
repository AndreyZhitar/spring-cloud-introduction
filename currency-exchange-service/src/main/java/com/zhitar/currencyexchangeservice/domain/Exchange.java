package com.zhitar.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exchanges_seq")
    @SequenceGenerator(
            name = "exchanges_seq", sequenceName = "exchanges_seq",
            initialValue = 10, allocationSize = 1)
    private Long id;
    @Column(length = 3, name = "currency_from")
    private String from;
    @Column(length = 3, name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
    @Transient
    private int port;

}
