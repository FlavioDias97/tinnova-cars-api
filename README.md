<h1 align="center">API REST TINNOVA - CARS API</h1>
<div align="center">
  <strong>processo seletivo</strong>
</div>

### Como executar

Tudo que será necessário para executar o projeto será java 8 e mySQL 8.0.22 instalados na maquina. Para executar basta baixar o JAR que está junto com o projeto na pasta executal ou realizar o build do mesmo com mvn clean install.

Por padrão o projeto virá configurado com username e senha de banco como root e será necessário já ter o banco (cars_database) criado na base.

para executar basta utilizar o seguinte comando:

```
java -jar tinnova-test-cars-0.0.1-SNAPSHOT.jar
```

### Questões

##Cadastrar novo veículo:
```
curl -X POST "http://localhost:8080/test-car-tinnova/api/v1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"brand\": \"Tesla\", \"createdAt\": \"2021-04-03T23:57:03.603Z\", \"description\": \"Eletric Car\", \"model\": \"X\", \"solded\": false, \"updatedAt\": \"2021-04-03T23:57:03.603Z\", \"year\": 2020}"
```

Retorno esperado:
```
http: 200
SUCCESS 
```

##Buscar veículo por ID:
```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1/1" -H "accept: */*"
```

Retorno Esperado:
```
{
  "id": 1,
  "model": "X",
  "brand": "Tesla",
  "year": 2020,
  "description": "Eletric Car",
  "createdAt": 1617494223603,
  "updatedAt": 1617494223603,
  "solded": false
}
```

##Atualizar veículo existente:
```
curl -X PUT "http://localhost:8080/test-car-tinnova/api/v1/1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"brand\": \"Tesla\", \"createdAt\": \"2021-04-03T23:57:03.603Z\", \"description\": \"Eletric Car\", \"model\": \"X\", \"solded\": false, \"updatedAt\": \"2021-04-03T23:57:03.603Z\", \"year\": 2021}"
```

Retorno esperado:
```
{
  "id": 1,
  "model": "X",
  "brand": "Tesla",
  "year": 2021,
  "description": "Eletric Car",
  "createdAt": 1617494223603,
  "updatedAt": 1617494223603,
  "solded": false
}
```

##Apagar veículo existente:
```
curl -X DELETE "http://localhost:8080/test-car-tinnova/api/v1/1" -H "accept: */*"
```

Retorno esperado:
```
http 200
```

##Retornar todos os veículos cadastrados:
```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1" -H "accept: */*"
```

Retorno esperado:
```
[
  {
    "id": 2,
    "model": "X",
    "brand": "Tesla",
    "year": 2020,
    "description": "Eletric Car",
    "createdAt": 1617494223603,
    "updatedAt": 1617494223603,
    "solded": false
  }
]
```

##Retornar veículos filtrados por marca:
```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1/carsFilteredByBrand" -H "accept: */*"
```

Retorno esperado:
```
{
  "listCarByBrand": [
    "Tesla <-> 2",
    "Ford <-> 1"
  ]
}
```

##Retornar veículos filtrados por década:
```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1/carsFilteredByDecade" -H "accept: */*"
```

Retorno esperado:
```
{
  "carsByDecade": [
    "2020 <-> 3"
  ]
}
```

##Retornar veículos registrados na última semana:
```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1/carsRegisteredLastWeek" -H "accept: */*"
```

Retorno esperado:
```
{
  "cars": [
    {
      "id": 2,
      "model": "X",
      "brand": "Tesla",
      "year": 2020,
      "description": "Eletric Car",
      "createdAt": 1617494223603,
      "updatedAt": 1617494223603,
      "solded": false
    },
    {
      "id": 3,
      "model": "y",
      "brand": "Tesla",
      "year": 2020,
      "description": "Eletric Car",
      "createdAt": 1617494223603,
      "updatedAt": 1617494223603,
      "solded": false
    },
    {
      "id": 4,
      "model": "F10",
      "brand": "Ford",
      "year": 2020,
      "description": "Not aEletric Car",
      "createdAt": 1617494223603,
      "updatedAt": 1617494223603,
      "solded": false
    }
  ]
}
```

##Retornar quantidade de carros ainda não vendidos:

```
curl -X GET "http://localhost:8080/test-car-tinnova/api/v1/notSoldedCars" -H "accept: */*"
```

Retorno esperado:
```
{
  "amountNotSolded": 3
}
```




