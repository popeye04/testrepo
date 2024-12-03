package com.mycompany.finalpractice;
import java.util.Scanner;
import java.io.File;
import java.util.Formatter;

public class FinalPractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        File file = new File("C:\\Users\\KIshor\\Desktop\\Java_Project\\person\\demo.txt");
        
        try{
            Formatter formatter = new Formatter("C:\\Users\\KIshor\\Desktop\\Java_Project\\person\\demo.txt");
            do{
            System.out.println("Enter an integer: ");
            num = scan.nextInt();
            formatter.format("%d\r\n",num);
            }
            while(num>0);
            formatter.close();
            System.out.println("File Written.");
         }catch(Exception e){
                    
                    System.out.println(e);
        }
}
