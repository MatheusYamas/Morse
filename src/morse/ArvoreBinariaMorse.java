package morse;

public class ArvoreBinariaMorse {
    private Nodo raiz;

    public void inicializar(){
        this.raiz = new Nodo();
    }

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
            System.out.println("Erro");
            return ' ';
        }

        return atual.getCaracter();
    }

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

    public void exibir(){
        recursaoExibir(this.raiz, 0);
    }

    private void recursaoExibir(Nodo no, int nivel){
        if (no == null){
            return;
        }

        for (int i = 0; i < nivel; i++){
            System.out.print("  ");
        }
        System.out.println(no.getCaracter());
        recursaoExibir(no.getEsquerda(), nivel + 1);
        recursaoExibir(no.getDireita(), nivel + 1);
    }

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
