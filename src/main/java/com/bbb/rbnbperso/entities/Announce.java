package com.bbb.rbnbperso.entities;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_announce")
    private Long idAnnounce;
    private TypeAR typeAnnounce;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private AppUser appUser;
    @OneToOne
    private Reservation reservation;
}
