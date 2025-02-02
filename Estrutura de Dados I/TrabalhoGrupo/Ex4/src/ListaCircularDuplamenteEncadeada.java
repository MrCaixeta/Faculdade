public class ListaCircularDuplamenteEncadeada {
    private NoDuplo head;

    public ListaCircularDuplamenteEncadeada() {
        this.head = null;
    }

    public void insert(int data) {
        NoDuplo newNode = new NoDuplo(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            NoDuplo tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public int countElements() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        NoDuplo current = head;
        while (current.next != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtHead(int data) {
        insert(data);
        head = head.prev;
    }

    public void printList() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        NoDuplo current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(volta para o início)");
    }

    public ListaCircularDuplamenteEncadeada copy() {
        ListaCircularDuplamenteEncadeada newList = new ListaCircularDuplamenteEncadeada();
        if (head == null) {
            return newList;
        }

        NoDuplo current = head;
        do {
            newList.insert(current.data);
            current = current.next;
        } while (current != head);

        return newList;
    }

    public static ListaCircularDuplamenteEncadeada concatenateNew(ListaCircularDuplamenteEncadeada list1, ListaCircularDuplamenteEncadeada list2) {
        ListaCircularDuplamenteEncadeada newList = list1.copy();

        if (list2.head == null) return newList;

        NoDuplo current = list2.head;
        do {
            newList.insert(current.data);
            current = current.next;
        } while (current != list2.head);

        return newList;
    }

    public static ListaCircularDuplamenteEncadeada interleaveSorted(ListaCircularDuplamenteEncadeada list1, ListaCircularDuplamenteEncadeada list2) {
        ListaCircularDuplamenteEncadeada newList = new ListaCircularDuplamenteEncadeada();

        NoDuplo current1 = list1.head;
        NoDuplo current2 = list2.head;

        if (current1 == null) return list2.copy();
        if (current2 == null) return list1.copy();

        do {
            newList.sortedInsert(current1.data);
            current1 = current1.next;
        } while (current1 != list1.head);

        do {
            newList.sortedInsert(current2.data);
            current2 = current2.next;
        } while (current2 != list2.head);

        return newList;
    }

    public void sortedInsert(int data) {
        NoDuplo newNode = new NoDuplo(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        NoDuplo current = head;

        do {
            if (current.data >= data) break;
            current = current.next;
        } while (current != head);

        NoDuplo prevNode = current.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = current;
        current.prev = newNode;

        if (current == head && data < head.data) {
            head = newNode;
        }
    }
}
