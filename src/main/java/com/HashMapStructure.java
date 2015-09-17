package main.java.com;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapStructure {

    /**
     * @author Arpit Mandliya
     * @version 1.0
     * @date 17/09/2015
     * {@link http://info.javarush.ru/translation/2014/04/27/Как-HashMap-работает-в-Java-.html}  {@link http://www.java2blog.com/2014/02/hashcode-and-equals-method-in-java.html}
     * {@link http://developer.alexanderklimov.ru/android/java/hashmap.php}
     * ***************************
     * Как HashMap работает в Java
     */
    public static void main(String[] args) {
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
        while(countryCapitalIter.hasNext()){ // debug-точку на этой строке (30)
            Country countryObj = countryCapitalIter.next();
            String     capital = countryCapitalMap.get( countryObj );

            System.out.println("Capital of "+ countryObj.getName()+"----"+capital);
        }
    }

}


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