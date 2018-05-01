
package rsacopy;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


public class Rsacopy {

    
    public static void main(String[] args) {

        BigInteger p;
    BigInteger q;
    BigInteger k;
    BigInteger phin, d;
    BigInteger e;
    BigInteger cip;
    System.out.println("Enter your msg to be encrypted!");
        Scanner in =new Scanner(System.in);
        BigInteger msg=in.nextBigInteger();
        long stime=System.nanoTime();
    Random rnd = new Random();
    p=BigInteger.probablePrime(512, rnd);
    q=BigInteger.probablePrime(512, rnd);
    
    k=p.multiply(q);
      phin=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    
    e=BigInteger.valueOf(65537);
    d = e.modInverse((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));
    cip=msg.modPow(e, k);
    
    long etime=System.nanoTime()-stime;
    
    etime=etime/1000000;
        System.out.println("Cipher Text : "+cip);
        System.out.println("Time for encryption : "+etime+" milli seconds");
            long dstime=System.nanoTime();

       msg=cip.modPow(d, k);
       
        long detime=System.nanoTime()-dstime;
        detime=detime/1000000;
        System.out.println("Decrypted message is: "+msg);
        System.out.println("Time for decryption : "+detime+" milli seconds");
    
    
    }
}
