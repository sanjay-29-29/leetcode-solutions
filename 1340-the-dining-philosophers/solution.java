class DiningPhilosophers {
    Semaphore[] sp = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            sp[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    synchronized public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
                sp[philosopher].acquire();
                sp[(philosopher + 1) % 5].acquire();
                
                pickLeftFork.run(); 
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();

                sp[philosopher].release();
                sp[(philosopher + 1) % 5].release();

    }
}
