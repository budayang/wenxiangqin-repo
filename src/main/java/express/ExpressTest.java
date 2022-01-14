package express;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

import java.util.ArrayList;
import java.util.List;

public class ExpressTest {
    public static void main(String[] args) throws Exception {
//        teatOperator();
        testShortCircuit();
    }

    public static void testSum() throws Exception {
        ExpressRunner expressRunner = new ExpressRunner();
        IExpressContext<String, Object> context = new DefaultContext<>();
        String script = "sum=0;for(i=0;i<10;i=i+1){sum=sum+i;};return sum;";
        Object res = expressRunner.execute(script, context, null, true, false);
        System.out.println(res);
    }

    public static void teatOperator() throws Exception {
        ExpressRunner expressRunner = new ExpressRunner();
        expressRunner.addOperatorWithAlias("如果","if", null);
        expressRunner.addOperatorWithAlias("则","then", null);
        expressRunner.addOperatorWithAlias("否则","else", null);

//        expressRunner.addOperatorWithAlias("语文", "100", null);
//        expressRunner.addOperatorWithAlias("数学", "80", null);
//        expressRunner.addOperatorWithAlias("英语", "90", null);

        String script = "如果 (语文+数学+英语>270) 则 {return 1;} 否则 {return 0;}";
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("语文", 80);
        context.put("数学", 80);
        context.put("英语", 80);

        Object res = expressRunner.execute(script, context, null, false, false, null);
        System.out.println(res);
    }

    public static void testShortCircuit() throws Exception {
        ExpressRunner expressRunner = new ExpressRunner();
        expressRunner.setShortCircuit(true);
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("违规天数", 100);
        context.put("虚假交易扣分", 11);
        context.put("VIP", false);
        List<String> errorInfo = new ArrayList<>();
        expressRunner.getOperatorFactory().getOperator("<").setErrorInfo("$1 < $2 = false");
        expressRunner.getOperatorFactory().getOperator(">").setErrorInfo("$1 > $2 = false");
        String script = "(2 < 1) and (违规天数 < 90 or 虚假交易扣分 < 12)";
        Boolean res = (Boolean) expressRunner.execute(script, context, errorInfo, true, false);
        if (res.booleanValue() == true) {
            System.out.println(script + " is true");
        } else {
            System.out.println(script + " is false");
            for (String error : errorInfo) {
                System.out.println(error);
            }
        }
    }
}
