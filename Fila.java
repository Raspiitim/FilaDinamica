package Dinamica;

public class Fila {
    private No inicio;
    private No fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Adiciona (Enqueue)
    public void enqueue(Object elemento) {
        No novo = new No(elemento, null);
        if (this.isEmpty()) {
            this.inicio = novo;
        } else {
            this.fim.setProximo(novo);
        }
        this.fim = novo;
        this.tamanho++;
    }

    // Verifica se é vazia
    public Boolean isEmpty() {
        return this.inicio == null;
    }

    // Verifica o tamanho
    public int size() {
        return this.tamanho;
    }

    // Retorna o primeiro elemento (Front)
    public Object front() {
        return this.inicio != null ? this.inicio.getElemento() : null;
    }

    // Remove o primeiro elemento (Dequeue)
    public Object dequeue() {
        if (!this.isEmpty()) {
            No primeiroElemento = this.inicio;
            this.inicio = this.inicio.getProximo();
            this.tamanho--;

            if (this.inicio == null) { // Se a fila ficar vazia
                this.fim = null;
            }

            return primeiroElemento.getElemento();
        }
        return null; 
    }

    // Adiciona múltiplos elementos à fila
    public void enqueueMultiplos(Object[] elementos) {
        for (Object elemento : elementos) {
            enqueue(elemento);
        }
    }

    // Retorna a ocorrência do elemento na fila
    public int contarOcorrencias(Object elemento) {
        int contador = 0;
        No atual = this.inicio;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                contador++;
            }
            atual = atual.getProximo();
        }

        return contador;
    }

    // Remove todos os elementos iguais
    public void removerTodos(Object elemento) {
        No anterior = null;
        No atual = this.inicio;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                if (anterior == null) { // Removendo o início
                    this.inicio = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                this.tamanho--;
            } else {
                anterior = atual;
            }
            atual = atual.getProximo();
        }

        // Se o último elemento foi removido, atualizamos o fim
        if (this.inicio == null) {
            this.fim = null;
        }
    }

    // Retorna a profundidade de um elemento na fila (posição na fila)
    public int profundidadeElemento(Object elemento) {
        int profundidade = 0;
        No atual = this.inicio;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return profundidade;
            }
            atual = atual.getProximo();
            profundidade++;
        }

        return -1;
    }

    // Mostra o conteúdo da fila
    public void mostrarFila() {
        No atual = this.inicio;
        if (atual == null) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("Conteúdo da fila (do primeiro para o último):");
        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
