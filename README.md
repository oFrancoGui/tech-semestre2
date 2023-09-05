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


## API de Cadastro de Pessoas
- **Objetivo:** Cadastrar cadastrar as pessoas que estão vinculas a um usuário.
- **Local:** src/main/java/com/tc/tech_challange/controller/PessoasController.java
- **Endpoint:** `localhost:8080/api/v2/pessoa`


### POST cadastrar
Funcionalidade: Permite cadastar uma pessoa nova vincula ao usuário.

Endpoint: `localhost:8080/api/v2/pessoa`

Entrada
* JSON de DadosCadastroPessoa: Classe com os dados de input da tela e validações, para cadastro de uma nova pessoa vinculada ao usuário.

Saída
* String: Resposta de sucesso ao cadastrar a pessoa.

URI da Request POST ex.:
```
localhost:8080/api/v2/pessoa

{
    "email":"joana.marival@gmail.com",
    "cpf":"44558105010",
    "nome":"Joana Marival",
    "parentesco":"MAE",
    "genero":"FEMININO_CIS",
    "data":"1976-06-01"
}
```

Response POST ex.:

`Usuario registrado com sucesso, ID: f732f856-3878-4081-b855-6d50e4a1d867`


### GET detalhar
Funcionalidade: Recupera os dados de uma pessoa cadastrada.

Endpoint: `localhost:8080/api/v2/pessoa/{id}`

Entrada
* UUID id: ID da pessoa a ser detalhada.

Saída
* JSON de DadosDetalhamentoPessoas: Dados da pessoa recuperada no banco de dados.

URI da Request GET ex.:

`localhost:8080/api/v2/pessoa/f732f856-3878-4081-b855-6d50e4a1d867`

Response GET ex.:

```
{
    "cpf": "44558105010",
    "nome": "Joana Marival",
    "email": "joana.marival@gmail.com",
    "data": "1976-06-01T00:00:00.000+00:00",
    "parentesco": "MAE",
    "genero": "FEMININO_CIS"
}
```

### DELETE deleteById

Funcionalidade: Excluí uma pessoa informada do banco de dados (delete físico).

Endpoint: `localhost:8080/api/v2/pessoa/{id}`

Entrada
* UUID id: ID da pessoa a ser detalhada.

Saída
* String: Resposta de exclusão com sucesso.

URI da Request DELETE ex.:

`localhost:8080/api/v2/pessoa/f732f856-3878-4081-b855-6d50e4a1d867`

Response DELETE ex.:

`Registro excluído com sucesso.`

### PUT atualizar

Funcionalidade: Atualiza os dados da pessoa cadastrada.

Endpoint: `localhost:8080/api/v2/pessoa/{id}`

Entrada
* UUID id: Indentificador da pessoa a ter os dados atualizados
* JSON de DadosDetalhamentoPessoas: Contendo os dados alterados da pessoa

Saída
* String: Mensagem de dados atualizados com sucesso.

URI da Request PUT ex.:
```
localhost:8080/api/v2/pessoa/f732f856-3878-4081-b855-6d50e4a1d867

{
    "email":"lucas.pedrosa@gmail.com",
    "cpf":"87857312002",
    "nome":"Lucas Pedrosa",
    "parentesco":"IRMAO",
    "genero":"MASCULINO_CIS",
    "data":"1993-06-09"
}
```

Response PUT ex.:

`"Dados atualizados com sucesso"`


# Como empacotar e rodar o projeto

```
./mvnw clean package

java -jar target/tech-semestre2-0.0.1-SNAPSHOT.jar
```

# #####| Tech-Semestre2 |######
* Aluno: Vinícius Miranda de Menezes
* Fiap turma: 1ADJT

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

Request GET ex.:
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

Request POST ex.:
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

Request POST ex.:
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

Request DELETE ex.:

`http://localhost:8080/api/v2/endereco/40edc7a4-df0f-4ad9-95b5-0b1a5c8693e3`

Response DELETE ex.:

`Excluído com sucesos.`


### PUT atualizar
Funcionalidade: Permite atualizas os dados de um endereço, já cadastrado.

Entrada
* JUUID id: Identificardor de banco do endereço a ser atualizado.

Saída
* String: Resposta de atualização realizada com sucesso.

Request PUT ex.:

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



## API de Cadastro de Eletro
- **Objetivo:** Cadastrar um repositório de eletronicos com os campos de titulo, ean, marca, potencia, horas uso. Um mesmo cadastro poderá ser compartilhando com váriios endereços.
- **Local:** src/main/java/com/tc/tech_challange/controller/EnderecoController.java

### GET detalhar
Funcionalidade: Permite consultar um endereço cadastrados por ID.

Entrada
* UUID id: Identificador sequencial gerado automáticamente pelo sistema, na funcionalidade de cadastro de eletrodomésticos.

Saída
* String: Json do objeto DadosDetalhamentoEletro, com os dados do Endereço persistido no banco de dados.

Request GET ex.:
```
http://localhost:8080/api/v2/eletro/5328ffea-43a7-11ee-be56-0242ac120002
```
Response GET ex.:
```
{
    "titulo": "Smart Lâmpada Wi-Fi",
    "ean": "7899711165084",
    "marca": "POSITIVO",
    "potencia": 9,
    "voltagem": "V110"
}
```

### POST cadastrar
Funcionalidade: Permite cadastrar um Eletro

Entrada
* JSON de DadosCadastroEndereco: Classe com os dados de input da tela e validações, para cadastro de um novo eletrodomestico.

Saída
* JSON de DadosCadastroEletro: Json com os dados do Endereço persistido no banco de dados.

Request POST ex.:
```
http://localhost:8080/api/v2/eletro

{	
	"ean":"37465756",
	"titulo":"lampada",
	"voltagem":"V110",
	"marca":"AMIGO"
}
```

Response POST ex.:
```
{
	"message":"Eletro registrado com sucesso", 
	"ID": "205beb74-abea-4e49-b4e1-c53bc00df6ae"
}
```

### DELETE deleteById
Funcionalidade: Permite excluir um Eletro

Entrada
* JUUID id: Identificardor de banco do eletrotrodomestico a ser excluído.

Saída
* String: Resposta de exclusão com sucesso.

Request POST ex.:
```
http://localhost:8080/api/v2/eletro

{	
	"ean":"37465756",
	"titulo":"lampada",
	"voltagem":"V110",
	"marca":"AMIGO"
}
```

Request DELETE ex.:

`http://localhost:8080/api/v2/eletro/205beb74-abea-4e49-b4e1-c53bc00df6ae`

Response DELETE ex.:

`Excluído com sucesso.`


### PUT atualizar
Funcionalidade: Permite atualizas os dados de um endereço, já cadastrado.

Entrada
* JUUID id: Identificardor de banco do endereço a ser atualizado.

Saída
* String: Resposta de atualização realizada com sucesso.

Request PUT ex.:

```
http://localhost:8080/api/v2/eletro/205beb74-abea-4e49-b4e1-c53bc00df6ae

{	
	"ean":"37465756",
	"titulo":"lampada",
	"voltagem":"V110",
	"marca":"AMIGO"
}
```

Response PUT ex.:

`Dados atualizados com sucesso`



