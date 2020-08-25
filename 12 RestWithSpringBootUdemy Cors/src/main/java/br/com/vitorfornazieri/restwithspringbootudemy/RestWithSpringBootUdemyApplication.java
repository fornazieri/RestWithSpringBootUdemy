package br.com.vitorfornazieri.restwithspringbootudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration //permitir que o application context do spring, seja aumomaticamente carregado baseado nos jars que definimos
//@ComponentScan //é usada para dizer ao spring que ele deve escanear nossos pacotes e encontrar arquivos de configuração
public class RestWithSpringBootUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootUdemyApplication.class, args);
	}

}
