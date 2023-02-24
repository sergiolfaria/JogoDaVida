import java.util.*;

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
      System.out.println("Digite o tamanho desejado de  matriz: ");
      String input = teclado.nextLine();

      try {
        int tamanhoDigitado = Integer.parseInt(input);
        validInput = true;

        criarMatriz(tamanhoDigitado);
      } catch (NumberFormatException e) {
        System.out.println("A entrada não é um número                          inteiro válido. Tente novamente.");
      }
    }
  }

  public void imprimirMatriz(){
    tamanhoMatriz();
    
    for (int[] tamanhoDigitado : matriz){
      for (int tamanhoDigitado : tamanhoDigitado){
        System.out.print(tamanhoDigitado + ("");
      }
        System.out.print();
    }
  }
}
