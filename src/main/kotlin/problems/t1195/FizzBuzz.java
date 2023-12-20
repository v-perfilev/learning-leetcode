package problems.t1195;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

class FizzBuzz {
    private final int n;
    private int counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        print(
                c -> c % 3 != 0 || c % 5 == 0,
                c -> printFizz.run()
        );
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        print(
                c -> c % 3 == 0 || c % 5 != 0,
                c -> printBuzz.run()
        );
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        print(
                c -> c % 3 != 0 || c % 5 != 0,
                c -> printFizzBuzz.run()
        );
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        print(
                c -> c % 3 == 0 || c % 5 == 0,
                printNumber::accept
        );
    }

    private void print(Function<Integer, Boolean> condition, Consumer<Integer> action) throws InterruptedException {
        while (counter <= n) {
            synchronized (this) {
                while (condition.apply(counter) && counter <= n) {
                    wait();
                }
                if (counter <= n) {
                    action.accept(counter);
                }
                counter++;
                notifyAll();
            }
        }
    }
}
