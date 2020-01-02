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
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreatedMessage {

    private double  amount;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate createdDate;

    private String currency;

    private String invoiceNumber;
}
