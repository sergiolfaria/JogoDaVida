import java.util.*;
import java.util.Random;

public class Matriz {
    private int[][] matriz;

    public void criarMatriz(int tamanhoDigitado) {
        matriz = new int[tamanhoDigitado][tamanhoDigitado];
    }

    public void tamanhoMatriz() {
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
            } catch (NumberFormatException e) {
                System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
            }
        }
    }

    public void imprimirMatriz() {
        tamanhoMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
               GerarAleatorio valor = new GerarAleatorio();
               int numeroAleatorio = valor.aleatorio();
                matriz[i][j] = numeroAleatorio;
            }
        }
        for (int[] linha : matriz) {
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
        }
    }
}
