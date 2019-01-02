package br.com.pegasuswe.calculadora_fisioterapeuta.model;

public class Calculo implements Comparable<Calculo> {

    private long time;
    private String nomePaciente;
    private String calculo;
    private String resultado;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCalculo() {
        return calculo;
    }

    public void setCalculo(String calculo) {
        this.calculo = calculo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Calculo() {
    }

    public Calculo(long time, String nomePaciente, String calculo, String resultado) {
        this.time = time;
        this.nomePaciente = nomePaciente;
        this.calculo = calculo;
        this.resultado = resultado;
    }


    @Override
    public int compareTo(Calculo o) {
        if (this.time < o.getTime()) {
            return 1;
        }

        if (this.time > o.getTime()) {
            return -1;
        }

        return 0;
    }
}
