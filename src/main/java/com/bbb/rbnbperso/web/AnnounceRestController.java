package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("announces")
@AllArgsConstructor
public class AnnounceRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AnnounceDTO> listAnnounce(){
        List<AnnounceDTO> announceDTOList = gestationService.listAnnounces();
        return announceDTOList;
    }

    @GetMapping("/all/{id}")
    public AnnounceDTO getAnnounce(@PathVariable Long id) throws AnnounceNotFoundException {
        return gestationService.getAnnounce(id);
    }

    /*public AnnounceDTO saveAnnounce(AnnounceDTO announceDTO){
        gestationService.saveAnnounce()
    }*/
}
