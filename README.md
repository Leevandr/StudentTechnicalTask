1) Запуск из ide
Производить запуск из Ide 
2) Запуск с docker-compose
   `docker-compose up --build`
3) По умолчанию если в application.yml `createOnStart: true` инициализируется 4 студента.
4) Можно добавлять студентов удалять/получить всех студентов/удалить всех студентов.
5) Добавить студента - `add Alex Mas 20` Alex - name, Mas - last_name, 20 - age.
6) Удалить студента - `remove 1` 1 - id.
7) Получить всех = `list`.
8) Удалить всех = `remove-all`.
9) 
   1) Student Commands
      add: Add a new student
      remove-all: removeAll students
      list: List all students
      remove: Remove a student by id