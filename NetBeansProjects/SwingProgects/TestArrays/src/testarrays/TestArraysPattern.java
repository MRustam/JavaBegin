package testarrays;

import java.util.Scanner;

public class TestArraysPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input simbol.
        char simbol = scanner.next().trim().charAt(0);
        
        char arr[][] = new char[5][5];

//      #
//      ##
//      ###
//      ####
//      #####
        System.out.println("\nPattern 1 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                
                if ((i == 0 || i < arr.length) && (j == i || j < i)) {
                    
                    arr[i][j] = simbol;
                    
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        
//      #####
//      ####
//      ###
//      ##
//      #
        System.out.println("\nPattern 2 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                
                if ((i + j < arr.length)) {
                    
                    arr[i][j] = simbol;
                    
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        
        
//          #
//         ##
//        ###
//       ####
//      #####
        System.out.println("\nPattern 3 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                
                if ((i + j + 1 < arr.length)) {
                    
                    arr[i][j] = ' ';
                    
                } else {
                    arr[i][j] = simbol;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        
//      #####
//       ####
//        ###
//         ##
//          #
        System.out.println("\nPattern 4 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                
                if (j >= i) {
                    
                    arr[i][j] = simbol;
                    
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
