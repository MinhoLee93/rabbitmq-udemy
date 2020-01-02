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
public class InvoicePaidMessage {

    private String invoiceNumber;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate paidDate;
}
