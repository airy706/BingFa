import java.awt.image.ImageObserver;
import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
         PipedReader in= new PipedReader();
         PipedWriter out= new PipedWriter();
         out.connect(in);
         int receive;
       Thread  print=new Thread(new Print(in),"printThread");
        print.start();
        try{
            while((receive=System.in.read())!=-1){
                out.write(receive);
            }
        }catch (IOException exp){

        }
    }
    private static class Print implements Runnable{
        private PipedReader in= new PipedReader();
        int receive;
        public Print(PipedReader in){
            this.in=in;
        }
        @Override
        public void run() {
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char)receive);
                }
            }catch(IOException exp){
            }

        }
    }
}
