
public class Client_Test {
	public static void main(String[] args){
		Client bob=new Client("127.0.0.1");
		try {
			bob.start();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
