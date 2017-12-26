
//Outside are the dogs, the sorcerers, the sexually immoral, the murderers, the idolaters, 
//and everyone who loves and practices falsehood. (Revelation 22:15)

package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {return document;}
    
    public void init() {
        createNewDocument();
    }
    
    public void exit() {
        System.exit(0);
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile = null;
        view.resetUndo();
    }
    
    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int choose = jFileChooser.showOpenDialog(view);
        if (choose == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();

            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());

            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int choose = jFileChooser.showSaveDialog(view);
        if (choose == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }


    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}

/*
HTML Editor (23)

23.1. Напишем метод для сохранения открытого файла saveDocument(). Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().

23.2. Пришло время реализовать метод openDocument(). Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.



Подсказка: Обрати внимание на имя метода для показа диалогового окна.



Когда файл выбран, необходимо:

23.2.1. Установить новое значение currentFile.

23.2.2. Сбросить документ.

23.2.3. Установить имя файла в заголовок у представления.

23.2.4. Создать FileReader, используя currentFile.

23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.

23.2.6. Сбросить правки (вызвать метод resetUndo представления).

23.2.7. Если возникнут исключения - залогируй их и не пробрасывай наружу.

Проверь работу пунктов меню Сохранить и Открыть.





Требования:

1. Метод saveDocument() в контроллере должен переключать представление на html вкладку.

2. Метод saveDocument() в контроллере должен создавать FileWriter на базе currentFile, если currentFile != null.

3. Метод saveDocument() в контроллере должен используя HTMLEditorKit переписывать данные из документа document в объект FileWriter-а, если currentFile != null.

4. Метод saveDocument() в контроллере должен вызывать метод saveDocumentAs(), если currentFile == null.

5. Метод saveDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.

6. Метод openDocument() в контроллере должен переключать представление на html вкладку.

7. Метод openDocument() в контроллере должен создавать новый объект для выбора файла JFileChooser.

8. Метод openDocument() в контроллере должен устанавливать объекту класса JFileChooser в качестве фильтра объект HTMLFileFilter.

9. Метод openDocument() в контроллере должен, используя метод showOpenDialog() у JFileChooser показывать диалоговое окно "Open File" для выбора файла.

10. Метод openDocument() в контроллере должен установить новое значение currentFile, если пользователь подтвердит выбор файла.

11. Метод openDocument() в контроллере должен сбросить документ, если пользователь подтвердит выбор файла.

12. Метод openDocument() в контроллере должен устанавливать имя файла в качестве заголовка окна представления, если пользователь подтвердит выбор файла.

13. Метод openDocument() в контроллере должен создавать FileReader на базе currentFile, если пользователь подтвердит выбор файла.

14. Метод openDocument() в контроллере должен используя HTMLEditorKit вычитать данные из FileReader-а в документ document, если пользователь подтвердит выбор файла.

15. Метод openDocument() в контроллере должен сбросить правки, если пользователь подтвердит выбор файла.

16. Метод openDocument() в контроллере не должен кидать исключения, а логировать через ExceptionHandler.
*/
