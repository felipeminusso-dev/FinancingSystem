package main;

import modelo.Apartamento;
import modelo.AumentoMaiorDoQueJurosException;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        boolean continuarCadastrando = true;

        while (continuarCadastrando) {
            double valorImovel = interfaceUsuario.pedirValorImovel();
            double taxaJuros = interfaceUsuario.pedirTaxaJuros();
            int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
            int tipoImovel = interfaceUsuario.pedirTipoImovel();

            Financiamento novoFinanciamento;

            switch (tipoImovel) {
                case 1:
                    double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                    double areaTerreno = interfaceUsuario.pedirAreaTerreno();
                    novoFinanciamento = new Casa(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, areaConstruida, areaTerreno);
                    break;
                case 2:
                    int numeroVagaGaragem = interfaceUsuario.pedirNumeroVagaGaragem();
                    int numeroAndar = interfaceUsuario.pedirNumeroAndar();
                    novoFinanciamento = new Apartamento(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, numeroVagaGaragem, numeroAndar);
                    break;
                default:
                    String tipoZona = interfaceUsuario.pedirTipoZona();
                    novoFinanciamento = new Terreno(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, tipoZona);
                    break;
            }

            listaFinanciamentos.add(novoFinanciamento);

            continuarCadastrando = interfaceUsuario.pedirContinuarCadastro();
        }

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        System.out.println("\n--- Detalhes dos Financiamentos ---");

        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            Financiamento financiamento = listaFinanciamentos.get(i);

            try {
                double valorFinanciamento = financiamento.totalPagamento();

                totalValorImoveis += financiamento.getValorImovel();
                totalValorFinanciamentos += valorFinanciamento;

                System.out.printf("Financiamento %d – valor do imóvel: R$ %.2f, valor do financiamento: R$ %.2f\n",
                        (i + 1), financiamento.getValorImovel(), valorFinanciamento);
                financiamento.getDetalhes();
            } catch (AumentoMaiorDoQueJurosException e) {
                System.out.println("Financiamento " + (i + 1) + " não pôde ser calculado: " + e.getMessage());
            }
        }

        System.out.println("-----------------------------------");
        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f\n",
                totalValorImoveis, totalValorFinanciamentos);

        salvarEmArquivoTexto(listaFinanciamentos);
        lerArquivoTexto();

        salvarFinanciamentosSerializados(listaFinanciamentos);
        lerFinanciamentosSerializados();
    }

    private static void salvarEmArquivoTexto(List<Financiamento> listaFinanciamentos) {
        String caminhoArquivo = "financiamentos.txt";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Financiamento financiamento : listaFinanciamentos) {
                try {
                    String linha = String.format("%.2f;%.2f;%.2f;%d;%s",
                            financiamento.getValorImovel(),
                            financiamento.totalPagamento(),
                            financiamento.getTaxaJurosAnual() * 100,
                            financiamento.getPrazoFinanciamento(),
                            financiamento.getAtributosEspecificos());

                    escritor.write(linha);
                    escritor.newLine();
                } catch (AumentoMaiorDoQueJurosException e) {
                    System.out.println("Não foi possível salvar um financiamento no arquivo: " + e.getMessage());
                }
            }

            System.out.println("\nDados salvos no arquivo de texto: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de texto: " + e.getMessage());
        }
    }

    private static void lerArquivoTexto() {
        String caminhoArquivo = "financiamentos.txt";

        System.out.println("\n--- Lendo o arquivo de texto para conferir ---");

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = leitor.readLine()) != null) {
                System.out.println("Linha " + numeroLinha + ": " + linha);
                numeroLinha++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de texto: " + e.getMessage());
        }
    }

    private static void salvarFinanciamentosSerializados(List<Financiamento> listaFinanciamentos) {
        String caminhoArquivo = "financiamentos.ser";

        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            saida.writeObject(listaFinanciamentos);
            System.out.println("\nLista de financiamentos serializada no arquivo: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar os financiamentos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void lerFinanciamentosSerializados() {
        String caminhoArquivo = "financiamentos.ser";

        System.out.println("\n--- Lendo o arquivo serializado para conferir ---");

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            List<Financiamento> listaLida = (List<Financiamento>) entrada.readObject();

            for (int i = 0; i < listaLida.size(); i++) {
                Financiamento financiamento = listaLida.get(i);
                System.out.printf("Financiamento %d (lido do arquivo serializado) – valor do imóvel: R$ %.2f\n",
                        (i + 1), financiamento.getValorImovel());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler os financiamentos serializados: " + e.getMessage());
        }
    }
}
