package poo.avaliacaora02;

import java.util.Random;

/**
 *
 * @author renan
 */
public class AvaliacaoRA02 {

    public static void main(String[] args) {

        ArvoreAVL arvoreAVL = new ArvoreAVL();
        ArvoreBinariaDeBusca arvoreBinaria = new ArvoreBinariaDeBusca();

        Random random = new Random();

        int numDeOperacoes = 20000;

        long startBin = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreBinaria.Insere(randomInt);
        }

        long finishBin = System.nanoTime();
        long timeElapsedBin = finishBin - startBin;

        long startAVL = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreAVL.Insere(randomInt);
        }

        long finishAVL = System.nanoTime();
        long timeElapsedAVL = finishAVL - startAVL;

        System.out.println("Tempo da inserção na arvore AVL: " + timeElapsedAVL + " ns");
        System.out.println("Tempo da inserção na arvore Binária: " + timeElapsedBin + " ns");

        startBin = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreBinaria.Busca(randomInt);
        }

        finishBin = System.nanoTime();
        timeElapsedBin = finishBin - startBin;

        startAVL = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreAVL.Busca(randomInt);
        }

        finishAVL = System.nanoTime();
        timeElapsedAVL = finishAVL - startAVL;

        System.out.println("Tempo da Busca na arvore AVL: " + timeElapsedAVL + " ns");
        System.out.println("Tempo da Busca na arvore Binária: " + timeElapsedBin + " ns");

        startBin = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreBinaria.Remove(randomInt);
        }

        finishBin = System.nanoTime();
        timeElapsedBin = finishBin - startBin;

        startAVL = System.nanoTime();

        for (int i = 0; i < numDeOperacoes; i++) {
            int randomInt = random.nextInt(numDeOperacoes / 2);
            arvoreAVL.Remove(randomInt);
        }

        finishAVL = System.nanoTime();
        timeElapsedAVL = finishAVL - startAVL;

        System.out.println("Tempo da Remoção na arvore AVL: " + timeElapsedAVL + " ns");
        System.out.println("Tempo da Remoção na arvore Binária: " + timeElapsedBin + " ns");
    }
}
