package disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.Executors;

public class DisruptorDemo {
    public static void main(String[] args) {
        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
                OrderEvent::new,
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler());
        disruptor.start();
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer orderEventProducer = new OrderEventProducer(ringBuffer);
        orderEventProducer.onData(UUID.randomUUID().toString());
    }
}
