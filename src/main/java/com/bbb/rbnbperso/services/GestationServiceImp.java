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
import com.bbb.rbnbperso.mappers.GestationMapperImp;
import com.bbb.rbnbperso.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class GestationServiceImp implements GestationService {

    private AnnounceRepository announceRepository;
    private AppUserRepository appUserRepository;
    private AvisRepository avisRepository;
    private ReservationRepository reservationRepository;
    private RoleRepository roleRepository;
    private GestationMapperImp dtoMappers;

    @Override
    public AppUserDTO saveUser(AppUserDTO appUserDTO) {
        log.info("Saving User");
        AppUser appUser = dtoMappers.fromAppUserDTO(appUserDTO);
        AppUser savedUser = appUserRepository.save(appUser);
        return dtoMappers.fromAppUser(savedUser);
    }

    @Override
    public AppUserDTO updateUser(AppUserDTO appUserDTO) {
        log.info("Saving User");
        AppUser appUser = dtoMappers.fromAppUserDTO(appUserDTO);
        AppUser savedUser = appUserRepository.save(appUser);
        return dtoMappers.fromAppUser(savedUser);
    }
    @Override
    public void deleteAppUser(Long idUser){
        appUserRepository.deleteById(idUser);
    }

    @Override
    public List<AppUserDTO> listUsers() {
        List<AppUser> userList = appUserRepository.findAll();
        List<AppUserDTO> appUserDTOS = userList.stream().map(user -> dtoMappers.fromAppUser(user)).collect(Collectors.toList());
        return appUserDTOS;
    }

    @Override
    public AppUserDTO getUser(Long idUser) throws UserNotFoundException {
        AppUser appUser = appUserRepository.findById(idUser).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        AppUserDTO appUserDTO = dtoMappers.fromAppUser(appUser);
        return appUserDTO;
    }

    @Override
    public AnnounceDTO saveAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException {
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
        AnnounceDTO announceDTO = dtoMappers.fromAnnounce(savedAnnounce);
        return announceDTO;
    }

    @Override
    public AnnounceDTO updateAnnounce(TypeAR type, LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate, String image, Long idUser) throws UserNotFoundException {
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
        AnnounceDTO announceDTO = dtoMappers.fromAnnounce(savedAnnounce);
        return announceDTO;
    }
    @Override
    public void deleteAnnounce(Long idAnnounce){
         announceRepository.deleteById(idAnnounce);
    }
    @Override
    public AnnounceDTO getAnnounce(Long idAnnounce) throws AnnounceNotFoundException {
        Announce announce = announceRepository.findById(idAnnounce).orElseThrow(()->new AnnounceNotFoundException("Announce Not Found"));
        return dtoMappers.fromAnnounce(announce);
    }
    @Override
    public List<AnnounceDTO> listAnnounces() {
        List<Announce> announceList = announceRepository.findAll();
        List<AnnounceDTO> announceDTOList = announceList.stream().map(announce -> dtoMappers.fromAnnounce(announce)).collect(Collectors.toList());
        return announceDTOList;
    }



    @Override
    public Reservation getReservation(Long idReservation) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(idReservation).orElseThrow(()->new ReservationNotFoundException("Reservation Not Found"));
        return reservation;
    }

    @Override
    public List<Reservation> listReservations() {
        return reservationRepository.findAll();
    }
}
