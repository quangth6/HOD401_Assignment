import java.util.Scanner;
import java.net.Socket;
import java.net.InetSocketAddress;

class Scanport{
	
	public static void main(String[] args){
		int timeout = 200;
		int PORT_VALUE = 65535;
		Scanner sc = new Scanner(System.in);
		System.out.printf("input ip address: ");
		String ip = sc.nextLine();

		System.out.println("Start scan...." );
		try{
			for(int port = 1; port <= PORT_VALUE ; port++){
				if(portIsOpen(ip, port, timeout)){
					System.out.println("Port: " + port+" is open");
				}
			}
			System.out.println("Scan Success...." );
		}catch(Exception ex){
			System.out.printf("Exception "+ ex);
		}	
	}
	public static boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}