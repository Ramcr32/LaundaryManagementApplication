package com.laundaryApplication.LaundaryManagingApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {
    private LocalDateTime date;
    private String message;
    private String description;

}
