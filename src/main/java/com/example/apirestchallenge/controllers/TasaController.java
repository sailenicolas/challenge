package com.example.apirestchallenge.controllers;

import com.example.apirestchallenge.dto.OperationDto;
import com.example.apirestchallenge.exceptions.BindingResultException;
import com.example.apirestchallenge.model.Account;
import com.example.apirestchallenge.model.Card;
import com.example.apirestchallenge.model.Holder;
import com.example.apirestchallenge.model.Operation;
import com.example.apirestchallenge.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TasaController {


    @PostMapping("/tasa")
    public ResponseEntity<?> getPrice(@RequestBody @Valid OperationDto operation, BindingResult bindingResult) throws BindingResultException {
        if (bindingResult.hasErrors())
            throw new BindingResultException(bindingResult);
        Account account = new Account("", "", new BigDecimal( "150" ) );
        Operation operation1 = new Operation( account, operation.getAmount(), operation.getOperationType(), new Card( operation.getCard().getBrand(), new Holder(operation.getCard().getCardHolder().getName(), operation.getCard().getCardHolder().getLastName() ), operation.getCard().getCardNumber(), operation.getCard().getExpiresAt().atDay( 1 )));
        Map<String, Object> map = new HashMap<>();
        map.put( "brand", operation.getCard().getBrand().name() );
        map.put( "price", Utils.getPrice( operation1.getCard() ) );
        return ResponseEntity.ok( map );
    }
}
