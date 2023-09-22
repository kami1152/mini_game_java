import java.io.*; // java.io 하위 모든 라이브러리 자동 호출
import java.net.*;// java.net 하위 모든 라이브러리 자동 호출

public class Client {
    /*
     * Java Socket Programming 설명 참조 : https://lktprogrammer.tistory.com/62
     * InetAddress 설명 참조 : https://hyunssssss.tistory.com/243
     */
    public static void main(String[] args) {
        Socket socket = null; // Server와 통신하기 위한 Client의 Socket
        BufferedReader in = null; // Server로부터 데이터를 읽어들이기 위한 입력스트림
        BufferedReader in2 = null; // 키보드로부터 읽어들이기 위한 입력스트림
        PrintWriter out = null; // 서버로 내보내기 위한 출력 스트림
        InetAddress ia = null;

        try {
            ia = InetAddress.getLocalHost(); // 서버로 접속하기 위해 서버 주소 입력

            /*
             * 클라이언트-서버 간의 네트워크 통신 시 필요한 것은 두가지 입니다.
             * 클라이언트는 서버의 IP 주소와 포트번호를 알아야합니다.
             * 필자는 컴퓨터 한대로 클라이언트-서버 통신을 하기 때문에 ia에 getLocalHost()를 사용하여
             * Local IP Address(본인 컴퓨터 IP 주소)를 불러왔습니다.
             * 포트번호는 4444로 정해놓았기 때문에 4444를 입력합니다.
             */
            socket = new Socket(ia, 4444);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader 선언
            in2 = new BufferedReader(new InputStreamReader(System.in)); // BufferredReader2 선언
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 이하 동문

            System.out.println(socket.toString());
        } catch (IOException e) {

        }

        try {
            System.out.print("서버로 보낼 매세지 : ");
            String data = in2.readLine(); // 키보드로부터 입력
            out.println(data);
            out.flush();

            String str2 = in.readLine(); // 서버로부터 되돌아오는 데이터를 읽어들임
            System.out.println("서버로부터 되돌아온 메세지 : " + str2);
            socket.close();
        } catch (IOException e) {

        }
    }
}
