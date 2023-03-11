class GerarAleatorio{
   public int aleatorio(){
      int min = 0;
      int max = 1;
      int valorAleatorio = (int)Math.floor(Math.random() * (max - min + 1) + min);
   
      return valorAleatorio;
   }
} 