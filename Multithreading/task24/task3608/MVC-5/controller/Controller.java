
//The same was in the beginning with God. (John 1:2)

package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.MainModel;
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
    
    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
}

/*
MVC (5)
В сервисе есть метод, который возвращает всех удаленных пользователей. Давай их отобразим.

1. Распредели методы по классам MVC:

public void fireEventShowDeletedUsers() {
…onShowAllDeletedUsers();
}

public void onShowAllDeletedUsers() {
…loadDeletedUsers();
}

public void loadDeletedUsers() {
List<User> users = userService.getAllDeletedUsers();
}

Не забудь, что данные, полученные с сервера, необходимо положить в ModelData. А потом обновить view.
Добавь это самостоятельно в нужные методы.

2. Добавь в Solution.main вызов нового метода, который ты поместил в view.

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventShowDeletedUsers() и реализовать этот метод.
2. Необходимо определить правильное расположение метода onShowAllDeletedUsers() и реализовать этот метод.
3. Необходимо определить правильное расположение метода loadDeletedUsers() и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод, который ты ранее реализовал в классе UsersView.
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.
*/
