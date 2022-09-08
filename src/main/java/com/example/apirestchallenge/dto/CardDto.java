package com.example.apirestchallenge.dto;

import com.example.apirestchallenge.enums.BRAND;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.YearMonth;

@AllArgsConstructor
@Getter
@Setter
@Valid
public class CardDto {
    @NotNull
    private BRAND brand;
    @Valid
    private HolderDto cardHolder;
    @NotNull
    private BigInteger cardNumber;
    @Future
    private YearMonth expiresAt;
}
