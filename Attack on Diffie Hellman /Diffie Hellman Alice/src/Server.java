import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.Random;
public class Server {
	private ServerSocket server;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket connection;
	private BigInteger prime;
	private BigInteger g;
	private BigInteger secretA;
	private BigInteger receivedfromB;
	private BigInteger keyA;
	
	Server(){
		prime=new BigInteger("133294399882575758380143779458803658621711224322668460285458826191727627667054255404674269333491950155273493343140718228407463573528003686665212740575911870128339157499072351179666739658503429931021985160714113146720277365006623692721807916355914275519065334791400296725853788916042959771420436564784273910949");
		g=new BigInteger("276931556780344213902868906164723309223760836398395325400503672280937582471494739461900602187562551243171865731050750745462388288171212746300721613469564396741836389979086904304472476001839015983033451909174663464663867829125664459895575157178816900228792711267471958357574416714366499722090015674047");
		receivedfromB=new BigInteger("0");
		
		    secretA = new BigInteger("2139028689061647233092237608363983953254005036722809375824714947394619006021875625512431718657");
		
		
	}
	
	public void start() throws ClassNotFoundException{
		
		try {
			server=new ServerSocket(7770,10);
			waitingforClient();
			setupStreams();
			output.flush();
			
			//Sending to Bob
			output.writeObject(g.modPow(secretA, prime));
			
			//reading number received from bob
			String msg=input.readObject().toString();
			receivedfromB=new BigInteger(msg);
			
			//calculating the key for alice
			keyA=new BigInteger(receivedfromB.modPow(secretA, prime).toString());
			
			System.out.println("Key Exchange done and key of ALice is as follows:  ");
			System.out.println(keyA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitingforClient(){
		try {
			System.out.println("Waiting for Bob to get Connected");
			connection=server.accept();
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

}
