package main.java.com.algorithm;

/**
 * Created by Саша on 06.10.2015.
 * {@link http://tproger.ru/translations/sorting-for-beginners/#more-8619}
 * *******************************************************
 * Алгоритмы и структуры данных для начинающих: сортировка
 */
public class Algorithm {

    public static void main(String[] args) {
        Integer[] items = {9,0,1,2,6,7,8,3,4,5};
        int left = 2;
        int right = 8;

//        for (Integer item:swap(items,left,right))
//            System.out.print(item + " ");
    }

//    public static <T> T[] swap(T[] items, int left, int right) {
//        if (left != right) {
//            T       temp = items[left];
//             items[left] = items[right];
//            items[right] = temp;
//        }
//        return items;
//    }
    public static <T> void swap(T[] items, int left, int right) {
        if (left != right) {
            T       temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }

//    public <T> void sort(T[] items) {
//        boolean swapped;
//        do {
//            swapped = false;
//            for (int i = 1; i < items.length; i++) {
//                if (items[i-1].compareTo(items[i]) < 0) {
//                    sort(items, i-1, i);
//                    swapped = true;
//                }
//            }
//        } while (swapped != false);
//    }
}
