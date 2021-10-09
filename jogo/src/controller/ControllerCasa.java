package controller;

import entidade.Casa;
import entidade.Jogador;

import java.util.ArrayList;

public class ControllerCasa {

    private static ControllerCasa CONTROLLER_CASA_INSTANCE;

    private ControllerCasa(){}
    public static ControllerCasa getInstance(){
        if(CONTROLLER_CASA_INSTANCE == null)
            CONTROLLER_CASA_INSTANCE = new ControllerCasa();
        return CONTROLLER_CASA_INSTANCE;
    }
    public ArrayList<Casa> inicializaCasas(ArrayList<Casa> casas, ArrayList<Jogador> jogadors){
        for(int i = 0; i < casas.size(); i++){
            casas.get(i).setNumero(i);
        }
        for(Jogador jogador: jogadors)
            casas.get(0).getJogadors().add(jogador);
        return casas;
    }
}
