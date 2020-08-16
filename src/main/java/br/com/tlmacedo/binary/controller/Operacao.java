package br.com.tlmacedo.binary.controller;

import br.com.tlmacedo.binary.model.Enums.CONTRAC_TYPE;
import br.com.tlmacedo.binary.model.Enums.DURATION_UNIT;
import br.com.tlmacedo.binary.model.Enums.SYMBOL;
import br.com.tlmacedo.binary.model.Msg_type;
import br.com.tlmacedo.binary.model.PriceProposal;
import br.com.tlmacedo.binary.model.TicksStream;
import br.com.tlmacedo.binary.services.UtilJson;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Operacao extends WebSocketListener implements Initializable {

    public Label lblTick;

    private WebSocket MyWebSocket;
    private Logger logger = LoggerFactory.getLogger(Operacao.class);
    private ObjectProperty<Msg_type> msg_type = new SimpleObjectProperty<>();
    private ObjectProperty<TicksStream> ticksStream = new SimpleObjectProperty<>(new TicksStream());
    private ObjectProperty<PriceProposal> priceProposal = new SimpleObjectProperty<>(new PriceProposal());


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Operacao operacao = new Operacao();
        operacao.connect();

        carregaContratos();
        escutaObjetos();
    }

    private void carregaContratos() {
        priceProposalProperty().getValue().amountProperty().setValue(1.);
        priceProposalProperty().getValue().barrierProperty().setValue(3);
        priceProposalProperty().getValue().basisProperty().setValue("stake");
        priceProposalProperty().getValue().contract_typeProperty().setValue(CONTRAC_TYPE.DIGITOVER);
        priceProposalProperty().getValue().currencyProperty().setValue("USD");
        priceProposalProperty().getValue().durationProperty().setValue(1);
        priceProposalProperty().getValue().duration_unitProperty().setValue(DURATION_UNIT.t);
        priceProposalProperty().getValue().symbolProperty().setValue(SYMBOL.R_100);

        //UtilJson.printJsonFromObject(priceProposalProperty().getValue(), "TestandoJson");
    }

    private void escutaObjetos() {
//        Thread.sleep(5000);
//        getLblTick().textProperty().bind(ticksStreamProperty().getValue().tickProperty().getValue().quoteProperty().asString());
        System.out.printf("Habilitando escutaObjetos...\n");
        ticksStreamProperty().addListener((observable, oldValue, newValue) -> {
            System.out.printf("teveMudança de: %s\t\tpara: %s\n",
                    oldValue.tickProperty().getValue().quoteProperty().getValue(),
                    newValue.tickProperty().getValue().quoteProperty().getValue()
            );
        });
//        ticksStreamProperty().addListener((ov, o, n) -> {
//            System.out.printf("teve Mudança.\n");
//            System.out.printf("Quote: %d\n", n.tickProperty().getValue().ultimoDigtProperty().getValue());
////            if (n.tickProperty().getValue().ultimoDigtProperty().getValue() < 6) {
////                System.out.printf("ultDigit<6");
////
////                getMyWebSocket().send(UtilJson.getJsonFromObject(priceProposalProperty().getValue()));
////            }
//        });

    }

    private void connect() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("wss://ws.binaryws.com/websockets/v3?app_id=23487").build();
        setMyWebSocket(client.newWebSocket(request, this));

    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        //webSocket.send("{\"ticks\": \"R_100\", \"subscribe\": 1}");
        getMyWebSocket().send("{\"ticks\": \"R_100\", \"subscribe\": 1}");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        logger.info("WebSocket: received message " + text);
        msg_typeProperty().setValue((Msg_type) UtilJson.getMsg_Type(text));
        System.out.printf("000\n");
//        ticksStreamProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.printf("teveMudança de: %s\t\tpara: %s\n",
//                    oldValue.tickProperty().getValue().quoteProperty().getValue(),
//                    newValue.tickProperty().getValue().quoteProperty().getValue()
//            );
//        });
        //UtilJson.printJsonFromObject(ticksStreamProperty().getValue(), "imprimindo");
        System.out.printf("000\n");
        switch (msg_typeProperty().getValue().getMsg_type()) {
            case TICK -> {
                System.out.printf("001\n");
//                ticksStream = (ObjectProperty<TicksStream>) UtilJson.getObjectFromJson(text, TicksStream.class);
                ticksStreamProperty().setValue((TicksStream) UtilJson.getObjectFromJson(text, TicksStream.class, ticksStreamProperty()));
                System.out.printf("Quote: %s\n", ticksStreamProperty().getValue().tickProperty().getValue().quoteProperty().getValue());
                System.out.printf("002\n");
//                UtilJson.printJsonFromObject(ticksStreamProperty().getValue(), "imprimindo");
//                System.out.printf("003\n");
            }
        }

//        switch (msg_type.getMsg_type()) {
//            case "tick":
//                ticksStreamProperty().setValue((TicksStream) UtilJson.getObjectFromJson(text, ticksStream.getClass()));
//
//                System.out.printf("Quote: %s\n", ticksStreamProperty().getValue().getTick().getQuote());
//                Integer ultDigit = (((Double) (ticksStreamProperty().getValue().getTick().getQuote().doubleValue() * 100)).intValue() % 10);
//                System.out.printf("quote: %s\t\tUltDigt: [%d]\n", ticksStreamProperty().getValue().getTick().getQuote(), ultDigit);
//
//
//                if (ultDigit == 0) {
//                    System.out.printf("tentando enviar pedido");
//                    webSocket.send("{\n" +
//                            "  \"proposal\": 1,\n" +
//                            "  \"amount\": 7.23,\n" +
//                            "  \"barrier\": 3,\n" +
//                            "  \"basis\": \"stake\",\n" +
//                            "  \"contract_type\": \"DIGITOVER\",\n" +
//                            "  \"currency\": \"USD\",\n" +
//                            "  \"duration\": 1,\n" +
//                            "  \"duration_unit\": \"t\",\n" +
//                            "  \"symbol\": \"R_100\"\n" +
//                            "}");
//                    System.out.printf("Sera que vai dar certo???");
//                }
//                break;
//
//        }


    }

    public Label getLblTick() {
        return lblTick;
    }

    public void setLblTick(Label lblTick) {
        this.lblTick = lblTick;
    }

    public WebSocket getMyWebSocket() {
        return MyWebSocket;
    }

    public void setMyWebSocket(WebSocket myWebSocket) {
        MyWebSocket = myWebSocket;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public PriceProposal getPriceProposal() {
        return priceProposal.get();
    }

    public ObjectProperty<PriceProposal> priceProposalProperty() {
        return priceProposal;
    }

    public void setPriceProposal(PriceProposal priceProposal) {
        this.priceProposal.set(priceProposal);
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

    public TicksStream getTicksStream() {
        return ticksStream.get();
    }

    public ObjectProperty<TicksStream> ticksStreamProperty() {
        return ticksStream;
    }

    public void setTicksStream(TicksStream ticksStream) {
        this.ticksStream.set(ticksStream);
    }
}