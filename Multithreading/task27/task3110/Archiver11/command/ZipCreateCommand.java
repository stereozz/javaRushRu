
//And of his fulness have all we received, and grace for grace. (John 1:16)

package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("Архив создан.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}

/*
Archiver (11)

Давай наконец попробуем нормально реализовать метод execute() класса ZipCreateCommand, который мы добавляли раньше.



Для этого нужно:

1. В начале метода добавить вывод сообщения "Создание архива." Не забудь, что мы работаем с консолью через методы класса ConsoleHelper.

2. Создай новый объект класса ZipFileManager. Т.к. создание этого объекта будет необходимо и другим командам, вынеси создание в отдельный метод ZipFileManager getZipFileManager() throws Exception в класс ZipCommand.

Этот метод должен:

2.1. Просить пользователя ввести полный путь файла архива

2.2. Считывать введенный путь в переменную типа String

2.3. Используя введенный String формировать путь Path

2.4. Создать объект ZipFileManager, передав в конструктор полученный путь

2.5. Вернуть созданный объект

3. Попроси пользователя ввести полное имя файла или директории для архивации

4. Создай путь Path, используя введенную строку

5. У объекта класса ZipFileManager вызови метод createZip(), передав в него путь из п.4

6. Выведи в консоль сообщение "Архив создан."

7. Оберни содержимое метода execute() класса ZipCreateCommand в блок try-catch и отлавливай

исключение типа PathIsNotFoundException. Если оно произошло, выведи сообщение "Вы неверно указали имя файла или директории."

8. Запусти программу и проверь, что команда "упаковать файлы в архив" работает





Требования:

1. В классе ZipCommand нужно добавить public метод ZipFileManager getZipFileManager() throws Exception.

2. Метод getZipFileManager должен считывать с консоли путь к архиву и возвращать для него объект ZipFileManager.

3. Метод execute в классе ZipCreateCommand должен быть реализован следуя описанию в задании, используя метод getZipFileManager.

4. В случае возникновения исключения PathIsNotFoundException, нужно вывести в консоль сообщение "Вы неверно указали имя файла или директории.".


*/
