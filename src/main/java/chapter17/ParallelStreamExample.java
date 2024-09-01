package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("김자바");
        list.add("박병렬");

        // 병렬 처리 스트림을 사용하는 경우
        System.out.println("========병렬 처리 stream 객체를 사용하는 경우========");
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(name -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        });

        System.out.println();

        // 일반 스트림을 사용하는 경우
        System.out.println("========일반 stream 객체를 사용하는 경우========");
        Stream<String> stream = list.stream();
        stream.forEach(name -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        });


        /*
         * 결론
         *
         * stream(), parallelStream() 사용 시 반환되는 객체 비교
         * 2개의 메소드 모두 스트림 파이프라인에서 데이터를 제공하는 단계를 담당하는 객체인, Head 객체를 얻는다.
         * (정확히는 ReferencePipeline을 상속하는 Head 객체. 디버깅 시 value는 ReferencePipeline$Head 이다.)
         * 두 함수 모두 같은 객체를 리턴하지만, 그 중 parallel 필드의 값은parallelStream() 사용 시 true로,
         * stream() 사용 시 false로 설정되어 객체가 리턴된다.
         *
         * forEach()문으로 실행 시 출력되는 결과 비교
         * parallelStream()을 사용한 경우 출력 결과가 뒤죽박죽이며, 각 메소드를 실행하는
         * 스레드도 4개였다.
         * 반면, steram()을 사용한 경우 출력 결과가 list의 요소 순서와 동일하며, 모두 main 스레드 하나로 실행되었다.
         */
    }
}
