# Client Account API

REST API для учёта клиентов компании "Лига Цифровой Экономики".

## Технологии
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven

## Запуск
1. Создайте базу данных `clientdb` в PostgreSQL
2. Настройте `application.properties`
3. Выполните `mvn spring-boot:run`

## Тестирование API
В папке `postman/` находится коллекция запросов для Postman.

### Импорт коллекции:
1. Откройте Postman
2. Нажмите **Import** (в левом верхнем углу)
3. Выберите файл `postman/Client-API.postman_collection.json`
4. Коллекция появится в левой панели

### Эндпоинты:
- `POST /api/clients` — создание клиента
- `GET /api/clients` — список всех клиентов
- `GET /api/clients/{id}` — клиент по ID
- `PUT /api/clients/{id}` — обновление клиента
- `DELETE /api/clients/{id}` — удаление клиента
