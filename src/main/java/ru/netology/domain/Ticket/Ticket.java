package ru.netology.domain.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

     public class Ticket implements Comparable<Ticket> {
         protected int id;
         protected int price;
         protected String from;
         protected String to;
         protected int travelTime;


         @Override
         public int compareTo(Ticket o) {
             return this.price - o.price;
         }

         }
