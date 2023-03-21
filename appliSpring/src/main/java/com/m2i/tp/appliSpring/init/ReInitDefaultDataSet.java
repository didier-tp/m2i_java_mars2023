package com.m2i.tp.appliSpring.init;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpring.dto.CompteDto;
import com.m2i.tp.appliSpring.service.ICompteService;

@Component
@Profile("reInit") //cette classe sera prise en compte que si 
                   //le profil "reInit" est activé au démarrage de l'application
public class ReInitDefaultDataSet {

	@Resource
	private ICompteService compteService;
	
	
	@PostConstruct
	public void initDataSet() {
		
	
		CompteDto cptA = new CompteDto(null,"compte_A",50.0);
		cptA = compteService.create(cptA); 
		
		CompteDto cptB = new CompteDto(null,"compte_B",150.0);
		cptB= compteService.create(cptB);
		
		CompteDto cptC = new CompteDto(null,"compte_C",60.0);
		cptC = compteService.create(cptC); 
		
		CompteDto cptD = new CompteDto(null,"compte_D",160.0);
		cptD= compteService.create(cptD);
	}
	
	

}
