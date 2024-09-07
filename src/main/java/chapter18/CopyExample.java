package main.java.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) throws IOException {
        final String originalFileName = "testImage.jpg";
        final String targetFileName = "testImageCopy.jpg";

        InputStream is = new FileInputStream(originalFileName);
        OutputStream os = new FileOutputStream(targetFileName);

        // InputStream, OutputStream의 메소드들을 이용해서 수동으로 데이터 이동
        /*
        byte[] data = new byte[1024];
        while (true) {
            int length = is.read(data);
            if (length == -1) {
                break;
            }
            os.write(data, 0, length);
        }
         */

        // Java 9에서 추가된 InputStream의 transferTo() 함수를 이용해 OutputStream 객체로 모든 바이트 데이터 이동
        is.transferTo(os);

        os.flush();
        os.close();
        is.close();

        System.out.println("복사 작업 완료");
    }

    /*
     * 결론
     * InputStream에서 OutputStream으로 바로 데이터를 이동시키기 위해서 transferTo()라는 함수를 쓸 수도 있다.
     */
}
