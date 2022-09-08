package com.example.apirestchallenge.dto;

import com.example.apirestchallenge.enums.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@Valid

public class OperationDto {
    @Setter(AccessLevel.NONE)
    private AccountDto account;
    @NotNull
    @DecimalMin( value = "0.0")
    private BigDecimal amount;
    private OperationType operationType;
    @Valid
    private CardDto card;

}
