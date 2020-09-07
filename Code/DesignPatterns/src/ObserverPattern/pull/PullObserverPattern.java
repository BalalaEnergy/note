package ObserverPattern.pull;

import java.util.ArrayList;
import java.util.List;

public class PullObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserverOne observerOne = new ConcreteObserverOne();
        ConcreteObserverTwo observerTwo = new ConcreteObserverTwo();

        subject.register(observerOne);
        subject.register(observerTwo);
        subject.change("start");
        subject.change("end");
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
    public void notifyObservers(){
        list.forEach(observer -> observer.update(this));
    }
}

class ConcreteSubject extends Subject {
    private String state;
    private String previousState;

    public String getState() {
        return state;
    }

    public String getPreviousState() {
        return previousState;
    }

    // 当需要通知其他观察者时，调用该方法
    public void change(String state) {
        this.previousState = this.state;
        this.state = state;
        notifyObservers();
    }
}

interface Observer {
    void update(Subject subject);
}

class ConcreteObserverOne implements Observer{

    @Override
    public void update(Subject subject) {
        System.out.println("ObserverOne is updated");
    }
}

class ConcreteObserverTwo implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("ObserverTwo is updated");
    }
}
