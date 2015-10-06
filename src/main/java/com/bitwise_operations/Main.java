package main.java.com.bitwise_operations;

/**
 * Created by Саша on 06.10.2015.
 *
 * {@link http://www.znannya.org/?view=Java_PrimitiveTypesOp}
 *
 * http://www.znannya.org/?view=Java_PrimitiveTypesOp
 * http://habrahabr.ru/post/187606/
 * http://wizardjava.com/java/java-voprosy-na-sobesedovanii-i-otvety-chast-1
 *
 */
public class Main {

    public static void main(String[] args) {
        /* Операция присваивания */
        int x;
        int y;
        int z;
        int x1;
        int y1;
        int z1;

        x = 3; y = x; z = x; // z: 3  y: 3  x: 3
        x1 = y1 = z1 = 0;    // x1: 0  y1: 0  z1: 0

        /* Унарные операции */
        int i = 3,j,k;   // k: 3  i: 3  j: -3
        j = -i;          // j: -3
        k = +i;          // k: 3  i: 3

        int a = 15;      // a: 15
        int b;
        b = ~a;          // a: 15  b: -16

        int x2 = 1,y2,z2; // x2: 3  z2: 2  y2: 2
        y2 = ++x2;        // y2: 2
        z2 = x2++;        // x2: 3  z2: 2

        /* Арифметические бинарные операции */
        int x_0 = 7,x_1,x_2,x_3,x_4,x_5;
        x_1 = x_0 + 10;                  // x_1: 17
        x_2 = x_0 - 8;                   // x_2: -1
        x_3 = x_2 * x_0;                 // x_3: -7
        x_4 = x_0 / 4;                   // x_4: 1 (при делении целых чисел дробная часть отбрасывается)
        x_5 = x_0 % 4;                   // x_5: 3 (остаток от деления 7 на 4)

        /* Побитовые операции */
        int x__0 = 112; // x__0: 00000000 00000000 00000000 01110000
        int y__0 = 94;  // y__0: 00000000 00000000 00000000 01011110
        int z__0;
        z__0 = x__0 & y__0; // z__0=80: 00000000 00000000 00000000 01010000

        return;
    }
}
