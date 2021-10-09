package entidade;

import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Casa> casas;

    public Tabuleiro(int quantidadeDeCasas) {
        casas = new ArrayList<Casa>();
        for(int i=0; i<quantidadeDeCasas; i++){
            casas.add(new Casa());
        }
    }

    public int getQuantidadeDeCasas() {
        return casas.size();
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
}
