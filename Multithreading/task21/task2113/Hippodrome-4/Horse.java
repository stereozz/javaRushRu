
//Then the soldiers, when they had crucified Jesus, took his garments and made four parts, to every soldier a part; and also the coat. Now the coat was without seam, woven from the top throughout. (John 19:23)

package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;
}

/*
Ипподром(4)
Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя (name) и скорость (speed).
Наши лошади будут бежать просто определенное время (100 секунд/»шагов»).
Будем определять победителя, как лошадь, пробежавшую наибольшую дистанцию.
Поэтому нам понадобится хранить еще и расстояние (distance), которое лошадь уже пробежала.
Добавь в класс Horse переменные name (String), speed (double), distance (double).


Требования:
1. В классе Horse должно быть создано поле name.
2. В классе Horse должно быть создано поле speed.
3. В классе Horse должно быть создано поле distance.
4. Поле name должно быть типа String.
5. Поле speed должно быть типа double.
6. Поле distance должно быть типа double.

Ипподром(3)
Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
Создай конструктор класса Hippodrome с одним параметром типа List.
Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).

Ипподром(2)
Раз это ипподром, то на нем должны быть лошади.
Значит наш ипподром должен хранить список всех его лошадей.
Добавь поле horses типа List<Horse> в класс Hippodrome.
А чтобы лошадей не украли — сделай это поле приватным.
Добавь getter для этого поля.

Ипподром(1)
Сегодня мы напишем небольшую игру под названием «Ипподром«.
Когда я говорю мы — я имею ввиду тебя. Я же буду работать наставником.

Для начала нам понадобятся классы «ипподром» и «лошадь«.
Создай классы Hippodrome (ипподром), Horse (лошадь).

Также не забудь, что любая программа начинается с метода main.
Добавь его в класс Hippodrome.
*/
