package main.java.chapter18;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderExample {
    public static void main(String[] args) {
        try {
            Reader reader = null;

            // 1개의 문자씩 읽기
            reader = new FileReader("test.txt");
            while (true) {
                int data = reader.read();
                if (data == -1) {
                    break;
                }
                System.out.print((char) data);
            }
            reader.close();

            System.out.print("\n==============\n");

            // 문자 배열 읽기
            reader = new FileReader("test.txt");
            char[] data = new char[100];
            while (true) {
                int length = reader.read(data);
                if (length == -1) {
                    break;
                }

                for (int i = 0; i < length; i++) {
                    System.out.print(data[i]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
