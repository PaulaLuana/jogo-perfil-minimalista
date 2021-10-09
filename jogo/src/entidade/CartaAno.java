package entidade;

import classes_abstratas.CartaAbstrata;
import organizacao_interface.IDica;

import java.util.ArrayList;

public class CartaAno extends CartaAbstrata {
    private String resposta;

    public CartaAno(ArrayList<IDica> dicasUsuais, String resposta) {
        super(dicasUsuais);
        this.resposta = resposta;
    }

    @Override
    public String getResposta() {
        return resposta;
    }

    @Override
    public String getTipo(){
        return "ano";
    }
}
