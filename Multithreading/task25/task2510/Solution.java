
//That no flesh should glory in his presence. (1Cor 1:29)

package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {
    public Solution() {
        setUncaughtExceptionHandler(new UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread thread, Throwable e)
            {
                if (e instanceof Error)
                    System.out.println("Нельзя дальше работать");
                else if (e instanceof Exception)
                    System.out.println("Надо обработать");
                else
                    System.out.println("ХЗ");
            }
        });
    }
    public static void main(String[] args) {
    }
}
/*
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль «Нельзя дальше работать«.
2. Если это Exception, то вывести в консоль «Надо обработать«.
3. Если это Throwable, то вывести в консоль «ХЗ«.
Реализуй эту логику.


Требования:
1. В конструкторе Solution должен устанавливаться свой UncaughtExceptionHandler, который будет перехватывать возникшие ошибки и выводить текст в консоль.
2. Если выполнение нити Solution закончилось исключением Error, нужно вывести в консоль "Нельзя дальше работать".
3. Если выполнение нити Solution закончилось исключением Exception, нужно вывести в консоль "Надо обработать".
4. Если выполнение нити Solution закончилось исключением Throwable, нужно вывести в консоль "ХЗ".

package com.javarush.task.task25.task2510;

* 
Поживем - увидим
*
public class Solution extends Thread {

    public Solution() {
    }

    public static void main(String[] args) {
    }
}
*/
