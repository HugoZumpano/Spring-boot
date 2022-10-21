package com.hugo.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hugo.myapi.domain.Usuarios;
import com.hugo.myapi.repositories.UsuariosRepository;

@SpringBootApplication
public class MyapApplication implements CommandLineRunner {
	
	@Autowired
	private UsuariosRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuarios usuario1 = new Usuarios(null, "Hugo Zumpano", "hugo", "1234");
		Usuarios usuario2 = new Usuarios(null, "Mariane Berger", "mary", "123");
		Usuarios usuario3 = new Usuarios(null, "joão Gomes ", "mary", "123");
		Usuarios usuario4 = new Usuarios(null, "Maria Roberta", "mary", "123");
		Usuarios usuario5 = new Usuarios(null, "Priscila Zumpano", "mary", "123");
		Usuarios usuario6 = new Usuarios(null, "Claudia Borges", "mary", "123");
		
		
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2,usuario3,usuario4,usuario5,usuario6));
		
		
		
		
		
	}

}
