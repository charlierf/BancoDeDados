package com.example.teste;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.LongStream;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Usuario c = new Usuario();
						c.setNome("Contact " + i);
						c.setCpf(111111111);
						c.setDataNascimento(new Date());
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}