
//Jesus said to him, "If I desire that he stay until I come, what is that to you? You follow me." (John 21:22)

package com.javarush.task.task36.task3608.model.service;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public interface UserService {
    public User deleteUser(long id);

    public User createOrUpdateUser(String name, long id, int level);

    public List<User> getUsersByName(String name);

    public List<User> getAllDeletedUsers();

    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel);

    List<User> filterOnlyActiveUsers(List<User> allUsers);

    User getUsersById(long userId);
}






/*
MVC (4)
Пора заменять нашу фейковую Модель на реальную, которая будет получать данные из DataSource.
В пакет model.service я добавил сервис для работы с пользователями.
Также в корне этой задачи ты найдешь утильный класс Util.

1. Аналогично FakeModel создай модель MainModel.

2. Т.к. Модель обращается к сервисам, то в MainModel создай поле UserService userService, инициализируй объектом.

3. Реализуй логику метода loadUsers:
3.1. Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
3.2. Положи всех пользователей в modelData.

4. Обнови Solution.main: замени FakeModel на MainModel.
Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.


Требования:
1. Класс MainModel, реализующий интерфейс Model, должен быть создан в пакете model.
2. В классе MainModel должно быть создано и инициализировано приватное поле ModelData modelData.
3. В классе MainModel должно быть создано и инициализировано приватное поле UserService userService.
4. В классе MainModel необходимо реализовать метод getModelData.
5. Метод loadUsers класса MainModel должен быть реализован согласно условию.
6. В методе main класса Solution должен создаваться объект класса MainModel вместо объекта класса FakeModel.
*/
