
//Whoever's sins you forgive, they are forgiven them. Whoever's sins you retain, they have been retained. (John 20:23)

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    
    public void setBall(Ball newBall) {
        this.ball = newBall;
    }
    public void setStand(Stand newStand) {
        this.stand = newStand;
    }
    public void setBricks(List<Brick> newBricks) {
        this.bricks = newBricks;
    }
    
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
Арканоид(4)
Также классу Arkanoid нужно будет хранить ссылку на шарик (Ball), «подставку» Stand и список «кирпичей«.

Надо:
а) создать в классе Arkanoid два private поля: ball типа Ball и stand типа Stand
б) добавить private поле bricks типа List<Brick>
в) добавь для них публичные геттеры и сеттеры


Требования:
1. В классе Arkanoid должно быть создано приватное поле ball типа Ball.
2. В классе Arkanoid должно быть создано приватное поле stand типа Stand.
3. В классе Arkanoid должно быть создано приватное поле bricks типа List.
4. В классе Arkanoid должен быть создан корректный геттер для поля ball.
5. В классе Arkanoid должен быть создан корректный геттер для поля stand.
6. В классе Arkanoid должен быть создан корректный геттер для поля bricks.
7. В классе Arkanoid должен быть создан корректный сеттер для поля ball.
8. В классе Arkanoid должен быть создан корректный сеттер для поля stand.
9. В классе Arkanoid должен быть создан корректный сеттер для поля bricks.

Арканоид(3)
Пожалуй, пора добавить конструктор в класс Arkanoid.
Конструктор должен принимать два параметра типа int (width и height) и корректно устанавливать значения соответствующих полей класса.


Требования:
1. В классе Arkanoid должен быть создан публичный конструктор с двумя параметрами типа int.
2. Конструктор класса Arkanoid должен корректно устанавливать значения соответствующих полей класса.

Арканоид(2)
Главному классу (Arkanoid) нужно будет хранить информацию о размерах поля, где будут происходить все действия.

Поэтому:
а) добавь в класс Arkanoid два приватных поля width(ширина) и height(высота) типа int
б) создай для них публичные геттеры и сеттеры

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

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Arkanoid {
    private int width, height;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
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

*/
