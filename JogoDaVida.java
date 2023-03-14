import java.util.*;

class JogoDaVida {
   
   int tamanhoDigitado;
   int[][] matriz;
   int opcao;
   int[][] novaMatriz;
    
   // recebe o valor digitado pelo usuário para o tamanho desejado da matriz
   public void receberMatriz() {
      Scanner teclado = new Scanner(System.in);
      boolean validInput = false;
       
      // verificar se a resposta do usuário é um número, caso contrário, o while repete até receber um número
      while (!validInput) {
         System.out.println("Digite o tamanho desejado para a matriz: ");
         String input = teclado.nextLine();
         
         try {
            tamanhoDigitado = Integer.parseInt(input);
            validInput = true;
         } catch (NumberFormatException e) {
            System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
         }
      }
   }

   // inicializa a matriz criando ela com a dimensão escolhida pelo usuário 
   public void criarMatriz(int tamanhoDigitado) {
      matriz = new int[tamanhoDigitado][tamanhoDigitado];
   }
     
   // popula a matriz com valores gerados aleatoriamente, sendo eles 0 ou 1
   public void popularMatriz() {
      for (int i = 0; i < tamanhoDigitado; i++) {
         for (int j = 0; j < tamanhoDigitado; j++) {
            
            GerarAleatorio valor = new GerarAleatorio();
            int numeroAleatorio = valor.aleatorio();
            matriz[i][j] = numeroAleatorio;
         }
      }
   }
   
   // imprime a matriz 
   public void imprimirMatriz() {
      for (int[] linha : matriz) {
         for (int coluna : linha) {
            System.out.print(coluna + " ");
         }
         System.out.println();
      }
   }
   
   // imprime a nova matriz 
   public void imprimirNovaMatriz() {
      for (int[] linha1 : novaMatriz) {
         for (int coluna1 : linha1) {
            System.out.print(coluna1 + " ");
         }
         System.out.println();
         matriz = novaMatriz;
      }
   }

   // inicializa o jogo chamando todos os métodos necessários para o funcionamento
   public void iniciarJogo() {
      receberMatriz();
      criarMatriz(tamanhoDigitado);
      popularMatriz();
      imprimirMatriz();
      
      while (opcao != 2) {
         exibirMenu();    
      }  
   }

   // exibe o menu do jogo 
   public void exibirMenu() {
      System.out.println("Deseja iniciar uma nova geração?");
      System.out.println("[1] Iniciar nova geração\n[2] Sair do jogo\n\n");
      Scanner teclado = new Scanner(System.in);
      opcao = teclado.nextInt();
      calcularNovaGeracao();  
   }  
   
   // realiza o cálculo para gerar uma nova geração da matriz 
  

// conta quantos vizinhos vivos a célula tem
public void calcularNovaGeracao() {
    novaMatriz = new int[tamanhoDigitado][tamanhoDigitado];

    for (int i = 0; i < tamanhoDigitado; i++) {
        for (int j = 0; j < tamanhoDigitado; j++) {
            int vizinhosVivos = contarVizinhos(i, j);

            if (matriz[i][j] == 1 && vizinhosVivos < 2) {
                novaMatriz[i][j] = 0; // morre por solidão
            } else if (matriz[i][j] == 1 && (vizinhosVivos == 2 || vizinhosVivos == 3)) {
                novaMatriz[i][j] = 1; // sobrevive
            } else if (matriz[i][j] == 1 && vizinhosVivos > 3) {
                novaMatriz[i][j] = 0; // morre por superpopulação
            } else if (matriz[i][j] == 0 && vizinhosVivos == 3) {
                novaMatriz[i][j] = 1; // nasce por reprodução
            } 
            System.out.printf("(%d,%d) vizinhos vivos: %d\n", i, j, vizinhosVivos);
        }
    }
    imprimirNovaMatriz();
 
}

// conta quantos vizinhos vivos a célula tem
public int contarVizinhos(int linha, int coluna) {
   int vivos = 0;
   // Verificar vizinhos acima e abaixo
   for (int i = linha - 1; i <= linha + 1; i += 2) {
      int linhaVerif = i;
      int colunaVerif = coluna;
      if (linhaVerif < 0) {
         linhaVerif = tamanhoDigitado - 1;
      } else if (linhaVerif >= tamanhoDigitado) {
         linhaVerif = 0;
      }
      if (matriz[linhaVerif][colunaVerif] == 1) {
         vivos++;
      }
   }
   // Verificar vizinhos à esquerda e à direita
   for (int j = coluna - 1; j <= coluna + 1; j += 2) {
      int linhaVerif = linha;
      int colunaVerif = j;
      if (colunaVerif < 0) {
         colunaVerif = tamanhoDigitado - 1;
      } else if (colunaVerif >= tamanhoDigitado) {
         colunaVerif = 0;
      }
      if (matriz[linhaVerif][colunaVerif] == 1) {
         vivos++;
      }
   }
   return vivos;
}

// classe auxiliar para gerar valores aleatórios para a matriz
}


      
      
