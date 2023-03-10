import java.util.*;imprimirMatriz()


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
    public void popularMatriz() {
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
        }
      }
      public void atualizarMatriz(int tamanhoMatriz) {
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
}

