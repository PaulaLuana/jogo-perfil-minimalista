package controller;

import entidade.*;
import organizacao_interface.ICarta;
import organizacao_interface.IDica;

public class ControllerDicas {

    private static ControllerDicas CONTROLLER_DICAS_INSTANCE;

    private ControllerDicas(){}
    public static ControllerDicas getInstance(){
        if(CONTROLLER_DICAS_INSTANCE == null)
            CONTROLLER_DICAS_INSTANCE = new ControllerDicas();
        return CONTROLLER_DICAS_INSTANCE;
    }
    public IDica criaDica(int tipo, String texto){
        Dica f = new Dica(tipo, texto);
        return f;
    }

    public IDica retornaDica(ICarta carta, int i){
        i -= 1;
        if((i >= carta.getNumDicas()) || (carta.getDicasUsuais().get(i).getTexto().equals(""))){
            return null;
        }
        IDica dica = carta.getDicasUsuais().get(i);
        return dica;
    }

    public ICarta removeDica(ICarta carta, IDica dica){
        carta.getDicasUsuais().remove(dica);
        carta.getDicasUsadas().add(dica);

        return carta;
    }



    public boolean temDica(ICarta carta){
        for(IDica i: carta.getDicasUsuais()){
            if(!i.getTexto().equals("")){
                return true;
            }
        }
        return false;
    }


    //verifica se dica é ação ou frase para poder pedir palpite
    //se verifica retornar true, pode pedir palpite
    //false - pula o jogador
    public boolean verificaDica(IDica dica){
        if(dica.getTipo() == 1){
            return true;
        }
        return false;
    }

    //Essa função vai servir quando quisermos calcular o quanto um jogador que acertou vai andar
    public int dicasUsuaisSize(ICarta carta){
        return carta.getDicasUsuais().size() - carta.getDicasUsadas().size();
    }

    //usamos um vetor em dicas disponíveis para não perder as númerações das dicas
    //mostra os números de dicas que estão disponíves
    public void mostraDicasDisponiveis(ICarta carta){
        System.out.print("Números das dicas disponíveis: ");
        for (int i = 0; i < carta.getDicasUsuais().size(); i++){
            if(!carta.getDicasUsuais().get(i).getTexto().equals("")){
                System.out.print(i+1 + " ");
            }
        }
        System.out.println();
    }

}
