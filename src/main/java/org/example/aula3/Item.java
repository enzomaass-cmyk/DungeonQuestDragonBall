package org.example.aula3;


public class Item {

    private String nome;
    private String tipo; // "kaiohken" para aumento temporário de poder
    private int valor; //20 de dano bonus

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    //Aplica o efeito do item no herói, ex: se for aumento temporario no poder, aumenta a força do herói
    public void usar(Heroi heroi) {
        if(tipo.equals("cura")) {
            heroi.usarPocao();
            System.out.println(" 🔥" + nome + " foi usado!");
        }
    }

     //Retorna descrição formatada: ex:"Aumento de Poder temporário [kaiohken +20]"
    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }

    //Getters: getNome(), getTipo(), getValor()
    public String getNome() {return nome; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }
}
