package com.example.apirestchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class HolderDto {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;

    @Override
    public String toString() {

        return "Holder{" + "name='" + name + ",'\n" +
                "lastName='" + lastName + "'\n" +
                '}';
    }
}
