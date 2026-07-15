package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos da classe
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual / 100;
    }

    // Construtor
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnual;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos
    public abstract double calcularPagamentoMensal();

    public double totalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12;
    }

    public abstract void getDetalhes();

    public abstract String getAtributosEspecificos();
}
