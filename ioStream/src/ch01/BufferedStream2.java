package ch01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedStream2 {

	public static void main(String[] args) {
		// BufferedInputStream

		BufferedInputStream bis = null;

		try {

			// 보조기반스트림을 먼저 선언해서 안에 FileInputStream 넣고 사용하기 
			bis = new BufferedInputStream(new FileInputStream("c:/tmp/test.txt"));
			int i;
			while ((i = bis.read()) != -1) {
				System.out.print(i + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
