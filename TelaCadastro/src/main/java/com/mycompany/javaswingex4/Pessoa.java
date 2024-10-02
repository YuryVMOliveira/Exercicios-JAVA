package com.mycompany.javaswingex4;

public class Pessoa {
    private String nome;
    private int idade;
    private DataNascimento dataNascimento;
    private CPF cpf;

    public Pessoa(String nome, DataNascimento dataNascimento, CPF cpf) {
        this.nome = nome;
        this.idade = dataNascimento.getIdade();
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public DataNascimento getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setDataNascimento(DataNascimento dataNascimento) {
        this.idade = dataNascimento.getIdade();
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
}
