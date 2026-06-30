package Dominio;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Estoque {
    private int indice;
    private String[] produtos = new String[20];
    private double[] valor = new double[20];
    private int[] quantidade = new int[20];
    public Scanner sc = new Scanner(System.in);


        public String[] getProdutos () {
        return produtos;
    }

        public double[] getValor () {
        return valor;
    }


        public int[] getQuantidade () {
        return quantidade;
    }



        public void iniciarPrograma () {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("Selecione a função desejada");
            System.out.println("""
                    [1-Cadastrar Produto]
                    [2-Mostrar Estoque]
                    [3-Deletar Produto]
                    [4-Editar Produto]
                    [5-Sair]
                    """);

            int opcao = sc.nextInt();
                if(opcao > 5 || opcao < 1){
                    System.out.println("[ERRO]Opção invalida");
                }

            switch (opcao) {
                case 1:
                    CadastrarProduto();
                    break;
                case 2:
                    MostrarEstoque();
                    break;
                case 3:
                    DeletarProduto();
                    break;

                case 4:
                    EditarProduto();
                    break;

                case 5:
                    Sair();
                    return;
            }

        }


    }

        public void MostrarEstoque () {
        System.out.println("Estoque:");

            for (int i = 0; i < indice; i++) {
                System.out.println(
                        "ID: " + i +
                                "| Produto: " + produtos[i].toUpperCase() +
                                "| Valor: " + valor[i] +
                                "| Quantidade: " + quantidade[i]
                );
            }

    }

        public void CadastrarProduto () {
        if (indice == 20) {
            System.out.println("Seu estoque está cheio[Limite definido 20 itens]");
            System.out.println("-------------------------------------------------");
            return;
        }
        while (true) {
            System.out.println("Digite o nome do produto: ");
            String Produto;
            Produto = sc.next();
            this.produtos[indice] = Produto;

            System.out.println("Digite a quantidade produto: ");
            int Quantidade = sc.nextInt();
                if (Quantidade < 0){
                    System.out.println("Esse campo não pode ser Vazio");
                }
            this.quantidade[indice] = Quantidade;

            System.out.println("Digite o valor do produto: ");
            double Preco = sc.nextDouble();
                if (Preco < 0){
                    System.out.println("Esse campo não pode ser Vazio");
                }
            this.valor[indice] = Preco;


            System.out.println("Produto adicionado com sucesso!");
            indice++;
            System.out.println("ID: " + indice);
            System.out.println("Produto: " + Produto.toUpperCase());
            System.out.println("Quantidade: " + Quantidade);
            System.out.println("Preço: " + Preco + "$");
            System.out.println("---------------------------------------------");

            System.out.println("Deseja Adicionar Outro Produto? [1-SIM] [2-NÃO]");
            int opcao = sc.nextInt();
            if (opcao > 2 || opcao < 1) {
                System.out.println("[ERRO] Opção invalida");
            }
            if (opcao == 1) {
                continue;
            }


            break;
        }

    }

        public void EditarProduto () {
            MostrarEstoque();
            System.out.println("Digite o ID do produto: ");
            int Id = sc.nextInt();
                if (Id < 0 || Id > indice) {
                    System.out.println("[ERRO] Id invalido");
                }
            System.out.println("Produto selecionado com sucesso! " +  produtos[Id].toUpperCase()+" | " + quantidade[Id] +" | " + valor[Id]);
            System.out.println("Digite novo nome do produto: ");
            String Nome = sc.next();
            if (Nome == null){
                System.out.println("Esse campo nao pode ser Vazio");
            }
            this.produtos[Id] = Nome;

            System.out.println("Digite novo valor do produto: ");
            double valor = sc.nextDouble();
            if (valor == 0){
                System.out.println("Esse campo nao pode ser Vazio");
            }
            this.valor[Id] = valor;

            System.out.println("Digite nova quantidade do produto: ");
            int quantidade = sc.nextInt();
            if (quantidade == 0){
                System.out.println("Esse campo nao pode ser Vazio");
            }
            this.quantidade[Id] = quantidade;

            System.out.println("Produto editado com sucesso!");


        }


        public void DeletarProduto () {
        MostrarEstoque();
        System.out.println("----------------------------");
        System.out.print("Digite o ID do produto: ");

        int ID = sc.nextInt();


        if (ID < 0 || ID >= indice) {
            System.out.println("ID inválido!");
            return;
        }

        System.out.println("Produto " + produtos[ID] + " removido com sucesso!");


        for (int i = ID; i < indice - 1; i++) {
            produtos[i] = produtos[i + 1];
            quantidade[i] = quantidade[i + 1];
            valor[i] = valor[i + 1];
        }


        produtos[indice - 1] = null;
        quantidade[indice - 1] = 0;
        valor[indice - 1] = 0;

        indice--;
    }

        public void Sair () {
        System.out.println("----------------------------------------------");
        MostrarEstoque();
            System.out.println("----------------------------------------------");
    }





}

