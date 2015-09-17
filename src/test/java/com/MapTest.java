package test.java.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandr on 17.09.15.
 */
public class MapTest {

    public static void main(String[] args) {
        func1();
    }

    public static void func1() {
        User[] arr1 = {new User("Vasya", 1), new User("Petya", 2), new User("Roma", 3), new User("Sasha", 4), new User("Dima", 5), new User("Lesha", 4), new User("Vladislav", 4), new User("Philip", 3)};
        User[] arr2 = {new User("Dasha", 4), new User("Nyusha", 5), new User("Lisa", 6), new User("Olya", 7), new User("Lesha", 6), new User("Veronika", 5), new User("Katya", 4), new User("Ira", 3)};

        Map<String,User> map = new HashMap<String,User>();
        map.put("vasya",arr1[0]);
        map.put("petya",arr1[1]);
        map.put("roma",arr1[2]);

        System.out.println(map);
    }

}
