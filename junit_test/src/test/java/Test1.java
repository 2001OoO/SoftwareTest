import com.nk.method.Caculator;
import org.junit.Test;

public class Test1 {
    @Test
    public void TestAdd(){
        Caculator caculator = new Caculator();
        caculator.add(1,10);
        System.out.println(caculator.GetResult());
    }

    @Test
    public void TestReduce(){
        Caculator caculator = new Caculator();
        caculator.reduce(1,10);
        System.out.println(caculator.GetResult());
    }

    @Test
    public void TestRide(){
        Caculator caculator = new Caculator();
        caculator.ride(1,10);
        System.out.println(caculator.GetResult());
    }

    @Test
    public void TestExcept(){
        Caculator caculator = new Caculator();
        caculator.except(1,10);
        System.out.println(caculator.GetResult());
    }
}
