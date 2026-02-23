package org.example.aula3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Objeto Heroi
        Heroi heroi = new Heroi("Naruto",100,20,5);
        heroi.exibirStatus();

        System.out.println();

        // Objeto Monstro
        Monstro neji = new Monstro("Neji", "🥷", 40, 12,2,20);
        neji.exibirStatus();


        // Objeto Item
        Item pocaoGrande = new Item("Poção Grande", "cura", 50);
        System.out.println("\n Item no inventário" + pocaoGrande.getDescricao());


        System.out.println("\n ------------------ Teste Manual -----------------------");
        heroi.receberDano(35); // heroi toma dano
        heroi.exibirStatus();

        pocaoGrande.usar(heroi); // usa o item
        heroi.exibirStatus();

        int danoHeroi = heroi.atacar();
        neji.receberDano(danoHeroi);
        System.out.println("\n Neji ainda esta vivo?" + neji.estaVivo());

    }
}