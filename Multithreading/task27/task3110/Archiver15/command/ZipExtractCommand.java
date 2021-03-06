
//And this is the record of John, when the Jews sent priests and Levites from Jerusalem to ask him, Who art thou? (John 1:19)

package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Архив был распакован.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Неверный путь для распаковки.");
        }
    }
}

/*
Archiver (15)

Пора попробовать что-нибудь распаковать. Для этого добавим публичный метод void extractAll(Path outputFolder) throws Exception в класс ZipFileManager. Path outputFolder - это путь, куда мы будем распаковывать наш архив. У тебя уже большой опыт работы с элементами архива и потоками. Так что, я дам только подсказки по реализации этого метода, а тебе придется хорошенько подумать, как это все сделать:

1. Проверь, есть ли zip файл вообще

2. Если директория outputFolder не существует, то ее нужно создать, как и все папки, внутри которых она лежит.

3. Внутри архива некоторые файлы могут лежат внутри папок, тогда метод getName() элемента архива ZipEntry, вернет не совсем имя, как может показаться из названия, а относительный путь внутри архива. Этот относительный путь должен сохраниться и после распаковки, но уже относительно той директории, куда мы распаковали архив

4. Реализуй метод execute() класса ZipExtractCommand, по аналогии с таким же методом класса ZipCreateCommand, сделай такой же блок try-catch, только поменяй сообщения выводимые пользователю, чтобы он понял, что сейчас мы будем распаковывать архив, и что нужно ввести полное имя архива и директорию, куда будем распаковывать. Не забудь вызвать метод extractAll класса ZipFileManager, а не createZip, как это было в ZipCreateCommand

5. Запускай программу и наслаждайся результатом распаковки



Примечание:

Для получения потоков чтения и записи используй Files.newInputStream(Path path), Files.newOutputStream(Path path).





Требования:

1. В классе ZipFileManager нужно создать публичный метод void extractAll(Path outputFolder) throws Exception.

2. Метод extractAll(Path outputFolder) должен бросать исключение WrongZipFileException, если файл архива не существует.

3. Метод extractAll(Path outputFolder) должен создавать директорию outputFolder, если она не существует.

4. Метод extractAll(Path outputFolder) должен распаковывать все файлы из архива в директорию outputFolder.

5. Метод execute() в классе ZipExtractCommand должен получать объект ZipFileManager и разархивировать файлы в указанную пользователем директорию.
*/
