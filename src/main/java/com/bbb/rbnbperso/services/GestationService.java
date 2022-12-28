package com.bbb.rbnbperso.services;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Reservation;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface GestationService {
    AppUser saveUser(AppUser appUser);
    Announce saveAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException;
    List<AppUser> listUsers();
    AppUser getUser(Long idUser) throws UserNotFoundException;
    List<Announce> listAnnounces();
    Announce getAnnounce(Long idAnnounce) throws AnnounceNotFoundException;
    List<Reservation> listReservations();
    Reservation getReservation(Long idReservation) throws ReservationNotFoundException;
}
