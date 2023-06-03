package entity;
import java.util.*;
public class Vertex<V> {
    public V data;
    private final Map<Vertex<V>, Double> adjVertices;

    public Vertex(V data){
        adjVertices = new HashMap<>();
        this.data = data;
    }

    public Vertex(final Map<Vertex<V>, Double> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public V getData() {
        return data;
    }

    public void setData(final V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

    public Double getWeight(Vertex<V> v){
        return adjVertices.get(v);
    }
    public void addAdjVertices(Vertex<V> dest, double weight){
        adjVertices.put(dest, weight);
    }
    public boolean containsDest(Vertex<V> v){
        return adjVertices.containsKey(v);
    }
    public int countOfAdj(){
        return adjVertices.size();
    }
    public Iterable<V> getAdj(){
        List<V> vertices = new LinkedList<>();
        for (var e : adjVertices.keySet()) {
            vertices.add(e.data);
        }
        return vertices;
    }
}