import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiayuan on 2018/5/22.
 */
public class Solution {
    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == j) level.add(1);
                else if (j == 0) level.add(1);
                else {
                    level.add(resultList.get(i - 1).get(j) + resultList.get(i - 1).get(j - 1));
                }
            }
            resultList.add(level);
        }

        return resultList;
    }
}
