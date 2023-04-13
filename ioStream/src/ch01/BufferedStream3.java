package ch01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStream3 {

	public static void main(String[] args) {

		// BufferedWriter, BufferedReader
		BufferedWriter bw = null;

		try {
			// bufferdWriter를 통해
			bw = new BufferedWriter(new FileWriter("c:/tmp/asdf.txt"));

			String str = "asdfasdfasdf";
			bw.write(str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
