package TemplateMethod;

public class TemplateMethod {
    public static void main(String[] args) {
        Application application = new Library();
        application.start();
    }
}

abstract class Application {
    // 稳定的部分，在主流程中实现
    protected /*final*/ void step1() {
        System.out.println("step1 run");
    }

    protected void step2() {
        System.out.println("step2 run");
    }

    // 需要变化的部分，交给子类来实现
    protected abstract void step3();
    protected abstract void step4();

    protected void end() {
        System.out.println("Application End");
    }

    // 调用父类的方法，开始一个流程
    final void start() {
        step1();
        step2();
        step3();
        step4();
        end();
    }
}

class Library extends Application {

    @Override
    protected void step3() {
        System.out.println("step3 run");
    }

    @Override
    protected void step4() {
        System.out.println("step4 run");
    }

    @Override
    protected void end() {
        System.out.println("Library End");
    }
}