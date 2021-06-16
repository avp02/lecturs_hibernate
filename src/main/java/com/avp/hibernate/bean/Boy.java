package com.avp.hibernate.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boy {
    private Integer id;
    private String boy;
    private Timestamp timestamp;
}
