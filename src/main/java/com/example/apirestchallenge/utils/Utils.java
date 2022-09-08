package com.example.apirestchallenge.utils;

import com.example.apirestchallenge.model.Card;
import com.example.apirestchallenge.model.Operation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Utils {


    public static BigDecimal getPrice(Card card) {

        switch (card.getBrand()) {
            case VISA -> {
                int year = card.getExpiresAt().getYear() - 2000;
                return BigDecimal.valueOf( year / card.getExpiresAt().getMonthValue() );
            }
            case NARA -> {
                return BigDecimal.valueOf( card.getExpiresAt().getDayOfMonth() * 0.5 );
            }
            case AMEX -> {
                return BigDecimal.valueOf( card.getExpiresAt().getMonthValue() * 0.1 );
            }
            default -> {
                return null;
            }
        }
    }

    public static String getSummary(Operation operation) {
        final StringBuilder sb = new StringBuilder( "{" );
        Card card = operation.getCard();
        sb.append( "card=" ).append( card );
        sb.append( ", amount='" ).append( operation.getAmount() ).append( "'\n" );
        sb.append( "}\n\n" );
        return sb.toString();
    }

    public static boolean isOperationValid(Operation operation) {
        return operation.getAccount().getAmount().compareTo( new BigDecimal( "1000" ) ) < 0;

    }
    public static boolean isCardValid(Operation operation) {
            return operation.getCard().getExpiresAt().isAfter( LocalDate.now());
    }

    public static boolean isCardDifferent(Card card, Card card1) {
        if(card1 == null) return false;
        return !card.equals( card1 );
    }

    public static String getPriceByBrand(Card card) {
        return card.getBrand()+": " + getPrice( card ) + "";
    }
}
