import java.util.*;

public class GrafoLista {
    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String v) {
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
        } else {
            System.out.println("El vértice " + v + " ya existe.");
        }
    }

    public void agregarArista(String v1, String v2) {
        if (!grafo.containsKey(v1) || !grafo.containsKey(v2)) {
            System.out.println("Error: uno o ambos vértices no existen.");
            return;
        }
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public void mostrarGrafo() {
        System.out.println("=== Lista de Adyacencia ===");
        for (String v : grafo.keySet()) {
            System.out.println(v + " -> " + grafo.get(v));
        }
    }

    public static void main(String[] args) {
        GrafoLista g = new GrafoLista();
        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");
        g.mostrarGrafo();
    }
}