package com.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter

@Entity
public class Student {
    @Id
    private String sId;
    private String sName;
    private String sEmail;
    private char sGender;
    private int sClass;


    public void setsId(int sId) {
        if(sId>0){
            LocalDate date = LocalDate.now();
            String monthInitial = date.getMonth().toString().substring(0, 1);
            String yearTwoDigits = String.valueOf(date.getYear()).substring(2);

            this.sId = monthInitial + yearTwoDigits+"00" + sId;
        }

    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsEmail(String sEmail) {
        String domain="@gmail.com";
//        if (sEmail.substring(sEmail.length() - domain.length()).equals(domain)) {
//            this.sEmail = sEmail;
//        }

        if(sEmail.endsWith(domain)){
            this.sEmail = sEmail;
        }

    }

    public void setsGender(char sGender) {
        if(sGender=='M' || sGender=='m'||sGender=='F'||sGender=='f'){
            this.sGender = Character.toUpperCase(sGender);
        }

    }

    public void setsClass(int sClass) {
        if(sClass<=12){
            this.sClass = sClass;
        }

    }
}

