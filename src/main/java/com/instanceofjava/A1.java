package main.java.com.instanceofjava;

/**
 * Created by Саша on 06.10.2015.
 */
public class A1 {

    static int a = 1111;

    static {
//        a = --a - a--; // 0
//        a = --a - --a; // 1
//        a = a-- - --a; // 2
//        a = a++ + ++a; // 2224
    }

//    {
//        a = a++ + ++a;
//    }

    /**
     * Существует стандартная форма записи выражения:
     * a = 1;
     * b = 2;
     * c = a + b;
     *
     * @param args
     */
    public static void main(String[] args)  {
//        int c = 100;
//        System.out.println((c--)); // сперва вернет состояние 'c', а потом после выхода их выражеия выполнится операция '--'
//        System.out.println((--c)); // сперва выполнит операцию '--', а потом вернет состояние 'c'

//        System.out.println(a);
        System.out.println( (a--) + " (" + a + ") " + " | " + (--a) + " | " + (a-- - --a) );
//        int a1 = 1111;
//        System.out.println( (a--) + " (" + a + ") " + " | " + (--a) + " | " + (a1-- - --a1) );

        int b = 1111;
        System.out.println( (b=-b) + " (" + b + ") " + " | " + (b-=b) + " (" + b + ") " );
        int c = 3;
        System.out.println( (c*=c) + " (" + c + ") " );
    }
}
