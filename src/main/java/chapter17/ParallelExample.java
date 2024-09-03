package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            scoreList.add(random.nextInt(101));
        }

        double avg = 0.0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;

        Stream<Integer> stream = scoreList.stream();
        startTime = System.nanoTime();
        avg = stream
                .mapToInt(num -> num.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.printf("avg: %f, 일반 스트림 처리 시간: %d ns or %d microSeconds or %d ms\n", avg, time, time / 1000, time / 1000 / 1000);

        System.out.println("================");

        Stream<Integer> parallelStream = scoreList.parallelStream();
        startTime = System.nanoTime();
        avg = parallelStream
                .mapToInt(num -> num.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.printf("avg: %f, 병렬 스트림 처리 시간: %d ns or %d microSeconds or %d ms\n", avg, time, time / 1000, time / 1000 / 1000);

        /*
         * 결론
         * 병렬 처리 스트림을 사용할 경우, 내부의 포크조인 프레임워크를 이용하기 때문에 작업 속도의 단축을 이끌어낼 수 있다.
         * 또한, 개발자가 직접 병렬 처리를 위한 코드를 작성하는 번거로움이 없어 작성하기도 편하다.
         *
         * 하지만, 병렬 처리 스트림이 일반 순차 처리 스트림보다 무조건 빠른 건 아니다.
         * 다음과 같은 3가지 경우를 잘 살펴보고 사용하자.
         *
         * 1. 요소의 수와 요소 당 처리 시간이 병렬 처리를 할 만큼 큰가?
         * 요소의 수가 적거나, 요소 당 처리 시간이 짧으면 일반 스트림이 더 빠를 수 있다.
         * 병렬 처리 스트림은 포크 조인 단계가 필요하고, 스레드 풀을 생성하는 추가적인 비용이 발생하기 때문이다.
         *
         * 2. 스트림 소스의 종류가 List 또는 배열이 맞는가?
         * List나 배열은 인덱스로 요소를 관리하므로 요소 분리가 쉽게 되어 병렬 처리 시간이 절약된다.
         * 반면에, HastSet, TreeSet은 요소 분리가 쉽지 않고, LinkedList의 경우 모든 노드를 지나며 요소를 찾아야 하므로
         * 요소 분리가 쉽지 않다. 이로 인해 해당 컬렉션의 경우 병렬 처리의 작업 속도가 늦다.
         *
         * 3. 코어의 수가 병렬 처리를 할 만큼 많은가?
         * CPU 코어의 수와 병렬 스트림의 성능은 비례한다. 즉, 코어의 수가 적을 경우에는 일반 스트림이 빠를 수 있다.
         * 적은 코어 개수를 가질 때, 병렬 스트림을 사용할 경우 스레드의 수만 많아져 동시성이 증가해 오히려 작업 속도가 감수할 수 있다.
         *
         */
    }
}
