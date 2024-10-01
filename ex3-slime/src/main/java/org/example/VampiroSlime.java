package org.example;

import java.sql.SQLOutput;

public class VampiroSlime extends Slime{
    private String habilidade="Causa 2 de dano e recupera 1 de vida.";
    public void usarEspecial(Slime oponente) {
        if (!this.usouEspecial) {
            if (this.energia >= 4) {
                this.usouEspecial=true;
                oponente.vida -= 2;
                this.vida += 1;
                this.energia -= 4;
                System.out.println("Especial Vampiro: Causa 2 de dano e recupera 1 de vida.");

            }
            System.out.println("Nao possui energia suficiente!");
        }
    }

    @Override
    public String getHabilidade() {
        return habilidade;
    }
}
