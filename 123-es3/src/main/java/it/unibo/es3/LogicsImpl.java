package it.unibo.es3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final static int RANDOMIZED_NUMBERS = 3;

    private final List<Pair<Integer, Integer>> randomizedPositions;
    private final int width;
    private final Map<Pair<Integer, Integer>, Boolean> map;

    public LogicsImpl(int width) {
        this.width = width;
        this.randomizedPositions = new ArrayList<Pair<Integer, Integer>>(RANDOMIZED_NUMBERS);
        this.map = new HashMap<>();
        initializeMap();
        randomizePositions();
    }

    private void randomizePositions() {
        final Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < RANDOMIZED_NUMBERS; i++) {
            Pair<Integer, Integer> pos;
            boolean inputOk = false;
            while (!inputOk) {
                inputOk = !randomizedPositions.contains(pos = new Pair<Integer, Integer>(
                    Math.abs(r.nextInt() % width), 
                    Math.abs(r.nextInt() % width)));
                if(inputOk) {
                    randomizedPositions.add(pos);
                    this.map.put(pos, true);
                }
            }
        }
    }

    private void initializeMap() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.width; j++) {
                this.map.put(new Pair<Integer,Integer>(i, j), false);
            }
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getInitalPositions() {
        return List.copyOf(randomizedPositions);
    }

    @Override
    public Set<Pair<Integer, Integer>> advance() {
        final Set<Pair<Integer, Integer>> out = new HashSet<>();
        for (Pair<Integer, Integer> key : map.keySet()) {
            if (map.get(key)) {
                out.addAll(getAdiacentPositions(key));
            }
        }
        return out;
    }

    private List<Pair<Integer, Integer>> getAdiacentPositions(Pair<Integer, Integer> pos) {
        List<Pair<Integer, Integer>> adiacents = new LinkedList<>();
        
        return adiacents;
    }
}
