package it.unibo.es3;

import java.util.List;

public interface Logics {

    List<Pair<Integer, Integer>> getInitalPositions();

    List<Pair<Integer, Integer>> advance();
}
