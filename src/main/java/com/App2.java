package main.java.com;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by alexandr on 16.09.15.
 */
public class App2 {

    public static void main(String[] args) {
        int[]        array = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(ArrayUtils.toObject(array)));

        func(list, new MyPredicate<Integer>(){
            public boolean myEquals(Integer i){
                return i<=5;
            }
        });

        for (Integer i:list)
            System.out.print(i+" ");
    }

    public interface MyPredicate<T> {
        public boolean myEquals(T o);
    }

    public static <T> void func(Collection collection, MyPredicate<T> predicate){
        if (collection != null && predicate != null)
            for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();)
                if(!predicate.myEquals(iterator.next()))
                    iterator.remove();
    }

}
