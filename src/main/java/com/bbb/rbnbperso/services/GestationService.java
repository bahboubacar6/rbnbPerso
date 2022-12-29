package com.bbb.rbnbperso.services;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.dtos.AppUserDTO;
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
    AppUserDTO saveUser(AppUserDTO appUserDTO);

    AppUserDTO updateUser(AppUserDTO appUserDTO);

    void deleteAppUser(Long idUser);

    AnnounceDTO saveAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException;
    List<AppUserDTO> listUsers();
    AppUserDTO getUser(Long idUser) throws UserNotFoundException;
    List<AnnounceDTO> listAnnounces();

    AnnounceDTO updateAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException;

    void deleteAnnounce(Long idAnnounce);

    AnnounceDTO getAnnounce(Long idAnnounce) throws AnnounceNotFoundException;
    List<Reservation> listReservations();
    Reservation getReservation(Long idReservation) throws ReservationNotFoundException;
}
