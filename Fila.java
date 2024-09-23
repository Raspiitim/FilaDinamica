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

    // Retorna o último elemento da fila (sem remover)
public Object back() {
    return this.fim != null ? this.fim.getElemento() : null;
}

// Remove e retorna todos os elementos da fila em um array
public Object[] dequeueAll() {
    Object[] elementos = new Object[this.tamanho];
    for (int i = 0; i < this.tamanho; i++) {
        elementos[i] = this.dequeue();
    }
    return elementos;
}

// Verifica se um elemento está na fila
public boolean contains(Object elemento) {
    No atual = this.inicio;
    while (atual != null) {
        if (atual.getElemento().equals(elemento)) {
            return true;
        }
        atual = atual.getProximo();
    }
    return false;
}

// Limpa todos os elementos da fila
public void clear() {
    this.inicio = null;
    this.fim = null;
    this.tamanho = 0;
}

// Retorna os elementos da fila como um array
public Object[] toArray() {
    Object[] elementos = new Object[this.tamanho];
    No atual = this.inicio;
    for (int i = 0; i < this.tamanho; i++) {
        elementos[i] = atual.getElemento();
        atual = atual.getProximo();
    }
    return elementos;
}

// Retorna uma representação em string da fila
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    No atual = this.inicio;
    sb.append("[");
    while (atual != null) {
        sb.append(atual.getElemento());
        if (atual.getProximo() != null) {
            sb.append(", ");
        }
        atual = atual.getProximo();
    }
    sb.append("]");
    return sb.toString();
}

// Inverte a fila (não altera a ordem original)
public Fila reverse() {
    Fila filaInvertida = new Fila();
    No atual = this.inicio;
    while (atual != null) {
        filaInvertida.enqueue(atual.getElemento());
        atual = atual.getProximo();
    }
    return filaInvertida;
}

// Retorna o elemento na posição especificada (0-base)
public Object get(int index) {
    if (index < 0 || index >= this.tamanho) {
        throw new IndexOutOfBoundsException("Índice fora dos limites.");
    }
    No atual = this.inicio;
    for (int i = 0; i < index; i++) {
        atual = atual.getProximo();
    }
    return atual.getElemento();
}

// Retorna o primeiro elemento e o remove (Dequeue)
public Object dequeueFirst() {
    return this.dequeue();
}

// Retorna o número de elementos na fila (size)
public int count() {
    return this.size();
}

// Retorna a posição de um elemento na fila (0-base)
public int indexOf(Object elemento) {
    int index = 0;
    No atual = this.inicio;

    while (atual != null) {
        if (atual.getElemento().equals(elemento)) {
            return index; // Retorna a posição se o elemento for encontrado
        }
        atual = atual.getProximo();
        index++;
    }

    return -1; // Retorna -1 se o elemento não for encontrado
}

    package Dinamica;

public class Fila {
    private No inicio;
    private No fim;
    private int tamanho;

    // Restante da classe...

    // Método para inverter a fila sem usar Stack
    public void inverter() {
        if (this.isEmpty()) {
            return;
        }

        Object[] elementos = new Object[this.tamanho];  // Cria um array temporário para armazenar os elementos
        int i = 0;

        // Desenfileira todos os elementos e armazena no array
        while (!this.isEmpty()) {
            elementos[i++] = this.dequeue();
        }

        // Reenfileira os elementos em ordem inversa
        for (int j = elementos.length - 1; j >= 0; j--) {
            this.enqueue(elementos[j]);
        }
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
