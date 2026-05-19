import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> map = new HashMap<>();
//    private final Map<T, List<Edge<T>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        if (hasVertex(v))
            return;

        map.put(v, new Vertex<>(v));
//        map.put(v, new LinkedList<>());
    }

    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertex(new Vertex<>(dest), weight);
//        map.get(source).add(new Edge<>(source, dest, weight));

        if (undirected)
            map.get(dest).addAdjacentVertex(new Vertex<>(source), weight);
//            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).contains(dest);
//        return map.get(source).contains(new Edge<>(source, dest));
    }

    public List<T> adjacencyList(T v) {
        List<T> vertices = new LinkedList<>();
        for (Vertex<T> vertex : map.get(v).getAdjacentVertices().keySet()){
            vertices.add(vertex.getData());
        }

        return vertices;

//        List<T> vertices = new LinkedList<>();
//        for (Edge<T> e : map.get(v)) {
//            vertices.add(e.getDest());
//        }
//
//        return vertices;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices(T v){
        return map.get(v).getAdjacentVertices();
    }
//    public Iterable<Edge<T>> getEdges(T v) {
//        if (!hasVertex(v)) return null;
//
//        return map.get(v);
//    }
}
