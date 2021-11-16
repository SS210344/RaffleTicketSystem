package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>Numbers = new ArrayList<>();
    private static ArrayList<String>Names = new ArrayList<>();


    public static void main(String[] args) {
        // write your code here

        MainMenu();

    }public static void MainMenu(){


        while(true) {
            try {
                System.out.println("main Menu: 1 to buy ticket; 2 to check ticket; other to exit");

                int options = Integer.parseInt(userInput());
                switch (options) {
                    case 1:
                        System.out.println("buy ticket");
                        buyTicket();

                        break;
                    case 2:
                        System.out.println("check ticket");
                        checkTicket();
                        break;
                    default:
                        System.out.println("exit");
                        System.exit(0);


                }

            }
            catch (Exception e){
                System.out.println("Error in main menu method"+e);
            }
        }
    }
    public static String userInput(){
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        String userIn= " ";
        try {
             userIn = bufferedReader.readLine();
        }
        catch (Exception e){
            System.out.println("error in user input"+e);
        }
        return userIn;
    }
    public static int randNum(int min , int max){
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }
    public static void buyTicket(){
        System.out.println("name:");
        String name = userInput();
        int randNum = randNum(1, 500);
        System.out.println("your number is "+randNum);
        Numbers.add(randNum);
        Names.add(name);
    }
    public static void checkTicket(){
        boolean isPrime = false;
        System.out.println("name on the ticket:");
        String name = userInput();
        System.out.println("number on the ticket:");
        int number = Integer.parseInt(userInput());

        boolean foundTicket = false;

        for (int i = 0; i < Names.size(); i++) {
            if(Names.get(i).equals(name)){
                if(Numbers.get(i)== number){
                    System.out.println("valid ticket");
                    foundTicket = true;
                    isPrime = checkPrime(number);
                }
            }
        }

        if(!foundTicket){
            System.out.println("invalid ticket");
        }
        if(isPrime){
            System.out.println("ticket is prime you win");
        }
        else{
            System.out.println("ticket is not prime you lose");
        }




    }
    public static boolean checkPrime(int number){
        boolean IsPrime = true;

        for (int i = 2; i < number; i++) {
            if(number%i == 0){
                IsPrime = false;
                break;
            }

        }
        return IsPrime;
    }
}
