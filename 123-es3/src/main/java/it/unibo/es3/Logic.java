package it.unibo.es3;

import javax.swing.*;
import java.util.HashMap;
import java.util.Set;

public interface Logic {

    Set<Pair<Integer,Integer>> init();

    Set<Pair<Integer,Integer>> toStar(final HashMap<Pair<Integer,Integer>, JButton> map);

}
