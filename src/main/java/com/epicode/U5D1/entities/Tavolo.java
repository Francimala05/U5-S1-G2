package com.epicode.U5D1.entities;

import com.epicode.U5D1.Enum.StatoOrdine;
import com.epicode.U5D1.Enum.StatoTavolo;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(exclude = "ordine")
@Component
public class Tavolo {
    private int nTavolo;
    private int nCopertiMassimo;
    private StatoTavolo stato;
    private Ordine ordine;


    public Tavolo(int nTavolo, int nCopertiMassimo, StatoTavolo stato) {
        this.nTavolo = nTavolo;
        this.nCopertiMassimo = nCopertiMassimo;
        this.stato = stato;


        if (stato == StatoTavolo.OCCUPATO) {

            List<Menu> ordini = new ArrayList<>();
            ordini.add(new Menu(
                    List.of(new Pizza("Pizza Margherita",
                            List.of(new Topping("Tomato", 0, 0),
                                    new Topping("Cheese", 92, 0.69)),
                            false)),
                    List.of(),
                    List.of()));
            ordini.add(new Menu(
                    List.of(),
                    List.of(new Drink("Lemonade", 128, 1.29)),
                    List.of()
            ));
            this.ordine = new Ordine(this, ordini, 9, StatoOrdine.IN_PREPARAZIONE, 5, LocalDateTime.now());
        }
    }

    public boolean hasOrdine() {
        return ordine != null;
    }
}
