package controller;

import entidade.Jogador;

import java.util.ArrayList;

public class ControllerJogador {
    private static ControllerJogador CONTROLLER_JOGADOR_INSTANCE;
    private ControllerJogador(){}
    public static ControllerJogador getInstance(){
        if(CONTROLLER_JOGADOR_INSTANCE == null)
            CONTROLLER_JOGADOR_INSTANCE = new ControllerJogador();
        return CONTROLLER_JOGADOR_INSTANCE;
    }
    public Jogador criarJogador(String id){
        Jogador j = new Jogador(((String) id));
        return j;
    }

    public ArrayList<Jogador> addJogadoresNoJogo(int n){
        ArrayList<Jogador> jogadors = new ArrayList<Jogador>();
        Jogador aux;
        //O Jogador 0 é nosso mediador(Computador)
        for(int j=0; j<=n; j++){
            if(j == 0){
                aux = criarJogador("computador");
            }else{
                aux = criarJogador("Jogador" + j);
            }
            jogadors.add(aux);
        }
        return jogadors;
    }

    public Jogador controlaVez(ArrayList<Jogador> jogadors, Jogador ultimoJogador){
        if(jogadors.get(jogadors.size()-1) == ultimoJogador){
            return jogadors.get(1);
        }
        return jogadors.get(jogadors.indexOf(ultimoJogador)+1);
    }

    public void mostraJogadores(ArrayList<Jogador> jogadors){
        System.out.print("[");
        for (Jogador i : jogadors){
            System.out.print(i.getId() + ", ");
        }
        System.out.println("]");
    }


}
