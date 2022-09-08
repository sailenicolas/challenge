package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var my_array = new String[]{"FirstWord", "SecondWord", "THIRDWORD"};
        concat( my_array );
    }


    public static String concat(String[] array){
        String stringBuffer1 = Arrays.stream( array ).map( String::toLowerCase ).collect( Collectors.joining(" ") );
        System.out.println(stringBuffer1 );
        return stringBuffer1;
    }
}