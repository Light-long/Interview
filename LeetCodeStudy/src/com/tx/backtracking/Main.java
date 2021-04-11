package com.tx.backtracking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b;
        boolean falg = true;
        while (falg && scan.hasNextInt()) {
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.println(String.format("%d %d",a,b));
            for (int i=0;i<b;i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                int z = scan.nextInt();
                System.out.println(String.format("%d %d %d",x,y,z));
            }
            falg = false;
        }
    }
}
