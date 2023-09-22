package app00;

import java.io.*; // java.io 하위 모든 라이브러리 자동 호출
import java.net.*; // java.net 하위 모든 라이브러리 자동 호출
import java.nio.*; // java.nio 하위 모든 라이브러리 자동 호출

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server_socket = null;
        BufferedReader in = null;

        PrintWriter out = null;

        /*
         * try/catch exception은 RuntimeException과 다르게 치명적 오류를 유발할 수 있습니다.
         * 따라서 try/catch exception을 통해 에러를 사전에 예방합니다.
         * 아래 구문에서는 포트가 열려있는지 확인하고 이미 열려있는 포트이면 에러 구문을 출력 후 종료하여
         * 에러를 예방합니다.
         */
        try {
            server_socket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("해당 포트가 열려있습니다.");
        }

        try {
            System.out.println("서버가 열렸습니다.");
            socket = server_socket.accept(); // 서버를 생성, Client는 접속 대기`1

            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림 생성

            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 출력스트림 생성

            String str = null;
            str = in.readLine(); // Client로부터 데이터 읽어옴

            System.out.println("Client로부터 온 메세지 : " + str);

            out.write(str); // print(str)와 비슷합니다.
            out.flush(); // 버퍼링으로 인해 기록되지 않은 데이터를 출력 스트림에 모두 출력
            socket.close(); // 출력되지 않은 스트림은 모두 출력하고 스트림을 닫는다.
        } catch (IOException e) {

        }
    }
}
