package main.java.com;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * @author Lazarchuk
 * @version 1.0
 * @date 16/09/2015
 * {@link http://info.javarush.ru/translation/2014/06/26/}
 * *******************************************************
 * 'сложные задачи с коллекциями в java 7' >> Топ 10 вопросов о коллекциях в Java
 *
 * {@link http://tproger.ru/translations/10-java-multithread-practices/}
 * *********************************************************************
 * 'сложные задачи с коллекциями в java 7' >> 10 советов по многопоточному программированию на Java
 *
 * {@link https://github.com/Home-Java8/MyMap/tree/master/src/com/luxoft}
 * {@link http://www.java2s.com/Code/Jar/o/Downloadorgapachecommonslangjar.htm}
 */
public class App {

    public static void main(String[] args) {
//        func1();
//        func2();
//        func3();
//        func4();
//        func5();
//        func6();
        func7(); // ??????????
    }

    public static void func1(){
        /* Чтобы массив конвертировать в список и потом работать в цикле... для этого нужно работать с данными как с объектами (не примитивными типами) */
        /* такой себе врапер-обвертка */
        Integer[] array = {9,0,1,8,4,5,2,3,6,7};
        for (Integer a:array)
            System.out.print(a+" ");

        System.out.println();

        /* Нужно сразу указывать тип который передаем в список */
//        List<String> list = new LinkedList<String>(); // List list = new LinkedList();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        for(String str:list)
//            System.out.print(str+" ");

        List<Integer> list = Arrays.asList(array);
        for (Integer i:list)
            System.out.print(i + " ");
    }

    public static void func2(){
        /* Как конвертировать массив int[] в List */
        int[] array = {9,0,1,8,4,5,2,3,6,7};
        for (int a:array)
            System.out.print(a+" ");

        System.out.println();

//        List<Integer> list = new ArrayList<Integer>();
//        for(int i: array) {
//            list.add(i);
//        }
        List<Integer> list = Arrays.asList(ArrayUtils.toObject(array));
        for (Integer i:list)
            System.out.print(i + " ");
    }

    public static void func3(){
        Integer[]    array = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array)); /* В таких случаях всегда лучше использовать конструкцию 'new ArrayList<Integer>' потому-что 'Arrays.asList' является иммутейбл: http://stackoverflow.com/questions/6260113/unsupportedoperationexception-in-abstractlist-remove-when-operating-on-arrayli */

        /* ConcurrentModificationException: http://stackoverflow.com/questions/223918/iterating-through-a-list-avoiding-concurrentmodificationexception-when-removing */
        /* Здесь будет ошибка типа 'ConcurrentModificationException' потому-что список одновременно/параллельно используется два раза. При этом одновременно выполняется чтение и изменение списка... */
//        for (Integer i:list)
//            if(i.intValue()==4)
//                list.remove(i);

        /* именно для таких вот случаев и применяется итератор - он позволяет разограничить список для работы в многопоточном режиме */
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) /* http://stackoverflow.com/questions/17123360/removing-element-from-arraylist-through-iterator */
            if (iterator.next() == 5) {
                iterator.remove();
                break; // оператор только выходит из текущего тела
//                return; // оператор полностью покидает функцию
            }

        for (Integer i:list)
            System.out.print(i+" ");
    }

    public static void func4(){
        Integer[]    array = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

        filter(list, new Predicate2<Integer>(){
            public boolean test2(Integer i){
                return i<=5;
            }
        });

        for (Integer i:list)
            System.out.print(i+" ");
    }
    public interface Predicate2<T> {
        boolean test2 (T o);
    }
    public static <T> void filter(Collection<T> collection, Predicate2<T> predicate) {
        if ((collection != null) && (predicate != null)){
            for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();)
                if (!predicate.test2(iterator.next()))
                    iterator.remove();
        }
    }

    public static void func5(){
        int[]        array = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList(Arrays.asList(ArrayUtils.toObject(array)));

        Set<Integer> set = new HashSet<Integer>(list);

        for (Integer i:set)
            System.out.print(i+" ");
    }

    public static void func6(){
        int[] array = {0,1,2,3,4,5,6,7,8,9,4,5,6,7,3,4,5,6,7};
        for (int a:array)
            System.out.print(a+" ");

        System.out.println();

        Arrays.sort(array);
        for (int a:array)
            System.out.print(a+" ");

        System.out.println();

        List<Integer> list = new ArrayList(Arrays.asList(ArrayUtils.toObject(array)));
//        for (Integer i:list)
//            System.out.print(i+" ");

        Set<Integer> set = new HashSet<Integer>(list);
        for (Integer i:set)
            System.out.print(i+" ");

        System.out.println();

        int[] array2 = {0,9,8,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,9,0};
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(ArrayUtils.toObject(array2)));
        Collection<Integer> linked = new LinkedHashSet<Integer>(list2);
        for (Integer i:linked)
            System.out.print(i+" ");
    }

    /* Копирование коллекции, Collections.copy() //  Collections.emptyList() или новый экземпляр */
    public static void func7(){
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {11,22,33,44,55,66,77,88,99};
        int[] arr3 = {111,222,333,444,555,666,777,888,999};

        List<Integer> lis1 = new ArrayList(Arrays.asList(ArrayUtils.toObject(arr1)));
        List<Integer> lis2 = new ArrayList(Arrays.asList(ArrayUtils.toObject(arr2)));
        List<Integer> lis3 = new ArrayList(Arrays.asList(ArrayUtils.toObject(arr3)));

        List<Integer> lists = new ArrayList<Integer>(lis1);
        lists.addAll(lis2);
        lists.addAll(lis3);

        for (Integer i:lists)
            System.out.print(i+" ");

        List<Integer> list11 = new ArrayList<Integer>(lists.size());
        Collections.copy(lis1,list11);

        System.out.println();

        for (Integer i:list11)
            System.out.print(i+" ");
    }
}
