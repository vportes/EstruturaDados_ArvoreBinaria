import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node raiz; // A raiz da árvore

    BinaryTree() {
        raiz = null; // Inicializa a árvore como vazia
    }

    void inserir(int key) {
        raiz = inserirRecursivo(raiz, null, key); // Chamando o método de inserção recursivo, passando a raiz como ponto de partida e o pai como null na inserção da raiz
    }

    Node inserirRecursivo(Node raiz, Node pai, int chave) {
        // Se a raiz for nula, significa que chegamos a uma folha, então criamos um novo nó com a chave fornecida
        if (raiz == null) {
            raiz = new Node(chave);
            raiz.pai = pai; // O pai do novo nó é definido como o nó pai fornecido
            return raiz;
        }

        // Se a chave fornecida for menor que a chave na raiz atual, inserimos recursivamente à esquerda
        if (chave < raiz.chave)
            raiz.esquerda = inserirRecursivo(raiz.esquerda, raiz, chave);
            // Se a chave fornecida for maior que a chave na raiz atual, inserimos recursivamente à direita
        else if (chave > raiz.chave)
            raiz.direita = inserirRecursivo(raiz.direita, raiz, chave);

        return raiz; // Retornando a raiz atualizada
    }

    Node buscar(int chave) {
        return buscaRecursiva(raiz, chave); // Chamando o método de busca recursiva, começando pela raiz
    }

    Node buscaRecursiva(Node raiz, int chave) {
        // Se a raiz for nula, significa que chegamos a uma folha e não encontramos o nó com a chave fornecida
        if (raiz == null)
            return null;

        // Se a chave fornecida for igual à chave na raiz atual, encontramos o nó e retornamos
        if (raiz.chave == chave)
            return raiz;

        // Se a chave fornecida for menor que a chave na raiz atual, buscamos recursivamente à esquerda
        if (chave < raiz.chave)
            return buscaRecursiva(raiz.esquerda, chave);
            // Se a chave fornecida for maior que a chave na raiz atual, buscamos recursivamente à direita
        else
            return buscaRecursiva(raiz.direita, chave);
    }

    void imprimirCaminho(Node no) {
        if (no != null) {
            imprimirCaminhoAux(no);
        }
        System.out.println("\n");
    }

    private void imprimirCaminhoAux(Node no) {
        if (no.pai != null) {
            imprimirCaminhoAux(no.pai); // Chamada recursiva para imprimir o pai
            System.out.print(" -> ");
        }
        System.out.print(no.chave); // Imprime a chave do nó
    }

    void visualizarArvorePorNiveis() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz); // Adiciona a raiz à fila

        int nivel = 0;
        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size(); // Obtém o tamanho do nível atual
            System.out.print("Nível " + nivel + ": ");
            for (int i = 0; i < tamanhoNivel; i++) {
                Node no = fila.poll(); // Remove o nó da frente da fila
                System.out.print(no.chave + " "); // Imprime a chave do nó

                // Adiciona os filhos do nó à fila, se existirem
                if (no.esquerda != null)
                    fila.add(no.esquerda);
                if (no.direita != null)
                    fila.add(no.direita);
            }
            System.out.println();
            nivel++; // Incrementa o nível
        }
    }
}
