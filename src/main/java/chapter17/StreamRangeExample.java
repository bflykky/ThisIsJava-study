package main.java.chapter17;

import java.util.stream.IntStream;

public class StreamRangeExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10);
        IntStream closedIntStream = IntStream.rangeClosed(1, 10);

        System.out.println("====IntStream.range(1, 10)에 대한 스트림 처리====");
        intStream.forEach(num -> System.out.println(num));

        System.out.println("====IntStream.rangeClosed(1, 10)에 대한 스트림 처리====");
        closedIntStream.forEach(num -> System.out.println(num));

        /*
         * 결론
         * range(), rangeClosed() 함수를 통해, 첫 번째 파라미터 ~ 두 번째 파라미터 사이의
         * 정수 범위의 정수 스트림 객체를 얻을 수 있다.
         *
         * ex) IntStream.range(1, 10) => 1, 2, 3, 4, 5, 6, 7, 8, 9를 요소로 가지는 스트림 객체
         * ex) IntStream.rangeClosed(1, 10) => 1, 2, 3, 4, 5, 6, 7, 8, 9, 10을 요소로 가지는 스트림 객체
         *
         * range()와 rangeClosed()의 차이는 파라미터 해석에 있다.
         * 둘 다 첫 번째 파라미터의 값부터 요소로 담지만, 두 번째 파라미터를 담을지 안담을지에 차이가 있다.
         * range(int startInclusive, int endExclusive) => 첫 번째 파라미터부터 (두 번째 파라미터 - 1)까지 담는다.
         * range(int startInclusive, int endInclusive) => 첫 번째 파라미터부터 두 번째 파라미터까지 담는다.
         */
    }
}
