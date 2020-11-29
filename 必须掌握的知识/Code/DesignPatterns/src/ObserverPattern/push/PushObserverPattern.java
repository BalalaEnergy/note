package ObserverPattern.push;

import java.util.ArrayList;
import java.util.List;

public class PushObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserverOne observerOne = new ConcreteObserverOne();
        ConcreteObserverTwo observerTwo = new ConcreteObserverTwo();

        subject.register(observerOne);
        subject.register(observerTwo);
        subject.change("start");
        System.out.println("observerOne state is " + observerOne.getState());
        System.out.println("observerTwo state is " + observerTwo.getState());
        subject.change("end");
        System.out.println("observerOne state is " + observerOne.getState());
        System.out.println("observerTwo state is " + observerTwo.getState());
    }
}

abstract class Subject {

    // 需要通知的对象
    private List<Observer> list = new ArrayList<>();

    // 注册观察者
    public void register(Observer object) {
        list.add(object);
    }

    // 注销观察者
    public void destroy(Observer object) {
        list.remove(object);
    }

    // 通知所有已注册的观察者
    public void notifyObservers(String state){
        list.forEach(observer -> observer.update(state));
    }
}

class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    // 当需要通知其他观察者时，调用该方法
    public void change(String state) {
        this.state = state;
        notifyObservers(state);
    }
}

interface Observer {
    void update(String message);
}

class ConcreteObserverOne implements Observer {

    private String state;

    @Override
    public void update(String state) {
        this.state = state;
        System.out.println("ObserverOne is updated, state is " + state);
    }

    public String getState() {
        return state;
    }
}

class ConcreteObserverTwo implements Observer {

    private String state;

    @Override
    public void update(String state) {
        this.state = state;
        System.out.println("ObserverTwo is updated, state is " + state);
    }

    public String getState() {
        return state;
    }
}
