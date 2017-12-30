
//And the wall of the city had twelve foundations, and in them the names of the twelve apostles of the Lamb. (Revelatiuon 21:14)

package com.javarush.task.task22.task2213;

public class Tetris {

    private Field field;
    private Figure figure;
    public static void main(String[] args) {}

    public void step() {}
    public void run() {}

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }
}

/*
Тетрис(4)

Так же еще нам понадобится пара методов.

Добавь в класс Tetris методы run() и step():



run() будет отвечать за всю игру.

А step() - за один шаг в игре.



Тип возвращаемого значения void для обоих методов.



Тут и в будущем, если нет явных указаний с каким модификатором доступа создавать метод, то он должен быть публичным, а поле приватным.



*В общем случае, стоит руководствоваться правилом использования наиболее строгого(из возможных) модификатора доступа.



*Т.е. если логика системы предполагает обращения к методу извне класса, мы не сможем сделать такой метод приватным.



*Но также нет никаких причин указывать уровень доступа public для методов которые будут использованы только в рамках пакета.



*Поначалу это кажется несущественным, но на самом деле это один из основополагающих принципов ООП.



*Учись сразу делать правильно!





Требования:

1. В классе Tetris должен быть создан метод run без параметров.

2. В классе Tetris должен быть создан метод step без параметров.

3. Метод run НЕ должен быть приватным.

4. Метод step НЕ должен быть приватным.

5. Метод run не должен возвращать значение.

6. Метод step не должен возвращать значение.

Тетрис(3)

Поле есть, фигура есть, а как их получить?



Добавь геттеры для полей field и figure.



Тетрис(2)

Отлично!

Теперь добавь в класс Tetris два поля: field типа Field и figure типа Figure.



Тетрис(1)

Давай напишем игру Тетрис!



Наш Тетрис будет состоять из двух вещей: поля из клеток и фигурки, которая падает.

Поэтому для начала создай три класса: Field(поле с клетками), Figure(фигура) и сам Tetris.



Также нам понадобится метод main в классе Tetris.
*/
