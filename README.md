# Sistema de Financiamento Imobiliário

Projeto desenvolvido na disciplina de **Programação Orientada a Objetos** aplicando os principais conceitos do paradigma: herança, polimorfismo e encapsulamento.

O sistema simula financiamentos de diferentes tipos de imóveis, calculando parcelas mensais e o total pago ao final do contrato com base em regras de negócio específicas para cada tipo.

---

## Funcionalidades

- Entrada de dados pelo usuário com validação (valor, prazo e taxa de juros)
- Cálculo de parcela mensal e total do financiamento por tipo de imóvel
- Suporte a três tipos de imóvel: Casa, Apartamento e Terreno
- Listagem consolidada com soma total dos imóveis e dos financiamentos
- Armazenamento em ArrayList polimórfico

---

## Regras de negócio

| Tipo        | Regra de cálculo                                                            |
|-------------|-----------------------------------------------------------------------------|
| Casa        | Parcela padrão com juros + R$ 240,00 de seguro obrigatório                  |
| Apartamento | Total = valor × (1 + taxa anual × prazo em anos); parcela = total ÷ meses  |
| Terreno     | Parcela padrão com juros + acréscimo de 2% (risco de inadimplência)         |

---

## Conceitos de POO aplicados

- **Herança**: `Casa`, `Apartamento` e `Terreno` estendem a classe `Financiamento`
- **Polimorfismo**: cada subclasse sobrescreve `calcularPagamentoMensal()` com sua regra própria
- **Encapsulamento**: atributos `protected` com métodos getters
- **ArrayList polimórfico**: todos os tipos armazenados em `List<Financiamento>`

---

## Estrutura do projeto

```
src/
├── main/
│   └── Main.java               # Ponto de entrada, lista de financiamentos
├── modelo/
│   ├── Financiamento.java      # Classe base com cálculo padrão
│   ├── Casa.java               # Sobrescreve parcela com seguro obrigatório
│   ├── Apartamento.java        # Cálculo alternativo de total e parcela
│   └── Terreno.java            # Sobrescreve parcela com acréscimo de 2%
└── util/
    └── InterfaceUsuario.java   # Leitura e validação de entrada do usuário
```

---

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/FinancingSystemJava.git
```

2. Abra no IntelliJ IDEA

3. Execute a classe `Main.java`

4. Informe os dados do primeiro financiamento quando solicitado

---

## Tecnologias

- Java 17+
- IntelliJ IDEA
- Git / GitHub

---

## Sobre

Projeto acadêmico do 1º semestre — disciplina de Programação Orientada a Objetos.
