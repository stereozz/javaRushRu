package com.javarush.task.task12.task1212;

//From now on, I tell you before it happens, that when it happens, you may believe that I am he (John 13:19)

/* 
«Исправь код», часть 1
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}

/*
«Исправь код», часть 1
Исправь код, чтобы программа компилировалась.

Подсказка:
метод getChild должен остаться абстрактным.


Требования:
1. Класс Pet должен быть статическим.
2. Класс Pet должен иметь два метода.
3. Метод getChild() должен быть абстрактным.
4. Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.
*/
