
//He first found his own brother, Simon, and said to him, "We have found the Messiah!" (which is, being interpreted, Christ). (John 1:41)

package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    private boolean isManAnya = false;
    private boolean isManRoma = true;

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return ((userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3);
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
         int i = (base.get() + age / 100);
        i = (int) (i * (hasWork ? 1.1 : 0.9));
        i = (int) (i * (hasHouse ? 1.1 : 0.9));
        return i;
    }

    public String getBossName(User user) {
        Work work = user.getWork();
        return work.getBoss();
    }
}

/*
Рефакторинг (13)
Разберись с кодом пакета user (пользователь).
13.1. Извлечение метода. Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль в формате

Имя: Вася
Фамилия: Пупкин

Замени повторяющийся код метода printUsers() его вызовом.
13.2. Встраивание метода. Избавься от метода ageLessThan16().
13.3. Перемещение метода. Перемести методы printInfo() и printAdditionalInfo() в класс User.
13.4. Расщепление переменной. Переменная age в методе calculateAverageAge() используется для разных промежуточных значений. Перепиши метод без использования этой переменной.
13.5. Удаление присваиваний параметрам. Перепиши метод calculateRate(), чтобы он не
пытался менять входные параметры, а просто возвращал рассчитанное значение.


Требования:
1. Необходимо создать метод printInfo() в классе User, который будет выводить имя и фамилию в консоль так же, как это делается в методе printUsers() класса UserHelper.
2. Необходимо заменить в методе printUsers() класса UserHelper повторяющийся код вызовами метода printInfo().
3. Необходимо избавиться от метода ageLessThan16() класса UserHelper.
4. Необходимо переместить метод printAdditionalInfo() в класс User. Обрати внимание, что метод printAdditionalInfo теперь не должен получать объект класса User в качестве параметра.
5. Необходимо переписать метод calculateAverageAge() класса UserHelper без использования переменной age.
6. Перепиши метод calculateRate() класса UserHelper, чтобы метод не изменял входные параметры, а просто возвращал рассчитанное значение (метод должен возвращать int).
Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры
boolean canPassengersBeTransferred() в класс Car. Метод должен возвращать true, если
водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.

Рефакторинг (11)
11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double
numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
11.2. Разбиение условного оператора.
11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к
лету: boolean isSummer(Date date , Date summerStart, Date summerEnd).
11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: double
getWinterConsumption(int length).
11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: double
getSummerConsumption(int length).
11.2.4. Перепиши метод getTripConsumption(), используя новые методы.

Рефакторинг (10)
Разберись с кодом в пакете car (машина).
10.1. Замена конструктора фабричным методом.
10.1.1. Объяви классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
10.1.2. Добавь в них конструкторы, принимающие int numberOfPassengers.
10.1.3. Добавь фабричный статический метод Car create(int type, int numberOfPassengers) в класс Car и реализуй его.
10.1.4. Измени область видимости конструктора класса Car.

Рефакторинг (9)
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.

Рефакторинг (8)
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент
создания объекта.
8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с
областью его использования.
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
break.
*/
