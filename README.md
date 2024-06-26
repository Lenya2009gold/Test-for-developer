# Проект "Заметки"

## Описание
Этот проект представляет собой простое приложение для создания и управления заметками, разработанное с использованием Java и JavaFX. Приложение позволяет пользователям создавать, просматривать, редактировать и удалять заметки. Это десктопное приложение, предназначенное для личного использования с возможностью управления небольшим объемом данных.

## Технологии
- **Язык программирования:** Java
- **Фреймворк для пользовательского интерфейса:** JavaFX
- **Хранение данных:** Сериализация объектов в файл

## Функциональность
- Создание заметок
- Отображение списка всех заметок
- Редактирование выбранной заметки
- Удаление заметок
- Сохранение заметок между сессиями работы приложения

## Архитектура
Проект включает следующие основные компоненты:
- `Note`: класс, представляющий заметку.
- `NoteManager`: класс для управления списком заметок, включая загрузку и сохранение заметок.
- `NoteAppController`: контроллер для обработки пользовательских взаимодействий и связывания данных с пользовательским интерфейсом.
- `NoteApp`: основной класс, запускающий приложение.

## Выбор технологий
Для хранения данных используется простой список (`List`), так как приложение рассчитано на работу с небольшим объемом данных. Это обеспечивает простоту реализации и уменьшает сложность проекта.
