package com.ws.quartzdemo1001.radom;

import java.util.*;

public class Gener {
    private static String[] telStarts = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153,180,181,182,183,185,186,176,187,188,189,177,178".split(",");

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    private static String getTel() {
        int index = getNum(0, telStarts.length - 1);
        String first = telStarts[index];
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + "****" + third;
    }

    private static String[] amountLists = ("0.75,1.58,1.3,2.25,1.95,0.75,1.38,2.37,0.75,0.95,1.72,1.58,0.97,2.33,1.27,0.73,2.07,1.77,2.0,0.51,1.07,0.91," +
            "1.57,1.72,2.56,1.88,1.09,1.71,1.96,1.72,0.74,1.72,1.35,1.41,1.58,1.48,1.2,1.01,1.24,0.82,0.6,0.55,0.57,0.56").split(",");

    private static String getAmount(ArrayList arrayList) {
        int index = getNum(0, arrayList.size() - 1);
        Object s = arrayList.remove(index);
        return s.toString();
    }

    public static void main(String[] args) {
        try {
            String a = "" + new Date().getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(int q = 1 ;q<5;q++) {
//            System.out.println("+++++++++++++++++++++" + q);
//            List<String> list = Arrays.asList(amountLists);
//            ArrayList arrayList = new ArrayList(list);
//            for (int i = 0; i < 6; i++) {
//                //一个小时
//                Date startTime = getTimeWithTimesN(i);
//                System.out.println(getTel() + " >><< " + getAmount(arrayList) + " ><>< " + startTime);
//            }
//            for (int i = 0; i < 36; i++) {
//                //半个小时
//                Date startTime = getTimeWithTimesD(i);
//                System.out.println(getTel() + " >><< " + getAmount(arrayList) + " ><>< " + startTime);
//            }
//        }
    }


    private static Date getTimeWithTimesN(int times) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        instance.add(Calendar.MINUTE, 60 * times);
        instance.add(Calendar.MINUTE, getNum(0, 59));
        instance.add(Calendar.SECOND, getNum(0, 59));
        return instance.getTime();
    }

    private static Date getTimeWithTimesD(int times) {

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        instance.add(Calendar.HOUR, 6);
        instance.add(Calendar.MINUTE, 30 * times);
        instance.add(Calendar.MINUTE, getNum(0, 29));
        instance.add(Calendar.SECOND, getNum(0, 59));
        return instance.getTime();
    }


}
