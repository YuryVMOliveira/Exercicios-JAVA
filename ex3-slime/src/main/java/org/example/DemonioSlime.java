package org.example;

public class DemonioSlime extends Slime{
    private String habilidade="Ganha 0.2 de multiplicador de dano permanentemente.";
    public void usarEspecial(Slime oponente){

        if(!this.usouEspecial) {
            if (this.energia >= 4) {
                this.usouEspecial = true;
                this.multiplicadorDano += 0.2;
                this.energia -= 4;
            } else {
                System.out.println("Nao possui energia suficiente!");
            }
        }
    }

    @Override
    public String getHabilidade() {
        return habilidade;
    }
}
