import java.math.BigInteger;


public class Modulo {
	public static void main(String[] args){
		//assigning the values to the following BigIntegers as given in the question
		BigInteger a=new BigInteger("34325464564574564564768795534569998743457687643234566579654234676796634378768434237897634345765879087764242354365767869780876543424");
		BigInteger n=new BigInteger("643808006803554439230129854961492699151386107534013432918073439524138264842370630061369715394739134090922937332590384720397133335969549256322620979036686633213903952966175107096769180017646161851573147596390153");
		BigInteger b=new BigInteger("45292384209127917243621242398573220935835723464332452353464376432246757234546765745246457656354765878442547568543334677652352657235");
		
		
		try{
		BigInteger ainverse=inverse(a,n);
		//negating the number for callulating inverse
		BigInteger bneg=b.multiply(new BigInteger("-1"));
		
		BigInteger ans=bneg.multiply(ainverse);
		System.out.println(ans.mod(n));
		BigInteger test=ans.multiply(a);
		BigInteger t2=test.add(b);
		System.out.println(t2.remainder(n));
		}catch(Exception e){
			System.out.println("Number not Invertibe....");
		}
		
	}
	
	
	public static BigInteger inverse(BigInteger a, BigInteger N){
		if(a.gcd(N).equals(BigInteger.ONE)){
			return a.modInverse(N);

		}else{
			
			return null;
		}
	}

}
