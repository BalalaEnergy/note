package StrategyPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        SalesOrder2 salesOrder = new SalesOrder2(TaxStrategyFactory.newTaxStrategy());
        salesOrder.calculateTax();
    }
}

class Context {
    // 上下文相关
}

class TaxStrategyFactory {
    public static TaxStrategy newTaxStrategy() {
//        return new ChinaTax();
        return new FranceTax();
    }
}

/**
 * 可以使用接口或抽象类，根据具体业务来选择
 * 比如结合模板方法时，可以使用抽象类
 */
interface TaxStrategy {
    void calculateTax(Context context);
}

/**
 * 来了个新需求，增加一个计算法国税的功能
 */
class FranceTax implements TaxStrategy {

    // 只需要新增一个类并实现TaxStrategy接口即可。其他的Tax类不需要修改
    @Override
    public void calculateTax(Context context) {
        System.out.println("calculate France Tax");
    }
}

class ChinaTax implements TaxStrategy {
    @Override
    public void calculateTax(Context context) {
        System.out.println("calculate China Tax");
    }
}

class USTax implements TaxStrategy {
    @Override
    public void calculateTax(Context context) {
        System.out.println("calculate U.S Tax");
    }
}

class GermanyTax implements TaxStrategy {
    @Override
    public void calculateTax(Context context) {
        System.out.println("calculate Germany Tax");
    }
}

class SalesOrder2 {
    TaxStrategy taxStrategy;
    public SalesOrder2(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
    public void calculateTax() {
        Context context = new Context();
        taxStrategy.calculateTax(context);
    }
}
//abstract class TaxStrategy {
//    protected abstract void calculateTax(Context context);
//}
//
//class ChinaTax extends TaxStrategy {
//
//    @Override
//    protected void calculateTax(Context context) {
//        System.out.println("calculate China Tax");
//    }
//}
//
//class USTax extends TaxStrategy {
//
//    @Override
//    protected void calculateTax(Context context) {
//        System.out.println("calculate U.S Tax");
//    }
//}
//
//class GermanyTax extends TaxStrategy {
//
//    @Override
//    protected void calculateTax(Context context) {
//        System.out.println("calculate Germany Tax");
//    }
//}
