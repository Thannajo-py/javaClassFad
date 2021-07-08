package com.adrar;

import static java.lang.Character.isUpperCase;

public class ChaineDeCaractere {
    public static String StringSansE(String in){
        String solution = "";
        for(int i = 0; i < in.length();i++){
            if (in.charAt(i) != 'e' && in.charAt(i) != 'E'){
                solution +=  in.charAt(i);
            }
        }
        return solution;
    }
    public static int NbDeA(String in){
        int solution = 0;
        for(int i = 0; i < in.length();i++){
            if (in.charAt(i) == 'a' || in.charAt(i) == 'A') {
                solution++;
            }
        }
        return solution;
    }
    public static String reverse(String in){
        String solution = "";
        for(int i = 0; i < in.length();i++){
            solution += in.charAt(in.length() -1 -i);
        }
        return solution;
    }
    public static int countMaj(String in){
        int solution = 0;
        for(int i = 0; i < in.length();i++){
            if(isUpperCase(in.charAt(i))){
                solution += 1;
            }
        }
        return solution;
    }
    public static String StringSansVoyelle(String in){
        String solution = "";
        for(int i = 0; i < in.length();i++){
            if (in.charAt(i) != 'e' && in.charAt(i) != 'a' && in.charAt(i) != 'i' && in.charAt(i) != 'o' &&
                    in.charAt(i) != 'u' && in.charAt(i) != 'y') {
                solution += in.charAt(i);
            }

        }
        return solution;
    }
    public static String stringSansMajuscule(String in){
        String solution = "";
        for(int i = 0; i < in.length();i++){
            if (!isUpperCase(in.charAt(i))){
                solution += in.charAt(i);
            }

        }
        return solution;
    }
    public static char plusHauteLettre(String in){
        char solution = in.charAt(0);
        for(int i = 1; i < in.length();i++){
            if(in.charAt(i)>solution){
                solution = in.charAt(i);
            }
        }
        return solution;
    }
    public static String stringSansEspace(String in){
        String solution = "";
        boolean start = false;
        for(int i = 0; i < in.length();i++){
            if(!start && in.charAt(i) == ' '){
                continue;
            }
            else {
                solution += in.charAt(i);
                start = true;
            }
        }
        return solution;
    }
    public static String stringSansEspaceAvantEtApres(String in){
        return reverse(stringSansEspace(reverse(stringSansEspace(in))));
    }
    public static boolean palindrome(String in){
        for(int i = in.length()-1; i >= 0;i--){
            if(in.charAt(i) != in.charAt(in.length()-1 - i)){
                return false;
            }
        }
        return true;
    }
    public static boolean palindrome2(String in){
        return reverse(in).equals(in);
    }
    public static boolean isValidPassword(String in){
        if (in.length()<8){
            return false;
        }
        boolean min = false;
        boolean maj = false;
        boolean num = false;
        String number = "0123456789";
        String lettermin = "abcdefghijklmnopqrstuvwxyz" ;
        for(int i = 0; i < in.length();i++) {
            if (!maj && isUpperCase(in.charAt(i))) {
                maj = true;
            }
            if (!num) {
                for (int j = 0; j < number.length(); j++) {
                    if (in.charAt(i) == number.charAt(j)) {
                        num = true;
                        break;
                    }
                }
            }
            if (!min) {
                for (int j = 0; j < lettermin.length(); j++) {
                    if (in.charAt(i) == lettermin.charAt(j)) {
                        min = true;
                        break;
                    }
                }
            }
            if (min && num && maj) {
                return true;
            }

        }
        return false;
    }
    public static boolean isValid(String in){
        return in.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$");
    }
}
