package br.com.tlmacedo.binary.controller;


import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class WSClient {


    @OnOpen
    public void onOpen(Session session) throws java.io.IOException {
        session.getBasicRemote().sendText("{\"ticks\": \"R_100\"}");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("ticks update: " + message);
    }


    public void connect() {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            Session session = container.connectToServer(WSClient.class,
                    new URI("wss://ws.binaryws.com/websockets/v3?app_id=23487"));
        } catch (DeploymentException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        WSClient wsClient = new WSClient();

        wsClient.connect();


//        URI apiUri = URI.create("wss://ws.binaryws.com/websockets/v3?app_id=23487");
//
//        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
//        Session session = container.connectToServer(WSClient.class, apiUri);
//
//        while (session.isOpen()) {
//            // receive ticks
//        }
    }


    //    private ApiWrapper api;
//
//    public void setup() throws Exception {
//        this.api = ApiWrapper.build("10");
//    }
//
//    public void getTickTest() throws Exception {
//        TickRequest request = new TickRequest("R_10");
//        TestObserver<ResponseBase> testSubscriber = new TestObserver<>();
//
//        this.api.sendRequest(request)
//                .subscribe(testSubscriber);
//
//        testSubscriber
//                .await(10, TimeUnit.SECONDS);
//        ResponseBase<TickRequest> responseBase = testSubscriber
//                .values().get(0);
//
//        assertEquals(responseBase.getType(), "tick");
//    }
//
//    public static void main(String[] args) throws Exception {
////        WSClient wsClient = new WSClient();
////        wsClient.setup();
////        wsClient.getTickTest();
//
//        ApiWrapper api = ApiWrapper.build("23487", "PT", "wss://ws.binaryws.com/websockets/v3");
//
//        TickRequest request = new TickRequest("R_25", true);
//        TestObserver<ResponseBase> testSubscriber = new TestObserver<>();
//
//        api.sendRequest(request).subscribe();
////                .subscribe(responseBase -> {
////                    System.out.printf("%s\n%s\n\n", ((TickResponse) responseBase.getRequest()).getTick(), "tick");
////                });
//
//
//    }
}