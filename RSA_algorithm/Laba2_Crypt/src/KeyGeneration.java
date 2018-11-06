import java.math.BigInteger;

public class KeyGeneration {
	private BigInteger d;
	private BigInteger p;
	private BigInteger q;
	private BigInteger e;
	private BigInteger n;
	public BigInteger getD() {
		return d;
	}
	public void setD(BigInteger d) {
		this.d = d;
	}
	public BigInteger getP() {
		return p;
	}
	public void setP(BigInteger p) {
		this.p = p;
	}
	public BigInteger getQ() {
		return q;
	}
	public void setQ(BigInteger q) {
		this.q = q;
	}
	public BigInteger getE() {
		return e;
	}
	{
		this.e = new BigInteger("10001",16);
	}
	public void setE(BigInteger e) {
		this.e = e;
	}
	public BigInteger getN() {
		return n;
	}
	public void setN(BigInteger n) {
		this.n = n;
	}
	BigInteger eulerFunction(BigInteger p, BigInteger q){
		BigInteger res = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		return res;
	}
	KeyGeneration(){
		BigInteger temp = MRTest.bestSipleNumber();
		q = temp;
		System.out.println(q);
		BigInteger temp1 = MRTest.bestSipleNumber();
		p = temp1;
		System.out.println(p);
		
		n =q.multiply(p);
		//System.out.println("generate n "+ n);
		
		d = MethMethods.Obratnuy(e,eulerFunction(p,q)).mod(n);
		System.out.println("generate d "+ d);
		System.out.println("E "+e);
		System.out.println("n in crypt    "+n);
		System.out.println("p in crypt    "+p);
		System.out.println("q in crypt    "+q);
	}
}
