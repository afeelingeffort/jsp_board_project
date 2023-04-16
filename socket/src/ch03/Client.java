package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	final String IP = "localhost";
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	public Client() {
		try {
			socket = new Socket(IP, 10002);

			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
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
