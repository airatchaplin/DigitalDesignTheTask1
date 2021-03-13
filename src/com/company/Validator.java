package com.company;

public class Validator {

    public static boolean isValid(String s){
        char[] arr = s.toCharArray();
        int countLeftBracket = 0;
        int countRightBracket = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '['){
                countLeftBracket++;
            }else if (arr[i] == ']'){
                countRightBracket++;
            }
        }
        if (countLeftBracket> countRightBracket || countLeftBracket < countRightBracket){
            throw new IllegalArgumentException("Некоррекктное выражение, проверьте колличество скобок!");
        }

        return true;
    }
}
