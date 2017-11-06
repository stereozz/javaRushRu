
//Jesus therefore said to them again, "Peace be to you. As the Father has sent me, even so I send you." (John 20:21)

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Arkanoid {
    private int width, height;
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand {
}
------------------------------------------------------------------------------------------------------------------------------

/*
Арканоид(2)
Главному классу (Arkanoid) нужно будет хранить информацию о размерах поля, где будут происходить все действия.

Поэтому:
а) добавь в класс Arkanoid два приватных поля width(ширина) и height(высота) типа int
б) создай для них публичные геттеры и сеттеры


Требования:
1. В классе Arkanoid должно быть создано приватное поле width типа int.
2. В классе Arkanoid должно быть создано приватное поле height типа int.
3. В классе Arkanoid должен быть создан корректный геттер для поля height.
4. В классе Arkanoid должен быть создан корректный геттер для поля width.
5. В классе Arkanoid должен быть создан корректный сеттер для поля height.
6. В классе Arkanoid должен быть создан корректный сеттер для поля width.

Арканоид(1)
Давай сегодня напишем игру Арканоид.

В оригинале это выглядит примерно так http://www.youtube.com/watch?v=Th-Z6QQ5AOQ
Для начала мы напишем упрощенную версию этой игры.
У нас будут кубики, шарик и летающая «подставка«, которая не дает шарику упасть.

Поэтому нам понадобятся классы:
а) Arkanoid — класс в котором происходят основные действия. Также в нем будет наша точка входа в программу, метод main.
б) Ball — шарик.
в) Brick — «кирпичи«, которые мы сбиваем шариком.
г) Stand — летающая подставка.

Создай их, и не забудь о методе public static void main (String[] args) в класе Arkanoid.


Требования:
1. Класс Arkanoid должен быть создан в отдельном файле.
2. Класс Ball должен быть создан в отдельном файле.
3. Класс Brick должен быть создан в отдельном файле.
4. Класс Stand должен быть создан в отдельном файле.
5. В классе Arkanoid должен быть создан метод public static void main (String[] args).

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Arkanoid {
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick {
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand {
}
------------------------------------------------------------------------------------------------------------------------------

*/
