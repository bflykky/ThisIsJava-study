package main.java.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        // 문장 스트림을 단어 스트림으로 변환
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("I am a best developer");
        list1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        // 문자열 숫자 목록 스트림을 숫자 스트림으로 변환
        List<String> list2 = Arrays.asList("10, 20, 30, 40, 50");
        list2.stream()
                .flatMap(list -> Arrays.stream(list.split(", ")))
                .mapToInt(str -> Integer.parseInt(str))
                .forEach(number -> System.out.println(number));

        /*
         * 결론
         * 하나의 요소를 여러 개의 요소로 변환하는 flatMap() 함수도 존재한다.
         * 경험 상으로, 이중 컬렉션으로 세팅된 요소들을 '평탄화'할 때 해당 함수를 쓰기도 했다.
         */
    }
}
