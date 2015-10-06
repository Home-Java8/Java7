package main.java.com.instanceofjava;

/**
 * Created by Саша on 06.10.2015.
 */
public class A2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);
        c += 3;
        System.out.println(c);
//        c =+ 3;
        c +=+ 3;
        System.out.println(c);

        System.out.println();
        int c1 = 5;
        c1 += 3; // 8
        c1 =+ 3; // 3
        c1 +=+ 4; // 7
        System.out.println(c1);
    }

}
