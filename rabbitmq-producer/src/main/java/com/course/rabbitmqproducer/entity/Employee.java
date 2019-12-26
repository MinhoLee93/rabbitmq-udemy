package com.course.rabbitmqproducer.entity;


import com.course.rabbitmqproducer.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.LocalDate;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Employee {
    private String employeeId;
    private String name;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;

    public Employee(){

    }

    public Employee(String employeeId, String name, LocalDate birthDate){
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
    }

}
