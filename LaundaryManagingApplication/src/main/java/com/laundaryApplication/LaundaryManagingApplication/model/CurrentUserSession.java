package com.laundaryApplication.LaundaryManagingApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {


    @Id
    private Integer userId;
    private String email;
    @NotNull
    private String uuid;
    @NotNull
    private LocalDateTime localDateTime;


}
