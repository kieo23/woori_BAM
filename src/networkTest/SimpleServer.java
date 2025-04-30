package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 9999; // 서버 포트

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 포트 " + port + "에서 대기 중입니다...");

// =================================================================================            
            //ip와 포트를 확인후 연결을 수락해줌
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

// ======================================================================================            
            
            // 데이터 수신
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine(); //수신된 정보를 저장
            System.out.println("클라이언트로부터 수신: " + clientMessage);
            
// ======================================================================================            

            // 데이터 송신
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("접속 감사합니다.");
            
// ======================================================================================            

            clientSocket.close();		// 다른 클라이언트 위해서 닫는다.
            System.out.println("서버 종료");
        } catch (IOException e) {		// 방화벽 예상외의 예외 발생
            e.printStackTrace();		// 로그 처리
        }
    }
}