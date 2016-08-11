import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by TommyFish on 16/8/11.
 */
public class RandNumGenerator {

    //牌组
    private int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13};

    //从52张牌中抽取n张卡
    public List<Integer> randomSelect(int n){
        List<Integer> list =new ArrayList<>();
        for(int i=0; i<n; i++){
            int r = (int)(Math.random()*(52-i));  //生成介于0~(51-i)的随机整数
            list.add(a[r]);

            //因为索引为r的牌已经抽出，将末尾的数字替换过来
            a[r] = a[51];
        }

        return list;
    }

}
