
//You didn't choose me, but I chose you, and appointed you, that you should go and bear fruit, 
//and that your fruit should remain; that whatever you will ask of the Father in my name, he may give it to you. (John 15:16)

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem menuItem = new JMenuItem(action);
        parent.add(menuItem);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem menuItem = addMenuItem(parent, action);
        menuItem.setText(text);
        return menuItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {}

    public static void initFontMenu(View view, JMenuBar menuBar) {}

    public static void initColorMenu(View view, JMenuBar menuBar) {}

    public static void initAlignMenu(View view, JMenuBar menuBar) {}

    public static void initStyleMenu(View view, JMenuBar menuBar) {}

    public static void initEditMenu(View view, JMenuBar menuBar) {}

    public static void initFileMenu(View view, JMenuBar menuBar) {}


}





/*
HTML Editor (7)

Добавь класс MenuHelper. Это будет вспомогательный класс для инициализации и настройки

меню.

У меню будет следующая структура:

- Файл

- Новый

- Открыть

- Сохранить

- Сохранить как...

- Выход



- Редактировать

- Отменить

- Вернуть

- Вырезать

- Копировать

- Вставить



- Стиль

- Полужирный

- Подчеркнутый

- Курсив

- Подстрочный знак

- Надстрочный знак

- Зачеркнутый



- Выравнивание

- По левому краю

- По центру

- По правому краю



- Цвет

- Красный

- Оранжевый

- Желтый

- Зеленый

- Синий

- Голубой

- Пурпурный

- Черный



- Шрифт

- Шрифт

- SansSerif, Serif, Monospaced, Dialog, DialogInput,

- Размер шрифта

- 6, 8, 10, 12, 14, 16, 20, 24, 32, 36, 48, 72



- Помощь

- О программе



7.1. Реализуй в MenuHelper статический метод JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener), где parent - меню в которое мы добавляем пункт, text - текст добавляемого пункта, actionListener - слушатель действий добавляемого пункта меню. Он должен:

7.1.1. Создавать новый пункт меню JMenuItem, используя text.

7.1.2. Устанавливать этому пункту слушателя действий с помощью метода addActionListener().

7.1.3. Добавлять в parent созданный пункт меню.

7.1.4. Возвращать созданный пункт меню.

7.2. Реализуй статический метод JMenuItem addMenuItem(JMenu parent, Action action). Этот метод аналогичен предыдущему, но в качестве параметра принимает действие action, которое необходимо выполнить при выборе пункта меню.



Подсказка: при создании JMenuItem передай в конструктор action. Разберись откуда возьмется имя пункта меню, если его не устанавливать дополнительно.



7.3. Реализуй статический метод JMenuItem addMenuItem(JMenu parent, String text, Action action), который добавляет в parent новый пункт меню с текстом text и действием action при выборе этого метода. При реализации используй вызов метода из предыдущего пункта.

7.4. Добавь в MenuHelper заглушки для следующих статический методов:

7.4.1. void initHelpMenu(View view, JMenuBar menuBar) - инициализация меню помощи.

7.4.2. void initFontMenu(View view, JMenuBar menuBar) - инициализация меню выбора

шрифта.

7.4.3. void initColorMenu(View view, JMenuBar menuBar) - инициализация меню выбора цвета.

7.4.4. void initAlignMenu(View view, JMenuBar menuBar) - инициализация меню выравнивания.

7.4.5. void initStyleMenu(View view, JMenuBar menuBar) - инициализация меню выбора стиля текста.

7.4.6. void initEditMenu(View view, JMenuBar menuBar) - инициализация меню редактирования текста.

7.4.7. void initFileMenu(View view, JMenuBar menuBar) - инициализация меню Файл.





Требования:

1. Класс MenuHelper должен быть создан в отдельном файле.

2. Класс MenuHelper должен реализовывать публичный статический метод JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener).

3. Класс MenuHelper должен реализовывать публичный статический метод JMenuItem addMenuItem(JMenu parent, Action action).

4. Класс MenuHelper должен реализовывать публичный статический метод JMenuItem addMenuItem(JMenu parent, String text, Action action).

5. Класс MenuHelper должен содержать публичный статический метод void initHelpMenu(View view, JMenuBar menuBar).

6. Класс MenuHelper должен содержать публичный статический метод void initFontMenu(View view, JMenuBar menuBar).

7. Класс MenuHelper должен содержать публичный статический метод void initColorMenu(View view, JMenuBar menuBar).

8. Класс MenuHelper должен содержать публичный статический метод void initAlignMenu(View view, JMenuBar menuBar).

9. Класс MenuHelper должен содержать публичный статический метод void initStyleMenu(View view, JMenuBar menuBar).

10. Класс MenuHelper должен содержать публичный статический метод void initEditMenu(View view, JMenuBar menuBar).

11. Класс MenuHelper должен содержать публичный статический метод void initFileMenu(View view, JMenuBar menuBar).

HTML Editor (6)

Реализуй метод инициализации панелей редактора initEditor(). Он должен:

6.1. Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.

Найди и используй подходящий метод.

6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.

6.3. Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего

пункта.

6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.

6.5. Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из

предыдущего пункта.

6.6. Устанавливать предпочтительный размер панели tabbedPane.

6.7. Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane.

6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.

Получить панель контента текущего фрейма можно с помощью метода getContentPane(), его реализация унаследовалась от JFrame.

После запуска приложения можно будет увидеть текущие результаты: две независимые закладки (HTML и Текст), в каждой из которых можно набирать свой текст.



HTML Editor (5)

5.1. Объяви класс TabbedPaneChangeListener реализующий интерфейс ChangeListener в пакете listeners. Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.

Реализуй в этом классе:

5.1.1. Конструктор, принимающий представление в виде параметра и сохраняющий во внутреннее поле view класса.

5.1.2. Переопредели метод из интерфейса ChangeListener, он должен вызывать метод selectedTabChanged() у представления. Последнего метода еще нет, сделай для него заглушку.

5.2. Объяви класс ExceptionHandler. Это будет наш обработчик исключительных ситуаций, который ты в дальнейшем сможешь переопределить. Пока добавь в него статический метод log(Exception e), который будет выводить в консоль краткое описание проблемы (используй метод toString у переданного исключения).



HTML Editor (4)

4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и панелей редактора.

4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс. Вызови из него инициализацию меню initMenuBar(), инициализацию редактора initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.

Разберись что делает метод pack().

4.3. Реализуй метод init() представления. Он должен:

4.3.1. Вызывать инициализацию графического интерфейса initGui().

4.3.2. Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй объект класса FrameListener. В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого наследуется и наш класс через классы JFrame и Frame.

4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.

На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.



HTML Editor (3)

Графический интерфейс будет представлять собой окно, в котором будет меню и панель с

двумя вкладками.

На первой вкладке будет располагаться текстовая панель, которая будет отрисовывать html страницу. На ней можно будет форматировать и редактировать текст страницы.

На второй вкладке будет редактор, который будет отображать код html страницы, в нем будут видны все используемые html теги. В нем также можно будет менять текст страницы, добавлять и удалять различные теги.

3.1. Добавь и проинициализируй поля в классе представления:

3.1.1. JTabbedPane tabbedPane - это будет панель с двумя вкладками.

3.1.2. JTextPane htmlTextPane - это будет компонент для визуального редактирования html.

Он будет размещен на первой вкладке.

3.1.3. JEditorPane plainTextPane - это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).

3.2. Добавь класс FrameListener в пакет listeners. Он должен:

3.2.1. Быть унаследован от WindowAdapter.

3.2.2. Иметь поле View view.

3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.

3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit() у представления.



HTML Editor (2)

2.1. Добавь в контроллер и представление по методу init(), пока без реализаций. Они будут отвечать за инициализацию контроллера и представления.

2.2. Теперь напишем в классе Controller метод main(). Он должен:

2.2.1. Создавать объект представления.

2.2.2. Создавать контроллер, используя представление.

2.2.3. Устанавливать у представления контроллер.

2.2.4. Инициализировать представление.

2.2.5. Инициализировать контроллер. Контроллер должен инициализироваться после представления.

2.3. Добавь в контроллер метод exit(), он должен вызывать статический метод exit у класса

System.

2.3.1. Метод exit в классе Controller не должен быть статическим.

2.4. Добавь в представление метод exit(), он должен вызывать exit() у контроллера.
*/
