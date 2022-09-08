package com.example.apirestchallenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter
@Getter
public class AccountDto extends HolderDto{

    public AccountDto(@NotBlank String name, @NotBlank String lastName, BigDecimal amount) {

        super( name, lastName );
        this.amount = amount;
    }

    private BigDecimal amount;
    @Override
    public String toString() {

        return "Account{" + "amount=" + amount +
                '}';
    }
}
