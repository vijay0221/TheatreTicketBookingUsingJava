package com.collectionExamples;

import java.util.*;

public class Theatre {
  private final String theatreName;
  private List<Seat>seatList=new ArrayList<>();

    public Theatre(String theatreName,int numberOfRows,int seatsPerRows) {
        this.theatreName = theatreName;
        int lastRow='A'+(numberOfRows-1);
        for(char row='A';row<=lastRow;row++){
            for(int seatNumber=1;seatNumber<=seatsPerRows;seatNumber++){
                Seat seat = new Seat(row  +  String.format("%02d",seatNumber));
                seatList.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return this.theatreName;
    }
    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat=Collections.binarySearch(seatList,requestedSeat,null);
        for(Seat seat:seatList){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat=seat;
                break;
            }
        }
        if(requestedSeat==null){
            System.out.println("there is no seat with "+seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }
    public void getSeats(){
        for(Seat seat:seatList){
            System.out.println(seat.getSeatNumber());
        }
    }



    private class Seat implements Comparable<Seat>{
      private final String seatNumber;
      private boolean reserved=false;

      public Seat(String seatNumber) {
          this.seatNumber = seatNumber;
      }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
          if(!this.reserved){
              this.reserved=true;
              System.out.println("your seat is reserved with seatNumber"+seatNumber);
              return true;
          }else{
              return false;
          }
      }
      public boolean cancel(){
          if(this.reserved){
              this.reserved=false;
              System.out.println("your seat is cancelled with seat number"+seatNumber);
              return true;
          }
          return false;
      }
      public String getSeatNumber() {
          return seatNumber;
      }
  }
}
