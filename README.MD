#### 1. Запустить БД в контейнере

docker-compose -f docker-compose.yml up --remove-orphans
Дождаться в логах сообщения 
Plugin ready for connections. Socket: '/var/run/mysqld/mysqlx.sock' bind-address: '::' port: 33060

#### 2. Пролить скрипты 

./gradlew update

#### 3. Собрать и запустить исполняемый jar

./gradlew bootJar
java -jar build/libs/addressbook.jar

#### 4. Протестировать

Файл test.http содержит тетстовые запросы.

