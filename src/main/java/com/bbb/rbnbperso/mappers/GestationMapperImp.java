package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GestationMapperImp {

    public AppUserDTO fromAppUser(AppUser appUser){
        AppUserDTO appUserDTO = new AppUserDTO();
        BeanUtils.copyProperties(appUser, appUserDTO);
        return appUserDTO;
    }

    public AppUser fromAppUserDTO(AppUserDTO appUserDTO){
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDTO,appUser);
        return appUser;
    }

    public AnnounceDTO fromAnnounce(Announce announce){
        AnnounceDTO announceDTO = new AnnounceDTO();
        BeanUtils.copyProperties(announce, announceDTO);
        announceDTO.setAppUserDTO(fromAppUser(announce.getAppUser()));
        return announceDTO;
    }

    public Announce fromAnnounceDTO(AnnounceDTO announceDTO){
        Announce announce = new Announce();
        BeanUtils.copyProperties(announceDTO, announce);
        announce.setAppUser(fromAppUserDTO(announceDTO.getAppUserDTO()));
        return announce;
    }
}
