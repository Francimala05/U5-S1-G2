package com.epicode.U5D1;

import com.epicode.U5D1.entities.Menu;
import com.epicode.U5D1.entities.Tavolo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
@Slf4j
public class CommandLiveRunner {

	public static void main(String[] args) {
		SpringApplication.run(CommandLiveRunner.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CommandLiveRunner.class);

		Menu m = (Menu) ctx.getBean("menu");
		List<Tavolo> tavoli = (List<Tavolo>) ctx.getBean("tavoli");
		m.printMenu();

		printTavoli(tavoli);

		ctx.close();
	}

	public static void printTavoli(List<Tavolo> tavoli) {
		System.out.println("*******Elenco Tavoli*******");

		tavoli.forEach(tavolo -> {
			System.out.println("Tavolo numero: " + tavolo.getNTavolo());
			System.out.println("Numero massimo di coperti: " + tavolo.getNCopertiMassimo());
			System.out.println("Stato tavolo: " + tavolo.getStato());
			if (tavolo.hasOrdine()) {
				System.out.println("Ordine associato al tavolo: " + tavolo.getOrdine());
			} else {
				System.out.println("Nessun ordine per questo tavolo.");
			}
			System.out.println("------------------------------");
		});
	}
}
