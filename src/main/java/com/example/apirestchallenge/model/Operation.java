package com.example.apirestchallenge.model;

import com.example.apirestchallenge.enums.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
public class Operation {
    @Setter(AccessLevel.NONE)
    private Account account;
    private BigDecimal amount;
    private OperationType operationType;
    private Card card;

}
