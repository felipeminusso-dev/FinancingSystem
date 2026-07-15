package modelo;

public class Apartamento extends modelo.Financiamento {

    private int numeroVagaGaragem;

    private int numeroAndar;

    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, int numeroVagaGaragem, int numeroAndar){
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.numeroVagaGaragem = numeroVagaGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double calcularPagamentoMensal(){
        return (this.valorImovel) * (1 + (this.getTaxaJurosAnual() * this.prazoFinanciamento)) / (this.prazoFinanciamento * 12);
    }

    public void getDetalhes(){
        System.out.println("Este apartamento tem " + this.numeroVagaGaragem + " vaga(s) de garagem e fica no " + this.numeroAndar + "° andar.");
    }

    public String getAtributosEspecificos() {
        return "Vagas de garagem: " + this.numeroVagaGaragem + "; Andar: " + this.numeroAndar;
    }
}
