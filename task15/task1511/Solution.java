package com.javarush.task.task15.task1511;

//Every branch in me that doesn't bear fruit, he takes away. Every branch that bears fruit, he prunes, that it may bear more fruit. (John 15:2)

import java.io.Serializable;

/* 
Максимально простой код-1
*/

public class Solution {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about level15.lesson06.task01?"));
        System.out.println(me.askZapp("When will be the next update?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev implements SpecificSerializable {
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends JavaDev  {
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}




/*
Максимально простой код-1
Упрости код — убери все наследования и реализации, которые и так будут добавлены автоматически при компиляции
PS: Взаимосвязь между объектами me и zapp — Has-a (использует): http://ru.wikipedia.org/wiki/Has-a


Требования:
1. Интерфейс SpecificSerializable должен расширять(extends) интерфейс Serializable.
2. Класс JavaDev должен реализовывать интерфейс SepecificSerializable.
3. В коде не должно быть явного наследования от Object(extends Object).
4. Класс JuniorJavaDev не должен явно наследовать интерфейс SpecificSerializable.

package com.javarush.task.task15.task1511;

import java.io.Serializable;

* 
Максимально простой код-1
*

public class Solution {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about level15.lesson06.task01?"));
        System.out.println(me.askZapp("When will be the next update?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev extends Object implements SpecificSerializable {
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends Object, JavaDev implements SpecificSerializable {
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}

*/
