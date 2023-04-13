package ch01;

import java.io.FileOutputStream;
import java.io.IOException;


public class Stream_FileOutputStream {

	public static void main(String[] args) {

		FileOutputStream fos = null;

		try {
			// FileOutputStream으로 파일 생성
			// 바이트 단위

			// FileOutputStream 파일을 생성할 곳을 지정
			fos = new FileOutputStream("c:/tmp/output.txt");

			fos.write(100); // d
			fos.write(99); // c
		} catch (IOException e) {
			System.out.println("파일 생성 안됨");
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
