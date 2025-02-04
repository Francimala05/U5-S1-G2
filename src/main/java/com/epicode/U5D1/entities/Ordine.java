package com.epicode.U5D1.entities;

import com.epicode.U5D1.Enum.StatoOrdine;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@ToString
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
        this.ordini = ordini;
        this.nOrdine = nOrdine;
        this.stato = stato;
        this.nCoperti = nCoperti;
        this.oraAcquisizione = oraAcquisizione != null ? oraAcquisizione : LocalDateTime.now();
        this.conto = calcolaConto();
    }

    // Metodo per calcolare il conto totale
    private double calcolaConto() {
        double sommaPizze = ordini.stream()
                .flatMap(menu -> menu.getPizzaList().stream()) // Stream di pizze dal menu
                .mapToDouble(Pizza::getPrice)  // Somma dei prezzi delle pizze
                .sum();

        sommaPizze += ordini.stream()
                .flatMap(menu -> menu.getDrinkList().stream()) // Stream di bevande dal menu
                .mapToDouble(Drink::getPrice)  // Somma dei prezzi delle bevande
                .sum();

        return sommaPizze + (nCoperti * prezzoCoperto); // Aggiunge il costo del coperto
    }



}
