
//Jesus answered and said unto them, Destroy this temple, and in three days I will raise it up. (John 2:19)

package com.javarush.task.task39.task3913.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}

/*
Парсер логов (5)

Как ты заметил существует огромное количество комбинаций параметров для выбора определенных записей из лог файла. Покрыть их все соответствующими методами дело не благодарное. Поэтому мы реализуем свой язык запросов (QL).



Пример запроса:

get ip for user = "Vasya"



Такой запрос должен будет вернуть все IP адреса, с которых пользователь Vasya что-то делал и это отображено в нашем логе. Представь, как будет удобно ввести запрос в консоль и получить необходимую информацию из лога.



5.1. Реализуй интерфейс QLQuery у класса LogParser. Метод execute() пока должен поддерживать только следующие запросы:

5.1.1. get ip

5.1.2. get user

5.1.3. get date

5.1.4. get event

5.1.5. get status



Пример: Вызов метода execute("get ip") должен вернуть Set<String>, содержащий все уникальные IP из лога (это будет: 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 для тестового файла). Аналогично должны работать и другие запросы.



Реальные объекты в возвращаемом множестве должны быть типа String для запросов ip и user, для запроса date - тип объектов Date, для event и status - Event и Status соответственно.





Требования:

1. Класс LogParser должен поддерживать интерфейс QLQuery.

2. Вызов метода execute("get ip") класса LogParser должен возвращать множество (Set) содержащее все уникальные IP адреса.

3. Вызов метода execute("get user") класса LogParser должен возвращать множество (Set) содержащее всех уникальных пользователей.

4. Вызов метода execute("get date") класса LogParser должен возвращать множество (Set) содержащее все уникальные даты.

5. Вызов метода execute("get event") класса LogParser должен возвращать множество (Set) содержащее все уникальные события.

6. Вызов метода execute("get status") класса LogParser должен возвращать множество (Set) содержащее все уникальные статусы.
*/
