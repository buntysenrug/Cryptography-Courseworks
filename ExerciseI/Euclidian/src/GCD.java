import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;


public class GCD {
	
	static BigInteger[] gcd(BigInteger i,BigInteger j){
		BigInteger[] ans=new BigInteger[3];
		//BigDecimal quotient;
		if(j==BigInteger.ZERO){
			return new BigInteger[]{i,BigInteger.ONE,BigInteger.ZERO};
			
		}
			//quotient=i.divide(j,0);
			ans= gcd(j,i.remainder(j));
			BigInteger d=ans[0];
			BigInteger a=ans[2];
			BigInteger eqndivide=i.divide(j);
			BigInteger equmultiply=eqndivide.multiply(ans[2]);
			BigInteger b=ans[1].subtract(equmultiply);
           return new BigInteger[]{d,a,b};
		
	}

}
