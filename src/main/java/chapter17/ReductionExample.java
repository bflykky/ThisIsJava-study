package main.java.chapter17;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("김자바", 88)
        );

        // 방법 1
        int sum1 = studentList.stream()
                .mapToInt(student -> student.getScore())
                .sum();

        // 방법 2
        int sum2 = studentList.stream()
                .map(student -> student.getScore())
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);

        /*
         * 결론
         * 기본 집계 함수 외에, reduce()라는 메소드를 스트림에서 제공한다.
         * 해당 함수에 BinaryOperator 파라미터를 전달해 커스텀 집계 메소드를 작성할 수 있다.
         * T reduce(T identity, BinaryOperator<T> accumulator)
         * identity 파라미터에 값을 넣으면, 집계할 값이 없을 경우 예외가 발생하지 않고
         * 해당 identity 값을 리턴한다.
         */
    }

    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
