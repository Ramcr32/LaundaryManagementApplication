package com.laundaryApplication.LaundaryManagingApplication.util;

import lombok.Data;

@Data
public class Query {
    private String title;
    private String searchQuery;
    private Long pageNumber;
    private  Long pageSize;
    private String sorting;
}
