package org.lect02_balls.circles.exceptions;

public class BallsOverflowException extends RuntimeException{
    public BallsOverflowException() {
        super("Невозможно создать более 15 шаров");
    }
}
