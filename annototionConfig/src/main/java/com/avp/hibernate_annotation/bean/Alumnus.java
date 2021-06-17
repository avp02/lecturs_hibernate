package com.avp.hibernate_annotation.bean;

import lombok.*;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = true)
public class Alumnus extends Student{

    private boolean isHired;
    @OneToOne
    private AlumnusPIIData piiData;
}
