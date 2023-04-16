package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// 소켓 통신을 하려면 소켓이 필요하다. ( 서버측 연결을 담당하는 포트 번호를 알아야 함.)
public class Client {

	final String IP = "localhost";
	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	
	public Client() {
		
		try {
			System.out.println("클라이언트 소켓 프로그램 시작");
			socket = new Socket(IP, 11001);
			System.out.println("소켓으로 연결 완료");
			
			// 소켓에다가 버퍼 스트림 연결
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 키보드에서 값을 받아 서버측으로 보내기
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("글자를 입력해주세요.");
				String keyMsg = bufferedReader.readLine();
				
				bufferedWriter.write(keyMsg + "\n");
				bufferedWriter.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}

}
