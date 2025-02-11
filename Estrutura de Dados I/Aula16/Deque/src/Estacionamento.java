import java.util.*;

class Estacionamento {
    private Deque<Integer> deque;
    private Queue<Integer> filaEspera;
    private final int capacidade;
    
    public Estacionamento(int capacidade) {
        this.capacidade = capacidade;
        this.deque = new LinkedList<>();
        this.filaEspera = new LinkedList<>();
    }
    
    public void chegadaCarro(int placa) {
        if (deque.size() < capacidade) {
            deque.addLast(placa);
            System.out.println("Carro " + placa + " estacionado.");
        } else {
            filaEspera.add(placa);
            System.out.println("Estacionamento cheio! Carro " + placa + " aguardando vaga.");
        }
    }
    
    public void partidaCarro(int placa) {
        if (deque.contains(placa)) {
            int deslocamentos = 0;
            Deque<Integer> tempDeque = new LinkedList<>();
            
            while (!deque.isEmpty() && deque.peekFirst() != placa) {
                tempDeque.addLast(deque.pollFirst());
                deslocamentos++;
            }
            
            if (!deque.isEmpty()) {
                deque.pollFirst(); 
                deslocamentos++;
                System.out.println("Carro " + placa + " saiu após " + deslocamentos + " deslocamentos.");
            }
            
            while (!tempDeque.isEmpty()) {
                deque.addFirst(tempDeque.pollLast());
            }
            
            if (!filaEspera.isEmpty()) {
                int carroEsperando = filaEspera.poll();
                deque.addLast(carroEsperando);
                System.out.println("Carro " + carroEsperando + " entrou no estacionamento.");
            }
        } else if (filaEspera.contains(placa)) {
            filaEspera.remove(placa);
            System.out.println("Carro " + placa + " foi embora da fila de espera sem estacionar.");
        } else {
            System.out.println("Carro " + placa + " não encontrado no estacionamento nem na fila de espera.");
        }
    }
    
    public void exibirEstacionamento() {
        System.out.println("Estado atual do estacionamento: " + deque);
        System.out.println("Fila de espera: " + filaEspera);
    }
}