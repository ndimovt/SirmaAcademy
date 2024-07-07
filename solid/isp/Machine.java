package io.github.ndimovt.solid.isp;

public abstract class Machine implements Scannable, Printable, FaxHub{
    public void print(){
        System.out.println("Print");
    }
    public void scan(){
        System.out.println("Scan stuff");
    }
    public void fax(){
        System.out.println("Fax work to be done here");
    }
}
