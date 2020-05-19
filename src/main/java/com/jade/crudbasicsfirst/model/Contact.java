package com.jade.crudbasicsfirst.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *  Esta classe é uma entidade JPA (representa a tabela do bd)
 *  chave primária: id  (por isso a anotação Id)
 *
 *  AllArgsConstructor: cria automaticamente um construtor com todas os atributos da classe como argumento.
 *  NoArgsConstructor: cria automaticamente um construtor vazio (sem argumentos).
 *  Data: cria automaticamente os métodos toString, equals, hashCode, getters e setters.
 *
 *  A anotação Entity pertence ao JPA e isso significa que a classe será automaticamente mapeada à tabela com o mesmo nome
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
}
