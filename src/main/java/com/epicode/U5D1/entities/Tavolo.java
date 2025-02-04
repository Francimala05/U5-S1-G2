package com.epicode.U5D1.entities;
import com.epicode.U5D1.Enum.StatoTavolo;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Tavolo {
    private int nTavolo;
    private int nCopertiMassimo;
   private StatoTavolo Stato;

   public Tavolo(int nTavolo, int nCopertiMassimo, StatoTavolo Stato){
       this.nTavolo = nTavolo;
       this.nCopertiMassimo= nCopertiMassimo;
       this.Stato = Stato;
   }



    }

