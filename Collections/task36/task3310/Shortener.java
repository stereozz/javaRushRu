
//And there was given me a reed like unto a rod: and the angel stood, saying, Rise, and measure the temple of God, 
//and the altar, and them that worship therein. (Revelation 11:1)

package com.javarush.task.task33.task3310;

public class Shortener {

    public Long getId(String string) {
        return new Long(0);
    }

    public String getString(Long id) {
        return new String();
    }
}

/*
Shortener (1)

Давай напишем укорачиватель Shortener. Это будет некий аналог укорачивателя

ссылок Google URL Shortener (https://goo.gl), но мы расширим его функциональность и

сделаем консольным. Он будет сокращать не только ссылки, но и любые строки.

Наш Shortener - это класс, который может для любой строки вернуть некий

уникальный идентификатор и наоборот, по ранее полученному идентификатору

вернуть строку.



Два дополнительных требования к Shortener:

- для двух одинаковых строк должен возвращаться один и тот же идентификатор;

- он должен поддерживать столько строк, сколько значений может принимать long,

именно этот тип будет использоваться для идентификатора.

Первое требование очень сильно влияет на производительность, т.к. при получении

идентификатора для новой строки мы должны проверить не обрабатывалась ли эта

строка ранее, чтобы вернуть старый идентификатор.



1.1. Объяви класс Shortener.

1.2. Добавь методы заглушки в объявленный класс:

1.2.1. Long getId(String string) - будет возвращать идентификатор id для заданной

строки.

1.2.2. String getString(Long id) - будет возвращать строку для заданного

идентификатора или null, если передан неверный идентификатор.



1.3. Создай класс Solution с пустым методом main.



P.S. Все методы делай публичными, а поля приватными, если нет явных указаний касательно модификаторов доступа.





Требования:

1. В классе Shortener должен быть объявлен метод public Long getId(String string).

2. В классе Shortener должен быть объявлен метод public Long String getString(Long id).

3. В классе Solution должен быть объявлен метод public static void main(String[] args).
*/
