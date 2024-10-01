package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        int vencedor;
        System.out.println(
                "Bem-vindo ao jogo de slimes\n" +
                "Regras:\n" +
                "Cada slime comeca com 10 de vida e 5 de energia\n" +
                "Cada slime tem 3 habilidades ativadas pelos seguintes comandos:\n" +
                "0: Termina o turno\n" +
                "1: Ataque\n" +
                "2: Energizar\n" +
                "3: Especial\n" +
                "Cada jogador pode escolher o ancestral do slime no comeco do jogo\n" +
                "Os Ancestrais disponiveis sao:\n" +
                "1 - Vampiro\n" +
                "2 - Dragao\n" +
                "3 - Sereia\n" +
                "4 - Anjo\n" +
                "5 - Demonio");
        Slime slimeA;
        Slime slimeB;
        //ESCOLHA JOGADOR A
        while(true){
            System.out.println("Escolha o Ancestral do A:");
            Scanner scanner = new Scanner(System.in);
            String valor=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[1-5]$");
            Matcher matcher=pattern.matcher(valor);
            if(matcher.find()){
                int nr=Integer.parseInt(valor);
                slimeA=escolherSlime(nr);
                break;
            }
            else{
                System.out.println("Valor incorreto digitado, DIGITE UM INTEIRO DE 1 A 5!");
            }
        }
        //ESCOLHA JOGADOR B
        while(true){
            System.out.println("Escolha o Ancestral do B:");
            Scanner scanner = new Scanner(System.in);
            String valor=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[1-5]$");
            Matcher matcher=pattern.matcher(valor);
            if(matcher.find()){
                int nr=Integer.parseInt(valor);
                slimeB=escolherSlime(nr);
                break;
            }
            else{
                System.out.println("Valor incorreto digitado, DIGITE UM INTEIRO DE 1 A 5!");
            }
        }
        System.out.println("-----------------------------------\n" +
                "INICIADO O JOGO\n" +
                "-----------------------------------");
        while(true){

            int escolha=-1;
            System.out.println("-----------------------------------\n" +
                    "TURNO DO SLIME A\n" +
                    "-----------------------------------");
                while(true) {
                    if(slimeA.energia==0){
                        break;
                    }
                    System.out.println("Vida atual dos SLimes: A: "+slimeA.getVida()+" B: "+slimeB.getVida());
                    System.out.println("Digite a habilidade para o slime A(A) usar: (energia restante: "+slimeA.energia+")");
                    System.out.println("0: Termina o turno\n" +
                            "1: Ataque\n" +
                            "2: Energizar\n" +
                            "3: Especial: "+slimeA.getHabilidade());
                    Scanner scanner = new Scanner(System.in);
                    String valor = scanner.nextLine();
                    Pattern pattern = Pattern.compile("^[0-3]$");
                    Matcher matcher = pattern.matcher(valor);
                    if (!matcher.find()) {
                        System.out.println("Digite um valor inteiro de 0 a 3!");

                    } else {
                        escolha = Integer.parseInt(valor);
                        if(escolha==0){
                            break;
                        }else if(escolha==1){
                            slimeA.atacar(slimeB);
                        }else if(escolha==2)    {
                            slimeA.energizar();
                        }
                        else if(escolha==3){
                            slimeA.usarEspecial(slimeB);
                        }
                    }
                    if(!slimeB.estaVivo()){
                        vencedor=0;
                        break;
                    }
                }
            if(!slimeA.estaVivo()){
                vencedor=0;
                break;
            }
            if(slimeB.invulneravel){
                    slimeB.setInvulneravel(false);
            }
            slimeA.energizado=false;
            slimeA.ganharEnergia();
            escolha=-1;
            System.out.println("-----------------------------------\n" +
                    "TURNO DO SLIME B\n" +
                    "-----------------------------------");
            while(true) {
                if(slimeB.energia==0){
                    break;
                }
                System.out.println("Vida atual dos SLimes: A: "+slimeA.getVida()+" B: "+slimeB.getVida());
                System.out.println("Digite a habilidade para o slime B(B) usar: (energia restante: "+slimeB.energia+")");
                System.out.println("0: Termina o turno\n" +
                        "1: Ataque\n" +
                        "2: Energizar\n" +
                        "3: Especial: "+slimeB.getHabilidade());
                Scanner scanner = new Scanner(System.in);
                String valor = scanner.nextLine();
                Pattern pattern = Pattern.compile("^[0-3]$");
                Matcher matcher = pattern.matcher(valor);
                if (!matcher.find()) {
                    System.out.println("Digite um valor inteiro de 0 a 3!");

                } else {
                    escolha = Integer.parseInt(valor);
                    if(escolha==0){
                        break;
                    }else if(escolha==1){
                        slimeB.atacar(slimeA);

                    }
                    else if(escolha==2)    {
                        slimeB.energizar();
                    }
                    else if(escolha==3){
                        slimeB.usarEspecial(slimeA);
                    }

                }
                if(!slimeA.estaVivo()){
                    vencedor=1;
                    break;
                }
            }
            slimeB.energizado=false;
            slimeB.ganharEnergia();
            if(!slimeA.estaVivo()){
                vencedor=1;
                break;
            }
            if(slimeA.invulneravel){
                slimeA.setInvulneravel(false);
            }

        }
        if(vencedor==0){
            System.out.println("-----------------------------------\n" +
                    "Slime A venceu\n" +
                    "-----------------------------------");
        }else{
                System.out.println("-----------------------------------\n" +
                        "Slime B venceu\n" +
                        "-----------------------------------");
        }

    }
    public static Slime escolherSlime(int ancestral){
        if(ancestral == 1){
            return new VampiroSlime();
        } else if (ancestral==2) {
            return new DragaoSlime();
        }else if(ancestral==3){
            return new SereiaSlime();
        }
        else if(ancestral==4){
            return new AnjoSlime();
        }else{
            return new DemonioSlime();
        }
    }
}