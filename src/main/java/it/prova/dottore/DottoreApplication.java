package it.prova.dottore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DottoreService;

@SpringBootApplication
public class DottoreApplication implements CommandLineRunner {
	@Autowired
	private DottoreService DottoreServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(DottoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Dottore dottore1 = new Dottore("Nome1", "Cognome1", "CodiceDottore1", "CodiceFiscalePaziente1", true,
					false);
			DottoreServiceImpl.inserisciNuovo(dottore1);
	}
}
