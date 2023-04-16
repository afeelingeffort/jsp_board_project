package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// 소켓 통신을 하려면 소켓이 필요하다. (서버측 연결 담당 포트 번호 알아야 함.)
public class Client {

	// 자신의 ip 
	final String IP = "localhost";
	
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	public Client() {
		try {
			// 소켓 생성과 동시에 ip, 연결 담당 포트 번호 
			socket = new Socket(IP, 10002);
			
			// 키보드로 받은 내용을 읽을 예정
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// 출력을 위한 소켓의 기반 스트림 불러오기.(?)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 이 부분에서 while(true)로 해서 무한 반복이 일어나 server측 코드가 flush()가 되지 않았었음.
			boolean flag = true;
			while (flag == true) {
				String msg = bufferedReader.readLine();
				System.out.println("Client 측 메세지 " + msg);
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
				flag = false;
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
