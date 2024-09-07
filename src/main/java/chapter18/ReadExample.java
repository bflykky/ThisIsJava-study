package main.java.chapter18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        // int read() 함수 사용 예제
        try {
            InputStream is = new FileInputStream("test1.db");

            while (true) {
                int data = is.read();
                if (data == -1) {
                    break;
                }
                System.out.println(data);
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("==========");

        // int read(byte[] b) 함수 사용 예제
        try {
            InputStream is = new FileInputStream("test2.db");

            byte[] data = new byte[100];

            while (true) {
                int readLength = is.read(data);
                if (readLength == -1) {
                    break;
                }

                for (int i = 0; i < readLength; i++) {
                    System.out.println(data[i]);
                }
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
