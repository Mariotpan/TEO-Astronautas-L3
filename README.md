# Astronautas
## Autor: José María Luna   


Este proyecto se basa en datos de personas que son o han sido astronautas.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **espacio**: Paquete que contiene los tipos del proyecto.
  * **fp.utiles**:  Paquete que contiene clases de utilidad. 
* **/data**: Contiene el único dataset del proyecto.
    * **astronautas.csv**: El dataset contiene información de los astronautas así como diferentes datos sobre su carrera.
    
## Estructura del *dataset*

URL del dataset original (ha sido modificado): https://www.kaggle.com/nasa/astronaut-yearbook

El dataset está compuesto por 8 columnas, y tiene la siguiente forma:

```
Name	Year	Status	Birth Date	Birth Place	Gender	Space Flights	Dead
Joseph M. Acaba	2004	Active	5/17/1967	Inglewood CA	Male	2	False
Loren W. Acton	2001	Retired	03/07/1936	Lewiston MT	Male	1	False
James C. Adamson	1984	Retired	03/03/1946	Warsaw NY	Male	2	False
Thomas D. Akers	1987	Retired	5/20/1951	St. Louis MO	Male	4	False
```

## Tipos del Proyecto

En este apartado se indican los diferentes tipos implementados en el proyecto:

### Tipo Base: Astronauta
El tipo Astronauta se implementa en el paquete espacio con sus respectivos métodos y propiedades.

**Propiedades**:

- **name**, de tipo String, consultable. Indica el nombre del astronauta.
- **year**, de tipo Integer, consultable. Representa el año en el que por primera vez la persona realizó un viaje espacial.
- **status**, de tipo Status, consultable y modificable. Especifica si el astronauta sigue en activo, retirado, fallecido o trabajando como director.
- **gender**, de tipo Gender, consultable. Representa la fecha de nacimiento del astronauta.
- **spaceFlights**, de tipo Integer, consultable y modificable. Número de misiones o vuelos realizados por el astronauta a lo largo de su carrera.
- **dead**, de tipo Boolean, consultable y modificable. Indica si ha fallecido (True) o no (False).
- **birth**, de tipo Nacimiento, consultable y modificable.  El tipo Nacimiento será un record compuesto de las propiedades: birthPlace y birthDate, String y LocalDate respectivamente.

**Constructores**: 

- Constuctor 1: indica los siguientes datos de un astronauta: Nombre, año de primer vuelo, estado, fecha de nacimiento, lugar de nacimiento, género, vuelos espaciales y si ha fallecido o no.
- Constructor 2: recibe todos los datos a partir de un string con el siguiente formato: "Name	Year	Status	Birth Date	Birth Place	Gender	Space Flights	Dead". Nota: los campos están separados por tabuladores

**Restricciones**:
 
- Restricción 1: El astronauta debe tener nombre.
- Restricción 2: El astronauta debe tener fecha de nacimiento.

**Criterio de igualdad**: 
Dos astronautas son iguales si lo son sus nombres y fechas de nacimiento.

**Criterio de ordenación**: 
El orden viene dado por nombre, y en caso de igualdad, por fecha de nacimiento.

### Tipo Factoría: FactoriaAstronauta
La factoría se encargará de crear un objeto de tipo contenedor Astronautas a partir de un fichero CSV. Sus métodos son los siguientes:

- **leerAstronautas**: Devuelve un tipo Astronautas formado por la lista de todos los astronautas que han sido obtenidos a partir de un fichero CSV dado por parámetro.
- **parsearAstronauta**: devuelve un objeto de tipo Astronauta a partir de un String dado.


### Tipo Contenedor: Astronautas

Este tipo contendrá una lista que contendrá objetos Astronauta.

**Propiedades**:

- astronautas, de tipo List<Astronauta>, consultable y modificable. 

**Constructores**: 

- Constrctor 1: No recibe ningún parámetro.
- Constructor 2: recibe una lista de Astronauta e inicializa la propiedad astronautas a partir de ella.

**Criterio de igualdad**: Dos astronautas son iguales si lo son todas sus propiedades.
 

**Otras operaciones**:
 
-	**getNumeroAstronautas**: Obtiene el numero de astronautas que contiene una lista.
-	**agregarAstronauta**: Agrega un astronauta a una lista.
-	**agregarColeccion**: Agrega una coleccion a una lista.
-	**eliminarAstronauta**: Elimina un astronauta de una lista.
 
#### Operaciones con astronautas:

-	**hayAstronautaConMasNVuelos**: recibe un número entero (n) y devuelve True si existe astronauta que haya realizado más de n vuelos espaciales.
-	**getMediaDeYear**: Devuelve la media de los años en los que se realizaron los primeros vuelos espaciales de los astronautas. En caso de que no se pueda calcular, devuelve cero.
-   **obtenerAstronautasPorGenero**: devuelve una lista con los astronautas con el género especificado por parámetro.
-   **agruparPorStatus**: Devuelve un Map en el que las claves son los posibles status de los astronautas, y los valores una lista que contiene a los astronautas que pertenecen a ese status. 
-	**getNumeroAstronautasPorYear**: Un Map en el que las claves son los años en los que ha habido mínimo un viaje espacial, y los valores indican el numero de viajes espaciales en ese año. 
- **obtenerNumeroMaximoViajesPorGenero**: Indica el máximo de viajes espaciales que ha realizado un astronauta del género dado por parámetro.
- **obtenerListaOrdenadaPorVuelos**: Devuelve una lista con los n astronautas que más vuelos realizaron. La lista deberá estar ordenada por número de vuelos.
- **obtenerMaximosVuelosPorStatus**: Se obtiene un map donde las claves son los posibles estados de los astronautas, y los valores son el máximo de 
 vuelos espaciales que ha realizado un astronauta con ese estado
- **obtenerMejoresAstronautasPorYear**: Devuelve un SortedMap donde las claves son los años en los que los astronautas realizaron su primer vuelo espacial, 
 y los valores son los n mejores astronautas (basándonos en su número de vuelos espaciales) que realizaron su primer viaje en ese año.
- **obtenerYearConMenosNumeroViajes**: Devuelve el año en el que hubo menos viajes espaciales. 

 
