package org.example;

public class AnjoSlime extends Slime{
    private String habilidade="Ganha 0.2 de resistência pelo resto do jogo.";
    public void usarEspecial(Slime oponente){
        if(!this.usouEspecial) {
            if (this.energia >= 4) {
                this.usouEspecial = true;
                this.resistencia += 0.2;
                this.energia -= 4;
            }
            System.out.println("Nao possui energia suficiente!");
        }
    }

    public String getHabilidade() {
        return habilidade;
    }
}

