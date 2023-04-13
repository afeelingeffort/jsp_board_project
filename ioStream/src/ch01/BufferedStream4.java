package ch01;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedStream4 {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// BufferedReader로 파일 읽어오기.
			// String으로 받아서 readLine()하고 != null 해야 한글 출력됨!
			br = new BufferedReader(new FileReader("c:/tmp/asdf.txt"));

			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
