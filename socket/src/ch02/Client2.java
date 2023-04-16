package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	// 소켓과 서버측과 연결할 포트 번호가 필요하다.
	final String IP = "localhost";
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public Client2() {
		try {
			socket = new Socket(IP, 11001);
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String msg = bufferedReader.readLine();
				
				bufferedWriter.write(msg+"\n");
				bufferedWriter.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Client2();
	}

}
