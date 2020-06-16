package com.gk.multithreading;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Simple {
    public static void main(String[] args) {
        Map<Employee, Integer> map = new HashMap<>();
        map.put(new Employee("Girish", 50), 1);
        map.put(new Employee("Girish1",  10), 3);
        map.put(new Employee("Girish2",  4), 3);
        map.put(new Employee("Girish3",  2), 3);
        map.put(new Employee("Girish4",  32), 3);
        System.out.println("before size=>"+map.size());
        map.compute(new Employee("Girish", 50), (key, value)-> key.amout== 50 ? value = value+100: value);
        System.out.println("After size=>"+map.size());
        map.forEach((key,value)-> System.out.println(value));
        Integer arr[] = {1,2,3,4,5,6};
        System.out.println("max is: "+ Arrays.stream(arr).reduce((a,b)-> a > b ? a: b).get());

        AbstractTest abstractTest = new AbstractTest() {};
        abstractTest.test();

//        map.forEach((key, value)->{
//            System.out.println(key.name+"=>"+value);
//        });

        //chargingSmartPhone(10, 561);
    }

    static int chargingSmartPhone(int initCharge, int finalCharge){
        // Write your code here
        if((initCharge ==0 && finalCharge == 0) || finalCharge == 0) return 0;

        int rate = getRate(initCharge);
        int currentCharge = initCharge + rate;
        int finalTime = 1;
        int remainingCharge = finalCharge - currentCharge;
        //    rate = getRate(remainingCharge);
        int temp = 0;
        while(remainingCharge > 0){
            if(remainingCharge >= 0 && remainingCharge <=10) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 10 ? remainingCharge - 230: 0;
            }
            else if(remainingCharge>= 11 && remainingCharge >=230) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 230 ? 0 : remainingCharge - 230;
            }
            else if (remainingCharge >= 231 && remainingCharge >= 559) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 559 ? 0: remainingCharge - 559;
            }
            else if (remainingCharge>=560 && remainingCharge >= 1009) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 1009 ? 0 :remainingCharge - 1009;

            }
            else if (remainingCharge>= 1010 && remainingCharge >= 5000) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 5000 ? 0:remainingCharge - 5000;
            }
            else if(remainingCharge >= 5001 && remainingCharge>=10000)  {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 10000 ? 0 : remainingCharge - 10000;
            }
            else if (remainingCharge>= 10001 && remainingCharge >= 1000000000) {
                temp = remainingCharge;
                remainingCharge = remainingCharge <= 1000000000 ? 0 : remainingCharge - 1000000000;
            }

            rate = getRate(temp);
            finalTime = finalTime + (temp / rate) ;
        }
        return finalTime;

    }


    static int getRate(int n){

        if(n >= 0 && n <=10) return 10;
        else if(n>= 11 && n <=230) return 5;
        else if (n >= 231 && n <= 559) return 8;
        else if (n>=560 && n <= 1009) return 2;
        else if (n>= 1010 && n <= 5000) return 7;
        else if(n >= 5001 && n<=10000) return 8;
        else if (n>= 10001 && n <= 1000000000) return 3;

        return 0;
    }
}
