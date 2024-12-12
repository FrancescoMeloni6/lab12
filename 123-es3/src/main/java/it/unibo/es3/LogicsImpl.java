package it.unibo.es3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final static int RANDOMIZED_NUMBERS = 3;

    private final List<Pair<Integer, Integer>> randomizedPositions;
    private final int width;
    private final Set<Pair<Integer, Integer>> advanced;

    public LogicsImpl(final int width) {
        this.width = width;
        this.randomizedPositions = new ArrayList<Pair<Integer, Integer>>(RANDOMIZED_NUMBERS);
        this.advanced = new HashSet<>();
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
                    this.advanced.add(pos);
                }
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
        for (Pair<Integer, Integer> key : this.advanced) {
            out.addAll(getAdiacentPositions(key));
        }
        advanced.addAll(out);
        return out;
    }

    private Set<Pair<Integer, Integer>> getAdiacentPositions(final Pair<Integer, Integer> pos) {
        Set<Pair<Integer, Integer>> adiacents = new HashSet<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                final int x = pos.getX() + i;
                final int y = pos.getY() + j;
                if (x >= 0 && x <= width - 1 && y >= 0 && y <= width - 1 && !(x == pos.getX() && y == pos.getY())) {
                    adiacents.add(new Pair<Integer,Integer>(x, y));
                }         
            }
        }
        return adiacents;
    }

    @Override
    public Boolean toQuit() {
        return advanced.size() >= width * width;
    }
}
