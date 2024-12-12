package org.less05.ex1;

public class Friend {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public synchronized void greeting(Friend friend){
        System.out.println(name + ": " + friend.getName() + " shook my hand");
        friend.greetingBack(this);
    }
    private synchronized void greetingBack(Friend friend){
        System.out.println(name + ": shook hand in replay "+ friend.getName());
    }
}
