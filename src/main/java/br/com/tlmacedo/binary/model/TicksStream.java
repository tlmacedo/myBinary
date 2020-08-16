package br.com.tlmacedo.binary.model;

import javafx.beans.property.*;

public class TicksStream {

    private ObjectProperty<Echo_req> echo_req = new SimpleObjectProperty<>();
    private ObjectProperty<Msg_type> msg_type = new SimpleObjectProperty<>();
    private ObjectProperty<Subscription> subscription = new SimpleObjectProperty<>();
    private ObjectProperty<Tick> tick = new SimpleObjectProperty<>();

    public TicksStream() {
    }

    public Echo_req getEcho_req() {
        return echo_req.get();
    }

    public ObjectProperty<Echo_req> echo_reqProperty() {
        return echo_req;
    }

    public void setEcho_req(Echo_req echo_req) {
        this.echo_req.set(echo_req);
    }

    public Msg_type getMsg_type() {
        return msg_type.get();
    }

    public ObjectProperty<Msg_type> msg_typeProperty() {
        return msg_type;
    }

    public void setMsg_type(Msg_type msg_type) {
        this.msg_type.set(msg_type);
    }

    public Subscription getSubscription() {
        return subscription.get();
    }

    public ObjectProperty<Subscription> subscriptionProperty() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription.set(subscription);
    }

    public Tick getTick() {
        return tick.get();
    }

    public ObjectProperty<Tick> tickProperty() {
        return tick;
    }

    public void setTick(Tick tick) {
        this.tick.set(tick);
    }

    @Override
    public String toString() {
        return "TicksStream{" +
                "echo_req=" + echo_req +
                ", msg_type=" + msg_type +
                ", subscription=" + subscription +
                ", tick=" + tick +
                '}';
    }

    //    {
//        "echo_req": {
//        "subscribe": 1,
//                "ticks": "R_50"
//    },
//        "msg_type": "tick",
//            "subscription": {
//        "id": "b12d927a-3461-5351-e878-9ec8c19605bb"
//    },
//        "tick": {
//        "ask": 260.1191,
//                "bid": 260.0791,
//                "epoch": 1597340038,
//                "id": "b12d927a-3461-5351-e878-9ec8c19605bb",
//                "pip_size": 4,
//                "quote": 260.0991,
//                "symbol": "R_50"
//    }
//    }

    class Echo_req {
        private IntegerProperty subscribe = new SimpleIntegerProperty();
        private StringProperty ticks = new SimpleStringProperty();

        public Echo_req() {
        }

        public int getSubscribe() {
            return subscribe.get();
        }

        public IntegerProperty subscribeProperty() {
            return subscribe;
        }

        public void setSubscribe(int subscribe) {
            this.subscribe.set(subscribe);
        }

        public String getTicks() {
            return ticks.get();
        }

        public StringProperty ticksProperty() {
            return ticks;
        }

        public void setTicks(String ticks) {
            this.ticks.set(ticks);
        }

        @Override
        public String toString() {
            return "Echo_req{" +
                    "subscribe=" + subscribe +
                    ", ticks=" + ticks +
                    '}';
        }
    }

    class Subscription {
        private StringProperty id = new SimpleStringProperty();

        public Subscription() {
        }

        public String getId() {
            return id.get();
        }

        public StringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        @Override
        public String toString() {
            return "Subscription{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}
