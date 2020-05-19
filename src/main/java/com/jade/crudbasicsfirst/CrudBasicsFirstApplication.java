package com.jade.crudbasicsfirst;

import com.jade.crudbasicsfirst.dao.ContactRepository;
import com.jade.crudbasicsfirst.model.Contact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

/**
 * https://www.oracle.com/technetwork/pt/articles/dsl/crud-rest-sb2-hibernate-5302424-ptb.html
 */
@SpringBootApplication
public class CrudBasicsFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudBasicsFirstApplication.class, args);
    }


    /**
     * opcional
     *
     * remove-se todos os registros da base, e logo após, cria-se um stream de 1 até 11 (não inclusivo),
     * e para cada iteração, insere um registro de teste na base e imprime (toString da classe Contact).
     * No total serão inseridos 10 registros na base.
     */
    @Bean
    CommandLineRunner init(ContactRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Contact c = new Contact();
                        c.setName("Contact " + i);
                        c.setEmail("contact" + i + "@email.com");
                        c.setPhone("(111) 111-1111");
                        return c;
                    })
                    .map(repository::save)
                    .forEach(System.out::println);
        };
    }
}
