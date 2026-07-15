package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario{

    private Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valorImovel = 0;
        boolean valorValido = false;

        do{
            try {
                System.out.println("Digite o valor do Imóvel: ");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    System.out.println("O valor não pode ser negativo ou zero.");
                } else {
                    valorValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // limpa o texto inválido que ficou preso no Scanner
            }
        } while (!valorValido);

        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazoFinanciamento = 0;
        boolean prazoValido = false;

        do{
            try {
                System.out.println("Digite o prazo do financiamento em anos: ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0) {
                    System.out.println("O valor não pode ser negativo ou zero.");
                } else {
                    prazoValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        } while (!prazoValido);

        return prazoFinanciamento;
    }

    public double pedirTaxaJuros() {
        double taxaJurosAnual = 0;
        boolean taxaValida = false;

        do{
            try {
                System.out.println("Digite a porcentagem da taxa de juros: ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0){
                    System.out.println("A taxa de juros não pode ser zero ou negativa.");
                } else if (taxaJurosAnual > 12) {
                    System.out.println("A porcentagem de juros excede o limite. A taxa máxima é de 12%.\nPor favor tente novamente.");
                } else {
                    taxaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        } while (!taxaValida);

        return taxaJurosAnual;
    }

    public int pedirTipoImovel() {
        int tipo = 0;
        boolean tipoValido = false;

        do {
            try {
                System.out.println("\nQual tipo de imóvel deseja cadastrar?");
                System.out.println("1 - Casa");
                System.out.println("2 - Apartamento");
                System.out.println("3 - Terreno");
                tipo = scanner.nextInt();

                if (tipo < 1 || tipo > 3) {
                    System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
                } else {
                    tipoValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                scanner.nextLine();
            }
        } while (!tipoValido);

        return tipo;
    }

    public double pedirAreaConstruida() {
        double area = 0;
        boolean areaValida = false;

        do {
            try {
                System.out.println("Digite a área construída (em m²): ");
                area = scanner.nextDouble();

                if (area <= 0) {
                    System.out.println("A área não pode ser negativa ou zero.");
                } else {
                    areaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        } while (!areaValida);

        return area;
    }

    public double pedirAreaTerreno() {
        double area = 0;
        boolean areaValida = false;

        do {
            try {
                System.out.println("Digite o tamanho do terreno (em m²): ");
                area = scanner.nextDouble();

                if (area <= 0) {
                    System.out.println("A área não pode ser negativa ou zero.");
                } else {
                    areaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        } while (!areaValida);

        return area;
    }

    public int pedirNumeroVagaGaragem() {
        int vagas = 0;
        boolean vagasValidas = false;

        do {
            try {
                System.out.println("Digite o número de vagas da garagem: ");
                vagas = scanner.nextInt();

                if (vagas < 0) {
                    System.out.println("O número de vagas não pode ser negativo.");
                } else {
                    vagasValidas = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        } while (!vagasValidas);

        return vagas;
    }

    public int pedirNumeroAndar() {
        int andar = 0;
        boolean andarValido = false;

        do {
            try {
                System.out.println("Digite o número do andar: ");
                andar = scanner.nextInt();

                if (andar <= 0) {
                    System.out.println("O andar deve ser maior que zero.");
                } else {
                    andarValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        } while (!andarValido);

        return andar;
    }

    public String pedirTipoZona() {
        String zona = "";
        boolean zonaValida = false;

        do {
            try {
                System.out.println("Digite o tipo de zona do terreno (ex: Residencial ou Comercial): ");
                zona = scanner.next();
                zonaValida = true;
            } catch (Exception e) {
                System.out.println("Não foi possível ler o tipo de zona. Tente novamente.");
                scanner.nextLine();
            }
        } while (!zonaValida);

        return zona;
    }

    public boolean pedirContinuarCadastro() {
        String resposta = "N";

        try {
            System.out.println("\nDeseja cadastrar outro financiamento? (S/N): ");
            resposta = scanner.next();
        } catch (Exception e) {
            System.out.println("Não foi possível ler sua resposta. Assumindo 'não'.");
            scanner.nextLine();
        }

        return resposta.equalsIgnoreCase("S");
    }
}
