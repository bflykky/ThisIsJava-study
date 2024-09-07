package main.java.chapter18;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("test.txt");

            // 문자 1개씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            // char 배열 출력
            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);

            // 문자열 출력
            writer.write("FGH");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 결론
         * Writer 클래스에서는 char형 문자, char형 배열, String 문자열을 write하는 메소드를 각각 제공한다.
         */
    }
}
