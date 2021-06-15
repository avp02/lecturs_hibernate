package com.avp.hibernate;

import com.avp.hibernate.bean.Boy;
import com.avp.hibernate.bean.Toy;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Toy hulaHoop = new Toy("hulaHoop");
        Toy solder = new Toy("solder");
        Toy boll = new Toy("boll");
//        List<Toy> listToy = new ArrayList<>();
//        listToy.add(hulaHoop);
//        listToy.add(solder);
//        listToy.add(boll);

//        Boy david = new Boy("David", listToy);
        Boy david = new Boy("David");

        david.getToyList().addAll(List.of(hulaHoop, solder, boll));

        System.out.println(david);
    }
}
