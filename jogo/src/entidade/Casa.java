package entidade;

import java.util.ArrayList;

public class Casa {
    private int numero;
    private ArrayList<Jogador> jogadors;
    public Casa(){
        jogadors = new ArrayList<>();
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Jogador> getJogadors() {
        return jogadors;
    }

}
