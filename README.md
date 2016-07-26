# spotippos
Lenda de Spotippos


Como rodar o projeto:

```
1) Configurar Java 7 ou 8

2) Baixar o servidor Java EE WildFly, versão wildfly-8.1.0.Final, em http://wildfly.org/downloads/

3) Copiar o arquivo spotippos.war para o diretorio 'standalone/deployments' do WildFly

4) Iniciar o WildFly executando o script 'bin/standalone.sh' ou 'bin/standalone.bat', se linux ou windows
```

TESTES
Utilizando alguma ferramenta como o Postman para requisições em uma API Rest.

1. Crie imóveis em Spotippos :)

Request:

```
POST localhost:8080/spotippos/properties
```

Body: JSON(application/json)

```json
{
  "x": 222,
  "y": 444,
  "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
  "price": 1250000,
  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  "beds": 5,
  "baths": 4,
  "squareMeters": 210
}
```

Response: JSON

```json

{
  "status": "Success",
  "message": "Operation was successful"
}
```

ou alguma validação de negócio. 
Ex:

```json
{
  "status": "Error",
  "message": "É permitido o cadastro de no máximo 240 metros quadrados, e no mínimo 20"
}
```

2. Mostre um imóvel específico em Spotippos =]

Request:

```
GET localhost:8080/spotippos/properties/{id}
```

Response:

```json
{
  "id": 1,
  "x": 222,
  "y": 444,
  "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
  "price": 1250000,
  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  "beds": 5,
  "baths": 4,
  "squareMeters": 210,
  "provinces": [
    "Scavy"
  ]
}

```

3. Busque imóveis em Spotippos :D

Request:

```
GET localhost:8080/spotippos/properties?ax={integer}&ay={integer}&bx={integer}&by={integer}
```

Response:

```json
{
  "foundProperties": 3,
  "properties": [
    {
      "id": 1,
      "x": 1233,
      "y": 323,
      "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
      "price": 1250000,
      "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      "beds": 5,
      "baths": 3,
      "squareMeters": 210,
      "provinces": [
        "Nova"
      ]
    },
    {
      "id": 2,
      "x": 222,
      "y": 444,
      "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
      "price": 1250000,
      "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      "beds": 4,
      "baths": 3,
      "squareMeters": 210,
      "provinces": [
        "Scavy"
      ]
    },
    {
      "id": 3,
      "x": 222,
      "y": 444,
      "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
      "price": 1250000,
      "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      "beds": 5,
      "baths": 4,
      "squareMeters": 210,
      "provinces": [
        "Scavy"
      ]
    }
  ]
}
```
