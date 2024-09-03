package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", "남", 92));
        studentList.add(new Student("김수영", "여", 87));
        studentList.add(new Student("김자바", "남", 95));
        studentList.add(new Student("오해영", "여", 93));

        // collect() 함수를 이용해 남학생만 묶어 List 생성
        /*
        List<Student> maleList = studentList.stream()
                .filter(student -> student.getSex().equals("남"))
                .collect(Collectors.toList());
         */

        // toList() 함수를 이용해 남학생만 묶어 List 생성
        List<Student> maleList = studentList.stream()
                .filter(student -> student.getSex().equals("남"))
                .toList();

        maleList.stream()
                .forEach(student -> System.out.println(student.getName()));

        System.out.println();

        // 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> studentMap = studentList.stream()
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student.getScore()));

        System.out.println(studentMap);

        /*
         * 결론
         * collect() 함수로 중간 처리한 요소들을 하나의 컬렉션으로 변환할 수 있다.
         * collect(Collectors.toList())와 toList()는 리턴한 컬렉션의 타입에 차이가 있다.
         * collect(Collectors.toList()): 변경 가능한 ArrayList
         * toList(): 불변 List. 리턴 객체는 실행된 toList()에 따라 다르다.
         */
    }

    static class Student {
        private String name;
        private String sex;
        private int score;

        public Student(String name, String sex, int score) {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public int getScore() {
            return score;
        }
    }
}
