package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("김자바");
        list.add("신용권");
        list.add("신민철");

        // 중복 요소 제거
        list.stream()
                .distinct()
                .forEach(str -> System.out.println(str));
        System.out.println();

        // 신으로 시작하는 문자열만 필터링
        list.stream()
                .filter(str -> str.startsWith("신"))
                .forEach(str -> System.out.println(str));
        System.out.println();

        // 중복 요소 제거 후, 신으로 시작하는 문자열만 필터링
        list.stream()
                .distinct()
                .filter(str -> str.startsWith("신"))
                .forEach(str -> System.out.println(str));


        /*
         * 결론
         * 필터링을 하는 중간처리 메소드에는 2가지가 있다.
         * distinct(): 중복되는 요소를 제거한다. 처리하는 요소가 객체라면 equals() 메소드를 이용한다.
         * filter(): 파라미터로 전달된 Predicate에 따라 필터링하여 true인 요소만 남긴다.
         */
    }
}
