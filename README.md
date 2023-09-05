# #####| Tech-Semestre2 |######
* Fiap turma: 1ADJT
* GRUPO: 60
   *  Eric da Silva Moraes - RM 348492
   * Lucca Brito Gesteira - RM 349111
   *  Guilherme Franco - RM 350562
   *  Vinícius Miranda de Menezes - RM 348870


Desenvolvimento de um sistema WEB, com interfaces e APIs, para cadastro de Pessoas, Casas
e Eletrodomésticos. Este sistema tem por finalidade calcular o consumo mensal de energia.

Funcionalidades
- API de Cadastro de Endereços
- API de gestão de pessoas
- API de gestão de eletrodomésticos

# Estrutura do projeto
Como a projeto possui 3 APIs principais e outas de suporte. Localizado em
```
src/main/java/com/tc/tech_challange/controller  
- ./EletroController.java
- ./EnderecoController.java
- ./PessoasController.java
- ./UserController.java
- ./UsoEletroEnderecoController.java
```

# Estrutura do projeto
Se tratando um laboratório com foco na aprendizagem na primeira fase para criação de APIs REST com Spring Boot e na segunda fase de persistência com JPA, este projeto ainda não contem a camada de view do projeto, mas já contem as camadas responsáveis de controller e persistência, conforme a seguir: 
```
src/main/java/com/tc/tech_challange
- ./controller
- ./domain
- ./infra
- ./repositories
```

# Como montar o ambiente
O JPA deste projeto foi configurado para criara automáticamente todas as tabelas necessárias. Basta configurar corretamente no
**application.properties** 
as configurações do banco de dados na máquina local, num schema vazio e inicar o projeto.

Quando a aplicação subir o banco de dados deve ser criado conforme o seguinte digrama MER:
![MER_do_banco_de_dados.png](src%2Fmain%2Fresources%2FMER_do_banco_de_dados.png)


## Tecnologias empregadas

### Repositório
Este projeto utiliza JPA para mapear as entidades (objetos Java) em entidades de banco relacional, com o Postgresql. 
O acesso ao banco de dados é todo encapsulado na camada `com/tc/tech_challange/repositories`, extendendo a classe do framwork JPA JpaRepository.
Na camada `com/tc/tech_challange/domain` as classes de domínio são mapeadas em relação as tabelas com as anotações de mapeando modelo relacional como @Table @Column

O acesso ao repositório de dados é injetado em:
`@Autowired
private EletroRepository repository;`
para cada API.

### Lombok
Foi utilizado o framework Lombok, com objetivo de diminuir a verbosidade das classes de mapeamento JPA, DTOs, Beans entre outros.

Durante o desenvolvimento deste projeto foi possível identificar que a sua vantagem é evitar a repetição comuns de códigos, como a criação de gets e sets para todos os atributos, métodos equals e hashCode, toString, Construtores entre outros. Dessa forma, o código fica mais limpo e claro.

### Validadores de campos
Para a validação de campos foi utilizado o pacote da bliblioteca do jakarta.validation.constraints.*. Com esta solução foi possível fácilmene mapear regras de validação um simples anotation, como: obrigatóridade de campos, valores máximos e mínimos e até regexp, conforme será destacando na seção das APIs.

# Documentação das APIs

## API de Cadastro de Endereços
- **Objetivo:** Cadastrar um repositório de endereços com os campos de rua, número, bairro, cidade e estado. Um mesmo cadastro poderá ser compartilhando com várias pessoas.
- **Local:** src/main/java/com/tc/tech_challange/controller/EnderecoController.java

### GET detalhar
Funcionalidade: Permite consultar um endereço cadastrados por ID.

Entrada
* UUID id: Identificador sequencial gerado automáticamente pelo sistema, na funcionalidade de cadastro de endereço.

Saída
* String: Json do objeto DadosDetalhamentoEndereco, com os dados do Endereço persistido no banco de daos.

URI da Request GET ex.:
```
http://localhost:8080/api/v2/endereco/eaf79fe6-9043-41c4-b61e-64e2a0310906
```
Response GET ex.:
```
{
    "id": "eaf79fe6-9043-41c4-b61e-64e2a0310906",
    "cep": 12345678,
    "rua": "Rua dos Bobos",
    "numero": 5,
    "compl": "",
    "bairro": "Vila do Chaves",
    "cidade": "São Paulo",
    "estado": "SP"
} 
```

### POST cadastrar
Funcionalidade: Permite cadastrar um Endereço

Entrada
* JSON de DadosCadastroEndereco: Classe com os dados de input da tela e validações, para cadastro de um novo endereço.

Saída
* JSON de DadosCadastroEndereco: Json com os dados do Endereço persistido no banco de dados.

URI da Request POST ex.:
```
http://localhost:8080/api/v2/endereco

{
  "cep": 12345678,
  "rua": "Rua dos Bobos",
  "numero": 5,
  "compl": "",
  "bairro": "Vila do Chaves",
  "cidade": "São Paulo",
  "estado": "SP"
}
```

Response POST ex.:
```
{
"id": "eaf79fe6-9043-41c4-b61e-64e2a0310906",
"cep": 12345678,
"rua": "Rua dos Bobos",
"numero": 5,
"compl": "",
"bairro": "Vila do Chaves",
"cidade": "São Paulo",
"estado": "SP"
}
```

### DELETE deleteById
Funcionalidade: Permite excluir um endereço

Entrada
* JUUID id: Identificardor de banco do endereço a ser excluído.

Saída
* String: Resposta de exclusão com sucesso.

URI da Request DELETE ex.:
```
http://localhost:8080/api/v2/endereco/40edc7a4-df0f-4ad9-95b5-0b1a5c8693e3
```

Response DELETE ex.:

`Excluído com sucesos.`


### PUT atualizar
Funcionalidade: Permite atualizas os dados de um endereço, já cadastrado.

Entrada
* JUUID id: Identificardor de banco do endereço a ser atualizado.

Saída
* String: Resposta de atualização realizada com sucesso.

URI da Request PUT ex.:

```
http://localhost:8080/api/v2/endereco/40edc7a4-df0f-4ad9-95b5-0b1a5c8693e3

{
  "cep": 12345678,
  "rua": "Rua dos Bobos",
  "numero": 5,
  "compl": "",
  "bairro": "Vila do Chaves",
  "cidade": "São Paulo",
  "estado": "SP"
}
```

Response PUT ex.:

`Dados atualizados com sucesso`


# Como empacotar e rodar o projeto

```
./mvnw clean package

java -jar target/smart-class-0.0.1-SNAPSHOT.jar
```



