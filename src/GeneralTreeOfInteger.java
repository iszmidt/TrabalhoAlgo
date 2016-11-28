
import java.util.ArrayList;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {

        public Node father;
        public Linha element;
        public ArrayList<Node> subtrees;
                
        public Node(Linha element) {
            father = null;
            this.element = element;
            subtrees = new ArrayList<>();
        }
        
        public Node(Linha element, Node father) {
            this.father = father;
            this.element = element;
            subtrees = new ArrayList<>();
        }

        public void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }

        public boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }

        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }

        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    // Atributos
    private Node root;
    private int count;

    // Metodos
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }

    public Linha getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void setRoot(Linha element) {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        root.element = element;
    }

    public boolean isRoot(Integer element) {
        if (root != null) {
            if (root.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        root = null;
        count = 0;
    }

    public Linha getFaher(Linha element) {
        Node n = searchNodeRef(element, root);
        if (n == null || n.father == null) {
            return null;
        } else {
            return n.father.element;
        }
    }

    public boolean contains(Linha element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node searchNodeRef(Linha father, Node target) {
        Node res = null;
        if (target != null) {
            if (father.equals(target.element)) {
                res = target;
            } else {
                Node aux = null;
                int i = 0;
                while ((aux == null) && (i < target.getSubtreesSize())) {
                    aux = searchNodeRef(father, target.getSubtree(i));
                    i++;
                }
                res = aux;
            }
        }
        return res;
    }

    public boolean add(Linha element, Linha father) {
        Node n = new Node(element);
        Node nAux = null;
        boolean res = false;
        if (father == null) {   // Insere na raiz 	
            if (root != null) { //Atualiza o pai da raiz
                n.addSubtree(root);
                root.father = n;
            }
            root = n;   //Atualiza a raiz
            res = true;
        } else {        //Insere no meio da Árvore
            nAux = searchNodeRef(father, root);
            if (nAux != null) {
                nAux.addSubtree(n);
                res = true;
            }
        }
        count++;
        return res;
    }


    public ArrayList<Linha> positionsPre() {
        ArrayList<Linha> lista = new ArrayList<>();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, ArrayList<Linha> lista) {
        if (n != null) {
            lista.add(n.element);
            for (int i = 0; i < n.getSubtreesSize(); i++) {
                positionsPreAux(n.getSubtree(i), lista);
            }
        }
    }
    
    public ArrayList<Linha> positionsWidth() {
        ArrayList<Linha> lista = new ArrayList<>();

        Queue<Node> fila = new Queue<>();
        Node atual;

        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                lista.add(atual.element);
                for (int i = 0; i < atual.getSubtreesSize(); i++) {
                    fila.enqueue(atual.getSubtree(i));
                }
            }
        }
        return lista;
    }

}
