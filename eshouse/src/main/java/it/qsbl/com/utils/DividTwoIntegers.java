package it.qsbl.com.utils;

public class DividTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        long pDividend = Math.abs((long) dividend);//取绝对值，放溢出转化为long
        long pDivisor = Math.abs((long) divisor);

        int result = 0;
        while (pDividend >= pDivisor) {
            int count = 0;//记录位移
            while (pDividend >= (pDivisor << count)) {
//                int a = (int) (pDivisor << count);
                count++;
            }
            result += (1 << (count - 1));
            pDividend -= (pDivisor << (count - 1));
        }
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        DividTwoIntegers dt = new DividTwoIntegers();
        int a = dt.divide(101, -3);
        System.out.println(a);
    }
}