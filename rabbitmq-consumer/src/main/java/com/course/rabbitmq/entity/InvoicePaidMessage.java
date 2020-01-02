package com.course.rabbitmq.entity;

import com.course.rabbitmq.json.CustomLocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate paidDate;
}
