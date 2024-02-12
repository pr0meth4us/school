import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class shuffleRows {
    public static void shuffle(int[][] m){
        Integer[] rowIndex = new Integer[m.length];

        for (int i =0; i<m.length; i++){
            rowIndex[i] = i;
        }
        List<Integer> rowIndexList = Arrays.asList(rowIndex);
        Collections.shuffle(rowIndexList);
        for (int i =0; i<m.length; i++){
            int shuffledIndex = rowIndexList.get(i);
            int[] temp = m[i];
            m[i] = m[shuffledIndex];
            m[shuffledIndex] = temp;

        }

    }
    public static void main(String[] args){
        int[][] m ={{1,2},{3,4},{5,6},{7,8},{9,10}};

        shuffle(m);
        System.out.println(Arrays.deepToString(m));

    }
}
