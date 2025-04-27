class FizzBuzz {
    private int n;

    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzBuzzSem = new Semaphore(0);
    private Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                fizzSem.acquire();
                printFizz.run();
                numberSem.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0){
                buzzSem.acquire();
                printBuzz.run();
                numberSem.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                fizzBuzzSem.acquire();
                printFizzBuzz.run();
                numberSem.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSem.acquire();
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSem.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzzSem.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSem.release();
            } else {
                printNumber.accept(i);
                numberSem.release();
            }
        }
    }
}
