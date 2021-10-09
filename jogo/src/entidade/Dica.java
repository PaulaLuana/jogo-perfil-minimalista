package entidade;

import organizacao_interface.IDica;
public class Dica implements IDica {
    private int tipo;
    private String texto;

    public Dica(int tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }


    @Override
    public String getTexto() {
        return texto;
    }

    public int getTipo() {
        return tipo;
    }

}
