public class ThreadLocalTest {
    public static void main(String[] args) {
        Thread ta=new Ta();
        Thread tb=new Tb();
        ta.start();
        tb.start();
        for(int i=0;i<20;i++){
            Tool.t1.set("main"+i);
            System.out.println("main get"+Tool.t1.get());
        }
    }
    static class Ta extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                Tool.t1.set("ta"+i);
                System.out.println("ta get"+Tool.t1.get());
            }
        }
    }
    static class Tb extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                Tool.t1.set("tb"+i);
                System.out.println("tb get"+Tool.t1.get());
            }
        }
    }
}
