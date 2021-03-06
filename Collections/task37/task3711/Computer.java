
//When the ruler of the feast had tasted the water that was made wine, and knew not whence it was: 
//(but the servants which drew the water knew;) the governor of the feast called the bridegroom (John 2:9)

package com.javarush.task.task37.task3711;

public class Computer {

    CPU cpu = new CPU();
    Memory memory = new Memory();
    HardDrive hardDrive = new HardDrive();

    public void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
     }
}

/*
Фасад

Паттерн Фасад позволяет скрыть сложность системы путём сведения всех возможных внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.



В данном случае, в классе Solution по отдельности создаются объекты типов CPU, Memory и HardDrive и, в дальнейшем, на этих объектах вызываются некоторые методы.

Клиенту (в данном случае классу Solution), было бы намного удобнее, если бы существовал класс

Computer, инкапсулирующий создание объектов и предоставляющий единую точку взаимодействия с ними.



Проведем рефакторинг:

1) Создай класс Computer в котором создай и инициализируй поля типов CPU, Memory и HardDrive.

2) В классе Computer реализуй метод void run(), в котором вызови необходимые методы у объектов CPU, Memory и HardDrive.

3) Удали содержимое метода main класса Solution, после чего добавь туда создание нового компьютера и его запуск.





Требования:

1. В классе Computer должны быть созданы и инициализированы поля типов CPU, Memory и HardDrive.

2. В методе run класса computer должны быть вызваны методы calculate, allocate и storeData у объектов CPU, Memory и HardDrive.

3. В классе Solution должен быть создан новый объект типа Computer и вызван его метод run.

4. В классе Solution не должны явно создаваться объекты типов CPU, Memory и HardDrive.
*/
