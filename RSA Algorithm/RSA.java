import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;


public class RSA {
	public static void main(String[] args) throws IOException{
		
		BigDecimal c=new BigDecimal("674472526620593903800497637242400187916753185909");
		
		
		
		double d=Math.cbrt(c.doubleValue());
		System.out.printf("%f%n",d);
		BigDecimal ans=new BigDecimal(d);
		BigInteger t=ans.toBigInteger();
		
		String str =ans.toString();
		
		byte[] b=new byte[str.length()];
		for(int i=0;i<str.length()-1;i=i+2){
			char a=str.charAt(i);
			char z=str.charAt(i+1);
			String dec=a+""+z;
			int ex=Integer.parseInt(dec);
			System.out.print((char)ex);
		}
				
	}

}
