## Requisitos
<p >
<img src="https://static.techspot.com/images2/downloads/topdownload/2014/05/Java.png" width="120"/> <img src="https://img.shields.io/badge/-v.%2011-red?style=for-the-badge" alt="Logo" width="100"  /> 
<img src="https://img.shields.io/badge/Spring boot-v.%202.7.4-green?style=for-the-badge" alt="Logo" width="250" style="padding-right: 20px" />   
  </p>
<br /> 

<details open="open">
  <summary><h2 style="display: inline-block">Tabla de contenido</h2></summary>
  <ol>
    <li>
      <a href="#getting-started">Comenzar a trabajar</a>
      <ul>
        <li><a href="#prerequisites">Requisitos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
  </ol>
</details>

<!-- GETTING STARTED -->

## Comenzar

Para comenzar a desarrollador siga los siguientes pasos.

### Instalación

1. Clone the repo
   ```sh
   git clone git@github.com:ronalfonso/back_user_rest.git
   ```
2. Install Dependencies
   ```sh
   mvn clean package
   ```
## Levantar proyecto

Luego de levantar el proyecto, puedes probar los siguientes endpoints

## Publicos
   ```sh
   http://localhost:8080/api/users
   ```
   ```sh
   http://localhost:8080/api/users/details?email=ronald@mail.com
   ```
   ```sh
    localhost:8080/api/users/details?email=ronald@mail.com
    Se obtiene el detalle de le usuario mediante su correo
   ```

## Privados
Debes usar las siguientes credenciales
   ```sh
   user: ronalfonso
   password: ionix123456
   ```
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

   ```sh
    http://localhost:8080/users-repository/search/findUserByEmail?email=ronald@mail.com&active=true&deleted=false
   ```
Se obtiene el usuario por medio del correo y los parametros active y deleted
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

   ```sh
    http://localhost:8080/users-repository
    
   ```
Se obtiene listado de todos los usuarios
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

   ```sh
    http://localhost:8080/users/create
   ```
Se crea un usuario con el siguite body
   ```sh
    {
        "username": "miguel",
        "password": "1234",
        "email": "miguel@mail.com",
        "name": "miguel alfonso",
        "phone": "+584246266732"
    }
```
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

   ```sh
    http://localhost:8080/users/delete/4
    
   ```
Se realiza un soft delete de un usuario mediante su id
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

   ```sh
    http://localhost:8080/api/external/1-9
    
   ```
Se obtiene respuesta de la api externa
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)




### Contributors

The contributors template adds the list of contributors and looks like this:


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributors)

## ➤ Contributors


[<img alt="" src="https://avatars.githubusercontent.com/u/41694372?v=4" width="100">](https://github.com/orgs/SancorSalud/people/ronalfonso)  