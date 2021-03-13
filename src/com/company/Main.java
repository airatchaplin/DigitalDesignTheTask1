package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        String s1 = "2[xyz]3[XY]z";
        String s2 = "2[3[x]y]";
        String s3 = "2[3[zxc]ZXC]2[Z]zz";
        String s4 = "2[3[zxc]ZXC]";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("<------------Старт программы----------->");
        System.out.println("<----------Введите выражегние---------->");


        while (true) {
            String string = reader.readLine();
            if (Validator.isValid(string)) {
                System.out.println(Unpacker.unpuck(string));
            }
        }


    }
}
