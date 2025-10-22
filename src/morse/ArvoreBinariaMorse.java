package morse;

public class ArvoreBinariaMorse {
    private Nodo raiz;

    // inicializar a árvore com um nó vazio
    public void inicializar(){
        this.raiz = new Nodo();
    }

    // método inserir
    public void inserir(String morse, char caracter){
        Nodo atual = this.raiz;
        for (int i = 0; i < morse.length(); i++){
            String bit = morse.substring(i, i + 1);

            if (bit.equals(".")){
                if (atual.getEsquerda() == null){
                    atual.setEsquerda(new Nodo());
                }
                atual = atual.getEsquerda();
            }

            else if (bit.equals("-")){
                if (atual.getDireita() == null){
                    atual.setDireita(new Nodo());
                }
                atual = atual.getDireita();
            }
        }
        atual.setCaracter(caracter);
    }

    // método para buscar um morse
    public char buscar(String morse){
        Nodo atual = this.raiz;
        for (int i = 0; i < morse.length(); i++){
            String bit = morse.substring(i, i + 1);
            if (atual == null){
                break;
            }
            if (bit.equals(".")){
                atual = atual.getEsquerda();
            }
            else if (bit.equals("-")){
                atual = atual.getDireita();
            }
        }
        if (atual == null) {
            System.out.println("Caracter não existe na árvore");
            return ' ';
        }

        return atual.getCaracter();
    }

    //método para buscar uma mensagem
    public String buscarMensagem(String morse){
        String finalM = "";
        String restanteM = "";

        for (int i = 0; i < morse.length(); i++){
            String bit = morse.substring(i, i + 1);

            if (!bit.equals(" ")){
                restanteM = restanteM + bit;
            }
            else {
                finalM = finalM + buscar(restanteM);
                restanteM = "";
            }
        }

        finalM = finalM + buscar(restanteM);

        return finalM;
    }

    // Método para buscar um morse e abaixo a recursao para buscar o morse
    public String buscarMorse(char caractere) {
        return recursaoBuscarMorse(this.raiz, caractere, "");
    }

    private String recursaoBuscarMorse(Nodo no, char bit, String caminhoAtual) {

        if (no == null) {
            System.out.println("A letra digitada não existe na árvore");
            return null;
        }

        if (no.getCaracter() == bit) {
            return caminhoAtual;
        }

        String ladoEsquerdo = recursaoBuscarMorse(no.getEsquerda(), bit, caminhoAtual + ".");
        if (ladoEsquerdo != null) {
            return ladoEsquerdo;
        }

        String ladoDireito = recursaoBuscarMorse(no.getDireita(), bit, caminhoAtual + "-");
        return ladoDireito;
    }

    // método para remover o morse digitado
    public void remover(String morse){
        Nodo atual = this.raiz;
        for (int i = 0; i < morse.length(); i++){
            String bit = morse.substring(i, i + 1);
            if (atual == null){
                break;
            }
            if (bit.equals(".")){
                atual = atual.getEsquerda();
            }
            else if (bit.equals("-")){
                atual = atual.getDireita();
            }
        }
        if (atual != null){
            atual.setCaracter(' ');
        }

    }

    // método para exibir e sua recursão
    public void exibir(){
        recursaoExibir(this.raiz);
    }

    private void recursaoExibir(Nodo no){
        if (no == null){
            return;
        }

        if (no.getCaracter() != ' '){
            System.out.print(no.getCaracter() + " ");
        }
        recursaoExibir(no.getEsquerda());
        recursaoExibir(no.getDireita());
    }

    // método para adicionar valores automaticamente na árvore em vez de digitar no inserir
    public void adicionarValores() {
        // Letras
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        // Números
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }
}
