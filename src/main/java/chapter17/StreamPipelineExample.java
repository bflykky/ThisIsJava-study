package main.java.chapter17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        // 일반 방식
        Stream<Student> stream = list.stream();
        IntStream scoreStream = stream.mapToInt(student -> student.getScore());
        double avg = scoreStream.average().getAsDouble();

        // 메소드 체이닝 방식
        /*
        double avg = list.parallelStream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
         */

        System.out.println("평균 점수: " + avg);

        /*
         * 결론
         * 스트림을 연결해 만든 스트림 파이프라인을 이용해 여러 작업을 할 수 있다.
         *
         * 새로 배운 것들
         * 메소드 체이닝에서, 최종 처리 과정의 함수(average(), getAsDouble())가 존재하지 않으면 앞의 오리지널 스트림과 중간 처리 스트림은 ignore된다.
         * => 동작하지 않는다.
         */
    }

    static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(score, o.getScore());
        }
    }
}
