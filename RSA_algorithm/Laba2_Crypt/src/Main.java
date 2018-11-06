import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		/*BigInteger A = new BigInteger("ADDA56DAA45",16);
		BigInteger B = new BigInteger("100110100111001110101110011001011100110010110011011111111111111111111111111000011111",2);
		BigInteger m = new BigInteger("8C32598A3E9087C219581E8BFB8478AF23E9A5577AA1CFC43914D2EC8C496705",16);
		
		BigInteger Aa = new BigInteger("5");
		BigInteger Bb = new BigInteger("71");
		System.out.println(MethMethods.Obratnuy(Aa, Bb));*/
		
		//ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,0,0,0,0,0,0,0,1,0,0,1,0));
		//System.out.println(MethMethods.toString(A));
		BigInteger M = new BigInteger("39",16);
		EncryptDecrypt enc = new EncryptDecrypt();
		BigInteger C = enc.encryption(M);
		BigInteger D = enc.decripton(C);
		System.out.println("MESSAGE"+M.toString(16));
		System.out.println("Encryption"+C.toString(16));
		//BigInteger expected = new BigInteger ("6DB2526EDD89CBC22F2E92B79F190BC5F307F11CBFE30F9E6F047BC6E5D95F9C",16);
		System.out.println("DECRYPT"+D.toString(16));
		
	
	}

}
