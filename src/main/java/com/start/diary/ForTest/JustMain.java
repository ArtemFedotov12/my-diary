package com.start.diary.ForTest;

public class JustMain {


    public static void main(String[] args) {

        Just just1 =new Just();
        just1.setId(1);
        just1.setKe("ke");
        Just just2 =new Just();
        just2.setId(1);
        just2.setKe("ke");
        just2.setCountry("iii");
     /*   System.out.println(just1.hashCode());
        System.out.println(just2.hashCode());*/

        System.out.println(just1.hashCode());
        System.out.println(just2.hashCode());
        System.out.println(just1==just2);
        System.out.println(just1.equals(just2));



    }
}
