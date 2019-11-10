# hows-the-weather

##### Sobre o projeto:
Consome dados da API aberta OpenWeather, utilizando um broker, api-rest e mongo database. 

##### Para rodar o projeto, é necessário:

1. MongoDatabase CE        = Banco NoSQL de código aberto (https://docs.mongodb.com/manual/installation/)
2. Apache ActiveMQ Artemis = Broker de código aberto fornecido pela APACHE (https://activemq.apache.org/components/artemis);
3. JVM 8                   = Ambiente de código aberto fornecido pela Oracle para 
execução de softwares escritos em Java;
4. Maven                   = Empacotador de código aberto fornecido pela APACHE;

## Organização do projeto:

##### Dividido em 3 aplicações:

**1. hows-the-weather-broker**
Broker do projeto, nele estão as configurações do ConnectionFactory e Session, além do produtor da mensagem. Está aplicação utiliza ActiveMQ-Artemis;

É necessário criar o BROKER no artemis, para isso, siga os passos:

> 1.1 Faça o download do Apache ActiveMQ Artemis no site da apache (https://activemq.apache.org/components/artemis) 

> 1.2 Extraia o arquivo e acesse o diretório "bin";

> 1.3 Execute o comando: "./artemis create WEATHER-BROKER";

> > 1.3.1 Defina o usuário de acesso do broker como "admin";

> > 1.3.2 Defina a senha de acesso ao broker como "w2019";

> > 1.3.3 Responda "N" para a pergunta que segue, pois o Broker não é acessado anônimamente;

**Obs.: Não altere o usuário, a senha e o nome do broker, pois o projeto não funcionará sem que ajustes sejam feitos.**

**2. hows-the-weather-request, responsável por:**
> 2.1 Receber requisições dos usuários através de um serviço rest;

> 2.2 Produzir mensagens na pilha de entrada do broker;

> 2.3 Consumir mensagens da pilha de "entrega" do broker

> 2.4 Registrar o resultado em um banco de dados qualquer (Para este projeto, foi utilizado Mongo Database CE);

**O serviço está configurado para rodar na porta 8081;**

**É necessário compilar o projeto;**

**O serviço foi desenvolvido utilizando SpringBoot, portanto, para publicá-lo basta executar o comando: java -jar hows-the-weather-request.jar**

**3. hows-the-weather-service (RestTemplate), responsável por:**
> 3.1) Consumir mensagens na pilha de entrada do broker;

> 3.2) Interagir com os serviços da API "Open Weather";

> 3.3) Produzir mensagens com o resultado do consumo dos serviços da API "OpenWeather";  
**O serviço está configurado para rodar na porta 8080;**

**É necessário compilar o projeto;**

**O serviço foi desenvolvido utilizando SpringBoot, portanto, para publicá-lo basta executar o comando: java -jar hows-the-weather-service.jar;**

**_O projeto possui um modelo de dados próprio que facilita a interação para o "dono da consulta". A cada requisição é devolvido ao usuário um "Identificador", este número é para recuperar o resultado da consulta realizada**

##### Para consumir dados da API, siga os passos:
1. Inicie o broker, para isso:
> 1.1 Acesse o diretório de instalação do ActiveMQ Artemis;

> 1.2 Acesse o diretório "bin";

> 1.3 Dentro do diretório "bin" é possível encontrar o diretório "WEATHER-BROKER", é preciso acessar este diretório;

> 1.4 Dentro do diretório "WEATHER-BROKER", acesse o diretório "bin";

> 1.5 Dentro do diretório "bin", execute o comando, "./artemis-service start"

2. Registre o banco de dados
> 2.1 Inicie o serviço do Mongo Database;

> 2.2 Crie o banco de dados _w2019_ **(Execute o comando no terminal, "use w2019")**;

> 2.3 Crie o usuário de acesso com permissão de leitura e escrita para banco de dados _w2019_, para isso, execute o script:

**_db.createUser({user:"w2019",pwd:"w201XXX_#$$#19",roles:[
  {
	  role: "readWrite", db: "ws2019"
	}
]});**

3. Compile os 3 projetos:
> 3.1 **hows-the-weather-broker;**

> 3.2 **hows-the-weather-request;**

> 3.3 **hows-the-weather-service;**

4. Execute os projetos pelo terminal:

> 4.1 java -jar hows-the-weather-request.jar

> 4.2 java -jar hows-the-weather-service.jar

5. Abra o navegador e envie uma requisição para cada **_endpoint_**;

##### Main path = "howstheweather"
##### Consulta por cidade
**%your_domain%/howstheweather/city/{name}/{country}**

Ex.: _http://%YOUR_DOMAIN%/howstheweather/city/Ribeirao Preto/BR_

##### Consulta por geolocalidade
**%your_domain%/howstheweather/geopoints/{lat}/{lgt}**

Ex.: _http://%YOUR_DOMAIN%/howstheweather/geopoints/-47.81/-21.18_

##### Consulta por cep
**%your_domain%/howstheweather/zipcode/{zipcode}/{country}**

Ex.: _http://%YOUR_DOMAIN%/howstheweather/zipcode/14051220/br_

##### Consulta por identificador da cidade
**%your_domain%/howstheweather/cityId/{id}**

Ex.: _http://%YOUR_DOMAIN%/howstheweather/cityId/3451328_

