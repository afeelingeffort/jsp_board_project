package ch01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stream_FileReader_FileWriter {

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;

		try {
			// 읽어올 파일을 생성을 안 하고 실행해서 오류 났었음.
			fr = new FileReader("c:/tmp/readerex.txt");
			fw = new FileWriter("c:/tmp/writerex.txt");

			int i;
			fw.write("hihihihi \n");
			while ((i = fr.read()) != -1) {
				fw.write(i + "\n");
			}
			fw.write("byebyebye \n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
