package classes_abstratas;

import organizacao_interface.ICarta;
import organizacao_interface.IDica;

import java.util.ArrayList;

//estamos usando o padrão fábrica na criação de cartas e injeção de dependência
public abstract class CartaAbstrata implements ICarta {
    private ArrayList<IDica>  dicasUsuais;
    private ArrayList<IDica> dicasUsadas;

    public CartaAbstrata(ArrayList<IDica> dicasUsuais) {
        this.dicasUsuais = dicasUsuais;
        this.dicasUsadas = new ArrayList<>();
    }

    @Override
    public ArrayList<IDica> getDicasUsuais() {
        return dicasUsuais;
    }

    public ArrayList<IDica> getDicasUsadas() {
        return dicasUsadas;
    }
    //precisamos desse set, para que na criação da carta, a quantida de dicas possa ser verificada
    //e só dps que as dicas(com valor válido) serão inclusas na carta.

    @Override
    public String getResposta() {
        return null;
    }

    @Override
    public String getTipo() {
        return null;
    }

    @Override
    public int getNumDicas() {
        return 5;
    }


}
