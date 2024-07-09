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
		System.out.println(recive);		
	}
	
	
	public static void dosAttack(){
		
	}
	
	
}
