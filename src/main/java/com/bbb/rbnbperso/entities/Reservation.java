package com.bbb.rbnbperso.entities;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeAR typeReservation;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
}
