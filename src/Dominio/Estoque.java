package Dominio;
import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

public class Estoque {
    private int indice;
    private String[] produtos = new String[20];
    private double[] valor = new double[20];
    private int[] quantidade = new int[20];
    public Scanner sc = new Scanner(System.in);



    public String[] getProdutos() {
        return produtos;
    }

    public void setProdutos(String[] produtos) {
        this.produtos = produtos;
    }

    public double[] getValor() {
        return valor;
    }

    public void setValor(double[] valor) {
        this.valor = valor;
    }

    public int[] getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int[] quantidade) {
        this.quantidade = quantidade;
    }


    public void iniciarPrograma(){
       while (true){
           System.out.println("Selecione a função desejada");
           System.out.println("""
                [1-Cadastrar Produto]
                [2-Mostrar Estoque]
                [3-Deletar Produto]
                [4-Sair]
                """);
           int opcao = sc.nextInt();
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
                   Sair();
                   return;
           }
       }


    }

    public void MostrarEstoque() {
        System.out.println("Estoque selecionado:");
        for (int i = 0; i < indice; i++) {
            System.out.println(
                    "ID: " + i +
                            "| Produto: " + produtos[i].toUpperCase() +
                            "| Valor: " + valor[i] +
                            "| Quantidade: " + quantidade[i]
            );
        }

    }

    public void CadastrarProduto() {
      if (indice == 20){
          System.out.println("Seu estoque está cheio[Limite definido 20 itens]");
          System.out.println("-------------------------------------------------");
          return;
      }
       while (true) {
           indice++;
           System.out.println("Digite o nome do produto: ");
           String Produto;
           Produto = sc.next();

           this.produtos[indice] = Produto;
           System.out.println("Digite a quantidade produto: ");
           int Quantidade = sc.nextInt();
           this.quantidade[indice] = Quantidade;

           System.out.println("Digite o valor do produto: ");
           double Preco = sc.nextDouble();
           this.valor[indice] = Preco;


           System.out.println("Produto adicionado com sucesso!");
           System.out.println("ID: " + indice);
           System.out.println("Produto: " + Produto.toUpperCase());
           System.out.println("Quantidade: " + Quantidade);
           System.out.println("Preço: " + Preco + "$");
           System.out.println("---------------------------------------------");

           System.out.println("Deseja Adicionar Outro Produto? [1-SIM] [2-NÃO]");
           int opcao = sc.nextInt();
           if (opcao == 1) {
               continue;
           }
          // CriarArquivo();
           break;
       }
    }

    public void DeletarProduto() {
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
        //CriarArquivo();
    }

    public void Sair(){
        File file = new File("ListaDeProdutos/ListaDeProdutos.txt");
        System.out.println("Acesse sua lista em: " + file.getAbsolutePath() );
    }

 /* private void CriarArquivo(){
        File file = new File("ListaDeProdutos/ListaDeProdutos.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(FileWriter fileWriter = new FileWriter(file);) {
            for(int i = 0; i < indice; i++){
                fileWriter.write(
                        "ID: " + i +
                                "| Produto: " + produtos[i].toUpperCase() +
                                "| Valor: " + valor[i] +
                                "| Quantidade: " + quantidade[i] + "\n");

            }
            System.out.println("-------------------------------------------");
            System.out.println("Arquivo salvo com sucesso!");
        }catch (IOException e){
            e.printStackTrace();
        }



    }
*/













}
