package controller;
import entidade.BancoDeCartas;
import organizacao_interface.ICarta;

import java.util.Random;

public class ControllerBancoDeCartas {

    private static ControllerBancoDeCartas CONTROLLER_BANCO_DE_CARTAS_INSTANCE;

    private ControllerBancoDeCartas(){}
    public static ControllerBancoDeCartas getInstance(){
        if(CONTROLLER_BANCO_DE_CARTAS_INSTANCE == null)
            CONTROLLER_BANCO_DE_CARTAS_INSTANCE = new ControllerBancoDeCartas();
        return CONTROLLER_BANCO_DE_CARTAS_INSTANCE;
    }
    public ICarta sorteio(BancoDeCartas bancoDeCartas){
        Random r = new Random();
        int n = r.nextInt(bancoDeCartas.getCartasUsuais().size());
        ICarta s = bancoDeCartas.getCartasUsuais().get(n);
        return s;
    }
}
