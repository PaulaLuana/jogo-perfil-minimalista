package entidade;

import java.util.ArrayList;

public class Jogo {
    private BancoDeCartas banco;
    private Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadors;

    public Jogo(BancoDeCartas banco, Tabuleiro tabuleiro, ArrayList<Jogador> jogadors) {
        this.banco = banco;
        this.tabuleiro = tabuleiro;
        this.jogadors = jogadors;
    }

    public ArrayList<Jogador> getJogadors() {
        return jogadors;
    }


    public BancoDeCartas getBanco() {
        return banco;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

}
