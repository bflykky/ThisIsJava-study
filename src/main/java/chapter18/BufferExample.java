package main.java.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        String originalFilePath1 = BufferExample.class.getResource("testImage.jpg").getPath();
        String targetFilePath1 = "targetFile1.jpg";

        FileInputStream fis1 = new FileInputStream(originalFilePath1);
        FileOutputStream fos1 = new FileOutputStream(targetFilePath1);

        // 입출력 스트림 + 버퍼 스트림 생성
        String originalFilePath2 = BufferExample.class.getResource("testImage.jpg").getPath();
        String targetFilePath2 = "targetFile2.jpg";

        FileInputStream fis2 = new FileInputStream(originalFilePath1);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath1);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 버퍼를 사용하지 않고 복사
        long nonBufferTime = copy(fis1, fos1);
        System.out.printf("버퍼를 사용하지 않고 복사했을 때 수행 시간:\t %d ms\n", nonBufferTime);

        // 버퍼를 사용하여 복사
        long bufferTime = copy(bis, bos);
        System.out.printf("버퍼를 사용하여 복사했을 대 수행 시간: \t %d ms\n", bufferTime);

        fis1.close();
        fos1.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream is, OutputStream os) throws IOException {
        // 시작 시간 저장
        long start = System.nanoTime();

        // 1바이트를 읽고 1바이트를 출력
        while (true) {
            int data = is.read();
            if (data == -1) {
                break;
            }

            os.write(data);
        }
        os.flush();

        // 종료 시간 저장
        long end = System.nanoTime();

        return (end - start) / 1000 / 1000;
    }
}
