import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class MethMethods {
	static String toString(ArrayList<Integer> number) {
		String result = "";
		for(Integer num : number){
			result+=num;
		}
		return result;
	}
	static BigInteger RandomNumberL20(int lenghts){
		ArrayList<Integer> number = new ArrayList<Integer>();
		Random rnd = new Random();
		for(int i = 0 ; i++<20;){
			number.add(rnd.nextInt(2));
		}
		//System.out.println(number);
		for(int index = 20; index++<lenghts;){
			number.add(number.get(index-20)^number.get(index-9)^number.get(index-5)^number.get(index-3));
		}
		//System.out.println(number);
		
		BigInteger Number = new BigInteger(toString(number),2); 
		return Number;
	}
	static BigInteger Obratnuy(BigInteger number,BigInteger Mod){
		BigInteger res;
		ArrayList<BigInteger> r = new ArrayList<BigInteger>();
		ArrayList<BigInteger> q = new ArrayList<BigInteger>();
		r.add(new BigInteger(Mod.toString()));
		r.add(new BigInteger(number.toString()));
		//BigInteger r2;
		int index = 1;
		do{
			index++;
			r.add(r.get(index-2).mod(r.get(index-1)));
			//System.out.println("r" + r.get(index));
			q.add(r.get(index-2).divide(r.get(index-1)));
			//System.out.println("q" + q.get(index-2));
			
		}while(!r.get(index).equals(BigInteger.ZERO));
		ArrayList<BigInteger> u = new ArrayList<BigInteger>();
		u.add(BigInteger.ZERO);
		u.add(BigInteger.ONE);
		int u_index = 1;
		//System.out.println("index"+index);
		//System.out.println(q.size());
		//System.out.println(r.size());
		//index--;
		while(u_index!=index){
			u_index++;
			//System.out.println(u.get(u_index-2)+"  "+u.get(u_index-1));
			//System.out.print("     "+q.get(u_index-1));
			u.add(u.get(u_index-2).subtract(u.get(u_index-1).multiply(q.get(u_index-2))));
			//System.out.println("index"+u_index+"     u"+u.get(u_index));
		}
		return u.get(u_index-1).mod(Mod);
//return BigInteger.ZERO;
	}
	}