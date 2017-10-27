
//Jesus therefore said to Peter, "Put the sword into its sheath. The cup which the Father has given me, shall I not surely drink it?" (John 18:11)


package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        br.close();

        while (fr.ready()) {
            String string = fr.readLine();
            if (string.startsWith(args[0]))
                System.out.println(string);
        }
        fr.close();
    }
}





/*
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id — int.
productName — название товара, может содержать пробелы, String.
price — цена, double.
quantity — количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.


package com.javarush.task.task18.task1822;

* 
Поиск данных внутри файла
*

public class Solution {
    public static void main(String[] args) {
    }
}


*/