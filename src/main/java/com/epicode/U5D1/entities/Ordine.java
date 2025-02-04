package com.epicode.U5D1.entities;

import com.epicode.U5D1.Enum.StatoOrdine;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@ToString(exclude = "tavolo")
public class Ordine {

    private Tavolo tavolo;
    private List<Menu> ordini;
    private int nOrdine;
    private StatoOrdine stato;
    private int nCoperti;
    private LocalDateTime oraAcquisizione;
    private double conto;

    @Value("${ristorante.coperto}")
    private double prezzoCoperto;


    public Ordine(Tavolo tavolo, List<Menu> ordini, int nOrdine, StatoOrdine stato, int nCoperti, LocalDateTime oraAcquisizione) {
        this.tavolo = tavolo;
        this.ordini =  ordini != null ? ordini : new ArrayList<>();;
        this.nOrdine = nOrdine;
        this.stato = stato;
        this.nCoperti = nCoperti;
        this.oraAcquisizione = oraAcquisizione != null ? oraAcquisizione : LocalDateTime.now();
        this.conto = calcolaConto();
    }

    private double getPrezzoCoperto() {
        return nCoperti * prezzoCoperto;
    }

    // Metodo per calcolare il conto
    private double calcolaConto() {
        System.out.println("Numero di coperti: " + nCoperti);
        System.out.println("Prezzo coperto: " + prezzoCoperto);
        double sommaPizze = ordini.stream()
                .flatMap(menu -> menu.getPizzaList().stream())
                .mapToDouble(Pizza::getPrice)
                .sum();

        double sommaBevande = ordini.stream()
                .flatMap(menu -> menu.getDrinkList().stream())
                .mapToDouble(Drink::getPrice)
                .sum();
        return sommaPizze + sommaBevande + getPrezzoCoperto();
    }



}
