Существует автор, который имеет имя, фамилию, возраст, количество книг, страну рождения, список книг и идентификатор.
Существует книга, которая имеет имя, жанр, количество страниц, автора, тираж и идентификатор.
Автор имеет отношение "один ко многим" с книгой, т.е. один автор может иметь много книг.
Перед запуском создать вручную схему данных с названием "testdb", в файле application.properties изменить логин и пароль 
от базы данных на необходимый, тоже самое сделать в файле liquibase.properties. 
Далее во вкладке Maven-Plugins-Liquibase запустить выполение Update.
После этого можно запускать приложение.
В браузере в адресной строке указать "localhost:8080".
Автоматически откроется Swagger-UI для демонстрации работоспособности REST-контроллеров.
Далее выполняются все необходимые запросы.
Общие правила написания запросов:
-в случае необходимости для автора обновить книги, указать только id уже существующей книги
Для книги отключено отображение автора во избежание StackOverflowError. Чтобы просмотреть какому автору принадлежит какая книга,
нужно просмотреть список авторов. Книги привязываются к автору в процессе создания и могут изменять привязку при операции UPDATE.
Книга не может существовать, если у нее нет автора. При удалении автора, удаляются книги, принадлежащие ему.

Описание зависимостей проекта:
spring-boot-starter-web - зависимость для работы c REST
spring-boot-devtools - работа со spring boot
mysql-connector-java - подключение к MySQL
lombok - аннотация, для сокращения размера кода и времени на его написание
swagger-annotations - аннотации для работы со Swagger(используются по необходимости)
springdoc-openapi-ui - UI-часть Swagger
spring-boot-starter-data-jpa - работа с БД
modelmapper - преобразование из entity в dto
liquibase-core и liquibase-maven-plugin - система миграций БД

Тестовые данные:
1. POST /authors:   {"name": "George",
                    "surname": "Martin",
                    "age": 74,
                    "country": "USA",
                    "booksCount": 0,
                    "bookList": [
                    ]}
2. POST /books:   authorId = 1 
                 {
                 "name": "Game of the thrones",
                 "kind": "Fantasy",
                 "pagesCount": 1000,
                 "edition": 1000000
                 }
3. GET /authors  просто выполнить
4. GET /authors/{id}  id = 1
5. GET /books    просто выполнить
6. GET /books/{id}    id = 1
7. PUT /authors/{id}     {
                           "id": 1,
                           "name": "George",
                           "surname": "Weasley",
                           "age": 74,
                           "country": "USA",
                           "booksCount": 1,
                           "bookList": [
                           {
                           "id": 1
                           }
                           ]
                          }
8. GET /authors/{id}    id = 1(проверка изменений)
9. PUT /books/{id}      authorId = 1
                        {
                          "name": "Game of the thrones",
                          "kind": "Fantastic",
                          "pagesCount": 1000,
                          "edition": 1000000
                        }
10. DELETE /books/{id}   id = 1
11. GET /books/{id}      id = 1(проверка изменений)
12. GET /books          проверяем, что книга удалена
13. DELETE /authors/{id}   id = 1
14. GET /authors         проверяем, что автор удален 