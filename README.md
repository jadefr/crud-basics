# crud-basics-first
Estudo sobre Java Web

Foi desenvolvida uma API REST, seguindo o framework Spring Boot 2, para realizar as operações CRUD em um banco de dados MySQL.

O objeto modelado é um contato, cujos atributos são: id, name, email, phone. O banco, portanto, armazena uma lista de contatos.

# Tech Stack
* Java 8
* SQL

# Dependências Utilizadas

* Web
* JPA
* Lombok
* MySQL

# Operações

   * Listar todos os contatos - @GetMapping(“/contatos)
    
   * Obter um contato específico pelo ID - @GetMapping(“/contatos/{id}”)
    
   * Remover um contato pelo ID - @DeleteMapping(“/contatos/{id}”)
    
   * Criar um novo contato - @PostMapping(“/contatos)
    
   * Atualizar detalhes de um contato - @PutMapping(“/contatos/{id}”)

# Estrutura Básica do Projeto

      src
        ├ java
        |  ├ controller
        |  |  └ ContactController.java 
        |  ├ dao
        |  |  └ ContactRepository.java
        |  ├ model
        |  |  └ Contact.java
        |  └ App.java
        └ resources 
          └ application.properties
          
  
# Anotações
      
## Lombok
 
 Utilizando as seguintes anotações na classe Contact, não se faz necessário gerar getters e setters e nem construtores explicitamente.
 
    * AllArgsConstructor: cria automaticamente um construtor com todas os atributos da classe como argumento.
    
    * NoArgsConstructor: cria automaticamente um construtor vazio (sem argumentos).
    
    * Data: cria automaticamente os métodos toString, equals, hashCode, getters e setters.
 
## JPA
      
 * A classe model/Contact.java apresenta a anotação @Entity, logo:
      
      * a classe é mapeada à tabela de mesmo nome
      * os atributos da classe se relacionam com as colunas da tabela
 
 * O acesso ao banco é feito através da interface dao/ContactRepository.java, que, anotada com @Repository, estende a interface JpaRepository (do Spring Data).
      
      * não foi necessário criar nenhum método na classe, pois não foi utilizada a camada de serviços
      
# Conexão com o Banco de Dados
