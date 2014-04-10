import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;


public class Test {
	public static void main(String[] args) throws FileNotFoundException{
		RandomAccessFile f=new RandomAccessFile("euclid.txt","rw");
		BigInteger x=new BigInteger("1572855870797393");
		BigInteger y=new BigInteger("630065648824575");
		
		BigInteger[] ans=GCD.gcd(x, y);
		
		System.out.println("The value of d is "+ans[0]);
		String a1="The value of d is "+ans[0];
		System.out.println("The value of s is "+ans[1]);
		String a2="The value of s is "+ans[1];
		System.out.println("The value of t is "+ans[2]);
		String a3="The value of t is "+ans[2];
		
		try {
			f.writeBytes(a1);
			f.writeBytes("\n");

			f.writeBytes(a2);
			f.writeBytes("\n");

			
			f.writeBytes(a3);
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
