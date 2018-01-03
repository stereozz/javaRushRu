
//There was a man sent from God, whose name was John. (John 1:6)

package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a full path for archive");
        String fullPathToArchive;
        ZipFileManager zipFileManager = null;
        try {
            fullPathToArchive = bufferedReader.readLine();
            zipFileManager = new ZipFileManager(Paths.get(fullPathToArchive));
        } catch (IOException e) {
        }

        System.out.println("Enter a full path for file");
        String fullPathToFile;
        try {
            fullPathToFile = bufferedReader.readLine();
            zipFileManager.createZip(Paths.get(fullPathToFile));
        } catch (Exception e) {
        }
    }
}

/*
Archiver (1)

Давай напишем архиватор. Архиватор, как минимум, должен уметь архивировать и разархивировать

файлы.



Начнем с первого.

Нам потребуется менеджер архива. Он будет совершать операции над файлом архива (файлом, который будет храниться на диске и иметь расширение zip). Класс, который будет этим заниматься, назовем ZipFileManager. А главный класс приложения "Архиватор" будет называться Archiver.

В программировании и не только, есть понятие полного (абсолютного) и относительного пути. Для начала, разберемся что-же такое путь вообще. Путь (англ. Path) - это набор символов, который показывает, где в операционной системе находится какой-то файл или папка.

Полный или абсолютный путь - это путь, начинающийся с корневой директории. В операционной системе Windows, корневой директорией принято считать диск.

Пример полного пути в Windows: C:userzipsTest1.zip.

Относительный путь - это путь относительно какой-то директории. zipsTest1.zip - это пример

относительного пути файла Test1.zip относительно директории (папки) C:user. Относительный путь,

относительно директории C:userzips будет просто Test1.zip и совпадать с именем файла.

Обрати внимание, что по умолчанию, и полный, и относительный путь к файлу, включают в себя имя

файла.

1. Создай класс менеджер ZipFileManager

2. Добавь в класс приватную переменную Path zipFile. В ней мы будем хранить полный путь к архиву, с которым будем работать.

3. Добавь конструктор ZipFileManager(Path zipFile). Проинициализируй поле класса zipFile.

4. Объяви публичный метод createZip(Path source) throws Exception, пока с пустой реализацией.

Path source - это путь к чему-то, что мы будем архивировать.

5. Создай класс Archiver и добавь в него метод main.

6. В методе main:

6.1 Запроси пользователя ввести полный путь архива с клавиатуры. Не забудь, что имя тоже входит в состав полного пути.

6.2 Создай объект класса ZipFileManager, передав в него имя файла архива. Разберись, как из String получить Path.



Подсказка: изучи метод get() класса Paths.



6.3 Запроси пользователя ввести путь к файлу, который будем архивировать. Не путай это с файлом архива, который мы уже ввели. На этот раз нам нужен файл, который мы будем сжимать, а не в котором хранить сжатые данные.

6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.





Требования:

1. Создай класс ZipFileManager.

2. Внутри класса ZipFileManager должно быть создано приватное поле Path zipFile.

3. Внутри класса ZipFileManager должен быть создан конструктор, который будет инициализировать поле zipFile.

4. Внутри класса ZipFileManager должен быть создан публичный метод void createZip(Path source) throws Exception.

5. Создай класс Archiver и добавь в него метод main. Реализуй его согласно заданию.
*/
