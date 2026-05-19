import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }


    public void addAdjacentVertex(Vertex<T> dest, Double weight) {
        adjacentVertices.put(dest, weight);
    }

    public T getData() {
        return data;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean contains(T dest) {
        for (Vertex<T> vertex : adjacentVertices.keySet()) {
            if (vertex.getData().equals(dest)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // references compared

        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> otherEdge = (Vertex<?>) o;

        if (!Objects.equals(this.data, otherEdge.data)) return false;
        if (otherEdge.adjacentVertices.size() != size()) return false;

        for (Vertex<?> vertex : otherEdge.adjacentVertices.keySet()) {
            if (!adjacentVertices.containsKey(vertex)) return false;
        }

        return true;
    }

    public int size() {
        return adjacentVertices.size();
    }
}
