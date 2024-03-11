public class Node {
    int chave;
    Node esquerda, direita, pai;

    public Node(int item) {
        chave = item;
        esquerda = direita = pai = null;
    }
}