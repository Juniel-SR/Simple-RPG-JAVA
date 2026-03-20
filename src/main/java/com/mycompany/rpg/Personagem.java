package com.mycompany.rpg;
public class Personagem {
    String nome;
    String classe;
    int hp;
    int ataque;
    
    public Personagem(String nome, String classe){
    this.nome = nome;
    this.classe = classe;
   }
    public void guerreiro(){
    System.out.println("Você se tornou um guerreiro feroz!");
    hp = 100;
    ataque = 60;
    }
    public void mago(){
    System.out.println("Você se tornou um mago implacavel!");
    hp = 60;
    ataque = 80;
    } 
    public void arqueiro(){
    System.out.println("Você se tornou um arqueiro habilidoso!");
    hp = 80;
    ataque = 60;
    }
    public void atacar(Inimigo inimigo){
    inimigo.vida -= this.ataque;
    }
    public void mostrarInformacoes(){
    System.out.println("Nome: " + nome);
    System.out.println("Classe: " + classe);
    System.out.println("HP: " + hp);
    }
    public void escolherClasse(int escolha){
    switch(escolha){
        case 0:
            guerreiro();
            break;
        case 1:
            mago();
            break;
        case 2:
            arqueiro();
    }
    }
}
