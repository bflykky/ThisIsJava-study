package main.java.chapter17;

import java.util.Arrays;

public class MatchingExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        boolean result = Arrays.stream(intArr)
                .allMatch(num -> num % 2 == 0);
        System.out.println("intArr의 요소가 모두 2의 배수인가?: " + result);

        result = Arrays.stream(intArr)
                .anyMatch(num -> num % 3 == 0);
        System.out.println("intArr의 요소 중 3의 배수인 요소가 존재하는가?: " + result);

        result = Arrays.stream(intArr)
                .noneMatch(num -> num % 3 == 0);
        System.out.println("intArr의 요소 중 3의 배수인 요소가 존재하지 않는가?: " + result);

        /*
         * 결론
         * 최종 처리 메소드인 allMatch(), anyMatch, noneMatch() 3개를 통해 특정 조건을 요소들이 만족하는지 여부를
         * 검사할 수 있다. 리턴값은 모두 boolean이다.
         *
         * allMatch(): 스트림의 모든 요소들이 조건을 만족하는지 리턴
         * anyMatch(): 스트림의 요소들 중 하나라도 조건을 만족하는지 리턴
         * noneMatch(): 스트림의 모든 요소들이 조건을 만족하지 않는지 리턴
         */
    }
}
