package main.java.chapter17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<StreamPipelineExample.Student> studentList = new ArrayList<>();
        studentList.add(new StreamPipelineExample.Student("홍길동", 30));
        studentList.add(new StreamPipelineExample.Student("신용권", 10));
        studentList.add(new StreamPipelineExample.Student("유미선", 20));

        studentList.stream()
                .sorted()
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));

        System.out.println();
        // =================
        List<Student> studentWithoutComparableList = new ArrayList<>();
        studentWithoutComparableList.add(new Student("홍길동", 30));
        studentWithoutComparableList.add(new Student("신용권", 10));
        studentWithoutComparableList.add(new Student("유미선", 20));

        studentWithoutComparableList.stream()
                .sorted((student1, student2) -> Integer.compare(student1.getScore(), student2.getScore()))
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));

        System.out.println();

        studentWithoutComparableList.stream()
                .sorted((student1, student2) -> Integer.compare(student2.getScore(), student1.getScore()))
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));


        /*
         * 결론
         * 객체 스트림을 정렬하기 위해 sorted() 메소드를 사용할 수 있다.
         * 하지만, sorted()를 사용하려면 해당 객체가 Comparable을 implements하거나, sorted() 메소드 사용 시 비교자를 제공해야 한다.
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
            return this.name;
        }

        public int getScore() {
            return this.score;
        }
    }
}
