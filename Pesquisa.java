public static boolean pesquisa(String valor, String vetor[]){

  for (int x = 0; x < vetor.length;x++){
    boolean encontrou = false;
    if(valor.equals(vetor[x])){
      return encontrou = true;
    }
  }
  return encontrou;

}
