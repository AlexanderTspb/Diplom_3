# project_ui_tests
В этой части проекта реализованы автотесты UI для учебного сервиса Stellar Burgers. В проекте используются:

- Maven
- Java 11
- JUnit 4
- Selenide
- RestAssured
- Allure

С помощью паттерна Page Object Model описаны локаторы элементов и методы взаимодействия с этими локаторами.

Тесты написаны в фреймворке Selenide.

С помощью фреймворка Allure сформирован отчет о тестировании.

Все тесты независимы. Необходимые тестовые данные создаются перед тестом и удаляются после того, как он выполнится.
Для удаления тестовых данных используется API методы. Запросы отравляются с помощью библиотеки RestAssured.
