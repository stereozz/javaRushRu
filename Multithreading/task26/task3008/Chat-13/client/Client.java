
//What do you wish? shall I come unto you with a rod, or in love, and in the spirit of meekness? (1Cor 4:21)


package com.javarush.task.task30.task3008.client;

import java.io.IOException;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import com.javarush.task.task30.task3008.Connection;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;
    
    protected String getServerAddress() {
        String serverAddress;
        ConsoleHelper.writeMessage("Enter server address: ");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }
    
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port: ");
        return ConsoleHelper.readInt();
    }
    
    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter User name: ");
        return ConsoleHelper.readString();
    }
    
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error, can't send your message...");
            clientConnected = false;
        }
    }
    
    public class SocketThread extends Thread {
        
    } 
}

/*
Чат (13)
Продолжаем реализацию вспомогательных методов класса Client.

Добавь в класс методы, которые будут доступны классам потомкам, но не доступны из других классов вне пакета:
1. String getServerAddress() – должен запросить ввод адреса сервера у пользователя и вернуть введенное значение. Адрес может быть строкой, содержащей ip, если клиент и сервер запущен на разных машинах или ‘localhost’, если клиент и сервер работают на одной машине.
2. int getServerPort() – должен запрашивать ввод порта сервера и возвращать его.
3. String getUserName() – должен запрашивать и возвращать имя пользователя.
4. boolean shouldSendTextFromConsole() – в данной реализации клиента всегда должен возвращать true (мы всегда отправляем текст введенный в консоль). Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего, который не должен отправлять введенный в консоль текст.
5. SocketThread getSocketThread() – должен создавать и возвращать новый объект класса SocketThread.
6. void sendTextMessage(String text) – создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection.
Если во время отправки произошло исключение IOException, то необходимо вывести
информацию об этом пользователю и присвоить false полю clientConnected.


Требования:
1. Метод getServerAddress должен возвращать строку (адрес сервера), считанную с консоли.
2. Метод getServerPort должен возвращать число (порт сервера), считанное с консоли.
3. Метод getUserName должен возвращать строку (имя пользователя), считанную с консоли.
4. Метод shouldSendTextFromConsole должен возвращать true.
5. Метод sendTextMessage должен создавать и отправлять новое текстовое сообщение используя connection и устанавливать флаг clientConnected в false, если во время отправки или создания сообщения возникло исключение IOException.
6. Метод getSocketThread должен возвращать новый объект типа SocketThread.
*/
