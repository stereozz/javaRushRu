
//But as many as received him, to them he gave the right to become God's children, to those who believe in his name: (John 1:12)

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();
    
    public ModelData getModelData() {
        return modelData;
    }
    
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);
    }
    
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

}

/*
MVC (6)
Функционал отображения удаленных пользователей есть, а самих таких пользователей нет. Давай это исправим.
Давай сделаем новую Вью, которая будет отвечать за редактирование одного конкретного пользователя.
UsersView отображает список пользователей.
EditUserView будет отображать данные о редактировании конкретного пользователя.
Для этого нам сначала нужен этот выбранный пользователь.
Как и любые данные его поместим в ModelData.

1. Создай в ModelData поле User activeUser с геттером и сеттером (Alt+Insert -> Getter and Setter).

2. Аналогично UsersView создай EditUserView.
Логика метода refresh:
2.1. Вывести в консоль «User to be edited:«.
2.2. С новой строки вывести табуляцию и активного пользователя.
2.3. С новой строки вывести разделитель «===================================================».

3. Создай в контроллере поле EditUserView editUserView с сеттером.

Когда наши данные выводятся в консоль, то совсем не понятно, список каких пользователей — удаленных или нет — выводится.
Давай сделаем так, чтобы Вью отображала эту информацию. Все данные для отображения хранятся в Моделе.

Поэтому:
4. создай в ModelData поле boolean displayDeletedUserList с геттером и сеттером.

5. Измени метод refresh в UsersView так, чтобы он отображал «All users:» либо «All deleted users:»
в зависимости от того, какие пользователи находятся в списке.
Добавь в необходимые методы модели изменение displayDeletedUserList.


Требования:
1. В классе ModelData должно быть создано приватное поле User activeUser, геттер и сеттер для этого поля.
2. Класс EditUserView должен быть создан аналогично классу UsersView: он должен поддерживать интерфейс View, содержать приватное поле Controller controller и сеттер этого поля.
3. Метод refresh класса EditUserView должен быть реализован согласно условию.
4. В классе Controller должно быть создано приватное поле EditUserView editUserView и сеттер этого поля.
5. В классе ModelData должно быть создано приватное поле boolean displayDeletedUserList, геттер и сеттер для этого поля.
6. Метод refresh в классе UsersView должен быть изменен согласно условию.
7. Необходимо добавить в некоторые методы класса MainModel вызов метода setDisplayDeletedUserList(boolean) с правильным флагом.
*/
