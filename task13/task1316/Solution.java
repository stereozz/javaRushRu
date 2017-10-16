package com.javarush.task.task13.task1316;

//Do this, knowing the time, that it is already time for you to awaken out of sleep, 
//for salvation is now nearer to us than when we first believed. (John 13:11)

/* 
Некорректные строки
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";

        String onPress(Object o);

        

    }
}


/*
Некорректные строки
Удали все некорректные строки в интерфейсе Button.


Требования:
1. Интерфейс SimpleObject должен быть объявлен внутри класса Solution.
2. Интерфейс Button должен быть объявлен внутри класса Solution.
3. Метод main менять нельзя.
4. В интерфейсе Button должно остаться объявление константы NAME.
5. В интерфейсе Button должно остаться корректное объявление метода onPress.

package com.javarush.task.task13.task1316;

/* 
Некорректные строки
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";

        void onPress();

        private void onPress();

        protected String onPress(Object o);

        String onPress(Object o);

        private String onPress(Object o);

    }
}

*/
