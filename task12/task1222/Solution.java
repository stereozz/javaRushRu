package com.javarush.task.task12.task1222;

//Therefore, having received that morsel, he went out immediately. It was night. (John 13:30)

/* 
Больше не Пушистик
*/

public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {
        public void setName(String name) {
            this.name = "Я - кот";
        }
    }
}



/*
Больше не Пушистик
Переопредели метод setName в классе Cat так, чтобы программа выдавала на экран надпись

«Я - кот»


Требования:
1. Класс Solution должен содержать класс Pet.
2. Класс Solution должен содержать класс Cat.
3. Класс Cat должен наследоваться от класса Pet.
4. Класс Pet должен содержать два метода getName() и setName().
5. Класс Cat должен переопределять метод setName().
6. Программа должна выводить на экран результат метода getName() объекта pet.

package com.javarush.task.task12.task1222;

 
Больше не Пушистик


public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {

    }
}
*/
