import java.math.BigInteger;

public class EncryptDecrypt {
	KeyGeneration Key = new KeyGeneration();
	public BigInteger encryption(BigInteger message ){
		System.out.println("n in crypt    "+Key.getN());
		System.out.println("e in crypt    "+Key.getE());
		/*System.out.println("d in crypt    "+Key.getD());
		System.out.println("q in crypt    "+Key.getQ());
		System.out.println("p in crypt    "+Key.getP());*/
		//BigInteger n = new BigInteger("A9B30BA55F29CCB4CA4C5230A4D228A0F28CFAE5B23ED8F8BBDB42694C4DEBA5",16);
		//Key.setN(n);
		System.out.println("chek1 "+(Key.getE().multiply(Key.getD())).mod(Key.eulerFunction(Key.getP(), Key.getQ())));
		
		BigInteger encrypt_message = message.modPow(Key.getE(),Key.getN());
		System.out.println("n in crypt    "+Key.getN());
		System.out.println("e in crypt    "+Key.getE());
		System.out.println("n in crypt    "+Key.getN());
		System.out.println("e in crypt    "+Key.getE());
		System.out.println("check"+(message.modPow(Key.getE().multiply(Key.getD()),Key.getN())));
		return encrypt_message;
	}
	public BigInteger decripton(BigInteger message ){
		/*System.out.println("n in decrypt    "+Key.getN());
		System.out.println("e in decrypt   "+Key.getE());
		System.out.println("d in decrypt   "+Key.getD());
		System.out.println("q in decrypt    "+Key.getQ());
		System.out.println("p in decrypt    "+Key.getP());*/
		//System.out.println(Key.getE().multiply(Key.getD()).mod(Key.eulerFunction(Key.getP(), Key.getQ())));
		BigInteger decrypt_message = message.modPow(Key.getD(),Key.getN());
		return decrypt_message;
	}
}
