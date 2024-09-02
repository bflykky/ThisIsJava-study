package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> emptyList = new ArrayList<>();

        // NoSuchElementException 예외 발생하는 경우
        /*
        double avg = emptyList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
         */

        // 방법 1
        OptionalDouble optional = emptyList.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: " + 0.0);
        }

        // 방법 2
        double average = emptyList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2_평균: " + average);

        // 방법 3
        emptyList.stream()
                .mapToInt(num -> num.intValue())
                .average()
                .ifPresent(avg -> System.out.println("방법3_평균: " + avg));

        /*
         * 결론
         * Optional 클래스의 메소드들을 통해 스트림이 비어 있어 최종 처리 메소드의 리턴값이 Optional.empty일 때도
         * 예외 없이 처리할 수 있다.
         */
    }
}
