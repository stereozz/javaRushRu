
//Your glorying is not good. Know you not that a little leaven leavens the whole lump? (1Cor 5:6)

package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.javarush.task.task30.task3008.ConsoleHelper;

public class BotClient extends Client {
    
    public static void main(String[] args) {
        new BotClient().run();

    }
    
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int) (Math.random() * 100));
        return botName;
    }
    
    public class BotSocketThread extends SocketThread {
     @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {
                ConsoleHelper.writeMessage(message);
                SimpleDateFormat format = null;
                if (message.contains(": ")) {
                    String[] massiv = message.split(": ");
                    if (massiv.length == 2 && massiv[1] != null) {
                        String name = massiv[0];
                        String text = massiv[1];
                        switch (text) {
                            case "дата":
                                format = new SimpleDateFormat("d.MM.YYYY");
                                break;
                            case "день":
                                format = new SimpleDateFormat("d");
                                break;
                            case "месяц":
                                format = new SimpleDateFormat("MMMM");
                                break;
                            case "год":
                                format = new SimpleDateFormat("YYYY");
                                break;
                            case "время":
                                format = new SimpleDateFormat("H:mm:ss");
                                break;
                            case "час":
                                format = new SimpleDateFormat("H");
                                break;
                            case "минуты":
                                format = new SimpleDateFormat("m");
                                break;
                            case "секунды":
                                format = new SimpleDateFormat("s");
                                break;

                        }
                        if (format != null) {
                            sendTextMessage(String.format("Информация для %s: %s", name, format.format(Calendar.getInstance().getTime())));
                        }
                    }
                }
            }
        }
    }
}

/*
Чат (19)
Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы, весь основной функционал он уже унаследовал от SocketThread.

1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом «Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.»
б) Вызови реализацию clientMainLoop() родительского класса.
2. Переопредели метод processIncomingMessage(String message). Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
«дата» – отправить сообщение содержащее текущую дату в формате «d.MM.YYYY«;
«день» – в формате «d«;
«месяц» — «MMMM«;
«год» — «YYYY«;
«время» — «H:mm:ss«;
«час» — «H«;
«минуты» — «m«;
«секунды» — «s«.
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил запрос «время«, мы должны отправить ответ «Информация для Боб: 12:30:47«.
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат «:«


Требования:
1. Метод clientMainLoop класса BotSocketThread должен вызывать метод sendTextMessage у внешнего объекта BotClient c приветственным сообщением указанном в условии задачи.
2. Метод clientMainLoop класса BotSocketThread должен вызывать clientMainLoop у объекта родительского класса (super).
3. Метод processIncomingMessage должен выводить на экран полученное сообщение message.
4. Метод processIncomingMessage должен отправлять ответ с помощью метода sendTextMessage (форматирование согласно условию задачи).
5. Метод processIncomingMessage не должен вызывать метод sendTextMessage для некорректных запросов.
*/
