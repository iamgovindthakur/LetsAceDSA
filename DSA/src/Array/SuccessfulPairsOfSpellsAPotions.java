package Array;

import java.util.Arrays;


//LC 2300
public class SuccessfulPairsOfSpellsAPotions {
    static public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; ++i)
            ans[i] = potions.length - firstIndexSuccess(spells[i], potions, success);
        return ans;
    }

    // First index i s.t. spell * potions[i] >= success
    static private int firstIndexSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if ((long) spell * potions[m] >= success) r = m;
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] spells = new int[]{5, 1, 3};
        int[] potions = new int[]{1, 2, 3, 4, 5};
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }


}
