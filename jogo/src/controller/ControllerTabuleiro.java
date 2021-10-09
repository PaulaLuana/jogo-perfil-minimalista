package controller;

import entidade.Casa;
import entidade.Jogador;
import entidade.Tabuleiro;
import organizacao_interface.ICarta;
import organizacao_interface.Observador;
import organizacao_interface.Observavel;


public class ControllerTabuleiro implements Observador, Observavel {

    private static ControllerTabuleiro CONTROLLER_TABULEIRO_INSTANCE;

    private ControllerTabuleiro(){}
    public static ControllerTabuleiro getInstance(){
        if(CONTROLLER_TABULEIRO_INSTANCE == null)
            CONTROLLER_TABULEIRO_INSTANCE = new ControllerTabuleiro();
        return CONTROLLER_TABULEIRO_INSTANCE;
    }
    ControllerDicas controllerDicas = ControllerDicas.getInstance();
    ControllerJogador controllerJogador = ControllerJogador.getInstance();

    private static int QUANTIDADE_DE_CASAS_MAXIMA = 10;
    public Tabuleiro iniciaTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro(QUANTIDADE_DE_CASAS_MAXIMA + 1);
        return tabuleiro;
    }

    public int computadorAndaNoTabuleiro(Tabuleiro tabuleiro, ICarta carta, Jogador computador){
        int dicas = carta.getDicasUsuais().size();//o tamanho original da lista
        int qDicasUsuais = controllerDicas.dicasUsuaisSize(carta)+1;//tamanho real da lista
        int posComputador = computador.getPos() + (dicas - qDicasUsuais);

        if(posComputador >= QUANTIDADE_DE_CASAS_MAXIMA){
            posComputador = QUANTIDADE_DE_CASAS_MAXIMA;
        }

        //atualizar a casa antiga, removendo o jogador da lista e passando a nova lista sem o jogador.
        Casa casa = tabuleiro.getCasas().get(computador.getPos());
        casa.getJogadors().remove(computador);

        computador.setPos(posComputador);//passa a nova posicao do jogador

        //atualizar os jogadores da casa nova
        Casa casaNova = tabuleiro.getCasas().get(computador.getPos());
        casaNova.getJogadors().add(computador);

        return posComputador;
    }

    //Faz o jogador andar casas e retorna o novo número da casa
    public int andaNoTabuleiro(Tabuleiro tabuleiro, ICarta carta, Jogador jogador){
        int qDicasUsuais = controllerDicas.dicasUsuaisSize(carta)+1; //quantidade de dicas q ainda poderiam ser usadas
        int posJogador = jogador.getPos() + qDicasUsuais; //posicao da nova casa

        if(posJogador >= QUANTIDADE_DE_CASAS_MAXIMA){
            posJogador = QUANTIDADE_DE_CASAS_MAXIMA;
        }

        //atualizar a casa antiga, removendo o jogador da lista e passando a nova lista sem o jogador.
        Casa casa = tabuleiro.getCasas().get(jogador.getPos());
        casa.getJogadors().remove(jogador);

        jogador.setPos(posJogador);//passa a nova posicao do jogador

        //atualizar os jogadores da casa nova
        Casa casaNova = tabuleiro.getCasas().get(jogador.getPos());
        casaNova.getJogadors().add(jogador);

        return posJogador;
    }

    //Indica se o jogador chegou na linha de chegada
    @Override
    public boolean linhaDeChegada(Tabuleiro tabuleiro, int numeroDaCasa, Jogador jogador){
        if(numeroDaCasa == tabuleiro.getCasas().size()-1){
            notifique(jogador);
            return true;
        }
        return false;
    }

    public void mostraTabuleiro(Tabuleiro tabuleiro){
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("Tabuleiro");
        for (Casa i : tabuleiro.getCasas()){
            System.out.print("Casa " + i.getNumero() +": ");
            controllerJogador.mostraJogadores(i.getJogadors());
            System.out.print(" ");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void notifique(Jogador jogador) {
        System.out.println("Parabéns " + jogador.getId() + " você ganhou jogo!");
    }
}
