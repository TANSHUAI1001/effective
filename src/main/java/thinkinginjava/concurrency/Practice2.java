package thinkinginjava.concurrency;

import net.mindview.util.Generator;

public class Practice2{
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Practice2Fibonacci(i+10)).start();
        }
    }
}

class Practice2Fibonacci implements Generator<Integer>,Runnable {
        private int num;
        private int count = 0;
        public Practice2Fibonacci(){
            this.num = 0;
        }
        public Practice2Fibonacci(int num){
            this.num = num;
        }
        public Integer next() { return fib(count++); }
        private int fib(int n) {
            if(n < 2) return 1;
            return fib(n-2) + fib(n-1);
        }

        @Override
        public void run() {
            Practice2Fibonacci gen = new Practice2Fibonacci(num);
            for(int i = 0; i < num; i++)
                System.out.print(gen.next() + " ");
        }
}
