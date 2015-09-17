package test.java.com;

import java.util.*;

/**
 * @author Lazarchuk
 * @version 1.0
 * @date 17/09/2015
 * {@link http://info.javarush.ru/translation/2014/06/14/Как-правильно-делать-сортировку-в-Java.html}
 * **************************************
 * Как правильно делать сортировку в Java
 */
public class ListTest {

    public static void main(String[] args) {
        func1();
    }

    public static void func1(){
        User[] arr1 = {new User("Vasya",1),new User("Petya",2),new User("Roma",3),new User("Sasha",4),new User("Dima",5),new User("Lesha",4),new User("Vladislav",4),new User("Philip",3)};
        User[] arr2 = {new User("Dasha",4),new User("Nyusha",5),new User("Lisa",6),new User("Olya",7),new User("Lesha",6),new User("Veronika",5),new User("Katya",4),new User("Ira",3)};

        List<User> list = new ArrayList(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));

        for (User u:list)
            System.out.print(u+"; ");

        System.out.println();

        Collections.sort(list, new Comparator<User>(){
            @Override
            public int compare(User u1, User u2){
                return u1.toString().compareTo(u2.toString());
            }
        });

        for (User u:list)
            System.out.print(u+" ");
    }

}


class User {
    public User(){}
    public User(String name, int ago){
        this.name = name;
        this.ago  = ago;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAgo(int ago){
        this.ago = ago;
    }
    public String getName(){
        return name;
    }
    public int getAgo(){
        return ago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public String toString(){
        return name+" ("+ago+")";
    }

    private String name;
    private int ago;
}

class UserKey  {}