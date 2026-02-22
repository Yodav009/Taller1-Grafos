import java.util.*;

public class GrafoRecorridos {
    private HashMap<String, List<String>> grafo;

    public GrafoRecorridos() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String v) {
        grafo.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        if (!grafo.containsKey(v1) || !grafo.containsKey(v2)) {
            System.out.println("Error: vértice no encontrado.");
            return;
        }
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public void bfs(String inicio) {
        if (!grafo.containsKey(inicio)) { System.out.println("Vértice no existe."); return; }
        Set<String> visitado = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);
        visitado.add(inicio);
        System.out.print("BFS desde " + inicio + ": ");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");
            for (String vecino : grafo.get(actual)) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String inicio) {
        if (!grafo.containsKey(inicio)) { System.out.println("Vértice no existe."); return; }
        Set<String> visitado = new HashSet<>();
        System.out.print("DFS desde " + inicio + ": ");
        dfsRecursivo(inicio, visitado);
        System.out.println();
    }

    private void dfsRecursivo(String v, Set<String> visitado) {
        visitado.add(v);
        System.out.print(v + " ");
        for (String vecino : grafo.get(v)) {
            if (!visitado.contains(vecino)) dfsRecursivo(vecino, visitado);
        }
    }

    public static void main(String[] args) {
        GrafoRecorridos g = new GrafoRecorridos();
        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");
        g.bfs("A");
        g.dfs("A");
    }
}