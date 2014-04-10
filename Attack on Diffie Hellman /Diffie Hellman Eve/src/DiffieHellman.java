import java.math.BigInteger;
import java.util.Scanner;


public class DiffieHellman {
final static BigInteger one = new BigInteger("1");
	
	public static void main(String args[]) {
		
		BigInteger prime=new BigInteger("135066410865995223349603216278805969938881475605667027524485143851526510604859533833940287150571909441798207282164471551373680419703964191743046496589274256239341020864383202110372958725762358509643110564073501508187510676594629205563685529475213500852879416377328533906109750544334999811150056977236890927563");
		BigInteger g=new BigInteger("50816963661245197486007345228623703418595648822546406495804049806657323264631970338989319305517608181613323446333935083744696517453071304474070224778737768950306796268709658088926191196810292514803993948536554855431059806478296314246944230604158181581971665791121231014000761432591640648278903879739332618478");
		
		BigInteger aliceSecret=new BigInteger("45675641368897451365745313654864326");
		BigInteger bobSecret=new BigInteger("4646453464561646541");
		BigInteger eveSecret=new BigInteger("4643516542312145751212154");
		//BigInteger resulte;
		
		
		
		// Make A's calculation.
		BigInteger resulta = g.modPow(aliceSecret,prime);
		
		// This is the value that will get sent from A to B.
		// This value does NOT compromise the value of a easily.
		System.out.println("Person Alice sends to person Bob "+resulta+".");
		System.out.println("But Eve is the Adversary and receives this number ");
		System.out.println("Now what Eve Does is sends his own values to bob");
		System.out.println();
		System.out.println();

		
		BigInteger resulte=g.modPow(eveSecret, prime);
		System.out.println("Eve Calculates the following and sends his own number to Bob not the original number that was supposed to sent to him");
		
		System.out.println();

		System.out.println();

				
		// Make Bob's calculation.
		BigInteger resultb = g.modPow(bobSecret,prime);
		
		// This is the value that will get sent from B to A.
		// This value does NOT compromise the value of b easily.
		System.out.println("Person Bob  sends to person Alice "+resultb+".");
		System.out.println("But again the adversy in middle Eve intercepts it and sends his own Number to Alice as it was from Bob");
		
		// Once A and B receive their values, they make their new calculations.
		// This involved getting their new numbers and raising them to the 
		// same power as before, their secret number.
		BigInteger KeyACalculates = resulte.modPow(aliceSecret,prime);
		BigInteger KeyBCalculates = resulte.modPow(bobSecret,prime);
		BigInteger KeyCCalculates=resulta.modPow(eveSecret, prime);
		
		// Print out the Key A calculates.
		System.out.println("A takes "+resultb+" raises it to the power "+aliceSecret+" mod "+prime);
		System.out.println("The Key A calculates is "+KeyACalculates+".");
		System.out.println();
		System.out.println();

		
		// Print out the Key A calculates.
		System.out.println("Eve takes "+resulta+" raises it to the power "+eveSecret+" mod "+prime);
		System.out.println("The Key Eve calculates for Alice is "+KeyACalculates+".");
		System.out.println("As well as Eve also Calculates the key for Bob and sends it to him as ");
		System.out.println(KeyCCalculates);
		
		
		
	}
	
	

}
