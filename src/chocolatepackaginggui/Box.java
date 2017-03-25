/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocolatepackaginggui;

/**
 *
 * @author sandr
 */
public class Box {
 
    boolean[][] theBoxMatrix;
    
    boolean add(int chocolateType) {
        if (chocolateType<1 || chocolateType>3) { System.out.println("ERRORE GRAVE!"); System.exit(-1); }
        
        for (int i = 0; i < theBoxMatrix[2*(chocolateType-1)].length; i++) {
            if (theBoxMatrix[2*(chocolateType-1)][i]) continue;
            theBoxMatrix[2*(chocolateType-1)][i]=true;
            return true;
        }
        for (int i = 0; i < theBoxMatrix[2*(chocolateType-1)+1].length; i++) {
            if (theBoxMatrix[2*(chocolateType-1)+1][i]) continue;
            theBoxMatrix[2*(chocolateType-1)+1][i]=true;
            return true;
        }
        return false;
    }

    public Box() {
        theBoxMatrix = new boolean[6][4];
    }
    
    boolean isFull() {
        for (int i = 0; i < theBoxMatrix.length; i++) {
            for (int j = 0; j < theBoxMatrix[i].length; j++) {
                if (!theBoxMatrix[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < theBoxMatrix.length; i++) {
            for (int j = 0; j < theBoxMatrix[i].length; j++) {
                if (theBoxMatrix[i][j]) s+="X\t"; else s+="O\t";
            }
            s += "\n";
        }
        return s;
    }
    
    
    
}
