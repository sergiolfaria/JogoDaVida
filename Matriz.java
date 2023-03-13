import java.util.*;

public class Matriz {
    private int[][] matriz;

    public void criarMatriz(int tamanhoDigitado) {
        matriz = new int[tamanhoDigitado][tamanhoDigitado];
    }

    public void instanciarMatriz() {
        Scanner teclado = new Scanner(System.in);
        boolean validInput = false;
        // verifica se a resposta do usuário é um número, caso não seja o while repete,
        // até ser.
        while (!validInput) {
            System.out.println("Digite o tamanho desejado de matriz: ");
            String input = teclado.nextLine();
            try {
                int tamanhoDigitado = Integer.parseInt(input);
                validInput = true;
                criarMatriz(tamanhoDigitado);
                popularMatriz();
            } catch (NumberFormatException e) {
                System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
            }
        }
    }

    // gera o tamanho da matriz e a preenche.
    public void imprimirMatriz() {
        tamanhoMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                GerarAleatorio valor = new GerarAleatorio();
                int numeroAleatorio = valor.aleatorio();
                matriz[i][j] = numeroAleatorio;
            }
        }
    }

    public void imprimirMatriz(){
        for (int[] linha : matriz) {
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
            proximaGeracao();
        }
        contarVizinhosVivos(0,):
        proximaGeracao();
    }

    public void proximaGeracao() {
        int[][] novaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int vizinhosVivos = contarVizinhosVivos(i, j);
                if (matriz[i][j] == 1 && (vizinhosVivos < 2 || vizinhosVivos > 3)) {
                    novaMatriz[i][j] = 0; // a célula morre
                } else if (matriz[i][j] == 0 && vizinhosVivos == 3) {
                    novaMatriz[i][j] = 1; // a célula nasce
                } else {
                    novaMatriz[i][j] = matriz[i][j]; // a célula continua no mesmo estado
                }
            }
        }
        matriz = novaMatriz; // atualiza a matriz original com a nova matriz
    }

    private int contarVizinhosVivos(int linha, int coluna) {
        int totalVizinhosVivos = 0;
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                int linhaVizinha = (i + matriz.length) % matriz.length; // conecta as bordas
                int colunaVizinha = (j + matriz[0].length) % matriz[0].length; // conecta as bordas
                if (matriz[linhaVizinha][colunaVizinha] == 1 && (i != linha || j != coluna)) {
                    totalVizinhosVivos++;
                }
            }
        }
    }
}
