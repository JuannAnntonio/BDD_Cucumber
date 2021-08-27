# BDD (Behavior Driven Development)
Es una estrategia de desarrollo dirigido por comportamiento, ha evolucionado desde TDD.

A diferencia de TDD, BDD se define en un idioma común entre todos los stakeholders, lo que mejora la comunicación entre equipos tecnológicos y no técnicos. Tanto en TDD como en BDD, las pruebas se deben definir antes del desarrollo, **aunque en BDD las pruebas se centran en el usuario y el comportamiento del sistema**, mientras que TDD que se centra en funcionalidades.

**¿Que debo tener en cuenta antes de implementar BDD?**
- Cada requisitos debe convertirse en historias de usuario, defiendo ejemplos concretos.
- Cada HU debe ser un escenario de un usuario en el sistema.
- Ser consciente de la necesidad de definir **"la especificación del comportamiento de un usuario"** en lugar de "la prueba unitaria de una clase".
- Comprender la fórmula ‘Given-When-Then’ u otras como las historias de usuario ‘Role-Feature-Reason'.

## Given-When-Then

**Given (dado):** Se especifica el escenario, las precondiciones.

**When (cuando):** Las condiciones de las acciones que se van a ejecutar.

**Then (entonces):** El resultado esperado, las validaciones a realizar.

### EJEMPLO:

Given: Dado que el usuario no ha introducido ningún dato en el formulario.

When: Cuando hace clic en el botón Enviar.

Then: Se deben mostrar los mensajes de validación apropiados.

## Role-Feature-Reason
Este patrón también se utiliza en BDD para ayudar a la creación de historias de usuarios. 
Esta se define como:

**As a (Como)**: Se especifica el tipo de usuario.

**I want (deseo)**: Las necesidades que tiene.

**So that (para que)**: Las características para cumplir el objetivo.


# Cucumber - https://cucumber.io/

Es un framework de test con soporte BDD. En Cucumber, las especificaciones de BDD están escritas en lenguaje **Gherkin**, basado en **Given-When-Then**. 
Gherkin presenta el comportamiento de la aplicación, a partir de la cual Cucumber puede generar los casos de prueba de la aplicación.

# Instalaciones Previas

**- Plugin Cucumber**

![image](https://user-images.githubusercontent.com/35055898/131171581-b7225fea-64b4-4fc2-a88d-0971091db0f6.png)

**- Dependencias Cucumber**

![image](https://user-images.githubusercontent.com/35055898/131171792-b884ba67-2131-4ff0-814d-a3cbed0ec468.png)


# Primer Feature
**1. Creamos un archivo en src/test/resources con la extensión .feature. (En este caso es login y usamos Given-When-Then**
![image](https://user-images.githubusercontent.com/35055898/131172078-18093a95-356f-44e1-904a-39c4c12cdd76.png)

**2. Ejecutamos Cucumber Feature**
![image](https://user-images.githubusercontent.com/35055898/131172371-228bcd33-d99e-4df4-9362-f31d9318c137.png)

**2.1. En consola nos apareceran los pasos para cumplir con el escenario:**
![image](https://user-images.githubusercontent.com/35055898/131172622-b7720a70-0a89-4930-b054-78d5b1eaa29f.png)

**3. Implementar los pasos anteriores en codigo (basta con copiar y pegarlos en una pruena unitaria)**
![image](https://user-images.githubusercontent.com/35055898/131173161-d0e9c9d7-22d3-4cab-b304-988666f37b9a.png)

**NOTA:** Se usa la anotacion **@CucumberContextConfiguration** para ejecutar el Feature

**4.Crear nuestro Test con integracion Cucumber, aqui define las options de Cucumber**
![image](https://user-images.githubusercontent.com/35055898/131173961-7052835c-5f15-47d2-adb9-2b91999b8c4d.png)

**5. Click derecho y ejecutar nuestra Prueba Unitaria**

**¡¡LISTO!!**

# Cucumber Reports
Cucumber nos da la opción de publicar nuestro reporte, para esto:

**1. Agregar en @CucumberOptions el valor publish = true**

![image](https://user-images.githubusercontent.com/35055898/131182221-8ec50092-7df6-41e9-ac12-2b767d1ddda7.png)

**2. Ejecutar nuestra prueba unitaria, cuando termine de ejecutar nos arrojara la URL de consulta:**
![image](https://user-images.githubusercontent.com/35055898/131182284-4c6ffd16-f21f-4714-8fe3-4f3cd39d750f.png)

**3. Ir a la URL veremos un reporte como el siguiente:**
![image](https://user-images.githubusercontent.com/35055898/131182364-4a29ae90-8f2a-4159-9547-b706cfb5da93.png)


