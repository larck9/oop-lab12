package it.unibo.es3;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicImpl implements Logic{

    private final int size;


    LogicImpl(final int size) {
        this.size = size;
    }

    public Set<Pair<Integer,Integer>> init() {
        HashSet<Pair<Integer,Integer>> s = new HashSet<>(3);
        while (s.size() < 3) {
            s.add(new Pair<>(new Random().nextInt(size),new Random().nextInt(size))); // genera numeri tra 0 e size-1
        }
        return s;
    }

    public Set<Pair<Integer,Integer>> toStar(final HashMap<Pair<Integer,Integer>, JButton>map){
        Set<Pair<Integer,Integer>> res=new HashSet<>();
        for(Pair<Integer,Integer> p:map.keySet()){
            if(map.get(p).getText().equals("*")){
                res.addAll(starAround(p,1));
            }
        }
        return res;
    }

    private Set<Pair<Integer, Integer>> starAround(final Pair<Integer, Integer> pair, int range) {
        Set<Pair<Integer, Integer>> res = new HashSet<>();

        int x = pair.getX();
        int y = pair.getY();

        // Lista di tutte le 8 direzioni
        int[][] directions = {
                {-range, 0},   // sopra
                {+range, 0},   // sotto
                {0, -range},   // sinistra
                {0, +range},   // destra
                {-range, -range}, // alto-sinistra
                {-range, +range}, // alto-destra
                {+range, -range}, // basso-sinistra
                {+range, +range}  // basso-destra
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < this.size && newY >= 0 && newY < this.size) {
                res.add(new Pair<>(newX, newY));
            }
        }

        return res;
    }

    // Metodo main per eseguire
    public static void main(String[] args) {
        int size = 10; // cambia il valore a piacere, ma ≥ 4
        LogicImpl logic = new LogicImpl(size);
        logic.init(); // stampa i numeri
    }
}
