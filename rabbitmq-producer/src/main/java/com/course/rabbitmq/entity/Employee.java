package com.course.rabbitmq.entity;

import com.course.rabbitmq.json.CustomLocalDateSerializer;
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
