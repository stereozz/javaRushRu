
//And thus I saw the horses in the vision, and them that sat on them, having breastplates of fire, and of jacinth,
//and brimstone: and the heads of the horses were as the heads of lions; and out of their mouths issued fire and smoke and brimstone. (Revelation 9:17)

package com.javarush.task.task30.task3001;

public enum NumerationSystemType implements NumerationSystem {
    _16,
    _12,
    _10,
    _9,
    _8,
    _7,
    _6,
    _5,
    _4,
    _3,
    _2;

    @Override
    public int getNumerationSystemIntValue() {
        return Integer.parseInt(this.name().substring(1));
    }
}

/*
Конвертер систем счислений

Реализуй логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit(), из одной системы счисления (numerationSystem) в другую (expectedNumerationSystem).

Брось NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2.

Валидация для - number.getDigit() - целое не отрицательное.

Метод main не участвует в тестировании.





Требования:

1. Метод convertNumberToOtherNumerationSystem (Number, NumerationSystem), возвращающий тип Number, должен существовать.

2. Должно бросаться исключение NumberFormatException, если переданное число некорректно в заданной системе счисления.

3. Необходимо корректно реализовать метод convertNumberToOtherNumerationSystem - перевод числа в указанную систему счисления.

4. Enum NumerationSystemType должен поддерживать интерфейс NumerationSystem.

5. В enum-е NumerationSystemType должно присутствовать 11 значений оснований систем счисления. Основания: 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 и 16.
*/
