package modelo;

public class Casa extends modelo.Financiamento {

    private double areaConstruida;

    private double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, double areaConstruida, double areaTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double calcularPagamentoMensal(){
        double pagamentoBase = this.valorImovel / (this.prazoFinanciamento * 12);
        double jurosMensal = pagamentoBase * (this.getTaxaJurosAnual() / 12);
        double acrescimo = 240;

        if (acrescimo > jurosMensal / 2) {
            throw new AumentoMaiorDoQueJurosException(
                    "O acréscimo de R$ " + acrescimo + " é maior do que a metade dos juros da mensalidade (R$ "
                            + String.format("%.2f", jurosMensal / 2) + ").");
        }

        return pagamentoBase * (1 + (this.getTaxaJurosAnual() / 12)) + acrescimo;
    }

    public void getDetalhes(){
        System.out.println("Esta casa tem uma área de " + this.areaConstruida + " e um terreno de " + this.areaTerreno + ".");
    }

    public String getAtributosEspecificos() {
        return "Área construída: " + this.areaConstruida + " m²; Área do terreno: " + this.areaTerreno + " m²";
    }
}
