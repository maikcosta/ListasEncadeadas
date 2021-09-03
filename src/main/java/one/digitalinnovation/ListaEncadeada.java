package one.digitalinnovation;

public class ListaEncadeada <T>{
    No<T> referenciadaEndada;

    public ListaEncadeada() {
        this.referenciadaEndada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){
            referenciadaEndada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciadaEndada;
        for (int i = 0 ; i < this.size()-1; i ++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }

    public T get (int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAuxiliar = referenciadaEndada;
        No<T> noRetorno = null;
        for (int i=0; i <= index; i++ ){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public T remove(int index){
        No<T>  noPrivor = this.getNo(index);
        if(index == 0){
            referenciadaEndada = noPrivor.getProximoNo();
            return  noPrivor.getConteudo();
        }
        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPrivor.getProximoNo());
        return noPrivor.getConteudo();
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciadaEndada;
        while(true){
            if(referenciaAux != null){
                tamanhoLista ++;
                if(referenciaAux.getProximoNo()!= null){
                    referenciaAux = referenciaAux.getProximoNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return tamanhoLista;
    }

    private void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice " + index + "desta lista. Esta lista só vai até o indice " + ultimoIndice + "." );

        }
    }


    public boolean isEmpty(){
        return referenciadaEndada == null ? true: false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciadaEndada;

        for (int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]---->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += "null";
        return strRetorno;
    }
}
