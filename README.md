# medcad

## API Tests

https://medcat.herokuapp.com/

```bash
# Postman
Pode fazer uso do Postman para testar a API
```

```bash
# Especialidades

GET	https://medcat.herokuapp.com/specialties
GET	https://medcat.herokuapp.com/specialties/${id}

POST	https://medcat.herokuapp.com/specialties

{
    "name": "teste2",
    "description": "Exame"
}

PUT	https://medcat.herokuapp.com/specialties/${id}

{
    "name": "teste2",
    "description": "Exame"
}

DELETE	https://medcat.herokuapp.com/specialties/${id}

```

```bash
### Médicos

GET	https://medcat.herokuapp.com/doctors
GET	https://medcat.herokuapp.com/doctors/${id}

POST	https://medcat.herokuapp.com/doctors

{
    "name": "Alisson José",
    "birthDate": "1977-04-20T03:00:00.000+00:00",
    "specialties": [
            {
                "id": 7
            },
            {
                "id": 4
            }                           
    ]
}

PUT	https://medcat.herokuapp.com/doctors/${id}

{
    "name": "Alisson José",
    "birthDate": "1977-04-20T03:00:00.000+00:00",
    "specialties": [
            {
                "id": 8
            }                           
    ]
}


DELETE	https://medcat.herokuapp.com/doctors/${id}
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring](https://spring.io/)
- [Heroku](https://https://heroku.com/)
- [Postgres](https://www.postgresql.org/)


## Autor

<a href="https://linkedin.com/in/youssf/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/36612443?s=60&v=4" width="100px;" alt=""/>
 <br />  
 </a> 
 
 <a href="https://linkedin.com/in/youssf/" title="Linkedin"><sub><b>Linkedin</b></sub></a> 
 <a href="https://alissonnews.blogspot.com/" title="AlissonNews"><sub><b>Blog</b></sub></a>

[![Gmail Badge](https://img.shields.io/badge/-youssfbr@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:youssfbr@gmail.com)](mailto:youssfbr@gmail.com)
