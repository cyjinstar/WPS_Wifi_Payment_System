import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket mSocket;
    //private InputStream mIn;
    private BufferedReader mIn;     //들어오는 통로
    //private OutputStream mOut;
    private PrintWriter mOut;    //나가는 통로

    public Server() {
        try {
            //5555는 포트번호이다
            serverSocket = new ServerSocket(3000);
            System.out.println("서버 시작!!!");
            //스레드가 멈춰 있고,

            //연결요청이 들어오면 연결
            //accept에 의해 5555번 포트에 접근하기 전까지 스레드는 아이스에이지
            mSocket = serverSocket.accept();
            System.out.println("클라이언트와 연결 됨 ");

            //이제 아래의 문장들을 while(true) 문을 사용해서 무한반복해준다.

            //원래는 아래처럼 굳이 input/output따로 빼줄 필요는 없다.
            //아래처럼 하면 byte단위로 받아와야 한다.

            //mIn = mSocket.getInputStream();
            mIn = new BufferedReader(
                    new InputStreamReader(mSocket.getInputStream()));

            //mOut = mSocket.getOutputStream();
            mOut = new PrintWriter(mSocket.getOutputStream());

            while(true){
                Scanner scanner = new Scanner(System.in);
                String stringTemp;
                String buffer;
                System.out.println(">>");
                buffer = scanner.nextLine();
                stringTemp = scanner.nextLine();
                if(stringTemp == "DISCONNECT"){
                    break;
                }else {
                    //클라이언트에서 보낸 문자열 출력
                    System.out.println(mIn.readLine());

                    //클라이언트에 문자열 전송
                    mOut.println(stringTemp);
                    mOut.flush();//쌓인 데이터를 상대 소켓으로 전송하는 역할을 한다.
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {// 결국은 finally안의 것을 실행하게 된다. 오류가 뜨더라도
            //소켓닫기 _ (연결종료)
            //서버나 클라이언트 중 한곳에 끊기면 연결이 끊기게 된다.
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }

}
