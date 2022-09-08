package com.example.apirestchallenge.model;

import com.example.apirestchallenge.enums.BRAND;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

import static com.example.apirestchallenge.utils.Utils.getPrice;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Card {


    @Override
    public String toString() {

        return "Card{" + "brand=" + brand + "',\n" +
                "cardHolder='" + cardHolder + "',\n" +
                "cardNumber=" + cardNumber + "',\n" +
                "expiresAt=" + expiresAt + "',\n" +
                "price='" + getPrice( this ) + "'\n" +
                '}';
    }

    private BRAND brand;
    @NotNull
    @ManyToOne
    private Holder cardHolder;
    private BigInteger cardNumber;
    private LocalDate expiresAt;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return getBrand() == card.getBrand() && getCardHolder().equals( card.getCardHolder() ) && getCardNumber().equals( card.getCardNumber() ) && getExpiresAt().equals( card.getExpiresAt() );
    }

    @Override
    public int hashCode() {

        return Objects.hash( getBrand(), getCardHolder(), getCardNumber(), getExpiresAt() );
    }
}
