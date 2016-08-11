/**
 * Created by TommyFish on 16/8/11.
 */
public class Calculator {

    //二元操作符计算
    private float operate(float right,float left,int operator){
        switch (operator){
            case 0:
                return right+left;
            case 1:
                return right-left;
            case 2:
                return right*left;
            case 3:
                return right/left;
            default:
                return 0;
        }
    }

    //获取操作符枚举值的字符表示
    private String getOpt(int o){
        switch (o){
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
            default:
                return " ";
        }
    }

    // 5种计算组合，此处用逆波兰式（后缀式）表示，不用考虑乘除运算的优先级，方便计算
    public void calculateExpression(float a,float b, float c, float d, int o1, int o2, int o3){

        // a b ? c ? d ?
        if(operate(operate(operate(a,b,o1),c,o2),d,o3)==24)   //计算结果是24则输出表达式
            System.out.println((int)a + " " + (int)b + " " + getOpt(o1) + " " + (int)c + " " + getOpt(o2) + " " + (int)d + " " + getOpt(o3));

        // a b ? c d ? ?
        if(operate(operate(a,b,o1),operate(c,d,o2),o3)==24)
            System.out.println((int)a + " " + (int)b + " " + getOpt(o1) + " " + (int)c + " " + (int)d + " " + getOpt(o2) + " " + getOpt(o3));

        // a b c ? ? d ?
        if(operate(operate(a,operate(b,c,o1),o2),d,o3)==24)
            System.out.println((int) a + " " + (int) b + " " + (int) c + " " + getOpt(o1) + " " + getOpt(o2) + " " + (int) d + " " + getOpt(o3));


        // a b c ? d ? ?
        if(operate(a,operate(operate(b, c, o1), d, o2),o3)==24)
            System.out.println((int) a + " " + (int) b + " " + (int) c + " " + getOpt(o1) + " " + (int) d + " " + getOpt(o2) + " " + getOpt(o3));

        // a b c d ? ? ?
        if(operate(a, operate(b, operate(c, d, o1), o2), o3)==24)
            System.out.println((int) a + " " + (int) b + " " + (int) c + " " + (int) d + " " + getOpt(o1) + " " + getOpt(o2) + " " + getOpt(o3));
    }
}
