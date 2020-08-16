package br.com.tlmacedo.binary.model;


import br.com.tlmacedo.binary.model.Enums.CONTRAC_TYPE;
import br.com.tlmacedo.binary.model.Enums.DURATION_UNIT;
import br.com.tlmacedo.binary.model.Enums.SYMBOL;
import javafx.beans.property.*;

public class PriceProposal {

    private IntegerProperty proposal = new SimpleIntegerProperty(1);
    private ObjectProperty<CONTRAC_TYPE> contract_type = new SimpleObjectProperty<>();
    private StringProperty currency = new SimpleStringProperty();
    private ObjectProperty<SYMBOL> symbol = new SimpleObjectProperty<>();
    private ObjectProperty<Number> amount = new SimpleObjectProperty<>();
    private IntegerProperty barrier = new SimpleIntegerProperty();
    private StringProperty basis = new SimpleStringProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private ObjectProperty<DURATION_UNIT> duration_unit = new SimpleObjectProperty<>();

    public PriceProposal() {
    }

    public int getProposal() {
        return proposal.get();
    }

    public IntegerProperty proposalProperty() {
        return proposal;
    }

    public void setProposal(int proposal) {
        this.proposal.set(proposal);
    }

    public CONTRAC_TYPE getContract_type() {
        return contract_type.get();
    }

    public ObjectProperty<CONTRAC_TYPE> contract_typeProperty() {
        return contract_type;
    }

    public void setContract_type(CONTRAC_TYPE contract_type) {
        this.contract_type.set(contract_type);
    }

    public String getCurrency() {
        return currency.get();
    }

    public StringProperty currencyProperty() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency.set(currency);
    }

    public SYMBOL getSymbol() {
        return symbol.get();
    }

    public ObjectProperty<SYMBOL> symbolProperty() {
        return symbol;
    }

    public void setSymbol(SYMBOL symbol) {
        this.symbol.set(symbol);
    }

    public Number getAmount() {
        return amount.get();
    }

    public ObjectProperty<Number> amountProperty() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount.set(amount);
    }

    public int getBarrier() {
        return barrier.get();
    }

    public IntegerProperty barrierProperty() {
        return barrier;
    }

    public void setBarrier(int barrier) {
        this.barrier.set(barrier);
    }

    public String getBasis() {
        return basis.get();
    }

    public StringProperty basisProperty() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis.set(basis);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public DURATION_UNIT getDuration_unit() {
        return duration_unit.get();
    }

    public ObjectProperty<DURATION_UNIT> duration_unitProperty() {
        return duration_unit;
    }

    public void setDuration_unit(DURATION_UNIT duration_unit) {
        this.duration_unit.set(duration_unit);
    }


    @Override
    public String toString() {
        return "PriceProposal{" +
                "proposal=" + proposal +
                ", contract_type=" + contract_type +
                ", currency=" + currency +
                ", symbol=" + symbol +
                ", amount=" + amount +
                ", barrier=" + barrier +
                ", basis=" + basis +
                ", duration=" + duration +
                ", duration_unit=" + duration_unit +
                '}';
    }
}
