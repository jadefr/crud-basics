package com.jade.crudbasicsfirst.controller;

import com.jade.crudbasicsfirst.dao.ContactRepository;
import com.jade.crudbasicsfirst.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A anotação RestController contém as anotações Controller e ResponseBody
 */
@RestController
@RequestMapping({"/contatos"})
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }


    /**
     * lista todos os contatos
     * <p>
     * utiliza o método findAll da interface JpaRepository que faz um select * from contacts
     */
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }


    /**
     * obtém um contato específico pelo id
     * <p>
     * faz um select * from contacts where id = ?
     * O método map transforma (mapeia) o registro retornado em um tipo ResponseEntity
     */
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    /**
     * cria um contato
     *
     * chama o método save da interface JpaRepository
     *
     * após criar o registro na tabela, retorna o contato com o atributo id populado e o
     * registro é retornado no corpo de resposta.
     *
     * a anotação RequestBody indica que o conteúdo do corpo da requisição é um objeto (da classe Contact) em JSON
     */
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }


    /**
     * atualiza um contato, dado seu id
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Contact contact) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    /**
     *  remove um contato, dado seu id
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
