
public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		while(true){
			c.ConnectToServer();
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
		}

	}

}
