package controller;

import entidade.*;
import organizacao_interface.ICarta;
import organizacao_interface.IDica;

import java.util.ArrayList;

public class ControllerCarta {

    int qDicas = 5;
    private static ControllerCarta CONTROLLER_CARTA_INSTANCE;

    private ControllerCarta(){}
    public static ControllerCarta getInstance(){
        if(CONTROLLER_CARTA_INSTANCE == null)
            CONTROLLER_CARTA_INSTANCE = new ControllerCarta();
        return CONTROLLER_CARTA_INSTANCE;
    }
    //responsável por criar cartas
    public ICarta criaCarta(ArrayList<IDica> dicas, String tipo, String resposta){
        ICarta carta;
        tipo = tipo.toLowerCase();

        if(tipo.equals("pessoa")){
            carta = new CartaPessoa(dicas, resposta);
        }else if(tipo.equals("coisa")){
            carta = new CartaCoisa(dicas, resposta);
        }else if(tipo.equals("lugar")){
            carta = new CartaLugar(dicas, resposta);
        }else if(tipo.equals("ano")){
            carta = new CartaAno(dicas, resposta);
        }else{
            return null;
        }

        if(dicas.size() > carta.getNumDicas()){
            return null;
        }
        return carta;
    }

    public boolean usaCarta(Jogo jogo, ICarta carta){
        for(int i = 0; i < jogo.getBanco().getCartasUsuais().size(); i++){
            if(jogo.getBanco().getCartasUsuais().get(i) == carta){
                jogo.getBanco().getCartasUsuais().remove(carta);
                jogo.getBanco().getCartasUsadas().add(carta);
                return true;
            }
        }
        return false;
    }

    public boolean verificaResposta(ICarta c, String resposta){
        String r1= resposta.toLowerCase();
        String r2 = c.getResposta().toLowerCase();
        if(r1.equals(r2)){
            return true;
        }
        return false;
    }

    public ArrayList<ICarta> addCartasDoJogo(){
        ControllerDicas controllerDicas = ControllerDicas.getInstance();
        ControllerCarta controllerCarta = new ControllerCarta();
        ArrayList<ICarta> cartas = new ArrayList<ICarta>();
        ArrayList<IDica> carta1 = new ArrayList<>();
        //ano 1964
        IDica c1d1 = controllerDicas.criaDica(1, "Constantino II se torna Rei da Grécia");
        IDica c1d2 = controllerDicas.criaDica(1, "Castelo Branco toma posse como Presidente do Brasil após uma eleição indireta");
        IDica c1d3 = controllerDicas.criaDica(2, "Perca a vez");
        IDica c1d4 = controllerDicas.criaDica(1, "O Presidente Democrata Lyndon B. Johnson é reeleito Presidente dos Estados Unidos com maioria esmagadora dos votos");
        IDica c1d5 = controllerDicas.criaDica(1, "Início da ditadura no Brasil");
        carta1.add(c1d1);
        carta1.add(c1d2);
        carta1.add(c1d3);
        carta1.add(c1d4);
        carta1.add(c1d5);

        ICarta _carta1 = controllerCarta.criaCarta(carta1, "ano", "1964");
        cartas.add(_carta1);

        //-------------------nova carta------------------------------
        ArrayList<IDica> carta2 = new ArrayList<>();

        //pessoa Machado de Assis
        IDica c2d1 = controllerDicas.criaDica(1, "Sou um escritor brasileiro");
        IDica c2d2 = controllerDicas.criaDica(1, "Considerado o introdutor do Realismo no Brasil");
        IDica c2d3 = controllerDicas.criaDica(1, "Escreveu Memórias Póstumas de Brás Cubas");
        IDica c2d4 = controllerDicas.criaDica(1, "Sua obra foi de fundamental importância para as escolas literárias brasileiras.");
        IDica c2d5 = controllerDicas.criaDica(2, "Perca a vez");
        carta2.add(c2d1);
        carta2.add(c2d2);
        carta2.add(c2d3);
        carta2.add(c2d4);
        carta2.add(c2d5);

        ICarta _carta2 = controllerCarta.criaCarta(carta2, "pessoa", "Machado de Assis");
        cartas.add(_carta2);

        //-------------------nova carta------------------------------
        ArrayList<IDica> carta3 = new ArrayList<>();
        //lugar Bahia
        IDica c3d1 = controllerDicas.criaDica(1, "É o mais antigo estado brasileiro");
        IDica c3d2 = controllerDicas.criaDica(2, "Perca a vez");
        IDica c3d3 = controllerDicas.criaDica(1, "Tem as maiores e mais produtivas lavouras de cacau do País");
        IDica c3d4 = controllerDicas.criaDica(1, "É um importante polo petroquímico.");
        IDica c3d5 = controllerDicas.criaDica(1, "O mais populoso da região Nordeste");
        carta3.add(c3d1);
        carta3.add(c3d2);
        carta3.add(c3d3);
        carta3.add(c3d4);
        carta3.add(c3d5);

        ICarta _carta3 = controllerCarta.criaCarta(carta3, "lugar", "Bahia");
        cartas.add(_carta3);

        //-------------------nova carta------------------------------
        ArrayList<IDica> carta4 = new ArrayList<>();
        //coisa Relógio
        IDica c4d1 = controllerDicas.criaDica(1, "Posso estar no pulso, na parede e até no seu bolso.");
        IDica c4d2 = controllerDicas.criaDica(1, "Não sou muito visto em shoppings.");
        IDica c4d3 = controllerDicas.criaDica(1, "Posso ser de sol, água, areia ou mecânico.");
        IDica c4d4 = controllerDicas.criaDica(2, "Perca a vez.");
        IDica c4d5 = controllerDicas.criaDica(1, "Comecei a estar em pulsos em 1814.");
        carta4.add(c4d1);
        carta4.add(c4d2);
        carta4.add(c4d3);
        carta4.add(c4d4);
        carta4.add(c4d5);
        ICarta _carta4 = controllerCarta.criaCarta(carta4, "coisa", "Relógio");
        cartas.add(_carta4);

        //-------------------nova carta------------------------------
        ArrayList<IDica> carta5 = new ArrayList<>();

        //coisa Monalisa
        IDica c5d1 = controllerDicas.criaDica(1, "Eu retrato a figura de uma mulher com sorriso enigmático.");
        IDica c5d2 = controllerDicas.criaDica(2, "Perca a vez");
        IDica c5d3 = controllerDicas.criaDica(1, "Sou um dos quadros mais famosos do mundo.");
        IDica c5d4 = controllerDicas.criaDica(1, "Atualmente, estou exposta no Museu do Louvre, em Paris.");
        IDica c5d5 = controllerDicas.criaDica(1, "Fui feita por um dos pintores mais conhecidos do renascimento italiano.");
        carta5.add(c5d1);
        carta5.add(c5d2);
        carta5.add(c5d3);
        carta5.add(c5d4);
        carta5.add(c5d5);

        ICarta _carta5 = controllerCarta.criaCarta(carta5, "coisa", "Monalisa");
        cartas.add(_carta5);

        //-------------------nova carta------------------------------
        ArrayList<IDica> carta6 = new ArrayList<>();

        //Pessoa homem-aranha
        IDica c6d1 = controllerDicas.criaDica(1, "Tenho sexto sentido.");
        IDica c6d2 = controllerDicas.criaDica(2, "Perca a vez");
        IDica c6d3 = controllerDicas.criaDica(1, "Fui picado por uma aranha.");
        IDica c6d4 = controllerDicas.criaDica(1, "Sou um herói da marvel.");
        IDica c6d5 = controllerDicas.criaDica(1, "Tenho a capacidade de me agarrar nas paredes.");
        carta6.add(c6d1);
        carta6.add(c6d4);
        carta6.add(c6d3);
        carta6.add(c6d2);
        carta6.add(c6d5);

        ICarta _carta6 = controllerCarta.criaCarta(carta6, "pessoa", "homem-aranha");
        cartas.add(_carta6);

        return cartas;
    }


}
