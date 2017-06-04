package es.ucm.fdi.porras;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


import java.time.Instant;
import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
@Slf4j
public class PorrasApplication {

	private static final Logger log = LoggerFactory.getLogger(PorrasApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PorrasApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://127.0.0.1:{}\n\t" +
						"\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"));
		log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
	}

}
