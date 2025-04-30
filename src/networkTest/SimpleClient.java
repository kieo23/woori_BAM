package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // 서버주소 ( localhost = 내컴퓨터 )
        int port = 9999;			   // 서버의 대기중인 포트 번호

        //포트 및 아이피 설정
        
// =================================================================
        
       // 서버에 메세지 전송
        try (Socket socket = new Socket(serverIP, port)) { // ip + 포트 --> 서버와 tcp 연결 --> 성공 sock 객체를 통해서
            // 서버에 메시지 전송 (요청 1
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("안녕하세요");

// =================================================================
            
            // 서버 응답 수신
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("서버 응답: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}