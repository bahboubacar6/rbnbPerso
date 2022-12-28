package com.bbb.rbnbperso.services;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Reservation;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GestationServiceImp implements GestationService {

    private AnnounceRepository announceRepository;
    private AppUserRepository appUserRepository;
    private AvisRepository avisRepository;
    private ReservationRepository reservationRepository;
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving User");
        AppUser savedUser = appUserRepository.save(appUser);
        return savedUser;
    }

    @Override
    public Announce saveAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException {
        AppUser user = appUserRepository.findById(idUser).orElse(null);

        if(user == null)
            throw new UserNotFoundException("User Not Found");
        Announce announce = new Announce();
        announce.setTypeAnnounce(type);
        announce.setDate(date);
        announce.setStartDate(startDate);
        announce.setEndDate(endDate);
        announce.setImage(image);
        announce.setAppUser(user);
        Announce savedAnnounce = announceRepository.save(announce);
        return savedAnnounce;
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUser(Long idUser) throws UserNotFoundException {
        AppUser appUser = appUserRepository.findById(idUser).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        return appUser;
    }

    @Override
    public List<Announce> listAnnounces() {
        return announceRepository.findAll();
    }

    @Override
    public Announce getAnnounce(Long idAnnounce) throws AnnounceNotFoundException {
        Announce announce = announceRepository.findById(idAnnounce).orElseThrow(()->new AnnounceNotFoundException("Announce Not Found"));
        return announce;
    }

    @Override
    public List<Reservation> listReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservation(Long idReservation) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(idReservation).orElseThrow(()->new ReservationNotFoundException("Reservation Not Found"));
        return reservation;
    }
}
