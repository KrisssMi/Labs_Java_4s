package by.belstu.it.Minevich;

import java.util.Arrays;

import static java.lang.Math.*;

/* @author Kristina Minevich POIT 4-1
 * @version 1.1.0 */

public class JavaTest {
    public static double rnd(int min, double max)   //Функция генерации рандомного числа
    {
        max -= min;
        return (double) (Math.random() * max) + min;
    }
    public static void main(String[] args) {

        //TODO Задание №1 (b):
        /*Определить переменные типа char, int, short, byte, long, boolean*/
        char var1='a';
        int var2=2;
        short var3=3;
        byte var4=4;
        long var5= 123456789L;
        boolean var6=true;
        double var7=23.56;
        String m="Hey";
        System.out.println("\n\n"+m+var2);
        System.out.println(m+var1);
        System.out.println(m+var7);
        System.out.println(var4 = (byte) (var4+var2));
        System.out.println(var2= (int) (var7+var5));
        System.out.println(var5=(long)(var2+2147483647)); // положительное значение
        if (var5>0) {
            System.out.println(var5);
        } else System.out.println("Значение переменной отрицательное.");
        /* int sint = 0;
        System.out.println(sint);*/     //значение без инициализации
        boolean var8= false;
        boolean var9=var6 && var8;      //или
        System.out.println(var9);

        boolean var10=var6^var8;        //исключающее или
        System.out.println(var10);

        //boolean var11=var6+var8;              //нельзя
        long lon3 = 9223372036854775807l;       //для такого числа подходит Long от -9223372036854775808 до 9223372036854775807
        //double var12=0x7fff_ffff_fff;         //слишком длинное число

        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        //TODO !!! Целые константы можно записывать лишь в 2, в 10 и в 16 системах счислениях




        //TODO Задание №2 (c):
        /*Задайте две константы в классе*/
        final int var13=45;
        final int var14=85;
        //public static final int var15=35;
        System.out.println("\n\nCONST_1: " + var13 + "; CONST_2: " + var14);
        // static можно менять и она применяется, когда переменная не зависит от объекта.
        // final же не изменяется и для каждого объекта может быть своим




        //TODO Задание №3 (d):
        /*Работа с библиотекой Math*/
        System.out.println("\n\nMath.PI = " + PI);
        System.out.println("Exp = " + E);
        System.out.println("Округление Math.PI = " + round(PI));
        System.out.println("Округление Exp = " + round(E));
        System.out.println("Минимальное число из Math.PI и Exp = " + min(PI, E));
        final int min = 0;
        final double max = 1.0;

        final double rnd = rnd(min, max);
        System.out.println("Cлучайное целое число из диапазона [0,1): " + rnd);





        //TODO Задание №4 (e):
        /*Создание объектов разных классов оболочек (Boolean, Character, Integer, Byte, Short, Long, Double)*/
        //Упаковка
        Boolean objbool = true;
        Character objchar = 'd';
        Integer objint1 = 19;
        Integer objint2 = 11;
        Byte objbyte=25;
        Short objshort = 873;
        Long longvar =938478L;
        Double doubvar=45.324;
        String str2 = "12345";

        System.out.println("\n\n"+objbool);
        System.out.println("Integer_1+Integer_2 = "+objint1+objint2);
        System.out.println("Long+Short = "+objshort+longvar);
        System.out.println("Максимальное значение типа Long"+Long.MAX_VALUE); //максимальное значение типа Long
        System.out.println("Минимальное значение типа Long"+Long.MIN_VALUE); //минимальное значение типа Long

        //Распаковка
        int ival = objint1.intValue();
        byte bval = objbyte.byteValue();

        System.out.println(Integer.parseInt(str2));
        System.out.println(Integer.toHexString(ival));
        System.out.println(Integer.toString(ival));
        System.out.println(Integer.bitCount(ival));
        //isNaN отсутствует
        System.out.println("compare(1,100) = "+Integer.compare(1, 100));  //1<100
        System.out.println("compare(11,11) = "+Integer.compare(11, 11));  //11=11





        //TODO Задание №5 (f):
        /*Преобразование числа типа String*/
        String s34 = "2345";
        //int s1;      // с помощью конструктора
        //s1 = new Integer(s34);
        int s2 = Integer.valueOf(s34);  // c помощью valueOf
        int s3 = Integer.parseInt(s34); // c помощью parseInt
        //System.out.println("\n\n"+s1);
        System.out.println(s2);
        System.out.println(s3);

        /*переводите строку в массив байтов и обратно из массива байтов в строку*/
        byte[] byteArray = s34.getBytes();
        System.out.println("Строку в массив байт : " + Arrays.toString(byteArray));
        // конвертируем байты в строку
        String byteStr = new String(byteArray);
        System.out.println("Байты в строку : " + byteStr);

        String fromArray = new String(byteArray);
        boolean boolean1 = Boolean.parseBoolean(s34);   //преобразование данной строки в ее логическое значение
        boolean boolean2 = Boolean.valueOf(s34);        //возвращает примитивное значение объекта Boolean
        System.out.println(boolean1);
        System.out.println(boolean2);

        String s35 = "2345";
        System.out.println("Проверка оператора == : "+ (s34 == s35));               //Оператор == сравнивает ссылки (быстрее)
        System.out.println("Проверка метода equals : "+s34.equals(s35));            //Метод equals сравнивает значения (медленнее)
        System.out.println("Проверка метода compareTo : "+s34.compareTo(s35));      //Метод compare проверяет строки на равенство

        String s36 = null;
        System.out.println("Проверка оператора == : "+ (s36 == s35));
        //System.out.println("Проверка метода equals : "+s36.equals(s35));
        //System.out.println(s36.compareTo(s35));

        /*функции для работы со строками:*/
        String str = "Моя новая строка для функций!\n";
        System.out.println("\nsplit -- ");
        for (String strEx : str.split(" ")) {
            System.out.print(strEx);
        }
        System.out.println("contains(к) -- " + str.contains("к"));
        System.out.println("hashcode -- " + str.hashCode());
        System.out.println("indexOf(н) -- " + str.indexOf('н'));
        System.out.println("length -- " + str.length());
        System.out.println("replace(М,м) -- " + str.replace('М','м'));





        //TODO Задание №6 (g):
        /*Проверьте какая из форм объявлений многомерного массива допустима*/
        char[][] c1;
        char[] c2[];
        char c3[][];

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        c2 = new char[][]{{'1', '2'}, {'3', '4'}};
        c3 = new char[][]{{'a', 'b'}, {'c', 'd'}};

        System.out.println("Length для Str1: " +c1[0].length);
        System.out.println("Length для Str2: " +c1[1].length);
        System.out.println("Length для Str3: " +c1[2].length);
        for (var strAr : c3) {          //вывод двумерного массива c3
            for(var item : strAr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        boolean comRez = c2 == c3;
        System.out.println(comRez);

        //TODO Можно ли определить массив нулевой длины?
        /*В Java Можно создавать и использовать массивы нулевой длины (пустой массив). Например: boolean[] bits = new boolean[0];
         * Пустой массив принято использовать в тех местах программы, где заранее неизвестно, будут элементы или нет.
         * Если элементы будут, то возвращается непустой массив, если элементов нет - пустой массив.*/

        //TODO Что случится, если индекс массива превысит его длину?
        /*Будет ошибка*/




        //TODO Задание №7 (h):
        /*Создайте класс WrapperString c приватным полем типа String*/
        WrapperString obj1=new WrapperString("String");
        WrapperString obj2=new WrapperString("Delete");
        System.out.println("\n\n1. Первоначальная строка"+obj1);                        //первоначальная строка

        obj1.replace('t','p');
        System.out.println("2. Итог функции Replace: "+obj1);      //конечная строка

        obj2.delete('e');
        System.out.println("3. Итог функции Delete: "+obj2);
    }
}
