import java.util.*;

class Estacionamento {
    private Deque<Integer> deque;
    private Queue<Integer> filaEspera;
    private static final int CAPACIDADE = 10;

    public Estacionamento() {
        deque = new LinkedList<>();
        filaEspera = new LinkedList<>();
    }

    public void chegadaCarro(String entrada, int placa) {
        if (deque.size() < CAPACIDADE) {
            if (entrada.equals("PT")) {
                deque.addFirst(placa); 
            } else {
                deque.addLast(placa); 
            }
            System.out.println("Carro " + placa + " entrou pelo " + entrada + ".");
        } else {
            filaEspera.add(placa);
            System.out.println("Estacionamento cheio. Carro " + placa + " aguardando vaga.");
        }
    }

    public void partidaCarro(int placa) {
        if (!deque.contains(placa)) {
            if (filaEspera.contains(placa)) {
                filaEspera.remove(placa);
                System.out.println("Carro " + placa + " partiu da fila de espera sem deslocamentos.");
            } else {
                System.out.println("Carro " + placa + " não está no estacionamento.");
            }
            return;
        }

        int deslocamentos = 0;
        Deque<Integer> tempDeque = new LinkedList<>();
        while (!deque.isEmpty()) {
            int atual = deque.removeFirst();
            if (atual == placa) {
                System.out.println("Carro " + placa + " partiu após " + deslocamentos + " deslocamentos.");
                break;
            } else {
                tempDeque.addLast(atual);
                deslocamentos++;
            }
        }
        while (!tempDeque.isEmpty()) {
            deque.addFirst(tempDeque.removeLast());
        }
        if (!filaEspera.isEmpty()) {
            int carroFila = filaEspera.poll();
            deque.addFirst(carroFila);
            System.out.println("Carro " + carroFila + " entrou da fila de espera.");
        }
    }

    public void estadoEstacionamento() {
        System.out.println("Estacionamento: " + deque);
        System.out.println("Fila de espera: " + filaEspera);
    }
}