package main.java.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class HashMapStructure {

    /**
     * @author Arpit Mandliya
     * @version 1.0
     * @date 17/09/2015
     * {@link http://info.javarush.ru/translation/2014/04/27/Как-HashMap-работает-в-Java-.html}  {@link http://www.java2blog.com/2014/02/hashcode-and-equals-method-in-java.html}
     * {@link http://developer.alexanderklimov.ru/android/java/hashmap.php}
     * ***************************
     * Как HashMap работает в Java
     *
     * {@link http://javaoutsource.blogspot.com/2012/11/hashcode.html}  {@link http://javaoutsource.blogspot.com/2012/10/hashset-hashmap.html}
     * * * * * * * * * * * * * * *
     * Контракт в HashMap между hashcode() и equals() - чтобы вся эта система корректно работала, необходимо соблюдать 2 правила:
     * 1. равные объекты должны иметь один и тот же hashcode то есть, если equals - true, hashcode() возвращает одинаковое число
     * 2. объекты, имеющие разный hashcode - неравны то есть если hashcode() возвращает разные числа, equals обязано вернуть false
     * В HashMap могут быть помещены записи только с уникальными ключами. Уникальность определяется методом equals().
     * Примечание #1: неравные объекты могут иметь одинаковый hashcode. В этом случае они хоть и попадают в один бакет, но все равно отсекаются при проверке объектов на equals().
     * Примечание #2: соблюдать правила взаимосвязь equals()-hashcode() необходимо, если вы переопределяете эти функции. В реализации по умолчанию (эти функции уже определены в базовом объекте - Object) эти правила уже соблюдены.
     *
     * * * * * * * * * * * * * * *
     * (Что такое список) Список - это (прежде всего) хранилище, с упорядоченным набором данных.
     * По назначению списки можно разделить на типы:
     * 1. Обычные списки (типа) 'List'. В таком списке может храниться (лежать) разные данные (муссор).
     *    Достоинством такого списка является тот факт что это самый простой список...
     *    Недостатком такого списка является тот факт что с работой большого количества данных он плохо будет справляться...
     * 2. (тип) 'Set'. Приеняется дабы недержать разный-ненужный муссор в хранилище (только полезные данные), способом предотвращения дубликатов...
     *    Достоинством такого списка является тот факт что он позволяет более экономно использовать рессурсы И хорошо справляется с большими объемами данных...
     *    Недостатком такого списка является тот факт что больше занимает время на добавления нового элемента в список...
     * 3. (тип) 'Map'. Преобразование одного списка в другой - ассоциативный массив - всегда удобно работать с объектами если наделить их смысловым названием.
     *    Достоинством такого списка является тот факт что позволяет удобно манипулировать-работать с очень большими объектами как с обычными-маленькими объектами... Строить еще более сложные структуры списков и концентрировать-держать их в едином хранилище
     *    Недостатком такого списка является тот факт что такие списки сложно реализовывать, имеются недостатки в качестве рабботы и есть высокая вероятность потерять данные...
     *
     * Для работы со списками важны такие ключевые функции как:
     * - поиск элемента в списке
     * - сортировка элементов по списку
     * - фильтрование элементов в списке
     *
     *   Есть случаи когда необходимо переопределять дефолтный механизм (hashCode, equals, compareTo), например:
     * когда пытаемся повторить структуру объекта из другого языка (не Java: база данных, специальный файл, ...).
     * То есть, такая структура непривязана к общему классу 'Object'
     */
    public static void main(String[] args) {
        Object o;

        Country  india = new Country("India",1000);
        Country  japan = new Country("Japan",10000);
        Country france = new Country("France",2000);
        Country russia = new Country("Russia",20000);

        HashMap<Country,String> countryCapitalMap = new HashMap<Country,String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        Iterator<Country> countryCapitalIter = countryCapitalMap.keySet().iterator(); // установите
        while(countryCapitalIter.hasNext()){ // debug-точку на этой строке (64)
            Country countryObj = countryCapitalIter.next();
            String     capital = countryCapitalMap.get( countryObj );

            System.out.println("Capital of "+ countryObj.getName()+"----"+capital);
        }
    }

}


/*
    Object
    -------------------
    hashCode()
    equals()
    toString()
    wait()
    notify()
    notifyAll()
    clone()
    finalize()
    registerNatives()
  */


/**
 * Легче всего представить что будет если эти правила будут нарушены
 *
 * Представим что у нас объект А и объект В - равны по equals, но возвращают разные hashcode.
 * Мы добавляем запись с ключом-объектом А в HashMap.
 * Далее мы пытаемся туда же добавить запись с ключом-объектом В.
 * (Что должно произойти? Поскольку А и В равны, вторая запись не должна добавиться. А что происходит на самом деле?)
 * При добавлении второй записи высчитывается hashcode() для В, и по нему находится бакет, в котором предположительно будет находиться новая запись, если ключ В будет уникален.
 * Для проверки уникальности вызывается метод equals() ключей записей, которые находятся в этом бакете.
 * Вероятнее всего запись А будет в другом бакете, поэтому проверки покажут уникальность В.
 * В результате мы будем иметь в HashMap с равными ключами А и В, что нарушает контракт HashMap.
 *
 * Проблемы возникают и при поиске объектов.
 */
class Country {

    public Country(){}
    public Country(String name, long population) {
        super();
        this.name       = name;
        this.population = population;
//        super(); /* ошибка в конце конструктора вызывать супер-конструктор. Его нужно вызывать в самом начале... */
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

    // Если длина имени в объекте Country - четное число, то возвращаем 31(любое случайное число), а если нечетное - 95 (любое случайное число).
    // (указанный ниже метод - это не самый лучший способ генерации хеш-кода, но мы воспользуемся им для более четкого понимания хеш-карт)

    @Override
    public int hashCode() {
        if(this.name.length()%2==0)
            return 31;
        else
            return 95;
    }

//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        return result;
//    }

    @Override
    public boolean equals(Object obj) {
        Country other = (Country) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }

//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Country other = (Country) obj;
//        if (name == null) {
//            if (other.name != null)
//                return false;
//        } else if (!name.equals(other.name))
//            return false;
//        return true;
//    }

    private String name;
    private long population;
}