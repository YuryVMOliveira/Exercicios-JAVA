package org.example;

public abstract class Slime {
    protected double vida;
    protected double multiplicadorDano;
    protected double resistencia;
    protected double energia;
    protected boolean energizado;
    protected boolean invulneravel ;
    protected boolean usouEspecial;


    public Slime(){
        this.vida = 10.0;
        this.multiplicadorDano = 1.0;
        this.resistencia = 0.0;
        this.energia = 5.0;
        this.energizado = false;
        this.invulneravel = false;
        this.usouEspecial = false;
    }
    public abstract void usarEspecial(Slime oponente);
    public boolean atacar(Slime oponente)
    {
        if (oponente.invulneravel) {
            System.out.println("Oponente invulnerável! Nenhum dano causado.");
            return true;
        }
        else if(energia>=1){
            double bonusEnergizar =this.energizado ? 0.5 : 0.0;
            double dano=this.multiplicadorDano-this.resistencia+bonusEnergizar;
            oponente.vida=oponente.vida-dano;
            energia-=1;
            return true;
        }else{
            System.out.println("Nao possui energia suficiente");
            return false;
        }

    }
    public boolean energizar(){
        if(energia>=2) {
            energizado = true;
            energia-=2;
            return true;
        }else{
            System.out.println("Nao possui energia suficiente");
            return false;
        }
    }
    public boolean estaVivo(){
        return vida > 0;
    }

    public void ganharEnergia(){
        if(invulneravel){
            multiplicadorDano -= 0.2;
        }
        energia=energia+2;
    }


    public double getVida() {
        return vida;
    }

    public void setInvulneravel(boolean invulneravel) {
        this.invulneravel = invulneravel;
    }
    public abstract String getHabilidade();

}
