import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket msocket;

    private BufferedReader mIn;
    private PrintWriter mOut;

    public Client(String ip, int port){
        try {
            //서버에 요청을 보내기...저 ip와 port로 통신하겠다는 의미
            msocket = new Socket(ip, port);
            System.out.println(ip + "연결됨");

            //통로 뚫기
            mIn = new BufferedReader(
                    new InputStreamReader(msocket.getInputStream()));
            mOut = new PrintWriter(msocket.getOutputStream());

            while(true){
                Scanner scanner = new Scanner(System.in);
                String stringTemp;
                String buffer;
                System.out.println(">>");
                buffer = scanner.nextLine();
                stringTemp = scanner.nextLine();
                if(stringTemp == "DISCONNECT"){
                    break;
                }else{

                    //메세지 전달
                    mOut.println(stringTemp);
                    mOut.flush();

                    System.out.println(mIn.readLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {// 결국은 finally안의 것을 실행하게 된다. 오류가 뜨더라도
            //소켓닫기 _ (연결종료)
            //서버나 클라이언트 중 한곳에 끊기면 연결이 끊기게 된다.
            try {
                msocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //new Client("localhost", 5555);
        new Client("172.30.1.34",3000);
    }
}
