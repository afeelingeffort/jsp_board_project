package ch01;

import java.io.FileOutputStream;
import java.io.IOException;


public class Stream_FileOutputStream2 {

	public static void main(String[] args) {

		FileOutputStream fos = null;

		try {
			// FileOutputStream으로 파일 생성
			// 바이트 기반
			// A ~ Z까지 출력하기
			
			// 바이트 기반이기 때문에 A~Z까지 찍기 위해 26개 배열 생성
			byte[] b = new byte[26];
			// 65 : A, 66 : B, ...
			byte data = 65;
			fos = new FileOutputStream("c:/tmp/output2.txt");

			for (int i = 0; i < b.length; i++) {
				fos.write(data);
				data++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	} // end of main

} // end of class
