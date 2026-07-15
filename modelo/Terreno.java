package modelo;

public class Terreno extends modelo.Financiamento {

    private String tipoZona;

    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, String tipoZona){
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.getTaxaJurosAnual() / 12)) * 1.02;
    }

    public void getDetalhes(){
        System.out.println("Este terreno é uma área " + this.tipoZona + ".");
    }

    public String getAtributosEspecificos() {
        return "Tipo de zona: " + this.tipoZona;
    }
}
