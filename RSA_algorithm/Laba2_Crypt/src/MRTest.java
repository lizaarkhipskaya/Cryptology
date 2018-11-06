import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class MRTest {
	public static final BigInteger TWO = new BigInteger("2");
	public static final BigInteger MINUSONE = new BigInteger("-1",10);
	public static int lenghtForRandomNumber;
	public static final int testConter = 20;
	static{
		lenghtForRandomNumber = 256;
	}
	private static final int[] primes =
		{   2,   3,   5,   7,  11,  13,  17,  19,  23,  29,  31,  37,  41,  43,
		47,  53,  59,  61,  67,  71,  73,  79,  83,  89,  97, 101, 103, 107,
		109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
		191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251 };
	static boolean primesTest(BigInteger A){
		for(int j : primes){
			BigInteger B = new BigInteger(Integer.toString(j));
			if(A.mod(B).compareTo(BigInteger.ZERO)==0) return false;
		}
		return true;
	}
	public static int S_inBigInteger(BigInteger b){
		int counterS = 0;
		while(true){
			if(b.mod(TWO).compareTo(BigInteger.ZERO)==0){
				b = b.divide(TWO);
				counterS++;
			}
			else break;
		}
		return counterS;
	}
	
	static boolean test(BigInteger A ,int counter,int s , BigInteger D){
		if(counter<testConter){
		BigInteger X = MethMethods.RandomNumberL20(127);
		BigInteger temp;
		if(A.gcd(X).compareTo(BigInteger.ONE)>0) return false;
		if(X.modPow(D, A).compareTo(MINUSONE)==0||X.modPow(D, A).compareTo(BigInteger.ONE)==0){ 
			return true;}
		
		for(int r = 1 ; r < s-1 ; r++){
			temp = X.modPow(D.multiply(TWO.pow(r)), A);
			if(temp.compareTo(MINUSONE)==0) return true;
			else if (temp.compareTo(BigInteger.ONE)==0) return false;
		}
		counter++;
		test(A,counter,s,D);
		}
		return false;
	}
	static boolean mrTest(BigInteger numberForTest){
		if(!primesTest(numberForTest)) return false;
		int counter = 0;
		BigInteger D = new BigInteger(numberForTest.toString());
		D = D.subtract(BigInteger.ONE);
		int s = S_inBigInteger(D) ;
		D = D.divide(TWO.pow(s));
		if(MRTest.test(numberForTest, counter,s,D )) return true ;
		return false;
	}
	static BigInteger simpleNumber(){
		while(true){
			BigInteger posible_number = MethMethods.RandomNumberL20(128);
			if(mrTest(posible_number)) {
				return posible_number;}
		}
		
	}
	static BigInteger bestSipleNumber(){
		System.out.println("founding ");
		BigInteger best_number = MRTest.simpleNumber();
		int iterator = 1;
		BigInteger temp ;
		while(true){
			temp =new  BigInteger(Integer.toString(2*iterator));
			best_number = best_number.multiply(temp).add(BigInteger.ONE);
			if(mrTest(best_number)){ 
				break;}
		}
		return best_number;
	}
}
