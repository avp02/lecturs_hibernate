package com.avp.hibernate_annotation.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beasty_boys")
public class Boy {
    @Id
    @GeneratedValue
    private Integer id;
    private String boy;
    private String boyName;
    private String boyLastName;
    @Column(name = "nickname", unique = true)
    private String login;
    @UpdateTimestamp
    private Timestamp timestamp;
}
