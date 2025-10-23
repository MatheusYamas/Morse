# Árvore Binária com Código Morse

## Informações Institucionais

- **Disciplina:** Resolução de Problemas Estruturados em Computação
- **Instituição:** Pontifícia Universidade Católica do Paraná
- **Professor:** Andrey Cabral Meira
- **Turma:** U
- **Equipe:** ATPS 2
- **Membros**: 
	1. [Gustavo Tasca Lazzari](https://github.com/GLazzari1428);
	2. [Mateus Roese Tucunduva](https://github.com/Matizuuu);
	3. [Matheus Yamamoto Dias](https://github.com/MatheusYamas);
	4. [Victor Ryuki Tamezava](https://github.com/VicRuk).

---
## 1. Introdução

Neste trabalho, foi desenvolvido um sistema de codificação e decodificação usando o Código Morse em Java, implementado através de uma estrutura de Árvore Binária. O objetivo principal é representar todas as letras do alfabeto e números em uma árvore binária, onde cada caminho da raiz até um nó folha descreve a sequência de pontos e traços correspondente ao caractere. 

---
## 2. Interface de Usuário (GUI)

O sistema apresenta um menu interativo via terminal com as seguintes opções:

1. Inserir novo caractere
2. Buscar mensagem
3. Buscar um caractere
4. Buscar um morse
5. Remover caractere
6. Exibir árvore
7. Adicionar valores na árvore
0. Sair

### 2.1 Exemplo Prático do GUI

Abaixo é possível ver um exemplo prático da interface de usuário:

```zsh
--- ÁRVORE BINÁRIA COM MORSE ---

1. Inserir novo caractere
2. Buscar mensagem
3. Buscar um caractere
4. Buscar um morse
5. Remover caractere
6. Exibir árvore
7. Adicionar valores na árvore
8. Sair
Digite sua escolha: 7
--- Valores adicionados ---

Digite sua escolha: 3
Digite o código Morse: ...
Caractere encontrado: 'S'

Digite sua escolha: 4
Digite a letra: O
Letra encontrada: '---'

Digite sua escolha: 2
Digite a mensagem Morse (separada por espaços): ... --- ...
Mensagem decodificada: SOS

Digite sua escolha: 6
--- Exibição da Árvore Hierárquica ---
E I S H 5 4 V 3 U F 2 A R L W J 1 P T N D B 6 X K C Y M G Z 7 Q O 8 9 0

```

---
## 3. Explicação Geral do Código

### 3.1 Estrutura de Nó

A árvore binária utiliza uma classe *Nodo* para representar cada elemento:

```java
public class Nodo {
	private char caracter;
	private Nodo esquerda;
	private Nodo direita;

	public Nodo() {
		this.caracter = ' ';
		this.direita = null;
		this.esquerda = null;
	}
}
```
Cada nó armazena um caractere e ponteiros para os filhos esquerdo e direito. A estrutura segue o padrão do código Morse: pontos apontam para a esquerda e traços apontam para a direita.

### 3.2 Árvore Binária (Operações Principais)

Inicializar árvore:
```java
public void inicializar() {
    this.raiz = new Nodo();
}
```
Inicializa a árvore criando um nó raiz vazio, que serve como ponto de partida para todas as operações de navegação e inserção.

Inserir caractere:
```java
public void inserir(String morse, char caracter) {
	Nodo atual = this.raiz;
	for (int i = 0; i < morse.length(); i++) {
		String bit = morse.substring(i, i + 1);
		if (bit.equals(".")) {
			if (atual.getEsquerda() == null) {
				atual.setEsquerda(new Nodo());
			}
			atual = atual.getEsquerda();
		} else if (bit.equals("-")) {
			if (atual.getDireita() == null) {
				atual.setDireita(new Nodo());
			}
			atual = atual.getDireita();
		}
	}
	atual.setCaracter(caracter);
}
```
Este trecho percorre a árvore de acordo com o código Morse fornecido. Se um nó necessário não existir, ele é criado automaticamente e ao final do caminho, o caractere é armazenado no nó apropriado.

Buscar caractere por código Morse:
```java
public char buscar(String morse) {
	Nodo atual = this.raiz;
	for (int i = 0; i < morse.length(); i++) {
		String bit = morse.substring(i, i + 1);
		if (atual == null) {
			break;
		}
		if (bit.equals(".")) {
			atual = atual.getEsquerda();
		} else if (bit.equals("-")) {
			atual = atual.getDireita();
		}
	}
	if (atual == null) {
		System.out.println("Caracter não existe na árvore");
		return ' ';
	}
	return atual.getCaracter();
}
```
Este trecho realiza a busca, navegando a árvore seguindo a sequência do Morse fornecido. Retorna o caractere correspondente ao caminho percorrido e se o caminho não existir, retorna um espaço vazio.

### 3.3 Busca de Mensagem

Decodificar mensagem completa:
```java
public String buscarMensagem(String morse) {
	String finalM = "";
	String restanteM = "";
	for (int i = 0; i < morse.length(); i++) {
		String bit = morse.substring(i, i + 1);
		if (!bit.equals(" ")) {
			restanteM = restanteM + bit;
		} else {
			finalM = finalM + buscar(restanteM);
			restanteM = "";
		}
	}
	finalM = finalM + buscar(restanteM);
	return finalM;
}
```
Para realizar a decodificação, a string de entrada deve ter os códigos separados por espaços. O método processa cada código individualmente usando o método *buscar()* e concatena os caracteres resultantes para formar a mensagem final.

### 3.4 Busca Reversa (Caractere para Morse)

Buscar código Morse de um caractere:
```java
public String buscarMorse(char caractere) {
	return recursaoBuscarMorse(this.raiz, caractere, "");
}

private String recursaoBuscarMorse(Nodo no, char bit, String caminhoAtual) {
	if (no == null) {
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
```
Realiza uma busca reversa na árvore para encontrar o código Morse correspondente a um caractere. Utiliza recursão para percorrer toda a árvore, construindo o caminho até encontrar o caractere desejado. E além disso, o lado esquerdo da árvore tem prioridade sobre o lado direito.

### 3.5 Remoção de Caractere

Remover caractere da árvore:
```java
public void remover(String morse) {
	Nodo atual = this.raiz;
	for (int i = 0; i < morse.length(); i++) {
		String bit = morse.substring(i, i + 1);
		if (atual == null) {
			break;
		}
		if (bit.equals(".")) {
			atual = atual.getEsquerda();
		} else if (bit.equals("-")) {
			atual = atual.getDireita();
		}
	}
	if (atual != null) {
		atual.setCaracter(' ');
	}
}
```
Para realizar a remoção, o caractere de que deve ser removido é substituido por um espaço vazio, mantendo a estrutura da árvore intacta para preservar outros caracteres que dependem do mesmo caminho.

### 3.6 Exibição da Árvore

Exibir estrutura hierárquica:
```java
public void exibir() {
	recursaoExibir(this.raiz);
}

private void recursaoExibir(Nodo no) {
	if (no == null) {
		return;
	}
	if (no.getCaracter() != ' ') {
		System.out.print(no.getCaracter() + " ");
	}
	recursaoExibir(no.getEsquerda());
	recursaoExibir(no.getDireita());
}
```
Exibe todos os caracteres armazenados na árvore através de uma travessia em pré-ordem (raiz-esquerda-direita). E faz uso de recursão para percorrer toda a estrutura, exibindo apenas nós que contêm caracteres não vazios.

### 3.7 Adição Automática de Valores

Preencher árvore com alfabeto e números:
```java
public void adicionarValores() {
// Letras
inserir(".-", 'A');
inserir("-...", 'B');
inserir("-.-.", 'C');
// ... (continua para todas as letras)

// Números
inserir("-----", '0');
inserir(".----", '1');
// ... (continua para todos os números)
}
```
E por ultimo, um método auxiliar que facilita o preenchimento automatico do alfabeto em morse.

