
//Peter seeing him, said to Jesus, "Lord, what about this man?" (John 21:21)

package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    
    public void setModel(Model model) {this.model = model;}
    
    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
    
    public void setUsersView(UsersView usersView) {this.usersView = usersView;}
}

/*
MVC (3)
Чтобы понимать, в правильном ли направлении ты движешься, тебе надо видеть данные. Поэтому:
1. В пакете view создай класс UsersView, реализующий View. Он будет отображать список пользователей в консоль.

2. В UsersView создай поле-контроллер, также создай ему сеттер.

3. Реализуй логику метода refresh:
3.1. Выведи в консоль фразу «All users:«.
3.2. Выведи в консоль всех пользователей, которые есть в modelData.
Перед каждым пользователем сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных
===================================================

4. Уже интересно посмотреть, что же получилось.
Добавь в UsersView публичный метод void fireEventShowAllUsers(), который будет эмулировать событие клиента.
Обратись к контроллеру и вызови его нужный метод для отображения всех пользователей.

5. Класс Solution будет эмулятором пользователя. Открой класс Solution, стань на красный метод,
с помощью горячих клавиш Идеи создай проперти(поле) для usersView.
Нужен только сеттер. Если у тебя создался геттер, то удали его.

6. Запусти main. Упс, ничего не вывело : (
Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.
Вью сама не умеет себя обновлять. Это делает Контроллер.
Пойди в контроллер и добавь обновление данных во Вью.
Напомню, данные хранятся в Модели.

7. Запусти main. У меня теперь такой вывод:
All users:
          User{name='A', id=1, level=1}
          User{name='B', id=2, level=1}
===================================================
Ура, идем дальше.


Требования:
1. Класс UsersView, реализующий интерфейс View, должен быть создан в пакете view.
2. В классе UsersView должно быть создано приватное поле Controller controller и сеттер для этого поля.
3. Метод refresh класса UsersView должен быть реализован согласно условию.
4. В классе UsersView должен быть создан публичный метод void fireEventShowAllUsers(), в котором у контроллера должен вызываться метод onShowAllUsers().
5. В классе Controller должно быть создано приватное поле UsersView usersView и сеттер для этого поля. Геттера для этого поля не должно быть создано.
6. В методе onShowAllUsers() класса Controller должен вызываться метод refresh у объекта usersView с параметром model.getModelData() после вызова метода loadUsers().
7. Вызов метода main должен выводить на экран информацию о всех пользователях, которых ты добавляешь в методе loadUsers() класса FakeModel.
*/
