package org.example;

public class SereiaSlime extends Slime{
    private String habilidade="Fica com 2 de energia para zerar a energia do alvo" +
            "(precisa de 6 de energia para usar).";
    public void usarEspecial(Slime oponente){

        if(!this.usouEspecial) {
            if (this.energia >= 6) {
                this.usouEspecial = true;
                this.energia = 2;
                oponente.energia = 0;
                System.out.println("Especial Sereia: Zera a energia do oponente.");

            }
            System.out.println("Nao possui energia suficiente!");
        }

    }

    @Override
    public String getHabilidade() {
        return habilidade;
    }
}
