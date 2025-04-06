Hecho por **Freth David Piraban Hernandez**.

--- 

## Descripción

El objetivo de la documentacion es informar un poco de como se analizo esta prueba

## Base de datos
![Diagram.png](mysql_data%2FDiagram.png)

Con el fin de soportar los datos de la aplicación en una base de datos relacional, se creó el modélo tal como se ve en
la imágen superior.

---
## Requerimientos Obtenidos
1. Analisis de los archivos .pf de as400
2. Analisis para migrar base de datos. Alojada en MySQL
3. Agregar datos a la tabla de descuadres con base a una fecha y año
4. Crear API batch que guarde los descuadres en la base de datos
5. Consultar los descuadres por mes y producto

## Diccionario

| Tipo AS400 | Descripción               | Tipo en Bases de Datos | Tipo en Java/Scala       |
|------------|---------------------------|------------------------|--------------------------|
| A          | Alfabético/Alfanumérico   | VARCHAR(n)             | String                   |
| S          | Numérico con signo        | INT, SMALLINT          | Integer, Short, Long     |
| P          | Decimal empaquetado       | DECIMAL(p,s)           | BigDecimal               |
| L          | Fecha                     | DATE                   | LocalDate o Date         |

| Campo (AS400) | Tipo (Datos Reales)       | Descripción                                                                 | Valores/Ejemplos                     |
|---------------|---------------------------|-----------------------------------------------------------------------------|---------------------------------------|
| AFEARAX       | DATE                      | Fecha del arqueo (inventario físico/virtual)                                | 2025-01-01                           |
| ASUCAX        | VARCHAR(20)               | Nombre de la sucursal                                                       | 'Sucursal A'                         |
| ACDSUAX       | VARCHAR(5)                | Código de sucursal                                                          | '00101'                              |
| ACOPRAX       | VARCHAR(4)                | Código de producto                                                          | 'PR01'                               |
| ACODOAX       | VARCHAR(6)                | Código de documento asociado al producto                                    | 'DOC001'                             |
| ADIFAX        | DECIMAL(15,2)             | Diferencia monetaria entre inventario físico y virtual                     | 19.50 (indica discrepancia)          |
| ASFARAX       | DECIMAL(15,2)             | Saldo final del producto en el inventario                                   | 3081673400.00                        |
| ARESAX        | VARCHAR(2)                | Resultado del arqueo:                                                       | - 'C': Correcto<br>- 'D': Descuadrado<br>- 'A'/'B': Otros estados |

## Ruta de Scripts
mysql_data/arqueosDb_creation.sql

## Urls
Api localmente : 127.0.0.1:8080/api/
DB Localmente : 127.0.0.1:3306/arqueosDb

POST http://localhost:8080/api/batch/procesar
# Json  
## Request  
{
"anno": "2025",
"mes": "5"
}

## Response  
Proceso batch ejecutado correctamente.

GET http://localhost:8080/api/arqueos/descuadres?mes=1&productoId=2

## Response
[
{
"idArqueoDescuadre": 1,
"anio": 2025,
"mes": 1,
"diferencia": 1.00,
"sucursal": {
"idSucursal": 1,
"codigoSucursal": "00101",
"nombre": "Sucursal A"
},
"producto": {
"idProducto": 2,
"codigoProducto": "PR02",
"nombre": null
},
"documento": {
"idDocumento": 1,
"codigoDocumento": "DOC001",
"descripcion": null
}
},
{
"idArqueoDescuadre": 3,
"anio": 2025,
"mes": 1,
"diferencia": 691624500.00,
"sucursal": {
"idSucursal": 3,
"codigoSucursal": "00103",
"nombre": "Sucursal C"
},
"producto": {
"idProducto": 2,
"codigoProducto": "PR02",
"nombre": null
},
"documento": {
"idDocumento": 1,
"codigoDocumento": "DOC001",
"descripcion": null
}
}
]

## Docker
Se creo un archivo Dockerfile y un archivo docker-compose.yml para trabajar los dos proyectos en contenedores
ejecutar con el comando "docker-compose up --build -d"
Para finalizar los contenedores ejecutar el comando "docker-compose down"
El archivo compose esta creando los usuarios y variables de entorno por lo que no seria necesario modificar alguna propiedad

## Notas
1 No esta muy claro que es cada columna asi que estoy deduciendo y con base en eso diseñando la base de datos
2 Los archivos .pf que me dan las especificaciones de los valores no cuadran con los datos de prueba,  
a menos que tocara recortar los caracteres. Por lo cual me guiare por los datos de prueba para determinar las longitudes
