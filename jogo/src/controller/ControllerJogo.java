package controller;

import entidade.*;
import organizacao_interface.ICarta;
import organizacao_interface.IDica;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerJogo {
    private ControllerCarta controllerCarta = ControllerCarta.getInstance();
    private ControllerJogador controllerJogador = ControllerJogador.getInstance();
    private ControllerTabuleiro controllerTabuleiro = ControllerTabuleiro.getInstance();
    private ControllerBancoDeCartas controllerBancoDeCartas = ControllerBancoDeCartas.getInstance();
    private ControllerDicas controllerDicas = ControllerDicas.getInstance();
    private ControllerCasa controllerCasa = ControllerCasa.getInstance();
    private Mediador mediador = Mediador.getInstance();
    Scanner scan = new Scanner(System.in);

    public void jogo() {
        System.out.println("--------JOGO PERFIL--------" +
                "\nSeja bem vindo ao jogo!" +
                "\nInformações importantes:" +
                "\n1. Nesse jogo o computador sempre é o mediador." +
                "\n2. Todos os jogadores iniciam na casa 0 do tabuleiro." +
                "\nTenha um bom jogo!");
        System.out.print("Quantidade de jogadores: ");
        int qJogadores = scan.nextInt();
        scan.nextLine();
        System.out.println();
        Jogo jogo = inicializa(qJogadores);
        controllerTabuleiro.mostraTabuleiro(jogo.getTabuleiro());
        Jogador atual = jogo.getJogadors().get(0);
        int ultimaCasa = jogo.getTabuleiro().getQuantidadeDeCasas() - 1;
        Jogador computador = jogo.getJogadors().get(0);
        Casa chegada = jogo.getTabuleiro().getCasas().get(ultimaCasa);

        //enquanto tivermos cartas no banco e ninguém tiver chegado na linha de chegada, fazemos o loop
        while ((jogo.getBanco().getCartasUsuais().size() > 0) && (chegada.getJogadors().size() == 0)) {
            ICarta carta = controllerBancoDeCartas.sorteio(jogo.getBanco());
            controllerCarta.usaCarta(jogo, carta);
            System.out.println("A carta foi sorteada seu tipo é: " + carta.getTipo());
            atual = rodada(jogo, carta, atual, computador);
        }
        System.out.println("--------FIM DE JOGO--------");
    }


    public Jogo inicializa(int qJogadores) {
        ArrayList<ICarta> cartas = controllerCarta.addCartasDoJogo();
        ArrayList<Jogador> jogadors = controllerJogador.addJogadoresNoJogo(qJogadores);
        BancoDeCartas bancoDeCartas = new BancoDeCartas(cartas);
        Tabuleiro tabuleiro = controllerTabuleiro.iniciaTabuleiro();
        tabuleiro.setCasas(controllerCasa.inicializaCasas(tabuleiro.getCasas(), jogadors));
        Jogo jogo = new Jogo(bancoDeCartas, tabuleiro, jogadors);
        return jogo;
    }

    public Jogador rodada(Jogo jogo, ICarta carta, Jogador atual, Jogador computador) {
        boolean acertouCarta = false;
        int casa;
        int casaComputador;
        while (controllerDicas.temDica(carta) && acertouCarta == false) {
            atual = controllerJogador.controlaVez(jogo.getJogadors(), atual);
            System.out.println("--------------------------------------" +
                    "\n" + atual.getId() + ": " +
                    "\n--------------------------------------");
            controllerDicas.mostraDicasDisponiveis(carta);
            System.out.print("Número da dica: ");
            int num = scan.nextInt();
            scan.nextLine();
            IDica dica = mediador.pedeDica(carta, num);
            controllerDicas.removeDica(carta, dica);
            System.out.println(dica.getTexto());
            if (mediador.confereDica(dica)) {//se for uma frase a gente continua
                String palpite = mediador.pedePalpite();
                acertouCarta = mediador.conferePalpite(carta, palpite);
                if (acertouCarta) {
                    casa = controllerTabuleiro.andaNoTabuleiro(jogo.getTabuleiro(), carta, atual);
                    casaComputador = controllerTabuleiro.computadorAndaNoTabuleiro(jogo.getTabuleiro(), carta, computador);
                    System.out.println("Resposta correta!");
                    System.out.println("O jogador anda para a casa " + casa + " e o computador para a casa " + casaComputador);
                    controllerTabuleiro.mostraTabuleiro(jogo.getTabuleiro());
                    controllerTabuleiro.linhaDeChegada(jogo.getTabuleiro(), casa, atual);
                } else {
                    System.out.println("Resposta incorreta.");
                }

            }



        }
        if (!controllerDicas.temDica(carta)) {//significa que as dicas acabaram e ninguém acertou
            casaComputador = controllerTabuleiro.computadorAndaNoTabuleiro(jogo.getTabuleiro(), carta, computador);
            controllerTabuleiro.mostraTabuleiro(jogo.getTabuleiro());
            System.out.println("O computador anda para casa " + casaComputador);
            controllerTabuleiro.linhaDeChegada(jogo.getTabuleiro(), casaComputador, atual);

        }
        return atual;

    }
}
