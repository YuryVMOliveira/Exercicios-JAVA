package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoDaVelha {
    //tabuleiro iniciado com todas posicoes com espaco
    private char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    //jogador sendo X ou O
    private char[] jogador = new char[2];
    //lista para armazenar todas jogadas validas realizadas
    private List<String> jogadasValidas = new ArrayList<>();


    public void jogar() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("              Jogo Da Velha                   ");
        System.out.println("----------------------------------------------");
        System.out.println("Bem vindo!");
        int modoDeJogo;
        while (true) {
            System.out.println("Deseja jogar contra humano(1) ou robo(2)?");
            String input = scanner.nextLine();
            modoDeJogo = Integer.parseInt(input);
            if (modoDeJogo == 1 || modoDeJogo == 2) {
                break;
            } else {
                System.out.println("Valor digitado incorreto!");
            }
        }
        escolherCaractere();
        //jogadar contra humano
        imprimirTabuleiro(tabuleiro);
        if (modoDeJogo == 1) {
            for (int i = 0; i < 9; i++) {

                int x = i % 2;
                jogadaHumana(x);
                if (verificaGanhadorRetornaTrue()) {
                    System.out.println("Jogador " +(x+1)+ " venceu!!!");
                    break;
                }
            }
            if (!verificaGanhadorRetornaTrue()) {
                System.out.println("Jogo empatado!!!");
            }

            //jogar contra robo
        } else {
            for (int i = 0; i < 9; i++) {

                int x = i % 2;
                if(i%2==0) {
                    jogadaHumana(x);

                    if (verificaGanhadorRetornaTrue()) {
                        System.out.println("Jogador " + (x + 1) + " venceu!!!");
                        break;
                    }
                }
                    else {
                    jogadaRobo();
                    if (verificaGanhadorRetornaTrue()) {
                        System.out.println("Robo venceu!!!");
                        break;
                    }
                }

            }
            if (!verificaGanhadorRetornaTrue()) {
                System.out.println("Jogo empatado!");
            }
        }
    }

    private void jogadaHumana(int nr) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Em qual posicao deseja jogar, jogador numero " + (nr + 1) + " ? Digite no formato x,y ");
            String input = scanner.nextLine();
            String[] partes = input.split(",");

            if (partes.length != 2) {
                System.out.println("Entrada invalida. Por favor, use o formato x,y.");
                continue;
            } else {
                int x = Integer.parseInt(partes[0].trim());
                int y = Integer.parseInt(partes[1].trim());
                if (validaPosicao(x, y)) {
                    tabuleiro[x][y] = jogador[nr];
                    imprimirTabuleiro(tabuleiro);
                    jogadasValidas.add("(" + x + "," + y + ")");
                    break;
                }
                else{
                    continue;
                }

            }
        }
    }


    private void jogadaRobo() {
        while (true) {

            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (tabuleiro[x][y] == ' ') {
                System.out.println("Vez do Robo");
                tabuleiro[x][y] = jogador[1];
                imprimirTabuleiro(tabuleiro);
                jogadasValidas.add("(" + x + "," + y + ")");
                System.out.println("O robo jogou na posicao x: " + x + ", y: " + y);
                break;
            }
        }
    }

    private void escolherCaractere() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jogador 1 deseja ser X OU O?");
        while (true) {
            String input = scanner.nextLine();
            char caracter = input.charAt(0);
            if (caracter == 'X' || caracter == 'O' || caracter == 'x' || caracter == 'o') {
                jogador[0] = caracter;
                if (caracter == 'X' || caracter == 'x') {
                    jogador[1] = 'O';
                } else {
                    jogador[1] = 'X';
                }
                break;
            }
            System.out.println("Valor incorreto! X OU O?");
        }
    }

    private boolean verificaGanhadorRetornaTrue() {
        for (int i = 0; i < 3; i++) {
            //Verifica linhas e colunas
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return true;
            }
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ') {
                return true;
            }

        }
        // Verificar diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') {
            return true;
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ') {
            return true;
        }
        return false;
    }

    private boolean validaPosicao(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            if (tabuleiro[x][y] == ' ') return true;
            else {
                System.out.println("Posicao ja ocupada!");
                return false;
            }
        } else {
            System.out.println("Valor nao pertence ao intervalo 0<=x<=2 , 0<=y<=2");
            return false;
        }
    }

    private void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }

    }

    public void imprimirListaJogadas() {
        System.out.println("Jogadas válidas realizadas:");
        for (String jogada : jogadasValidas) {
            System.out.println(jogada);
        }
    }
}