package fr.eni.pigeonier;

import fr.eni.pigeonier.bo.Pigeon;
import fr.eni.pigeonier.dal.PigeonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PigeonierApplication implements CommandLineRunner {


	@Autowired
	PigeonDAO pigeonDAO;

	public static void main(String[] args) {
		SpringApplication.run(PigeonierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			// Créer des pigeons de test
			Pigeon pigeon1 = new Pigeon("Pigeon1", "PoGo", "1");
			Pigeon pigeon2 = new Pigeon("Pigeon2", "PoGo", "2");
			Pigeon pigeon3 = new Pigeon("Pigeon3", "PoGo", "3");
			Pigeon pigeon4 = new Pigeon("Pigeon4", "PoGo", "4");
			Pigeon pigeon5 = new Pigeon("Pigeon5", "PoGo", "5");
			Pigeon pigeon6 = new Pigeon("Pigeon6", "PoGo", "6");

			// Enregistrer les pigeons dans la base de données
			pigeonDAO.saveAll(List.of(pigeon1, pigeon2, pigeon3, pigeon4, pigeon5, pigeon6));
		}

	}

