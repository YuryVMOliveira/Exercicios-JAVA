package com.mycompany.javaswingex4;

import com.mycompany.javaswingex4.DataNascimentoException;

import java.time.LocalDate;

public class DataNascimento {
    private String data;

    DataNascimento(String data) {
        this.data = data;
    }

    public static DataNascimento parser(String data) throws DataNascimentoException {
        if(data.matches("^(0?[1-9]|[12][0-9]|30)/(0?[1-9]|(1[0-2]))/(19\\d{2}|20[01]\\d|202[0-4])$")){
            return new DataNascimento(data);
        }
        throw new DataNascimentoException();
    }

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        int dia = dataAtual.getDayOfMonth();
        int mes = dataAtual.getMonthValue();
        int ano = dataAtual.getYear();

        String [] datas = data.split("/");
        int diar = Integer.parseInt(datas[0]), mesr = Integer.parseInt(datas[1]), anor = Integer.parseInt(datas[2]);

        if(anor<ano){
            if(mesr<mes)
                return ano-anor;
            else if (mesr==mes) {
                if(diar<=dia)
                    return ano-anor;
                else
                    return ano-anor-1;
            }
            else
                return ano-anor-1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return data;
    }
}