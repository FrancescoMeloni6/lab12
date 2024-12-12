package it.unibo.es3;

import java.util.List;
import java.util.Set;

public interface Logics {

    List<Pair<Integer, Integer>> getInitalPositions();

    Set<Pair<Integer, Integer>> advance();
}
