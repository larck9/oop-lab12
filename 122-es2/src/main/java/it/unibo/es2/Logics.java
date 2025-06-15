package it.unibo.es2;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public interface Logics {

    String labelSwap(JButton b);

    boolean exitCondition(Map<JButton,Pair<Integer,Integer>> map);
}