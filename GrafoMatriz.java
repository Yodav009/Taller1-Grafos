import java.util.*;

public class GrafoMatriz {
    private int[][] matriz;
    private Map<String, Integer> indice;
    private List<String> vertices;
    private int size;

    public GrafoMatriz(int maxVertices) {
        matriz = new int[maxVertices][maxVertices];
        indice = new HashMap<>();
        vertices = new ArrayList<>();
        size = 0;
    }

    public void agregarVertice(String v) {
        if (!indice.containsKey(v)) {
            indice.put(v, size);
            vertices.add(v);
            size++;
        }
    }

    public void agregarArista(String v1, String v2) {
        if (!indice.containsKey(v1) || !indice.containsKey(v2)) {
            System.out.println("Error: uno o ambos vértices no existen.");
            return;
        }
        int i = indice.get(v1);
        int j = indice.get(v2);
        matriz[i][j] = 1;
        matriz[j][i] = 1;
    }

    public void mostrarMatriz() {
        System.out.print("   ");
        for (String v : vertices) System.out.print(v + "  ");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(vertices.get(i) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoMatriz g = new GrafoMatriz(10);
        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarArista("A", "B");
        g.agregarArista("B", "C");
        g.agregarArista("C", "D");
        g.agregarArista("D", "A");
        System.out.println("=== Matriz de Adyacencia ===");
        g.mostrarMatriz();
    }
}