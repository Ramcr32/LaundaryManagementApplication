package com.laundaryApplication.LaundaryManagingApplication.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private List<?> content;
    private Integer count;
//    private Integer noOfpage;
}
