package morse;

public class Nodo {
    private char caracter;
    private Nodo esquerda;
    private Nodo direita;

    public Nodo(){
        this.caracter = ' ';
        this.direita = null;
        this.esquerda = null;
    }

    public char getCaracter(){
        return caracter;
    }

    public Nodo getEsquerda(){
        return esquerda;
    }

    public Nodo getDireita(){
        return direita;
    }

    public void setCaracter(char caracter){
        this.caracter = caracter;
    }

    public void setEsquerda(Nodo esquerda){
        this.esquerda = esquerda;
    }

    public void setDireita(Nodo direita){
        this.direita = direita;
    }

}
