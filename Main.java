package Dinamica;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Testando se a fila está vazia
        System.out.println("Fila está vazia? " + fila.isEmpty());

        // Adicionando elementos à fila (enqueue)
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);

        // Exibindo o conteúdo da fila
        System.out.println("Conteúdo da fila após adicionar elementos:");
        fila.mostrarFila();

        // Verificando o tamanho da fila
        System.out.println("Tamanho da fila: " + fila.size());

        // Verificando o primeiro elemento da fila (front)
        System.out.println("Primeiro elemento da fila: " + fila.front());

        // Removendo o primeiro elemento da fila (dequeue)
        System.out.println("Removendo o primeiro elemento da fila: " + fila.dequeue());

        // Exibindo o conteúdo da fila após a remoção
        System.out.println("Conteúdo da fila após remover um elemento:");
        fila.mostrarFila();

        // Verificando o tamanho da fila novamente
        System.out.println("Tamanho da fila após remoção: " + fila.size());

        // Adicionando múltiplos elementos de uma vez (enqueueMultiplos)
        Object[] novosElementos = {50, 60, 70};
        fila.enqueueMultiplos(novosElementos);

        // Exibindo o conteúdo da fila após adicionar múltiplos elementos
        System.out.println("Conteúdo da fila após adicionar múltiplos elementos:");
        fila.mostrarFila();

        // Contando a ocorrência de um elemento
        int ocorrencias = fila.contarOcorrencias(50);
        System.out.println("Ocorrências do elemento 50 na fila: " + ocorrencias);

        // Removendo todos os elementos iguais a 50
        fila.removerTodos(50);

        // Exibindo o conteúdo da fila após remover todos os elementos iguais a 50
        System.out.println("Conteúdo da fila após remover todos os elementos iguais a 50:");
        fila.mostrarFila();

        // Verificando a profundidade de um elemento na fila
        int profundidade = fila.profundidadeElemento(30);
        System.out.println("Profundidade do elemento 30 na fila: " + profundidade);

        // Removendo todos os elementos da fila
        while (!fila.isEmpty()) {
            System.out.println("Removendo elemento da fila: " + fila.dequeue());
        }

        // Exibindo o conteúdo da fila após remover todos os elementos
        System.out.println("Conteúdo da fila após remover todos os elementos:");
        fila.mostrarFila();
    }
}

