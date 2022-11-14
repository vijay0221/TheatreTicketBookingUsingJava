package com.collectionExamples;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Theatre theatre=new Theatre("INOX",8,12);
        theatre.getSeats();
        System.out.println(theatre.getTheatreName());
        if(theatre.reserveSeat("G12")){
            System.out.println("please pay");
        }else {
            System.out.println("sorry seat is taken");
        }
        if(theatre.reserveSeat("G12")){
            System.out.println("please pay");
        }else {
            System.out.println("sorry seat is taken");
        }

    }
}

