package vp.ThreadCoordination;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        PowerCalculatingThread p1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread p2 = new PowerCalculatingThread(base2, power2);
        p1.start();
        p2.start();
        p1.join();
        p2.join();
        result = p1.getResult().add(p2.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
           
        	BigInteger temp = BigInteger.ONE;
        	for (BigInteger i = BigInteger.ZERO; i.compareTo(this.power) < 0 ; i = i.add(BigInteger.ONE))
        	{
        		temp = temp.multiply(this.base);
        	}
        	this.result = temp;
        	
        }
    
        public BigInteger getResult() { return result; }
    }
}