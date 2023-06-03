package entity;

import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, entity.Vertex<Vertex>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public void addVertex(Vertex v) {
        map.put(v, new entity.Vertex<>(v));
    }
    public entity.Vertex<Vertex> getVertex(Vertex v){
        return map.get(v);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjVertices(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjVertices(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).countOfAdj();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).containsDest(map.get(dest));
    }

    public Iterable<Vertex> adjList(Vertex v) {
        if (!hasVertex(v)) return null;
        return map.get(v).getAdj();
    }

}