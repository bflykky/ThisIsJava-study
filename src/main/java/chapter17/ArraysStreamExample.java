package main.java.chapter17;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysStreamExample {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김자바"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(str -> System.out.print(str + ", "));
        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(num -> System.out.print(num + ", "));
        System.out.println();


        /*
         * 결론
         * Arrays.stream(T[] array) 함수를 통해 특정 타입의 스트림이나,
         * int, long, double 타입 요소를 처리하는 스트림을 얻을 수 있다.
         */
    }
}
