# Calculadora
Calculadora como micro-servicio (API) utilizando Spring-boot y Maven con funcionalidades básicas de sumar, restar, multiplicar y dividir.
## Requisitos previos
Necesario disponer de la ultima versión de Maven instalada. Tambien hace falta tener JAVA instalado en el sistema.

## Como utilizar

1. Ejecutar una verificación de Maven
2. Instalación limpia de Maven
3. Ejecutar el JAR de la carpeta /target

Abrir una consola en la raiz del proyecto y ejecutar:
```
mvn validate
mvn verify
mvn clean install
```
Debería haberse generado una carpeta `/target` con el JAR definitivo del programa `calculadora.jar`. Para ejecutarlo:

`java -jar target/calculadora.jar`

Con estos pasos deberiamos tener a nuestra disposición una API REST escuchando en `http://localhost:8080/calcular`

## API REST
Si has seguido correctamente los pasos anteriores, deberias tener el puerto 8080 abierto y escuchando peticiones REST GET.

Los parámetros se le deben pasar por URL en formato URLEncoded. Los parametros son los siguientes `firstNumber` el primer numero de la operación,
`secondNumber` el segundo numero de la operación y `operation` una cadena de texto describiendo la operación a realizar (valores aceptados `SUMA`, `RESTA`, `MULTIPLICAR`, `DIVIDIR`). Por ejemplo:

`GET http://localhost:8080/calcular?firstNumber=2&secondNumber=3&operation=SUMAR`

El resultado será un valor numerico con decimales (2 + 3 = 5):
`5.0`
## Ejecutar tests
Los test nada mas haydebes ejecutar el comando `mvn clean test`.

