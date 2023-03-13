import java.util.*;


class JogoDaVida {
   
   int tamanhoDigitado;
   int[][] matriz;
   int opcao;
    
   //recebe o valor digitado pelo usuario para o tamanha desejado da matriz
   public void receberMatriz(){
      Scanner teclado = new Scanner(System.in);
      boolean validInput = false;
       
      // verificar se a resposta do usuário é um número, caso não seja o while repete ate receber um numero
      while (!validInput){
         System.out.println("Digite o tamanho desejado para a matriz: ");
         String input = teclado.nextLine();
         
         try {
            tamanhoDigitado = Integer.parseInt(input);
            validInput = true;
         }
         catch (NumberFormatException e){
            System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
         }
      }
   }

   //Inicializa a matriz criando ela com a dimensão escolhida pelo usuario 
   public void criarMatriz(int tamanhoDigitado){
      matriz = new int[tamanhoDigitado][tamanhoDigitado];
   }
     
   //Popula a matriz com valores gerados aleatoriamente, sendo eles 0 ou 1
   public void popularMatriz(){
      for (int i = 0; i < tamanhoDigitado; i++){
         for (int j = 0; j < tamanhoDigitado; j++){
            
            GerarAleatorio valor = new GerarAleatorio();
            int numeroAleatorio = valor.aleatorio();
            matriz[i][j] = numeroAleatorio;
         }
      }
   }
   
   //imprime a matriz 
   public void imprimirMatriz(){
      for (int[] linha : matriz) {
         for (int coluna : linha) {
            System.out.print(coluna + " ");
         }
         System.out.println();
      }
   }

   //Inicializa o jogo chamando todos os metodos necessarios para o funcionamento
   public void iniciarJogo(){
      receberMatriz();
      criarMatriz(tamanhoDigitado);
      popularMatriz();
      imprimirMatriz();
      
      while(opcao != 2){
         exibirMenu();
         imprimirMatriz();
      }  
   }

   public void exibirMenu(){
      System.out.println("Deseja iniciar uma nova geracao?");
      System.out.println("[1] Iniciar nova geração\n[2] Sair do jogo\n\n");
      Scanner teclado = new Scanner(System.in);
      opcao = teclado.nextInt();
      boolean validInput = false;
      while (!validInput){
         if(opcao == 1){
            
           CalcularNovaGeracao();
            
            validInput = true;
         }
         else if(opcao == 2){
            validInput = true;
         }
         else{
            validInput = false;
         }
      }
   } 
  public void CalcularNovaGeracao() {
    int[][] novaMatriz = new int[tamanhoDigitado][tamanhoDigitado];
    
    for (int i = 0; i < tamanhoDigitado; i++) {
        for (int j = 0; j < tamanhoDigitado; j++) {
            int conta = contarVizinhosVivos(i, j);
            
            // Aplica as regras do jogo
            if (matriz[i][j] == 1 && (conta < 2 || conta > 3)) {
                novaMatriz[i][j] = 0; // A célula morre de solidão ou superpopulação
            } else if (matriz[i][j] == 0 && conta == 3) {
                novaMatriz[i][j] = 1; // A célula nasce por reprodução
            } else {
                novaMatriz[i][j] = matriz[i][j]; // A célula continua no mesmo estado
            }
        }
    }
    
    // Atualiza a matriz para a próxima geração
    matriz = novaMatriz;
}
private int contarVizinhosVivos(int i, int j) {
    int conta = 0;
    
    // Percorre todas as células ao redor da célula em questão
    for (int x = -1; x <= 1; x++) {
        for (int y = -1; y <= 1; y++) {
            // Ignora a célula em questão
            if (x == 0 && y == 0) {
                continue;
            }
            
            // Incrementa o contador se a célula estiver viva
            if (reviverVizinhos(i + x, j + y)) {
                conta++;
            }
        }
    }
    
    return conta;
}
private boolean reviverVizinhos(int i, int j) {
    // Verifica se a célula está dentro da matriz
    if (i < 0 || i >= tamanhoDigitado || j < 0 || j >= tamanhoDigitado) {
        return false;
    }
    
    // Retorna true se a célula estiver viva, false se estiver morta
    return matriz[i][j] == 1;
}

  
  }  
   
   
   
   
   

  
   
   //For
   //exibirMenu();
   //calcularProximaGeracao();
   //imprimirMatriz();























/*  private Matriz matriz;
  private int tamanhoMatriz;

  public void iniciarJogo() {
        this.matriz = new Matriz();
        matriz.instanciarMatriz();
        
    }

    public int contarVizinhosVivos(int linha, int coluna) {
        int numVizinhosVivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignora a célula atual
                if (i == 0 && j == 0) {
                    continue;
                }

                // Obtém as coordenadas do vizinho
                int vizinhoLinha = (linha + i + receberMatriz) % tamanhoMatriz;
                int vizinhoColuna = (coluna + j + receberMatriz) % tamanhoMatriz;

                // Incrementa o número de vizinhos vivos, se o vizinho estiver vivo
                if (matriz[vizinhoLinha][vizinhoColuna] == 1) {
                    numVizinhosVivos++;
                }
            }
        }
        return numVizinhosVivos;
    }*/