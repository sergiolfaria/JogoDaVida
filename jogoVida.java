import java.util.Random;

public class JogoVida {
    private int[][] matriz;
    private int tamanhoMatriz;

    public JogoVida(int tamanhoMatriz) {
        this.tamanhoMatriz = tamanhoMatriz;
        matriz = new int[tamanhoMatriz][tamanhoMatriz];
        // Preenche a matriz com células vivas e mortas aleatoriamente
        Random rand = new Random();
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < tamanhoMatriz; j++) {
                matriz[i][j] = rand.nextInt(2);
            }
        }
    }

    public void imprimirMatriz() {
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < tamanhoMatriz; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void atualizarMatriz() {
        int[][] novaMatriz = new int[tamanhoMatriz][tamanhoMatriz];

        // Atualiza cada célula da nova matriz
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < tamanhoMatriz; j++) {
                int numVizinhosVivos = contarVizinhosVivos(i, j);

                // Aplica as regras do jogo para atualizar a célula
                if (matriz[i][j] == 1) {
                    if (numVizinhosVivos < 2 || numVizinhosVivos > 3) {
                        novaMatriz[i][j] = 0;
                    } else {
                        novaMatriz[i][j] = 1;
                    }
                } else {
                    if (numVizinhosVivos == 3) {
                        novaMatriz[i][j] = 1;
                    } else {
                        novaMatriz[i][j] = 0;
                    }
                }
            }
        }

        // Atualiza a matriz antiga com os novos valores
        matriz = novaMatriz;
    }

    private int contarVizinhosVivos(int linha, int coluna) {
        int numVizinhosVivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignora a célula atual
                if (i == 0 && j == 0) {
                    continue;
                }

                // Obtém as coordenadas do vizinho
                int vizinhoLinha = (linha + i + tamanhoMatriz) % tamanhoMatriz;
                int vizinhoColuna = (coluna + j + tamanhoMatriz) % tamanhoMatriz;

                // Incrementa o número de vizinhos vivos, se o vizinho estiver vivo
                if (matriz[vizinhoLinha][vizinhoColuna] == 1) {
                    numVizinhosVivos++;
                }
            }
        }
        return numVizinhosVivos;
    }
}
