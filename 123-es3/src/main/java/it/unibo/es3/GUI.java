package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final Map<Pair<Integer,Integer>,JButton> map = new HashMap<>();
    private final LogicImpl logic;
    
    public GUI(int width) {
        logic=new LogicImpl(width);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);

        ActionListener al = e -> {
            for(Pair<Integer,Integer> p:logic.toStar(new HashMap<>(map))){
                map.get(p).setText("*");
            }
        };

        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);

        JButton go= new JButton(">");
        this.getContentPane().add(go,BorderLayout.SOUTH);
        go.addActionListener(al);

        Set<Pair<Integer,Integer>> randomStart= logic.init();
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton();
                this.map.put(new Pair<>(i,j),jb);
                if(randomStart.contains(new Pair<>(i,j))){
                    jb.setText("*");
                }
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
    
}