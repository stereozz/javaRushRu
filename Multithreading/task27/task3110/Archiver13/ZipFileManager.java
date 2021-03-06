
// For the law was given by Moses, but grace and truth came by Jesus Christ (John 1:17)

package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }
        return files;
    }
}

/*
Archiver (13)

Продолжим наш путь к получению содержимого файла архива. Напишем метод getFilesList() в классе ZipFileManager. Он будет возвращать список файлов в архиве, вернее список свойств этих файлов (класс свойств FileProperties мы уже реализовали).

Итак:

1. Добавь метод List<FileProperties> getFilesList() throws Exception в класс ZipFileManager

2. Внутри метода проверь является ли содержимое zipFile обычным файлом с помощью подходящего метода класса Files. Если это не файл, брось исключение WrongZipFileException().

3. Создай список с элементами типа FileProperties, в него мы будем складывать свойства файлов

4. Создай входящий поток ZipInputStream, для файла из переменной zipFile. Как и в прошлые разы, оберни его создание в try-with-resources

5. Пройдись по всем элементам ZipEntry потока ZipInputStream

6. Для каждого элемента ZipEntry вычитай его содержимое, иначе у нас не будет информации о его размере. Нельзя узнать размер файла в архиве, не вычитав его. Это очень легко сделать с помощью функции copyData, используя временный буфер типа ByteArrayOutputStream.

7. Получи имя, размер, сжатый размер и метод сжатия элемента архива. Посмотри, что еще можно узнать о нем.

8. Создай объект класса FileProperties, используя полученные данные о файле.

9. Добавь созданный объект из п.8 в список из п.3

10. После выхода из цикла верни собранную информацию вызвавшему методу.





Требования:

1. В классе ZipFileManager нужно создать публичный метод List getFilesList() throws Exception.

2. Если Path zipFile не является файлом, метод getFilesList должен кинуть исключение WrongZipFileException.

3. Метод getFilesList должен пройтись по всем файлам архива и вернуть данные о них. Реализация должна быть выполнена согласно описанию в задании.

4. Поток для чтения из архива должен быть закрыт.
*/
