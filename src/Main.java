import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree arvoreBinaria = new BinaryTree();

        int escolha = 0;
        do {
            System.out.println("\n1. Inserir um elemento na árvore");
            System.out.println("2. Buscar um elemento na árvore");
            System.out.println("3. Visualizar a árvore por níveis");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser inserido na árvore: ");
                    int inserirValor = scanner.nextInt();
                    arvoreBinaria.inserir(inserirValor);
                    System.out.println(inserirValor + " inserido na árvore.");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser buscado na árvore: ");
                    int searchValue = scanner.nextInt();
                    Node encontrado = arvoreBinaria.buscar(searchValue);
                    if (encontrado != null) {
                        System.out.println(searchValue + " encontrado na árvore.");
                        System.out.print("Caminho até o nó: ");
                        arvoreBinaria.imprimirCaminho(encontrado);
                    } else {
                        System.out.println(searchValue + " não encontrado na árvore.");
                    }
                    break;
                case 3:
                    System.out.println("Visualizando a árvore por níveis:");
                    arvoreBinaria.visualizarArvorePorNiveis();
                    break;
                case 9:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 9);
    }
}
