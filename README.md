# hows-the-weather

Sobre o projeto:
 O projeto faz uso de um broker, rest-api e mongo database. Tudo está dividido em 3 aplicações:
  #1)hows-the-weather-broker  = Projeto de definição do broker. É nele que estão configurados o ConnectionFactory e Session, além do produtor da mensagem. Está aplicação utiliza ActiveMQ-Artemis;

  #2)hows-the-weather-request = Service Rest e Producer / Consumer Broker. Responsável por:
  	I)   Receber requisições dos usuários através de um serviço rest;
  	II)  Produzir mensagens na pilha de entrada do broker;
  	III) Consumir mensagens da pilha de "entrega" do broker

  #3)hows-the-weather-service = Service Rest Template e Produtor / Consumer Broker. Responsável por
  	I)   Consumir mensagens na pilha de entrada do broker;
  	II)  Interagir com os serviços da API "Open Weather";
  	III) Produzir mensagens com o resultado do consumo dos serviços da API "OpenWeather";  

  O projeto possui um modelo de dados próprio que facilita a interação e identificação do "dono da consulta";

