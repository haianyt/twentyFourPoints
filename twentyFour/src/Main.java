import java.util.List;

/**
 * Created by TommyFish on 16/8/11.
 */

public class Main {




    public static void main(String[] args) {


        //随机生成测试用例 实现见RandNumGenerator类
        RandNumGenerator randNumGenerator = new RandNumGenerator();

        //4张牌
        List<Integer> num = randNumGenerator.randomSelect(4);

        System.out.println("输入的牌组是: "+num.get(0)+" "+num.get(1)+" "+num.get(2)+" "+num.get(3));


        //判断数字的正确性
        for(int i = 0; i<4; i++){
            if(num.get(i) <1|| num.get(i) >13){
                System.out.println("Please input the right poker number");
            }
        }

        //实例化一个计算器
        Calculator calculator = new Calculator();


        //生成4个数字索引的全排列
        for(int a = 0; a < 4; a++){
            for(int b = 0; b < 4; b++){
                //如果跟第一个一样跳过
                if(b==a)
                    continue;

                for(int c = 0; c < 4; c++){
                    //同理
                    if(c==a || c==b)
                        continue;

                    for(int d = 0; d < 4; d++){
                        //同理
                        if(d==a || d==b || d==c)
                            continue;

                        //把整数转为浮点数，防止除法运算时省略小数部分
                        float A = (float) num.get(a);
                        float B = (float) num.get(b);
                        float C = (float) num.get(c);
                        float D = (float) num.get(d);

                        //运算符的全排列
                        for(int operator1 = 0; operator1 < 4; operator1++){
                            for (int operator2 = 0; operator2 < 4; operator2++){
                                for (int operator3 = 0; operator3 < 4; operator3++){

                                    //生成括号的组合并计算 见Calculator类中的注释
                                    calculator.calculateExpression(A,B,C,D,operator1,operator2,operator3);

                                }
                            }
                        }

                    }
                }
            }
        }


    }





}
