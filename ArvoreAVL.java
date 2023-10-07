package poo.avaliacaora02;

/**
 *
 * @author renan
 */
public class ArvoreAVL {

    Node raiz;

    public void Insere(int info) {
        if (raiz != null) {
            raiz.Insere(info);
        } else {
            raiz = new Node(info);
        }
        Balancear();
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
        Balancear();
    }

    public int Altura() {
        if (raiz != null) {
            return raiz.Altura();
        }
        return -1;
    }

    public void Balancear() {
        if (raiz != null) {

            int fatorBalanceamento = raiz.ChecarBalanceamento();
            if (fatorBalanceamento > 1) {
                raiz.Balancear();
                raiz = raiz.RotacionarDireita();
                raiz.Balancear();
            } else if (fatorBalanceamento < -1) {
                raiz.Balancear();
                raiz = raiz.RotacionarEsquerda();
                raiz.Balancear();
            }

        }
    }

    public int ChecarBalanceamento() {

        if (raiz != null) {
            return raiz.ChecarBalanceamento();
        }
        return 0;
    }
}
