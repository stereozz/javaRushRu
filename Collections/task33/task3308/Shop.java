
//And I saw the dead, small and great, stand before God; and the books were opened: and another book was opened, which is the book of life: and the dead were judged out of those things which were written in the books, according to their works. (Revelation 20:12)

package com.javarush.task.task33.task3308;

import java.util.List;
import java.util.ArrayList;

public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    //В классе Shop.Goods должен быть создан список строк names.
    public static class Goods {
        public List<String> names = new ArrayList<>();
    }
}

/*
Создание класса по строке xml

Восстанови класс по переданной строке xml.

Класс должен быть в отдельном файле.

Метод getClassName должен возвращать восстановленный класс.

Метод main не участвует в тестировании.





Требования:

1. Класс Shop должен быть создан в отдельном файле.

2. В классе Shop должно быть создано поле goods типа Goods.

3. В классе Shop должно быть создано поле count типа int.

4. В классе Shop должно быть создано поле profit типа double.

5. В классе Shop должен быть создан массив строк secretData.

6. В классе Shop должен содержаться вложенный статический класс Goods.

7. В классе Shop.Goods должен быть создан список строк names.

8. Все поля класса Shop должны быть публичными.

9. Метод getClassName класса Solution должен возвращать класс Shop.
*/
