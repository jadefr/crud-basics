# crud-basics-first
Estudo sobre Java Web

Foi desenvolvida uma API REST, seguindo o framework Spring Boot 2, para realizar as operações CRUD em um banco de dados MySQL.

O objeto modelado é um contato, cujos atributos são: id, name, email, phone. O banco, portanto, armazena uma lista de contatos.

Projeto baseado em https://www.oracle.com/technetwork/pt/articles/dsl/crud-rest-sb2-hibernate-5302424-ptb.html

# Tech Stack
* Java 8
* SQL

# Dependências Utilizadas

* Web
* JPA
* Lombok
* MySQL

# Operações

   * Listar todos os contatos 
              
            @GetMapping(“/contatos)
    
   * Obter um contato específico pelo ID
   
          @GetMapping(“/contatos/{id}”)
    
   * Remover um contato pelo ID 
          
          @DeleteMapping(“/contatos/{id}”)
    
   * Criar um novo contato 
      
          @PostMapping(“/contatos)
          
          exemplo de objeto:
          {
            "name": "Java",
            "email": "java@email.com",
            "phone": "(111) 111-1111"
          }
    
   * Atualizar detalhes de um contato 
   
          @PutMapping(“/contatos/{id}”)
          
          exemplo de objeto:
          {
            "name": "Java",
            "email": "java@email.com",
            "phone": "(111) 111-1111"
          }

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

O arquivo application.properties foi configurado de acordo com o seguinte: 

	## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
	spring.datasource.url=jdbc:mysql://localhost:3306/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	spring.datasource.username=
	spring.datasource.password=

	# Dialeto SQL melhorar o SQL gerado pelo Hibernate
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
      
    # Hibernate ddl auto (create, create-drop, validate, update)
    spring.jpa.hibernate.ddl-auto=update 

Alternativamente, caso se queira criar a tabela manualmente no DataGrip, omite-se a última linha do código acima.

Neste caso, o código de criação da tabela em SQL é o seguinte:



	CREATE DATABASE crud;

	CREATE TABLE crud.contact (
		id INT NOT NULL,
		name VARCHAR(255) NULL,
		email VARCHAR(255) NULL,
		phone VARCHAR(45) NULL,
		PRIMARY KEY (id)
	);

	ALTER TABLE crud.contact
	CHANGE COLUMN id id INT(11) NOT NULL AUTO_INCREMENT,
		ADD UNIQUE INDEX id_UNIQUE (id ASC);


	

