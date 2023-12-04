package com.example.paysec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Apisec {
    @Value("${api.s}")
    String s;
    public String returnApis(){
        return s;
    }
}
