# Сервис сокращения ссылок

В данном проекте разработано серверное приложение для сокращения ссылок. Приложение содержит одностраничный сайт с минималистичным интерфейсом.

![Site](./.github/img.png)

## Использованные технологии

- [JDK 16](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Lombok](https://projectlombok.org/)
- [SL4J](https://www.slf4j.org/)
- [Logback](https://logback.qos.ch/)
- [PostgreSQL](https://www.postgresql.org/)
- HTML5, CSS3, JS
- [jQuery](https://jquery.com/)

## Как настроить проект на вашем компьютере

- Установить [JDK 16](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html) и [PostgreSQL](https://www.postgresql.org/)
- Клонировать [этот](https://github.com/Popov-Dmitry/url-shortener) репозиторий
- В файле `./src/main/resources/application.properties` изменить параметры для доступа к БД:
- - `spring.datasource.url` - url-адрес подключения к БД
- - `spring.datasource.username` - имя пользователя
- - `spring.datasource.password` - пароль пользователя