package com.company;

import java.util.Stack;

public class Unpacker {

    public static String unpuck(String s) {
        char[] arr = s.toCharArray();

        StringBuilder number = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        String text = "";

        Stack<Integer> stackInteger = new Stack<>();
        Stack<String> stackString = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                number.append(arr[i]);
            } else if (arr[i] == '[') {
                if (number.toString().equals("")) {
                    stackInteger.push(1);
                } else {
                    stackInteger.push(Integer.valueOf(number.toString()));
                    number = new StringBuilder();
                }
            } else if (!isNumber(arr[i]) && arr[i] != ']') {
                symbols.append(arr[i]);
            } else if (arr[i] == ']') {

                stackString.add(symbols.toString());
                symbols = new StringBuilder();
                text += addText(stackInteger.pop(), stackString.pop());

                if (i < arr.length - 1) {
                    if (!isNumber(arr[i + 1])) {
                        stackInteger.push(1);
                    } else {
                        if (!stackInteger.isEmpty()) {
                            int a = stackInteger.pop();
                            text += addText(a - 1, text);
                        }
                    }
                }
            }
        }
        if (!symbols.toString().equals("")) {
            text += symbols;
        }
        if (!stackInteger.isEmpty()) {
            int a = stackInteger.pop();
            if (a != 0) {
                text += addText(a - 1, text);
            }
        }
        return text;
    }

    public static String addText(int count, String symbols) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < count; i++) {
            text.append(symbols);
        }
        return text.toString();
    }

    private static boolean isNumber(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
