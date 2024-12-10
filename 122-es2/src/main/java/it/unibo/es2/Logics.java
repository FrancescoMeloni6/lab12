package it.unibo.es2;

public interface Logics {
    
    Boolean isQuittable();

    <X,Y> String changeBox(Pair<X,Y> position);
}
