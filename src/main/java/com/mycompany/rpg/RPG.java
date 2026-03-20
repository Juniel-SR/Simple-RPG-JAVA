package com.mycompany.rpg;
 import java.util.ArrayList;
 import javax.swing.JOptionPane;
 import java.util.Random;
public class RPG {
    public static void main(String[] args) {
        
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(new Inimigo("slime", 15, 180));
        inimigos.add(new Inimigo("goblin", 20, 210));
        
        ArrayList<Personagem> player = new ArrayList<>();
        String[] classes = {"Guerreiro","Mago","Arqueiro"};
  
        String nome = JOptionPane.showInputDialog("Nome Do Personagem:");
        int escolha = JOptionPane.showOptionDialog(null, "Escolha a classe:",
                "Seleção de classe", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, classes, classes[0]);
        
        if(escolha == -1){
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada!");
            return;
        }
 
        Personagem p = new Personagem(nome, classes[escolha]);
        
        JOptionPane.showMessageDialog(null, "O personagem " + nome + " foi criado com sucesso!");
      
        p.escolherClasse(escolha);
        player.add(p);
        
        Random random = new Random();
        int encontro = random.nextInt(inimigos.size());
        Inimigo inimigoAtual = inimigos.get(encontro);
        
        JOptionPane.showMessageDialog(null, "Um " + inimigoAtual.nome + " inimigo apareceu!");
        while (p.hp > 0 && inimigoAtual.vida > 0){
        
            String[] opcoes = {"atacar", "fugir"};
            int selecao = JOptionPane.showOptionDialog(
                    null, "Seu HP: " + p.hp +
                    " | HP do " + inimigoAtual.nome + ": " + inimigoAtual.vida,
                    "Combate", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            
        if (selecao == -1 || selecao == 1){
            JOptionPane.showMessageDialog(null, "Você escapou em segurança!");
            break;
        }
        p.atacar(inimigoAtual);
        JOptionPane.showMessageDialog(null, "Você atacou! " + "HP atual do inimigo: " + inimigoAtual.vida);
        
        if (inimigoAtual.vida <= 0){
            JOptionPane.showMessageDialog(null, "Você venceu!");
            break;
        }
        p.hp -= inimigoAtual.ataque;
        JOptionPane.showMessageDialog(null,"O " + inimigoAtual.nome + " te atacou!");
        
        if (p.hp <= 0){
            JOptionPane.showMessageDialog(null, "Você está morto!");
            break;
        }
        }
    }
}
