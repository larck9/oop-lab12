package it.unibo.es2;
import javax.swing.*;
import java.util.HashSet;
import java.util.Map;

public class LogicsImpl implements Logics{
    private final int size;

    LogicsImpl(final int size){
        this.size=size;
    }

    //Quando tutte le label su una riga qualsiasi sono "*" o tutte le label su una colonna qualsiasi sono "*" ritorna true
    public boolean exitCondition(Map<JButton,Pair<Integer,Integer>> map){
        HashSet<Pair<Integer,Integer>> stars=new HashSet<>();
        HashSet<Pair<Integer,Integer>> spaces =new HashSet<>();
        for(JButton b:map.keySet()){
            if(b.getText().equals("*")){
                stars.add(map.get(b));
            }else{
                spaces.add(map.get(b));
            }
        }

        if(hasCompleteRowOrColumn(stars) || hasCompleteRowOrColumn(spaces)){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasCompleteRowOrColumn(HashSet<Pair<Integer, Integer>> coords) {
        // Controllo righe
        for (int row = 0; row < this.size; row++) {
            boolean fullRow = true;
            for (int col = 0; col < this.size; col++) {
                if (!coords.contains(new Pair<>(row, col))) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                return true;
            }
        }

        // Controllo colonne
        for (int col = 0; col < this.size; col++) {
            boolean fullCol = true;
            for (int row = 0; row < this.size; row++) {
                if (!coords.contains(new Pair<>(row, col))) {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) {
                return true;
            }
        }

        // Nessuna riga o colonna completa
        return false;
    }



    public String labelSwap(JButton button){
        if(button.getText().equals("*")){
            return " ";
        }else{
            return "*";
        }
    }
}
