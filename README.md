# Practica 3 - Servicios REST Spring Boot  
## Descripción  
Es un programa en JAVA, desarrollado en Spring Boot. Tiene como objetivo poder acceder a un CRUD de diferentes tablas que tienen relación (ManyToOne, OneToMany, ManyToMany), además de que tiene servicios de paginacion y algunas consultas DSL. También cuenta con una función generica de un promedio y un procedimiento para la tabla de seguros. 
## Versión
Versión 1.1
## Requisitos  
La aplicación para funcionar necesita de JAVA 17, Maven, la base de datos de Oracle y SQL Developer. Para modificar el código se usa Spring Tools 4, el cual se puede encontrar en el siguiente enlace:  
https://spring.io/tools 

La aplicación se ejectua sobre el puerto 8383, si se desea cambiar el puerto por alguna razon se realiza en el archivo _application.properties_ en donde contiene la siguiente sintáxis:

`server.port= {número de puerto}`  

En donde en _número de puerto_ se debe modificar al número deseado. 

## Instalación en Windows  

Si se desea utilizar el programa en un ambiente que no tenga ninguna herramienta instalada se debe de instalar primero JAVA 17, que se puede encontrar en el siguiente enlace:  
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html  

Para ello se necesita crear una cuenta que es totalmente gratis. 

Para instalar Maven se puede dirigir al siguiente enlace:  
https://maven.apache.org/download.cgi#Installation  

Para la ejecución se debe contar con Spring Tools 4, se puede instalar del enlace anteriormente proporcionado. 

El enlace para descargar Oracle es el siguiente:  
https://www.oracle.com/database/technologies/appdev/xe.html  

Para la descarga de SQL Developer debe dirigirse al siguiente enlace:  
https://www.oracle.com/database/sqldeveloper/  

## Observaciones generales  

En el programa se manejan 7 diferentes tablas, las cuales son específicadas a continuación:

### CLIENTES
#### Atributos
| Nombre        | Tipo     |
|---------------|----------|
| DNI_CL        | VARCHAR2 |
| NOMBRE_CL     | VARCHAR2 |
| APELLIDO_1    | VARCHAR2 |
| APELLIDO_2    | VARCHAR2 |
| CLASE_VIA     | VARCHAR2 |
| NOMBRE_VIA    | VARCHAR2 |
| NUMERO_VIA    | NUMBER   |
| COD_POSTAL    | NUMBER   |
| CIUDAD        | VARCHAR2 |
| TELEFONO      | VARCHAR2 |
| OBSERVACIONES | VARCHAR2 |

### COMPANIAS_SEGUROS
#### Atributos
| Nombre                | Tipo     |
|-----------------------|----------|
| NOMBRE_COMPANIA       | VARCHAR2 |
| CLASE_VIA             | VARCHAR2 |
| NOMBRE_VIA            | VARCHAR2 |
| NUMERO_VIA            | NUMBER   |
| COD_POSTAL            | NUMBER   |
| TELEFONO_CONTRATACION | VARCHAR2 |
| TELEFONO_SINIESTROS   | VARCHAR2 |
| NOTAS                 | VARCHAR2 |

### COMPANIAS_SEGUROS
#### Atributos
| Nombre          | Tipo     |
|-----------------|----------|
| ID              | NUMBER   |
| NUMERO_POLIZA   | NUMBER   |
| NOMBRE_COMPANIA | VARCHAR2 |

### PERITOS
#### Atributos
| Nombre            | Tipo     |
|-------------------|----------|
| DNI_PERITO        | VARCHAR2 |
| NOMBRE_PERITO     | VARCHAR2 |
| APELLIDO_PERITO1  | VARCHAR2 |
| APELLIDO_PERITO2  | VARCHAR2 |
| TELEFONO_CONTACTO | VARCHAR2 |
| TELEFONO_OFICINA  | VARCHAR2 |
| CLASE_VIA         | VARCHAR2 |
| NOMBRE_VIA        | VARCHAR2 |
| NUMERO_VIA        | NUMBER   |
| COD_POSTAL        | NUMBER   |
| CIUDAD            | VARCHAR2 |

### SEGUROS
#### Atributos
| Nombre                   | Tipo     |
|--------------------------|----------|
| NUMERO_POLIZA            | NUMBER   |
| RAMO                     | VARCHAR2 |
| FECHA_INICIO             | DATE     |
| FECHA_VENCIMIENTO        | DATE     |
| CONDICIONES_PARTICULARES | VARCHAR2 |
| OBSERVACIONES            | VARCHAR2 |
| DNI_CL                   | NUMBER   |

### SINIESTROS
#### Atributos
| Nombre          | Tipo     |
|-----------------|----------|
| ID_SINIESTRO    | NUMBER   |
| FECHA_SINIESTRO | DATE     |
| CAUSAS          | VARCHAR2 |
| ACEPTADO        | CHAR     |
| INDEMNIZACION   | NUMBER   |
| NUMERO_POLIZA   | NUMBER   |
| DNI_PERITO      | VARCHAR2 |

### USUARIOS
#### Atributos
| Nombre   | Tipo     |
|----------|----------|
| USERNAME | VARCHAR2 |
| PASSWORD | VARCHAR2 |

Para poder usar la función y el procedimiento se deben ejecutar los siguientes scripts en SQL Developer:  
### Función
<pre><code>CREATE OR REPLACE PACKAGE paquete IS
    FUNCTION funcPromedio(info IN OUT VARCHAR2,
                    num1 IN NUMBER,
                    num2 IN NUMBER,
                    salida OUT VARCHAR2) RETURN NUMBER;               
END paquete;  

CREATE OR REPLACE PACKAGE BODY paquete IS
    FUNCTION funcPromedio(info IN OUT VARCHAR2,
                    num1 IN NUMBER,
                    num2 IN NUMBER,
                    salida OUT VARCHAR2) RETURN NUMBER
    IS
        BEGIN
        IF num1 > num2 THEN
            info := 'El numero 1 es mas grande que el numero 2.';
        ELSIF num2 > num1 THEN
            info := 'El numero 2 es mas grande que el numero 1.';
        ELSE 
            info := 'Los numeros son iguales';
        END IF;    
        salida := 'El promedio se realizo con exito.';
        RETURN (num1 + num2)/2;
    END funcPromedio;
END paquete;
</code></pre>

### Procedimiento
<pre><code>CREATE OR REPLACE PACKAGE paquetep IS
    PROCEDURE procClientes(info IN OUT VARCHAR2,
                    numMayor IN NUMBER,
                    contador OUT NUMBER);              
END paquetep;  

CREATE OR REPLACE PACKAGE BODY paquetep IS
    PROCEDURE procClientes(info IN OUT VARCHAR2,
                    numMayor IN NUMBER,
                    contador OUT NUMBER)
    AS
    BEGIN
      SELECT COUNT(*) 
      INTO contador
      FROM SEGUROS 
      WHERE SEGUROS.NUMERO_POLIZA >= numMayor;
      info:= 'El contador contiene el numero de coincidencias.';
    END procClientes;
END paquetep;
</code></pre>
