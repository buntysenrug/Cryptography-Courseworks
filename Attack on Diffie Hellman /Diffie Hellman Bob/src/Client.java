import java.math.BigInteger;
import java.net.*;
import java.util.Random;
import java.io.*;

public class Client {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket connection;
	private String serverIP;
	private String message;
	private BigInteger prime;
	private BigInteger g;
	private BigInteger secretB;
	private BigInteger receivedfromA;
	private BigInteger keyB;
	
	Client(String host){
		serverIP=host;
		prime=new BigInteger("133294399882575758380143779458803658621711224322668460285458826191727627667054255404674269333491950155273493343140718228407463573528003686665212740575911870128339157499072351179666739658503429931021985160714113146720277365006623692721807916355914275519065334791400296725853788916042959771420436564784273910949");
		g=new BigInteger("276931556780344213902868906164723309223760836398395325400503672280937582471494739461900602187562551243171865731050750745462388288171212746300721613469564396741836389979086904304472476001839015983033451909174663464663867829125664459895575157178816900228792711267471958357574416714366499722090015674047");
		receivedfromA=new BigInteger("0");
		
		    secretB = new BigInteger("9473946190060218756255124317186573105075074546238828817121274630072161346956439674");
	}
	
	
	public void start() throws ClassNotFoundException{
		try {
			connectToServer();
			setupStreams();
			//reading the number from alice
			message=input.readObject().toString();
			receivedfromA=new BigInteger(message);
			
			//sending the number to alice
			output.flush();
			output.writeObject(g.modPow(secretB, prime));
			
			//calculating the key 
			keyB=new BigInteger(receivedfromA.modPow(secretB, prime).toString());
			
			System.out.println("After key exchange and calculations the keyB is as follows:  ");
			System.out.println(keyB);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void setupStreams(){
		try{
			output=new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input=new ObjectInputStream(connection.getInputStream());
			System.out.println("Streams setting are done;");
			}catch(IOException io){
				System.out.println("Connection Failed...");
			}
		
	}
	
	private void connectToServer() throws IOException{ 
        System.out.println("\nAttempting to Connect...."); 
        connection=new Socket(InetAddress.getByName(serverIP),7770); 
        System.out.println("Connected to the host....."+connection.getInetAddress().getHostName());
	}

}
