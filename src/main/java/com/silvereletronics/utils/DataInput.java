package com.silvereletronics.utils;

import java.util.Scanner;

public class DataInput {
    static Scanner input = new Scanner(System.in);
    public static String TextInput(){
        System.out.println("Digite: ");
        return input.nextLine();
    }
    public static int IntegerInput(){
        String num;
        do{
            System.out.println("Digite: ");
            num = input.nextLine();
        } while(!isInteger(num));
        return Integer.parseInt(num);
    }
    public static int IntegerInput(int min, int max){
        String num;
        int numNum = min-1;
        do{
            System.out.println("Digite: ");
            num = input.nextLine();
            if(isInteger(num)){
                numNum = Integer.parseInt(num);
                if(numNum < min || numNum > max){
                    System.out.println("Não é uma opção.");
                }
            }
        } while(numNum < min || numNum > max);
        return numNum;
    }

    public static float FloatInput(){
        String num;
        do{
            System.out.println("Digite: ");
            num = input.nextLine();
        } while(!isFloat(num));
        return Float.parseFloat(num);
    }



    private static boolean isInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Não é um inteiro.");
            return false;
        }
    }

    private static boolean isFloat(String value){
        try{
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Não é um número real.");
            return false;
        }
    }
}
