package main.java.chapter17;

import main.java.chapter17.StreamPipelineExample.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 10));
        studentList.add(new Student("신용권", 20));
        studentList.add(new Student("유미선", 30));

        studentList.stream()
                .mapToInt(student -> student.getScore())
                .forEach(score -> System.out.println(score));

        System.out.println();

        studentList.stream()
                .map(student -> student.getScore())
                .forEach(score -> System.out.println(score));

        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()
                .forEach(num -> System.out.println(num));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));

        /*
         * 결론
         * mapToInt()를 사용 시 IntStream이 리턴되고, map()을 사용 시 Stream<Integer>가 리턴된다.
         *
         * 스트림은 한 번만 '소비'될 수 있기 때문에, forEach()와 같은 최종 처리를 했을 경우
         * 해당 스트림을 다시 사용할 수 없다.
         * => 다시 사용할 경우 IllegalStateException 예외 발생. "stream has already been opreated upon or closed"
         * 위와 같이 스트림이 이미 수행되었다는 에러 메시지가 출력된다.
         */
    }

}
