
//Therefore Peter and the other disciple went out, and they went toward the tomb. (John 20:3)

------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print() {
        int [][] frame = new int[height][width]; //Создаем массив, куда будем "рисовать" текущее состояние игры
        
        int headX = snake.getSections().get(0).getX();
        int headY = snake.getSections().get(0).getY();
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i==(headY) && j==(headX)){ //HEAD
                    frame[i][j]=2;
                }

                for (int k = 1; k < snake.getSections().size(); k++) {
                    int elemX = snake.getSections().get(k).getX();
                    int elemY = snake.getSections().get(k).getY();

                    if (i==(elemY) && j==(elemX)){ //ELEM
                        frame[i][j]=1;
                    }
                }

                if (i==(mouseY) && j==(mouseX)){ //MOUSE
                    frame[i][j]=3;
                }

            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (frame[i][j]==1){
                    System.out.print('x');
                } else if (frame[i][j]==2){
                    System.out.print('X');
                } else if (frame[i][j]==3){
                    System.out.print('^');
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep() {
        int pause = 500;
        if (game.snake.getSections().size() >= 11) {pause = 300;}
        if (game.snake.getSections().size() >= 15) {pause = 200;}
        try{
            Thread.sleep(pause);
        }catch(InterruptedException e) {e.printStackTrace();}
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Snake.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;

import java.util.*;

public class Snake {
    private List<SnakeSection> sections = new ArrayList<SnakeSection>();
    private boolean isAlive;
    private SnakeDirection direction;
    
    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    
    public boolean isAlive() {return isAlive;}
    public List<SnakeSection> getSections() {return sections;}
    public SnakeDirection getDirection() {return direction;}
    public void setDirection(SnakeDirection newDirection) {this.direction = newDirection;}
    
    public int getX() {return sections.get(0).getX();}
    public int getY() {return sections.get(0).getY();}
    public void move() {
        if (isAlive == false) {return;}
        if (direction == SnakeDirection.UP) {move(0, -1);}
        if (direction == SnakeDirection.RIGHT) {move(1, 0);}
        if (direction == SnakeDirection.DOWN) {move(0, 1);}
        if (direction == SnakeDirection.LEFT) {move(-1, 0);}
    }
    public void move(int x, int y) {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;


public class Mouse {
    private int x, y;
    
    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
    private int x, y;
    
    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection 
    {
     UP,
     RIGHT,
     DOWN,
     LEFT
    }

------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------KeyboardObserver.java---------------------------------------------------
package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class KeyboardObserver extends Thread
{
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    private JFrame frame;

    @Override
    public void run()
    {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());

        frame.setOpacity(0.0f);
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                System.exit(0);
            }
        });


        frame.addKeyListener(new KeyListener()
        {

            public void keyTyped(KeyEvent e)
            {
                //do nothing
            }

            public void keyReleased(KeyEvent e)
            {
                //do nothing
            }

            public void keyPressed(KeyEvent e)
            {
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents()
    {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop()
    {
        return keyEvents.poll();
    }
}
------------------------------------------------------------------------------------------------------------------------------

/*
Змейка(15)
Теперь осталось допилить змею.

Вот что я предлагаю насчет движения змеи:
Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний — удалять. Тогда получится, что змея ползет.

Давай добавим два метода move, один без параметров, а другой с двумя параметрами типа int.

В методе move без параметров необходимо:
а) прекратить движение если змея умерла(isAlive == false)
б) вызвать метод move(0, -1) если направление движения равно SnakeDirection.UP
в) вызвать метод move(1, 0) если направление движения равно SnakeDirection.RIGHT
г) вызвать метод move(0, 1) если направление движения равно SnakeDirection.DOWN
д) вызвать метод move(-1, 0) если направление движения равно SnakeDirection.LEFT

Метод move с параметрами int, int пока оставим пустым.


Требования:
1. В методе move без параметров должен быть вызван метод move(0, -1), если направление движения равно SnakeDirection.UP.
2. В методе move без параметров должен быть вызван метод move(1, 0), если направление движения равно SnakeDirection.RIGHT.
3. В методе move без параметров должен быть вызван метод move(0, 1), если направление движения равно SnakeDirection.DOWN.
4. В методе move без параметров должен быть вызван метод move(-1, 0), если направление движения равно SnakeDirection.LEFT.
5. Метод move с параметрами (int, int) не должен быть вызван, если змея умерла (isAlive == false).
6. В классе Snake должен быть создан метод move без параметров.
7. В классе Snake должен быть создан метод move с параметрами int, int.

Змейка(14)
Теперь поработаем над методом print().

Надо:
а) вывести на экран прямоугольник из точек размером width x height.
б) тело змеи отметить символом «x«-английское
в) голову змеи нарисовать символом «X«-английское.

Подсказка:
а) удобно сначала создать матрицу типа int[][] с размером (height x width)
б) затем пройтись по всем объектам и отрисовать их в матрицу.
Например, тело змеи — 1, голова змеи — 2, мышь — 3.


Требования:
1. Метод print должен выводить данные на экран.
2. Метод print должен выводить на экран количество строк равное height.
3. Количество символов в каждой строке выведенной на экран должно быть равно width.
4. Голова змеи должна быть отмечена символом X.
5. Тело змеи должно быть отмечено символами x.
6. Мышь должна быть отмечена символом ^.

Змейка(13)
Предлагаю тебе в этот раз написать специальный метод sleep(), который будет делать паузу в зависимости от длины змеи (количества элементов в sections).
Придумай какой-нибудь хитрый алгоритм. Чтобы на первом уровне пауза была 500 миллисекунд,
а к 10 уровню постепенно уменьшилась до 300. А к 15 до 200. И дальше оставалась постоянной.


Требования:
1. Метод sleep должен вызывать метод Thread.sleep(500) в начале игры.
2. Метод sleep должен вызывать метод Thread.sleep(300) на 11 уровне.
3. Метод sleep должен вызывать метод Thread.sleep(200) для уровней больше 15.

Змейка(12)
Змея у нас есть, пусть и мышь будет.

Добавить в метод main:
a) вызов метода createMouse().
б) вызов метода run().
Без него ничего работать не будет. В нем вся основная логика.
Неплохо получилось, но я все-таки внесу пару правок.
Кстати, как насчет написать метод sleep?
Ты уже понял из предыдущих задач, что в методе run нужна пауза.
Но насколько я помню, скорость в змейке должна расти при росте ее длины.
Значит чем длиннее змея, тем выше скорость и меньше пауза.


Требования:
1. В методе main классе Room должен быть вызван метод createMouse на объекте типа Room.
2. В методе main классе Room должен быть вызван метод run на объекте типа Room.
3. В классе Room должен быть создан метод sleep без параметров.
Змейка(11)
Теперь логика управления мышью.

С мышью у нас будут происходить две вещи.

Первая - змея съедает мышь.

Вторая - появляется новая мышь в случайной точке комнаты.

Надо написать и реализовать метод createMouse() в классе Room.

В этом методе мы просто должны создавать новую мышь со случайными координатами в комнате.

Как получить случайные координаты?

Это ты уже должен был знать. На всякий случай даю подсказку:

int x = (int) (Math.random() * width);

Еще понадобится метод - eatMouse(), на случай, если мышь все-таки кто-то съест :)

Пока сложной логики в этом методе не будет - просто будем вызывать метод createMouse и все.

Змейка(10)
Займемся методом main.

Для начала надо создать в классе Room статическое поле game типа Room. Доступ к переменной должен быть из всех классов.

Затем в методе main:
а) Создать змею — объект типа Snake.
б) Создать комнату — объект типа Room и передать в него ширину, высоту и змею.
в) Установить змее direction равным SnakeDirection.DOWN

Чего еще не хватает? Собственно метода, в котором будет идти вся игровая логика.
И еще нужен метод, который бы отрисовывал все это на экране:
а) создать метод void run()
б) создать метод void print()

Змейка(9)
Еще остался самый главный класс — Room.
Что нам нужно для его описания?
Размеры комнаты (width и height) — раз.
Змея — два
Мышь — три.

Надо:
а) создать в классе Room переменные width и height типа int.
б) создать в классе Room переменную snake типа Snake.
в) создать в классе Room переменную mouse типа Snake. Шучу. Типа Mouse, конечно же :).
г) создать для них всех геттеры и сеттеры.
д) создать конструктор. Конструктор должен принимать три параметра: width, height и … snake!

Змейка(8)
Настала очередь конструктора класса Snake.

Змея у нас будет поначалу состоять из одного кусочка — головы.
А что для него требуется?
Что необходимо передать в конструктор?
Координаты змеи, конечно же.

Надо:
а) Передать в конструктор координаты головы змеи (x и y)
б) создать в нем первый «кусочек змеи» (голову) и добавить его в коллекцию sections.
в) isAlive выставить в true
г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
ж) еще добавить классу метод move()— он нам пригодится попозже.
з) созданный конструктор должен быть публичным.

Змейка(7)
«Кусочки змеи» мы описали, теперь займемся самой змеей.

У змеи должен быть список кусочков(SnakeSection) и голова.
Пусть головой будет просто самый первый кусочек (с номером 0).

У змеи также есть направление движения — сторона, куда она движется по умолчанию.
А еще есть состояние — жива змея или мертва.
Игра заканчивается тогда, когда змея мертва.

Надо:
а) Добавить в класс Snake поле sections типа List<SnakeSection>.
б) Добавить поле isAlive типа boolean.
в) Добавить поле direction типа SnakeDirection.
г) Для всех полей добавить getter’ы, а для direction еще и setter.

Примечание:
Для полей логического типа геттер принято писать не как getValue(), а как isValue() — это улучшает читабельность кода.
Только не пиши isIsAlive(). Одного is будет вполне достаточно.

Примечание 2:
Все поля создаваемые в этом задании должны быть приватными, а методы — публичными.
------------------------------------------------------Room.java---------------------------------------------------------------
package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */
    public void print() {
        int [][] frame = new int[height][width]; //Создаем массив, куда будем "рисовать" текущее состояние игры
        
        int headX = snake.getSections().get(0).getX();
        int headY = snake.getSections().get(0).getY();
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i==(headY) && j==(headX)){ //HEAD
                    frame[i][j]=2;
                }

                for (int k = 1; k < snake.getSections().size(); k++) {
                    int elemX = snake.getSections().get(k).getX();
                    int elemY = snake.getSections().get(k).getY();

                    if (i==(elemY) && j==(elemX)){ //ELEM
                        frame[i][j]=1;
                    }
                }

                if (i==(mouseY) && j==(mouseX)){ //MOUSE
                    frame[i][j]=3;
                }

            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (frame[i][j]==1){
                    System.out.print('x');
                } else if (frame[i][j]==2){
                    System.out.print('X');
                } else if (frame[i][j]==3){
                    System.out.print('^');
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */
    public void sleep() {
        int pause = 500;
        if (game.snake.getSections().size() >= 11) {pause = 300;}
        if (game.snake.getSections().size() >= 15) {pause = 200;}
        try{
            Thread.sleep(pause);
        }catch(InterruptedException e) {e.printStackTrace();}
    }
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------Snake.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;

import java.util.*;

public class Snake {
    private List<SnakeSection> sections = new ArrayList<SnakeSection>();
    private boolean isAlive;
    private SnakeDirection direction;
    
    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    
    public boolean isAlive() {return isAlive;}
    public List<SnakeSection> getSections() {return sections;}
    public SnakeDirection getDirection() {return direction;}
    public void setDirection(SnakeDirection newDirection) {this.direction = newDirection;}
    
    public int getX() {return sections.get(0).getX();}
    public int getY() {return sections.get(0).getY();}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------Mouse.java--------------------------------------------------------------
package com.javarush.task.task23.task2312;
public class Mouse {
    private int x, y;
    
    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------SnakeSection.java-------------------------------------------------------
package com.javarush.task.task23.task2312;


public class SnakeSection {
    private int x, y;
    
    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------SnakeDirection.java-----------------------------------------------------
package com.javarush.task.task23.task2312;


public enum SnakeDirection 
    {
     UP,
     RIGHT,
     DOWN,
     LEFT
    }
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------KeyboardObserver.java---------------------------------------------------
package com.javarush.task.task23.task2312;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
public class KeyboardObserver extends Thread
{
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);
    private JFrame frame;
    @Override
    public void run()
    {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());
        frame.setOpacity(0.0f);
        frame.setVisible(true);
        frame.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                //do nothing
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                System.exit(0);
            }
        });
        frame.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e)
            {
                //do nothing
            }
            public void keyReleased(KeyEvent e)
            {
                //do nothing
            }
            public void keyPressed(KeyEvent e)
            {
                keyEvents.add(e);
            }
        });
    }
    public boolean hasKeyEvents()
    {
        return !keyEvents.isEmpty();
    }
    public KeyEvent getEventFromTop()
    {
        return keyEvents.poll();
    }
}
------------------------------------------------------------------------------------------------------------------------------
*/
