package StrategyPattern;

public class GeneralWrite {
    public static void main(String[] args) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.tax = TaxBase.CN_Tax;
        salesOrder.calculateTax();
    }
}

enum TaxBase {
    CN_Tax,
    US_Tax,
    DE_Tax,
    FR_Tax      //新增计算法国的税
}

class SalesOrder {
    TaxBase tax;

    public void calculateTax() {
        if (tax == TaxBase.CN_Tax) {
            System.out.println("calculate China Tax");
        }
        else if (tax == TaxBase.US_Tax) {
            System.out.println("calculate U.S Tax");
        }
        else if (tax == TaxBase.DE_Tax) {
            System.out.println("calculate Germany Tax");
        }
        // 新增计算法国税时，显然违反了面向对象设计原则中的开闭原则。
        else if (tax == TaxBase.FR_Tax) {
            System.out.println("calculate France Tax");
        }
    }
}
