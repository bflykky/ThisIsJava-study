package main.java.chapter17;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        // 정수 배열
        int[] arr = {1, 2, 3, 4, 5};

        // 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        // 총합
        long sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        // 평균
        double avg = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        // 최댓값
        int max = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .max()
                .getAsInt();
        System.out.println("2의 배수 중 최댓값: " + max);

        // 최솟값
        int min = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("2의 배수 중 최솟값: " + min);

        // 첫번 째 요소
        int first = Arrays.stream(arr)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);

        /*
         * 결론
         * 스트림에서 제공하는 최종 처리를 위한 집계 메소드들이 있다.
         * count(): 개수
         * sum(): 합
         * average(): 평균 (double 타입)
         * max(): 최댓값
         * min(): 최솟값
         * findFirst(): 가장 첫 번째 요소
         */
    }
}
