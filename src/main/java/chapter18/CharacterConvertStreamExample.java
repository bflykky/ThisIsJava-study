package main.java.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws IOException {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws IOException {
        // 보조 스트림을 직접 연결하는 경우
        /*
        OutputStream os = new FileOutputStream("test.txt");
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        */

        // FileWriter를 사용해 내부적으로 보조 스트림이 연결되는 로직을 이용하는 경우
        Writer writer = new FileWriter("test.txt");
        writer.write(str);

        writer.flush();
        writer.close();
    }

    public static String read() throws IOException {
        InputStream is = new FileInputStream("test.txt");
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100];

        int length = reader.read(data);
        String str = new String(data, 0, length);

        reader.close();
        return str;
    }

    /*
     * 결론
     * 바이트 스트림으로 문자 데이터를 입출력하는 경우, 보조 스트림 중 문자 변환 스트림을 이용해
     * 문자 스트림으로 변환하여 사용하는 것이 좋다.
     * 이때, 수동적으로 OutputStreamWriter, InputStreamReader 보조 스트림을 생성해도 되고,
     * FileReader, FileWriter와 같이 보조 스트림을 상속하면서, 생성자 호출 시 바이트 스트림을 파라미터로
     * 전달함으로써 내부적으로 보조 스트림을 연결하는 클래스들을 사용해도 된다.
     *
     */
}
