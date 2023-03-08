public class Stack<E> {
    private LinkedList<E> list;

    Stack() {
        this.list = new LinkedList<E>();
    }

    public void push(E o) {
        this.list.insert(o);
    }

    public E pop() throws StackException {
        if (this.list.isEmpty()) {
            throw new StackException("Popping an empty stack");
        }
        E item = this.list.delete(this.list.getSize() - 1).getItem();
        return item;
    }

    public E peek() throws StackException {
        if (this.list.isEmpty()) {
            throw new StackException("Peeking an empty stack");
        }
        return this.list.getTail().getItem();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.getSize();
    }

}