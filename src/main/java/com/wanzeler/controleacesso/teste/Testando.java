package com.wanzeler.controleacesso.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wanzeler.controleacesso.entities.PlanilhaControle;
import com.wanzeler.controleacesso.repositories.PlanilhaControleRepository;

@Configuration
@Profile("test")
public class Testando implements CommandLineRunner {

	@Autowired
	private PlanilhaControleRepository repo;

	@Override
	public void run(String... args) throws Exception {
			
		PlanilhaControle ent1 = new PlanilhaControle (null, "João", "entrega", "Suburbanos", "120.789.987-43","1/405", null, "20:31", "20:36");
		PlanilhaControle ent2 = new PlanilhaControle (null, "Paulo", "entrega", "Suburbanos", "122.079.907-12","1/302", null, "19:31", "19:36");
		PlanilhaControle ent3 = new PlanilhaControle (null, "André", "entrega", "Suburbanos", "090.789.987-05","1/401", null, "21:31", "21:36");
		PlanilhaControle ent4 = new PlanilhaControle (null, "Tiago", "entrega", "Suburbanos", "134.009.987-12","1/403", null, "20:23", "20:28");
		PlanilhaControle ent5 = new PlanilhaControle (null, "André", "entrega", "Suburbanos", "090.789.987-05","1/401", null, "21:31", "21:36");
			
		repo.saveAll(Arrays.asList(ent1, ent2, ent3, ent4, ent5));
		
	}
				
}