package com.example.apirestchallenge;

import com.example.apirestchallenge.enums.BRAND;
import com.example.apirestchallenge.enums.OperationType;
import com.example.apirestchallenge.model.Account;
import com.example.apirestchallenge.model.Card;
import com.example.apirestchallenge.model.Holder;
import com.example.apirestchallenge.model.Operation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import static com.example.apirestchallenge.utils.Utils.*;

public class Main {

    public static void main(String[] args) {

        try {
            Account account = new Account("John", "Frenzy", new BigDecimal( "150" ));
            Holder cardHolder = new Holder( "John", "Frenzy" );
            Card card = new Card( BRAND.AMEX, cardHolder, new BigInteger( "12332321232132" ), LocalDate.now().minusYears( 2 ) );
            Operation operation = new Operation( account, new BigDecimal( "12332321232132" ), OperationType.PAYING ,card);
            Card card1 = new Card( BRAND.AMEX, new Holder( "Jane", "Frenzy" ), new BigInteger( "12332321232132" ), LocalDate.now().minusYears( 2 ) );

            account.setAmount( new BigDecimal( "900.5" ) );
            String summary = getSummary( operation );

            boolean operationValid = isOperationValid( operation );
            boolean cardValid = isCardValid( operation );
            boolean cardDifferent = isCardDifferent( card, card1 );
            String cardByBrand = getPriceByBrand( card );
            System.out.println( "summary = " + summary );
            System.out.println( "cardByBrand = " + cardByBrand );
            System.out.println( "cardDifferent = " + cardDifferent );
            System.out.println( "cardValid = " + cardValid );
            System.out.println( "isCardDifferent( card, card ) = (they are equal)" + isCardDifferent( card, card ) );
            System.out.println( "operationValid = " + operationValid );

        }catch (Exception e) {
            System.out.println( "error = " + e.getMessage() );
        }
    }



}