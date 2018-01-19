
//Marvel not that I said unto thee, Ye must be born again. (John 3:7)

package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {

    static PrepareMyTest classes;

    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }



    public static boolean printFullyQualifiedNames(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {return false;}
        classes = (PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
        for (String string : classes.fullyQualifiedNames()) {
            System.out.println(string);
        }
        return true;
    }

    public static boolean printValues(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {return false;}
        classes = (PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
        for (Class clazz : classes.value()) {
            System.out.println(clazz.getSimpleName());
        }
        return true;
    }
}

/*
Обработка аннотаций

В классе Solution необходимо реализовать простейшую обработку аннотаций.



В методы printFullyQualifiedNames и printValues приходит класс. Если этот класс отмечен аннотацией PrepareMyTest, необходимо вывести на экран fullyQualifiedNames и values в соответствующих методах и вернуть true. Если же аннотация PrepareMyTest отсутствует - вернуть false.



Для вывода на экран классов из массива value используй сокращенное имя (getSimpleName).





Требования:

1. Метод printFullyQualifiedNames должен возвращать false в случае, если переданный в качестве параметра класс не отмечен аннотацией @PrepareMyTest.

2. Метод printValues должен возвращать false в случае, если переданный в качестве параметра класс не отмечен аннотацией @PrepareMyTest.

3. Метод printFullyQualifiedNames должен выводить на экран все элементы массива fullyQualifiedValues, и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.

4. Метод printValues должен выводить на экран все элементы массива value используя их сокращенное имя, и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.
*/