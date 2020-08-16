package br.com.tlmacedo.binary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import java.math.BigDecimal;

public class Tick {
    private static final long serialVersionUID = 1L;

    private ObjectProperty<Number> ask = new SimpleObjectProperty<>();
    private ObjectProperty<Number> bid = new SimpleObjectProperty<>();
    private IntegerProperty epoch = new SimpleIntegerProperty();
    private StringProperty id = new SimpleStringProperty();
    private ObjectProperty<Number> pip_size = new SimpleObjectProperty<>();
    private ObjectProperty<Number> quote = new SimpleObjectProperty<>();
    private StringProperty symbol = new SimpleStringProperty();
    private IntegerProperty ultimoDigt = new SimpleIntegerProperty();

    public Tick() {
    }

    public Number getAsk() {
        return ask.get();
    }

    public ObjectProperty<Number> askProperty() {
        return ask;
    }

    public void setAsk(Number ask) {
        this.ask.set(ask);
    }

    public Number getBid() {
        return bid.get();
    }

    public ObjectProperty<Number> bidProperty() {
        return bid;
    }

    public void setBid(Number bid) {
        this.bid.set(bid);
    }

    public int getEpoch() {
        return epoch.get();
    }

    public IntegerProperty epochProperty() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch.set(epoch);
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

    public Number getPip_size() {
        return pip_size.get();
    }

    public ObjectProperty<Number> pip_sizeProperty() {
        return pip_size;
    }

    public void setPip_size(Number pip_size) {
        this.pip_size.set(pip_size);
    }

    public Number getQuote() {
        return quote.get();
    }

    public ObjectProperty<Number> quoteProperty() {
        return quote;
    }

    public void setQuote(Number quote) {
        this.quote.set(quote);
    }

    public String getSymbol() {
        return symbol.get();
    }

    public StringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    @JsonIgnore
    public int getUltimoDigt() {
        return (((Double) (quoteProperty().getValue().doubleValue() * 100)).intValue() % 10);
//        return ultimoDigt.get();
    }

    public IntegerProperty ultimoDigtProperty() {
        return ultimoDigt;
    }

    public void setUltimoDigt(int ultimoDigt) {
        this.ultimoDigt.set(ultimoDigt);
    }

    @Override
    public String toString() {
        return "Tick{" +
                "ask=" + ask +
                ", bid=" + bid +
                ", epoch=" + epoch +
                ", id='" + id + '\'' +
                ", pip_size=" + pip_size +
                ", quote=" + quote +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    //                "bid": 260.0791,
//                "epoch": 1597340038,
//                "id": "b12d927a-3461-5351-e878-9ec8c19605bb",
//                "pip_size": 4,
//                "quote": 260.0991,
//                "symbol": "R_50"

}
