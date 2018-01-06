
//And the sixth angel sounded, and I heard a voice from the four horns of the golden altar which is before God (Revelation 9:13)

package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class Man implements Human {

    @Override
    public String toString() {
        return "Man{}";
    }
}

/*
Фабрики (1)

Привет!

Сейчас ты будешь разбираться с паттерном Factory Method. Возьмем пример с людьми.

Будем определять, к какому типу относится человек в зависимости от его возраста.



В этом задании подготовим данные, которые будем использовать в фабрике.



1. Для всех типов людей создай общий интерфейс Human.



2. Будем делать Factory для мужчин. Для этого создай пакет male, в котором создай классы KidBoy, TeenBoy, Man.

Во всех этих классах реализуй интерфейс Human.



3. В каждом классе KidBoy, TeenBoy создай свою публичную константу MAX_AGE с соответствующими значениями: 12, 19.



4. Сгенерируй автоматические методы toString для каждого класса KidBoy, TeenBoy, Man. Получится "KidBoy{}" и т.п.



5. Создай класс Solution с методом main.





Требования:

1. Интерфейс Human должен быть создан в базовом пакете большой задачи.

2. Классы KidBoy, TeenBoy, Man должны быть размещены в пакете male и поддерживать интерфейс Human.

3. В классах KidBoy, TeenBoy, Man должен быть переопределен метод toString в соответствии с условием задачи.

4. В классе KidBoy константа MAX_AGE должна быть равна 12.

5. В классе TeenBoy константа MAX_AGE должна быть равна 19.

6. В классе Solution должен быть создан метод public static void main(String[] args).
*/
