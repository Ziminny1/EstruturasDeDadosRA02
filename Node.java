package poo.avaliacaora02;

/**
 *
 * @author renan
 */
public class Node {

    int info;
    Node direita;
    Node esquerda;

    public Node(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public void Insere(int numero) {
        if (numero >= info) {
            if (direita != null) {
                direita.Insere(numero);
            } else {
                direita = new Node(numero);
            }
        } else if (numero < info) {
            if (esquerda != null) {
                esquerda.Insere(numero);
            } else {
                esquerda = new Node(numero);
            }
        }
    }

    public Node Busca(int numero) {
        Node retorno = null;
        if (info == numero) {
            return this;
        }
        if (numero < info && esquerda != null) {
            retorno = esquerda.Busca(numero);
        }
        if (numero > info && direita != null && retorno == null) {
            retorno = direita.Busca(numero);
        }
        return retorno;
    }

    public Node Remove(int numero) {
        if (numero == info) {
            if (esquerda == null && direita != null) {
                return direita;
            } else if (esquerda != null && direita == null) {
                return esquerda;
            } else if (esquerda != null && direita != null) {
                this.info = esquerda.Substituicao();
                esquerda = esquerda.Remove(info);
            } else {
                return null;
            }
        } else if (numero < info && esquerda != null) {
            esquerda = esquerda.Remove(numero);
        } else if (numero > info && direita != null) {
            direita = direita.Remove(numero);
        }
        return this;

    }

    public int Substituicao() {
        int maximo = this.info;
        if (direita != null) {
            maximo = direita.Substituicao();
        }
        return maximo;
    }

    public int Altura() {
        int alturaEsquerda = -1;
        int alturaDireita = -1;
        if (esquerda != null) {
            alturaEsquerda = esquerda.Altura();
        } else {
            alturaEsquerda = -1;
        }
        if (direita != null) {
            alturaDireita = direita.Altura();
        } else {
            alturaDireita = -1;
        }
        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        } else {
            return alturaDireita + 1;
        }
    }

    public int ChecarBalanceamento() {
        int alturaEsquerda = -1;
        int alturaDireita = -1;
        if (esquerda != null) {
            alturaEsquerda = esquerda.Altura();
        }
        if (direita != null) {
            alturaDireita = direita.Altura();
        }
        return alturaEsquerda - alturaDireita;
    }

    public Node RotacionarDireita() {
        if (esquerda != null) {

            if (esquerda.ChecarBalanceamento() == -1) {
                esquerda = esquerda.RotacionarEsquerda();
            }
        }

        Node novaRaiz = esquerda;
        Node temp = null;
        if (novaRaiz.direita != null) {
            temp = novaRaiz.direita;
        }
        novaRaiz.direita = this;
        esquerda = temp;

        return novaRaiz;
    }

    public Node RotacionarEsquerda() {
        if (direita != null) {
            if (direita.ChecarBalanceamento() == 1) {
                direita = direita.RotacionarDireita();
            }
        }

        Node novaRaiz = direita;
        Node temp = null;
        if (novaRaiz.esquerda != null) {
            temp = novaRaiz.esquerda;
        }
        novaRaiz.esquerda = this;
        direita = temp;

        return novaRaiz;
    }

    public void Balancear() {
        if (esquerda != null) {

            if (esquerda.ChecarBalanceamento() > 1) {
                esquerda.Balancear();
                esquerda = esquerda.RotacionarDireita();
                esquerda.Balancear();
            }
            if (esquerda.ChecarBalanceamento() < -1) {
                esquerda.Balancear();
                esquerda = esquerda.RotacionarEsquerda();
                esquerda.Balancear();
            }

        }

        if (direita != null) {

            if (direita.ChecarBalanceamento() < -1) {
                direita.Balancear();
                direita = direita.RotacionarEsquerda();
                direita.Balancear();
            }
            if (direita.ChecarBalanceamento() > 1) {
                direita.Balancear();
                direita = direita.RotacionarDireita();
                direita.Balancear();
            }

        }
    }
}
