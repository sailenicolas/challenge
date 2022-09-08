package com.example.apirestchallenge.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Account extends Holder{
    private BigDecimal amount;

    public Account(String name, String lastName, BigDecimal amount) {

        super( name, lastName );
        this.amount = amount;
    }

    @Override
    public String toString() {

        return "Account{" + "amount=" + amount +
                '}';
    }
}
