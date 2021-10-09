package entidade;

import organizacao_interface.ICarta;

import java.util.ArrayList;

//uso de injeção de dependência
public class BancoDeCartas {
    private ArrayList<ICarta> cartasUsuais;
    private ArrayList<ICarta> cartasUsadas;

    public BancoDeCartas(ArrayList<ICarta> cartasUsuais){
        this.cartasUsuais = cartasUsuais;
        this.cartasUsadas = new ArrayList<ICarta>();
    }

        public ArrayList<ICarta> getCartasUsuais() {
        return cartasUsuais;
    }

    public ArrayList<ICarta> getCartasUsadas() {
        return cartasUsadas;
    }


}
