Meta:


Scenario: scenario description

Given Открывается главная страница

Then Загружена страница "Главная страница"

When Выполнено нажатие на кнопку войти

Then Загружена страница "Страница авторизации"

When Проверяется валидация полей логин и пароль

When Заполняются поля логин значением "dmitriyzotovtest@yandex.ru" и пароль значением "767200"

When Выполнено нажатие на кнопку войти

Then Загружена страница "Авторизованная зона"

Then Проверяется значение поля userName = "Дмитрий"
