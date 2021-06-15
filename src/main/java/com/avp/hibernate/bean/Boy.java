package com.avp.hibernate.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Boy {
    private String name;
    private List<Toy> toyList = new ArrayList<>();

    public Boy(String name) {
        this.name = name;
    }
}
