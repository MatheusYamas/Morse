package morse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaMorse morse = new ArvoreBinariaMorse();
        morse.inicializar();

        while (true) {
            System.out.println("\n--- ÁRVORE BINÁRIA COM MORSE ---");
            System.out.println("1. Inserir novo caractere");
            System.out.println("2. Buscar mensagem");
            System.out.println("3. Buscar um caractere");
            System.out.println("4. Buscar um morse");
            System.out.println("5. Remover caractere");
            System.out.println("6. Exibir árvore");
            System.out.println("7. Adicionar valores na árvore");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o código Morse: ");
                    String morseInserir = scanner.nextLine();

                    System.out.print("Digite o caractere: ");
                    char charInserir = scanner.nextLine().charAt(0);

                    morse.inserir(morseInserir, charInserir);
                    System.out.println("'" + charInserir + "' inserido com código " + morseInserir);
                    break;

                case 2:
                    System.out.print("Digite a mensagem Morse (separada por espaços): ");
                    String msgMorse = scanner.nextLine();
                    String msgDecodificada = morse.buscarMensagem(msgMorse);
                    System.out.println("Mensagem decodificada: " + msgDecodificada);
                    break;

                case 3:
                    System.out.print("Digite o código Morse: ");
                    String morseBuscar = scanner.nextLine();
                    char charEncontrado = morse.buscar(morseBuscar);
                    System.out.println("Caractere encontrado: '" + charEncontrado + "'");
                    break;

                case 4:
                    System.out.print("Digite a letra: ");
                    char letraBuscar = scanner.next().charAt(0);
                    String morseEncontrado = morse.buscarMorse(letraBuscar);
                    System.out.println("Letra encontrada: '" + morseEncontrado + "'");
                    break;

                case 5:
                    System.out.print("Digite o código Morse para remover: ");
                    String morseRemover = scanner.nextLine();
                    morse.remover(morseRemover);
                    break;

                case 6:
                    System.out.println("--- Exibição da Árvore Hierárquica ---");
                    morse.exibir();
                    break;

                case 7:
                    System.out.println("--- Valores adicionados ---");
                    morse.adicionarValores();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
