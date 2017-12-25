
//These things I command you, that ye love one another. (John 15:17)

package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    public void actionPerformed(ActionEvent actionEvent) {}
}

/*
HTML Editor (8)
Пришло время добавить все необходимые пункты меню и написать классы действий, выполняемые при нажатии. Это довольно трудоемкая и рутинная работа, а ты отличный ученик и не хотелось бы тебя огорчать. Поэтому, в качестве бонуса ты получаешь готовый класс MenuHelper! А ты:
8.1. Напиши в пакете actions заглушки для следующих классов:
8.1.1. Класс отмены действия UndoAction. Он должен наследоваться от AbstractAction и содержать конструктор UndoAction(View view).
8.1.2. Класс возврата действия RedoAction. Требования аналогичны требованиям к UndoAction.
8.1.3. Класс StrikeThroughAction, который отвечает за стиль текста "Зачеркнутый". Унаследуй его от StyledEditorKit.StyledTextAction.
8.1.4. Класс SubscriptAction, который отвечает за стиль текста "Подстрочный знак". Его также унаследуй его от StyledEditorKit.StyledTextAction.
8.1.5. Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак". Добавь ему правильный родительский класс.
8.2. Напиши в пакете listeners заглушки для классов:
8.2.1. UndoMenuListener, он должен реализовывать интерфейс MenuListener и иметь конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem). Чем он будет заниматься узнаешь чуть позже.
8.2.2. TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
Добавь ему конструктор TextEditMenuListener(View view). В следующих заданиях мы рассмотрим его детальнее.
Требования:
1. Класс UndoAction должен быть создан в отдельном файле.
2. Класс RedoAction должен быть создан в отдельном файле.
3. Класс StrikeThroughAction должен быть создан в отдельном файле.
4. Класс SubscriptAction должен быть создан в отдельном файле.
5. Класс SuperscriptAction должен быть создан в отдельном файле.
6. Класс UndoMenuListener должен быть создан в отдельном файле.
7. Класс TextEditMenuListener должен быть создан в отдельном файле.
*/
