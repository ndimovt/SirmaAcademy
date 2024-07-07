package io.github.ndimovt.solid.isp;

public abstract class Player implements Playable, Pausable, Shuffler, RecordNavigator{
    @Override
    public void next() {
        System.out.println("next");
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void play() {
        System.out.println("play");
    }

    @Override
    public void previous() {
        System.out.println("prev");
    }

    @Override
    public void shuffle() {
        System.out.println("shuffle");
    }
}
