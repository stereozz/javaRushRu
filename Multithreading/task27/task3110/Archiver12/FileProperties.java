
//For the law was given by Moses, but grace and truth came by Jesus Christ. (John 1:17)

package com.javarush.task.task31.task3110;

public class FileProperties {

    private String name;

    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        if (size > 0) {
            stringBuilder.append(" ");
            stringBuilder.append(size / 1024);
            stringBuilder.append(" Kb (");
            stringBuilder.append(compressedSize / 1024);
            stringBuilder.append(" Kb) сжатие: ");
            stringBuilder.append(getCompressionRatio());
            stringBuilder.append("%");
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }
}

/*
Archiver (12)

Сегодня мы подготовимся к реализации команды ZipContentCommand. Она будет заниматься получением содержимого архива. Содержимое архива - это упакованные файлы и папки, но нам было бы интересно узнать не только имена объектов архива, но и их размер до и после сжатия, степень сжатия и метод сжатия.

Создадим класс FileProperties, который будет отвечать за свойства каждого файла в архиве. Свойства - это набор, состоящий из: имя файла, размер файла до и после сжатия, метод сжатия.

1. Создай класс FileProperties

2. Добавь в него приватные переменные класса:

2.1. Имя String name

2.2. Размер в байтах long size

2.3. Размер после сжатия в байтах long compressedSize

2.4. Метод сжатия int compressionMethod

3. Добавь гетеры для них

4. Добавь конструктор FileProperties(String name, long size, long compressedSize, int compressionMethod)

5. Добавь метод long getCompressionRatio(), который будет считать степень сжатия по формуле: 100 - ((compressedSize * 100) / size)

6. Перегрузи метод String toString(), чтобы он возвращал строку по шаблону: "name size Kb

(compressedSize Kb) сжатие: compressionRatio%", если размер size больше нуля, иначе он должен

вернуть только имя файла. Нулевой размер может быть, например, у директории. Не забудь

перевести байты в килобайты, а их не столько же, сколько граммов в килограмме, и даже не

столько, сколько блинов у меня на столе... Хм, похоже мне пора перекусить...





Требования:

1. В корне задачи нужно создать класс FileProperties.

2. Класс FileProperties должен содержать поля String name, long size, long compressedSize, int compressionMethod.

3. Класс FileProperties должен содержать конструктор FileProperties(String name, long size, long compressedSize, int compressionMethod).

4. Для всех полей в FileProperties должны быть созданы геттеры.

5. Класс FileProperties должен содержать публичный метод long getCompressionRatio(), который считает степень сжатия файла.

6. Метод toString у класса FileProperties должен быть реализован следуя описанию в задании.


*/
