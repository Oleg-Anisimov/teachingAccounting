## Запуск проекта
### Установка базы данных
```
1. cd /path/to/project/
2. cd Support
3. docker build . -t test_database
4. docker container run -p 5432:5432 --name test_database test_database
5. docker container stop test_database
6. docker container start test_database
```


