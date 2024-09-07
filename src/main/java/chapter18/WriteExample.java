package main.java.chapter18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        // 1바이트를 write하는 write() 함수
        try {
            OutputStream os = new FileOutputStream("test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a); // int로 전환된다.
            os.write(b);
            os.write(c);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 결론
         * write() 사용 시, 해당 바이트는 버퍼에 우선 저장 후, 버퍼가 차면 순서대로 바이트를 출력한다.
         */

        // 바이트 배열을 write하는 write() 함수
        try {
            OutputStream os = new FileOutputStream("test2.db");

            byte[] array = { 10, 20, 30};
            os.write(array);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 결론
         * write(byte[] b) 사용 시, 배열 b의 모든 바이트를 write한다.
         */

        // 바이트 배열 중 일부를 write하는 write() 함수
        try {
            OutputStream os = new FileOutputStream("test3.db");

            byte[] array = { 10, 20, 30, 40, 50};
            os.write(array, 1, 3);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
