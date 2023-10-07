package poo.avaliacaora02;

/**
 *
 * @author renan
 */
public class ArvoreBinariaDeBusca {

    Node raiz;

    public void Insere(int info) {
        if (raiz != null) {
            raiz.Insere(info);
        } else {
            raiz = new Node(info);
        }
    }

    public Node Busca(int informacao) {
        if (raiz != null) {
            return raiz.Busca(informacao);
        }
        return null;
    }

    public void Remove(int informacao) {
        if (raiz != null) {
            raiz = raiz.Remove(informacao);
        }
    }
}
