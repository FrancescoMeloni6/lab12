package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final static int RANDOMIZED_NUMBERS = 3;

    private final List<Pair<Integer, Integer>> randomizedPositions;
    private final int width;

    public LogicsImpl(int width) {
        this.width = width;
        this.randomizedPositions = new ArrayList<Pair<Integer, Integer>>(RANDOMIZED_NUMBERS);
        randomizePositions();
    }

    private void randomizePositions() {
        for (int i = 0; i < RANDOMIZED_NUMBERS; i++) {
            Pair<Integer, Integer> pos;
            boolean inputOk = false;
            Random r = new Random(System.currentTimeMillis());
            while (!inputOk) {
                inputOk = !randomizedPositions.contains(pos = new Pair<Integer, Integer>(
                    Math.abs(r.nextInt() % width), 
                    Math.abs(r.nextInt() % width)));
                randomizedPositions.add(pos);
            }
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getInitalPositions() {
        return List.copyOf(randomizedPositions);
    }

    @Override
    public List<Pair<Integer, Integer>> advance() {
        // TODO Auto-generated method stub
        return null;
    }

}
