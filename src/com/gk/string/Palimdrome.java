package com.gk.string;

import java.util.HashSet;
import java.util.Objects;

public class Palimdrome {

    boolean checkPali1mdrome(String str){
        if(Objects.isNull(str)) return false;
        if(str.length() == 0 || str.length() == 1) return true;
        if(str.charAt(0) == str.charAt(str.length()-1))
                return checkPali1mdrome(str.substring(1, str.length()-1));
        return false;
    }
    public static void main(String[] args) {
        Palimdrome palimdrome = new Palimdrome();
        System.out.println(palimdrome.checkPali1mdrome("nsn"));
    }
}
