package ch01;

import java.io.FileReader;

// FileReader로 텍스트 읽어오기.
// 문자 단위로 읽어옴.
public class Stream_FileReader {

	public static void main(String[] args) {

		FileReader fr = null;

		try {
			// c드라이버 tmp폴더의 a텍스트 파일에 적은 내용을 읽어옴.
			fr = new FileReader("c:\\tmp\\a.txt");
			int i;
			// i에 읽어온 내용 저장하고 파일 끝까지 읽음(!= -1)
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (Exception e) {
			System.out.println("입출력 오류났어");
			e.printStackTrace();
		}
	} // end of main

} // end of class
