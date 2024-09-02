package main.java.chapter17;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        // peek()은 최종 처리 메소드가 없으면 동작하지 않는다.
        Arrays.stream(intArr)
                .peek(num -> System.out.println(num));

        // 중간 처리 메소드 peek()을 이용해 반복 처리
        int total = Arrays.stream(intArr)
                .filter(num -> num % 2 == 0)
                .peek(num -> System.out.println(num))
                .sum();
        System.out.println("총합: " + total + "\n");

        // 최종 처리 메소드 forEach()를 이용해 반복 처리
        Arrays.stream(intArr)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.println(num));

        /*
         * 결론
         * 반복 처리하는 메소드는 peek(), forEach() 2개의 메소드가 있다.
         * peek()는 중간 처리 메소드로 리턴값이 Stream이고,
         * forEach()는 최종 처리 메소드로 리턴값이 void이다.
         */
    }
}
