package ch01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Stream_FileOutputStream3 {

	public static void main(String[] args) {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("c:/tmp/output3.txt");
			// 넣고 싶은 문자열을 생성하여 byte[] 배열에 .getBytes()메서드 사용하기
			String msg = "hello world";
			byte[] b = msg.getBytes();

			for (int i = 0; i < b.length; i++) {
				fos.write(b[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
