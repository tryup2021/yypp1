package com.phome.yypp.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class Nums {
    private int id;
    private String num;
    private String password;

    public Nums(String num, String password) {
        this.num = num;
        this.password = password;
    }

}
