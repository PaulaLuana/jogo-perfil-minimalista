package controller;

import organizacao_interface.ICarta;
import organizacao_interface.IDica;

import java.util.Scanner;

public class Mediador {

    //O medidador é sempre o computador
    Scanner scan = new Scanner(System.in);
    ControllerDicas controllerDicas = ControllerDicas.getInstance();
    ControllerCarta controllerCarta = ControllerCarta.getInstance();

    private static Mediador MEDIADOR_INSTANCE;
    private Mediador(){}
    public static Mediador getInstance(){
        if(MEDIADOR_INSTANCE == null)
            MEDIADOR_INSTANCE = new Mediador();
        return MEDIADOR_INSTANCE;
    }

    //pede dica
    public IDica pedeDica(ICarta carta, int num){
        IDica dica = controllerDicas.retornaDica(carta, num);
        return dica;
    }

    //confere dica, ve se vai pedir palpite ou nao ao jogador
    public boolean confereDica(IDica dica){
        if(controllerDicas.verificaDica(dica)){
            return true;
        }
        return false;
    }

    //pede palpite ao jogador
    public String pedePalpite(){
        System.out.print("Palpite: ");
        String palpite = scan.nextLine();
        return palpite;
    }

    //confere se palpite está certo
    public boolean conferePalpite(ICarta c, String palpite){
        if(controllerCarta.verificaResposta(c, palpite)){
            return true;
        }
        return false;
    }





}
