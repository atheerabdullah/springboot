package com.example.homework.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Customer {

    private Long id;
    private String username;
    private int balance;

}
