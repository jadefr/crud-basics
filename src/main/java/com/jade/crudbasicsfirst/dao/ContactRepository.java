package com.jade.crudbasicsfirst.dao;

import com.jade.crudbasicsfirst.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface fornece os métodos para o CRUD
 *
 *  A interface JpaRepository precisa de dois parâmetros do tipo Generics:
 *  o primeiro é a entidade JPA que representa a tabela e o segundo é o
 *  tipo da chave primária (o mesmo tipo do atributo id).
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
