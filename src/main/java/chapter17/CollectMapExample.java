package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectMapExample {
    public static void main(String[] args) {
        List<CollectExample.Student> studentList = new ArrayList<>();
        studentList.add(new CollectExample.Student("홍길동", "남", 92));
        studentList.add(new CollectExample.Student("김수영", "여", 87));
        studentList.add(new CollectExample.Student("김자바", "남", 95));
        studentList.add(new CollectExample.Student("오해영", "여", 93));

        Map<String, List<CollectExample.Student>> map = studentList.stream()
                .collect(
                        Collectors.groupingBy(s -> s.getSex()) // 그룹핑 키 리턴
                );

        List<CollectExample.Student> maleList = map.get("남");
        maleList.stream().forEach(student -> System.out.println(student.getName()));

        System.out.println();

        List<CollectExample.Student> femaleList = map.get("여");
        femaleList.stream().forEach(student -> System.out.println(student.getName()));

        Map<String, Double> avgScoreMap = studentList.stream()
                .collect(
                        Collectors.groupingBy(
                                student -> student.getSex(),
                                Collectors.averagingDouble(student -> student.getScore())
                        )
                );

        System.out.println(avgScoreMap);

        /*
         * 결론
         * collect(Collectors.groupingBy()) 메소드로, 해당 스트림에 대해서 특정 값을 뽑아 해당 값을 키로 이용하여
         * 그룹핑하여 Map 컬렉션을 만들 수 있다.
         * 위 코드에선, getSex()로 얻은 "남", "여" 2개의 값을 키로 사용한 후, 해당 키로 요소들을 매핑해 남자 2명 List 1개, 여자 2명 List 1개를 만들어
         * size가 2인 Map을 리턴하였다.
         *
         * groupingBy() 메소드에 Function 1개만 들어가면 요소들을 모은 List<>가 Map의 값이 되지만,
         * 2번째 파라미터로 Collectors 클래스에서 제공하는 매핑, 집계를 수행하기 위한 정적 메소드를 사용하면
         * 해당 메소드의 리턴 값이 Map의 값으로 설정된다.
         */
    }
}
