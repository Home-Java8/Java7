package main.java.com.bitwise_operations;

/**
 * Created by alexandr on 07.10.15.
 *
 * {@link http://www.znannya.org/?view=Java_PrimitiveTypesOp}
 * {@link https://sohabr.net/habr/post/261315/?version=107602}
 * {@link http://tproger.ru/translations/10-tricky-core-java-interview-coding}
 * ***************************************
 * Операции над примитивными типами в Java
 * Примитивные типы в Java
 * 10 интересных вопросов по Java, которые вам могут задать на собеседовании
 */
public class Main2 {

    public static void main(String[] args) {
        /*
         * Перед вызовом переменной - она должна быть проинициализированна (числом - константой)!
         * Иннициализацию можно выполнять:
         * - после объявления;
         * - во время объявления;
         * - при передаче параметров в функцию;
         * Объект класса сам выполняет неявно иннициализацию.
         *
         * Зачем нужно объявление...
         * Здесь можно провести аналогию между рыбалкой: рыбак стоит на берегу и держит удочкой; на крючке висит нажывка но в процессе рыболовли там может быть все что угодно; крючек привязан к удочке за нитку чтобы рыбак не потерять непотерял его.
         * Так вот: 'переменная' - это есть (удочка) зарезервированная область для примитивного типа внутри стековой памяти; 'константа' (число/значение) - это есть зарезервированная область для данных любого типа внутри кучи (хип-памяти); переменная связанна сылкой на константу-значение;
         * Объявления нужны только в том случае если ожидается многократный вызов и изменение состояния для значения. (в противном случае можно просто оперировать константой-данными...)
         */

        /* 1. Операция присваивания: */
        func1();

        /* 2. Унарные операции: */
        func2();

        /* 3. Арифметические бинарные операции: */
        func3();

        /* 4. Побитовые операции: */
        func4();

        /* 5. Комбинированные операции: */
        func5();

        /* 6. Операции сравнения: */
        func6();

        /*
         * 7. Булевские операции:
         * http://www.quizful.net/interview/java/java-interview
         *
         * http://ru.stackoverflow.com/questions/281650/Побитовые-операции-о-каких-из-них-полезно-знать-программистам-более-высоких
         * http://ru.stackoverflow.com/questions/100851/Зачем-нужны-побитовые-операторы-и-что-они-фактически-делают-в-Си
         */
        func7();

        /* 8. Условная операция: */
        func8();

        /* 9. Старшинство операций: */
        func9();

        /* 10. Преобразование и приведение типов при выполнении операций: */
        func10();


//        for(int i=1;;i++){
//            System.out.println(i);
//        }
    }

    static void func1(){
        int x;
        int y;
        int z;

        x = 3; // z: 3
        y = x; // y: 3
        z = x; // x: 3


        int x1;
        int x2;
        int x3;

        x1 = x2 = x3 = 0; // x1: 0  x2: 0  x3: 0
    }

    static void func2(){
        int i = -3, j, k, b, x = 1, y, z;

        j = -i;  // j: -3             унарный оператор "-" миняет знак числа на противоположный
        b = ~i;  // b: 2              унарный оператор "~" миняет знак числа на противоположный и отнимает от значения единицу
        k = +i;  //                   унарный оператор "+" ничего неделает
//        b = -~i;  // b: -2  i: -3
        y = ++x; //                   префиксный унарный оператор "++"/"--" прибавляет/убавляет от значения единицу и сохраняет значение в эту-же переменную
        z = x++; //                   постфиксный унарный оператор "++"/"--" (просто) прибавляет/убавляет от значения единицу

//        System.out.println("i: "+i+"  j: "+j+"  k: "+k+"  b: "+b+"  x: "+x+"  y: "+y+"  z: "+z);
    }

    static void func3(){
        int a = 5 + 2; // бинарный (арифметических) оператор сложение "+"
        int b = 5 - 2; // бинарный (арифметических) оператор вычитание "-"
        int c = 5 * 2; // бинарный (арифметических) оператор умножение "*"
        int d = 5 / 2; // бинарный (арифметических) оператор деление "/"
        int e = 5 % 2; // бинарный (арифметических) оператор остаток от деления целых чисел "%"

        System.out.println("a: "+a+"  b: "+b+"  c: "+c+"  d: "+d+"  e: "+e);
    }

    static void func4(){
        int x = 112; // x: 00000000 00000000 00000000 01110000
        int y = 94;  // y: 00000000 00000000 00000000 01011110
        int z;

        z = x & y;   // z=80: 00000000 00000000 00000000 01010000          // бинарный (арифметических) оператор 'побитовое И'
        z = x | y;   // z=126: 00000000 00000000 00000000 01111110         // бинарный (арифметических) оператор 'побитовое ИЛИ'
        z = x ^ y;   // z=46: 00000000 00000000 00000000 00101110          // бинарный (арифметических) оператор 'побитовое исключающее ИЛИ'
        z = x << 2;  // z=448: 00000000 00000000 00000000 01111100         // бинарный (арифметических) оператор 'сдвиг влево с учетом знака'
        z = x >> 2;  // z=28: 11111111 11111111 11111111 11111011          // бинарный (арифметических) оператор 'сдвиг вправо с учетом знака'
        x = -17;
        z = x >>> 2; // z=1073741819: 00111111 11111111 11111111 11111011  // бинарный (арифметических) оператор 'сдвиг вправо без учета знака'

//        System.out.println("z: "+z);
    }

    static void func5(){
        int x = 5, b = 2;

        x += b;   // x: 7   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x + b
        x -= b;   // x: 5   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x - b
        x *= b;   // x: 10  // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x * b
        x /= b;   // x: 5   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x / b
        x %= b;   // x: 1   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x % b
        x &= b;   // x: 0   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x & b
        x |= b;   // x: 2   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x | b
        x ^= b;   // x: 3   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x ^ b
        x <<= b;  // x: 0   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x << b
        x >>= b;  // x: 0   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x >> b
        x >>>= b; // x: 0   // комбинированные (составные) знаки операций для бинарных арифметических операций, означает x = x >>> b
    }

    static void func6(){
        /*
         *  В Java определены следующие операции сравнения:
         *  "==" (равно), "!=" (не равно);
         *  ">" (больше), ">=" (больше или равно);
         *  "<" (меньше), "<=" (меньше или равно);
         */
        boolean isEqual, isNonEqual, isGreater, isGreaterOrEqual, isLess, isLessOrEqual;
        int x1 = 5, x2 = 5, x3 = 3;

        isEqual          = x1 == x2; // операции сравнения (равно), isEqual: true
        isNonEqual       = x1 != x2; // операции сравнения (не равно), isNonEqual: false
        isGreater        = x1 > x3;  // операции сравнения (больше), isGreater: true
        isGreaterOrEqual = x2 >= x3; // операции сравнения (больше или равно), isGreaterOrEqual: true
        isLess           = x3 < x1;  // операции сравнения (меньше), isLess: true
        isLessOrEqual    = x1 <= x3; // операции сравнения (меньше или равно), isLessOrEqual: false
    }

    static void func7(){
        /*
         * Булевские операции выполняются над булевскими переменными и их результатом также является значение типа boolean.
         * "!"              (отрицание - замена false на true, или наоборот)
         * "&"              (операция 'И')
         * "|"              (операция 'ИЛИ')
         * "^"              (операция 'исключающее ИЛИ')
         * "&=", "|=", "^=" (операции можно также как и соответствующие побитовые операции использовать в составных операциях присваивания)
         * "==", "!="       (к булевским операндам применимы операции 'равно' и 'не равно')
         * "&&", "||"       (операция укороченное 'И' и операция укороченное 'ИЛИ' - при использовании этих операций второй операнд вообще не будет вычисляться, что полезно в тех случаях, когда правильное функционирование правого операнда зависит от того, имеет ли левый операнд значение true или false)
         */
        boolean isInRange, isValid, isNotValid, isEqual, isNotEqual;
        int x = 8;

        isInRange  = x > 0 && x < 5;       // булевская операция укороченное 'И', isInRange: false
        isValid    = x > 0 || x > 5;       // булевская операция укороченное 'ИЛИ', isValid: true
        isNotValid = !isValid;             // булевская операция 'отрицание', isNotValid: false
        isEqual    = isInRange == isValid; // булевская операция 'равно', isEqual: false
        isNotEqual = isInRange != isValid; // булевская операция 'не равно', isNotEqual: true
    }

    static void func8(){
        /*
         * Условная операция записывается в форме 'выражение-1 ? выражение-2 : выражение-3'
         * При этом сначала вычисляется выражение выражение-1, которое должно дать булевское значение, а затем, если выражение-1 имеет значение true, тогда вычисляется и возвращается выражение-2, либо (если выражение-1 имеет значение false) вычисляется и возвращается выражение-3
         */
        int n = 2, x;

        x = n>1 ? 0 : 1;
    }

    static void func9(){
        /*
         * Операции в выражениях выполняются слева направо, в соответствии со своим приоритетом
         * Круглые скобки повышают старшинство операций, которые находятся внутри них.
         */
    }

    static void func10(){
        /*
         * При выполнении операции присваивания преобразование типов происходит автоматически если происходит расширяющее преобразование для совместимых типов.
         * Для расширяющих преобразований с числовыми типами являются преобразования: byte >> short >> int >> long >> float >> double
         *
         * (однако 'числовые' типы не совместимы с типами 'char' и 'boolean'. Типы 'char' и 'boolean' не совместимы также и друг с другом)
         * Если преобразование является сужающим - такое преобразование может привести к потере точности числа или к его искажению: byte >> short << char >> int >> long >> float >> double
         */

        /* При преобразовании целых или вещественных чисел в данные типа char, преобразование в символ происходит, если исходное число лежит в диапазоне от 0 до 127, иначе символ получает значение '?' */
        byte x1 = 71;        // x1: 71
        char c1 = (char) x1; // c1: 'G' 71
        int i2 = 327;        // i2: 127
        char c2 = (char) i2; // c2: 'G' 71

        double d = 77.85;   // d: 77.85
        int    i = (int) d; // i: 77

//        System.out.println("x1: "+x1+"  c1: "+c1+"  i2: "+i2+"  c2: "+c2+"  d: "+d+"  i: "+i);

        /*
         * При выполнении арифметических и побитовых преобразований все значения byte и short, а также char расширяются до int, (при этом в вычислениях для char используется числовое значение кода символа) затем, если хотя бы один операнд имеет тип long, тип целого выражения расширяется до long. Если один из операндов имеет тип float, то тип полного вы­ражения расширяется до float, а если один из операндов имеет тип double, то тип результата будет double
         * (автоматические расширения типов, особенно расширения short и byte до int, могут вызывать плохо распознаваемые ошибки во время компиляции)
         *  Перед выполнением умножения значение переменных x и y будет расширено до int, а затем при выполнении попытки присвоения результата вычисления типа int переменной типа byte - будет ошибка на уровне компиляции
         */
//        byte a = 1, c = 2;
//        short b = 3;
//        a + b * c – 15L + 1.5F + 1.08 - 10; // Таким образом, результат вычисления выражения будет иметь тип double
        byte x = 30, y = 5;
//        x = x + y;        // при выполнении попытки присвоения результата вычисления типа int переменной типа byte - будет ошибка на уровне компиляции
        x = (byte) (x + y); // чтобы этого избежать надо использовать во втором операторе явное преобразование типов
    }
}
