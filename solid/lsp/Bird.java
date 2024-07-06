package io.github.ndimovt.solid.lsp;

public abstract class Bird {
    //making Bird abstract and creating concrete method inside it removes the need for a concrete classes extending it to implement fly()
    public void fly(){
        System.out.println("Generic bird flying!");
    }

}
