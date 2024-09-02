package main.java.chapter17;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(FileStreamExample.class.getResource("data.txt").toURI());
        Stream<String> stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(line -> System.out.println(line));
        stream.close();

        /*
         * Path 인터페이스, Paths 클래스의 경우 java.nio 패키지의 하위 파일들이다.
         * nio 패키지의 경우, Java 4부터 새로운 입출력, new Input/Output이라는 뜻으로 등장하였다.
         * Java 7에서는 io와 nio 패키지 간의 일관성 없는 클래스 설계를 수정하고,
         * 이것저것 향상시켜 nio2 라 불리는 새로운 파일시스템 API도 추가되었다.
         *
         * io와 nio 패키지의 차이를 몇개 보고 가자.
         * 좌: io, 우: nio
         * 입출력 방식: 스트림, 버퍼
         * 버퍼 방식: 넌버퍼, 버퍼
         * 비동기 지원: X, O
         * 블로킹/논블로킹 방식: 블로킹만 지원, 블로킹/논블로킹 모두 지원
         */
    }
}
