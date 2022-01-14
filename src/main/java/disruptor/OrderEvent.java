package disruptor;

public class OrderEvent {

    private String id;

    public OrderEvent() {
    }

    public OrderEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "id='" + id + '\'' +
                '}';
    }
}
