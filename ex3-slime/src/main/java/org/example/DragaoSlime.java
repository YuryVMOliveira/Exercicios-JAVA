package org.example;

public class DragaoSlime extends Slime{

    private String habilidade="Ganha 0.2 de multiplicador de dano e invulnerabilidade por um turno";
    public void usarEspecial(Slime oponente) {
        if (!this.usouEspecial) {
            if (this.energia >= 4) {
                this.usouEspecial = true;
                this.multiplicadorDano += 0.2;
                this.invulneravel = true;
                this.energia -= 4;

            }
            System.out.println("Nao possui energia suficiente!");

        }
    }

    @Override
    public String getHabilidade() {
        return habilidade;
    }
}
