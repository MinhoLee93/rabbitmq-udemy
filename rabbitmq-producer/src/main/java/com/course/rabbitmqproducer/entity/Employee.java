package com.course.rabbitmqproducer.entity;

import com.course.rabbitmqproducer.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String employeeId;

    private String name;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate birthDate;
}
