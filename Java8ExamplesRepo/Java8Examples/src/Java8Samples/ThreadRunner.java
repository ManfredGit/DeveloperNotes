package Java8Samples;
class ThreadRunner implements Runnable 
{ 
    int x = 0, y = 0; 
    int addX() {x++; return x;} 
    int addY() {y++; return y;} 
    public void run() { 
    for(int i = 0; i < 10; i++) 
        System.out.println(addX() + " " + addY()); 
} 
    public static void main(String args[]) 
    { 
        ThreadRunner run1 = new ThreadRunner(); 
        ThreadRunner run2 = new ThreadRunner(); 
        Thread t1 = new Thread(run1); 
        Thread t2 = new Thread(run2); 
        t1.start(); 
        t2.start(); 
    } 
}
