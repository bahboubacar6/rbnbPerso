package com.bbb.rbnbperso;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class RbnbpersoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbnbpersoApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AppUserRepository appUserRepository,
							AnnounceRepository announceRepository,
							AvisRepository avisRepository,
							ReservationRepository reservationRepository,
							RoleRepository roleRepository){
		return arg -> {
			/*Stream.of("Bart","Lisa","Omer").forEach(name->{
				AppUser appUser = new AppUser();
				appUser.setLastName(name);
				appUser.setFirstName("Simpson");
				appUser.setEmail(name+"@gmail.com");
				appUser.setUsername(name+"6");
				appUser.setPassword("1234");
				appUserRepository.save(appUser);
			});*/
			appUserRepository.findAll().forEach(user ->{
				Announce announce = new Announce();
				announce.setTypeAnnounce(TypeAR.CHAMBRE);
				announce.setDate(new LocalDate(2022,12,27));
			});
		};
	}

}
