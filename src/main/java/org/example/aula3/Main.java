package org.example.aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println("🦸🏽‍♂ Digite o nome do seu heroí: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 170,30,15);

        //Dando itens iniciais ao herói
        heroi.adicionarItem(new Item("Doação de ki", "cura",30));
        heroi.adicionarItem(new Item("Água sagrada", "cura",80));
        heroi.adicionarItem(new Item("Semente dos Deuses", "cura",150));
        System.out.println("\n✅ Herói criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                
                new Monstro("Capitão Ginyu", "👾", 50,14,3,30), // novo monstro Capitão Ginyu
                new Monstro("Freeza de Namek", "👽", 90,22,7,65), // novo monstro Freeza de Namek
                new Monstro("Cell Perfeito", "🪲", 140,30,12,100), // novo monstro Cell Perfeito
                new Monstro("Kid Boo", "💥", 200,40,18,200) // novo monstro Kid Boo
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n🗺️ Você avança pela dungeon...");
            System.out.println("🚪 Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e ){
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" 🏃🏽 Você fugiu para o proximo corredor...");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();

            if (venceu) {
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("-----------------------------------------");
        System.out.println("-       ⚔️ DUNGEON QUEST DRAGON BALL    -");
        System.out.println("-  Programação Orientação a Objeto       -");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println("-------------------------------------------");
        System.out.println("-            ☠️ GAME OVER                 -");
        System.out.println("-------------------------------------------");
        System.out.println(" Fim da Jornada de " + nome);
        System.out.println(" Vitórias: "+ vitorias);
        System.out.println(" XP Total: " + xp);
        System.out.println();
    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------------------");
        System.out.println("-           👑 DUNGEON COMPLETA!              -");
        System.out.println("-----------------------------------------------");
        System.out.println(" Parabéns, " + heroi.getNome() + "!");
        System.out.println(" Vitórias: " + vitorias);
        System.out.println(" XP Total: " + heroi.getXp());
        heroi.exibirStatus();
    }
}