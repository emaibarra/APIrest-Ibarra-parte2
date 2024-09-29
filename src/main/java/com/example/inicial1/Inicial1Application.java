package com.example.inicial1;

import com.example.inicial1.dtos.PersonaDto;
import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, LocalidadRepository localidadRepository, AutorRepository autorRepository) {
		return args -> {

	//creo algunas localidades
			Localidad localidad1 = Localidad.builder()
					.denominacion("Guaymallen")
					.build();
			Localidad localidad2 = Localidad.builder()
					.denominacion("Godoy Cruz")
					.build();
			Localidad localidad3 = Localidad.builder()
					.denominacion("San Rafael")
					.build();

localidadRepository.save(localidad1);
localidadRepository.save(localidad2);
localidadRepository.save(localidad3);


Autor autor1 = Autor.builder()
		.apellido("Garcia")
		.nombre("Marquez")
		.biografia("Desconocida")
		.build();

autorRepository.save(autor1);


// Creo un objeto persona
Persona per1 = Persona.builder()
		.nombre("Ema")
		.apellido("Ibarra")
		.domicilio(Domicilio.builder()
				.calle("Luzuriaga")
				.numero(534)
				.localidad(localidad3)
				.build())
		.build();

//lo persisto
personaRepository.save(per1);

Persona per3 = Persona.builder()
		.nombre("Lucas")
		.apellido("Hernadez")
		.domicilio(Domicilio.builder()
				.calle("Formosa")
				.numero(4433)
				.localidad(localidad1)
				.build())
		.build();
personaRepository.save(per3);

// Creo otra persona
			Persona per2 = Persona.builder()
					.nombre("Tito")
					.apellido("Calderon")
					.domicilio(Domicilio.builder()
							.calle("La Plata")
							.numero(1134)
							.localidad(localidad3)
							.build())
					.build();


			// Lo grabo a través del repositorio de Spring
			personaRepository.save(per2);





			/*List<Persona> recuperadas = personaRepository.findAll();
			System.out.println(recuperadas);

			logger.info("Detalles de la persona: {}", recuperadas);




			Optional<Persona> recuperada = personaRepository.findById(1L);
			System.out.println(recuperada);

			logger.info("Detalles de la persona: {}", recuperada);*/



			//personaRepository.save(per1);




		};

		};




}
