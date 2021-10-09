package organizacao_interface;

import entidade.Jogador;
import entidade.Tabuleiro;

public interface Observador {
    public boolean linhaDeChegada(Tabuleiro tabuleiro, int numeroDaCasa, Jogador jogador);
}
