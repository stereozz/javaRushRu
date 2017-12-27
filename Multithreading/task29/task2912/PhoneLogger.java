
//These things have I spoken unto you, that ye should not be offended (John 16:1)

package com.javarush.task.task29.task2912;

public class PhoneLogger extends AbstractLogger {

    public PhoneLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}

/*
Рефакторинг паттерна Chain of Responsibility

Есть программа, в которой реализована система логирования по принципу:

- если событие уровня FATAL - происходит звонок директору, отправляется СМС-сообщение CEO, выводится сообщение в консоль, происходит логирование в файл;

- если событие уровня ERROR - отправляется СМС-сообщение CEO, выводится сообщение в консоль, происходит логирование в файл;

- если событие уровня WARN - выводится сообщение в консоль, происходит логирование в файл;

- если событие уровня INFO - происходит логирование в файл.



В программе реализован паттерн "цепочка ответственности". Изучи его внимательно. В классах FileLogger, ConsoleLogger, SmsLogger, PhoneLogger есть много повторяющегося кода. Подними весь повторяющийся код в абстрактный класс AbstractLogger.

Подъемом в рефакторинге называется перенос полей, методов, конструкторов из всех наследников в одного общего предка. Из наследников, при этом, удаляется код, который перенесен в класс предка.



Логика работы программы не должна измениться.





Требования:

1. Класс AbstractLogger должен быть абстрактным.

2. Класс AbstractLogger должен поддерживать интерфейс Logger.

3. Необходимо поднять поля level и next в класс AbstractLogger.

4. Необходимо поднять методы setNext(Logger) и inform(String, int) в класс AbstractLogger.

5. Вывод программы должен остаться неизменным.
*/
