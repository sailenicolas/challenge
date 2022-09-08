package com.example.apirestchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Holder {

    private String name;
    private String lastName;

    @Override
    public String toString() {

        return "Holder{" + "name='" + name + ",'\n" +
                "lastName='" + lastName + "'\n" +
                '}';
    }
}
