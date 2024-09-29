package com.app.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    String name;
    String salary;
    String city;
    String country;

    public String convertInCSVFormat(){
        return name+" , "+salary+" , "+city+" , "+country;
    }
}
