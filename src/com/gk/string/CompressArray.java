package com.gk.string;

public class CompressArray {

    public static char[] compress(char[] chars) {
        String[] arra = new String[10];
        System.out.println(arra[0]);
        String result = "";
        int count = 1;
        if(chars.length == 1) return chars;
        StringBuilder sb = new StringBuilder();
        for(int index=0;index<chars.length;index++){

            if(index == chars.length-1){
                sb.append(chars[index]+""+count);
                break;
            }
            if(chars[index] == chars[index+1]){
                count++;
            }else{
                sb.append(chars[index]+""+count);
                count = 1;
            }
        }
        System.out.println("=>"+sb.toString().toCharArray());
        return sb.toString().toCharArray();
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println("compress lengthis: "+CompressArray.compress(chars).toString());
    }

}
