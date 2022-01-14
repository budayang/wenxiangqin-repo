package disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;


public class OrderEventHandler implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent orderEvent, long l, boolean b) throws Exception {
        System.out.println("有监听到成功事件");
        System.out.println(orderEvent);
        System.out.println(l);
        System.out.println(b);
    }

    @Override
    public void onEvent(OrderEvent orderEvent) throws Exception {
        System.out.println("有监听到成功事件2");
        System.out.println(orderEvent);
    }
}
