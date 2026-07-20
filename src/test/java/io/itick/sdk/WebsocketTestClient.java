package io.itick.sdk;

import com.google.gson.Gson;
import io.itick.sdk.model.Tick;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class WebsocketTestClient {

    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        try {
            // 初始化客户端
            String token = "8850**************************6ee4127087";
            Client client = new Client(token);

            Gson gson = new Gson();

            // 设置 WebSocket 消息处理器
            client.setMessageHandler(message -> {
                if (message.contains("pong")) {
                    System.out.println("Received WebSocket heartbeat: " + gson.toJson(message));
                } else {
                    if (count.addAndGet(1) % 10000 == 0) {
                        System.out.println("Received WebSocket message: " + gson.toJson(message));
                        count.set(0);
                    }
                }
            });

            // 设置 WebSocket 错误处理器
            client.setErrorHandler(error -> {
                error.printStackTrace();
                System.err.println("WebSocket error: " + error.getMessage());
            });

            // 测试外汇实时成交接口
            System.out.println("Testing forex tick...");
            Tick tick = client.getForexTick("GB", "EURUSD");
            System.out.println(gson.toJson(tick));

            // 测试外汇实时报价接口
            System.out.println("\rTesting forex quote...");
            var quote = client.getForexQuote("GB", "EURUSD");
            System.out.println(gson.toJson(quote));

            // 测试外汇实时盘口接口
            System.out.println("\nTesting forex depth...");
            var depth = client.getForexDepth("GB", "EURUSD");
            System.out.println(gson.toJson(depth));

            // 测试外汇历史K线接口
            System.out.println("\nTesting forex kline...");
            var kline = client.getForexKline("GB", "EURUSD", 2, 10, null);
            for (var k : kline) {
                System.out.println(gson.toJson(k));
            }

            // 测试 WebSocket 连接
            System.out.println("\nTesting WebSocket...");
            try {
                client.connectStockWebSocket();
                Thread.sleep(3000);

                // 发送订阅消息
                /**
                 * {
                 *   "ac": "subscribe",
                 *   "params": "AAPL$US,TSLA$US",
                 *   "types": "depth,quote"
                 * }
                 */
                client.subscribedSymbol(Set.of("AAPL$US,MSFT$US,GOOG$US,GOOGL$US,AMZN$US,NVDA$US,BRK.A$US,BRK.B$US,TSLA$US,META$US,LLY$US,UNH$US,XOM$US,V$US,WMT$US,JPM$US,JNJ$US,MA$US,PG$US,AVGO$US,CVX$US,HD$US,ORCL$US,MRK$US,ABBV$US,KO$US,COST$US,PEP$US,ADBE$US,BAC$US,CSCO$US,CRM$US,ACN$US,MCD$US,TMO$US,CMCSA$US,PFE$US,DHR$US,LIN$US,ABT$US,NFLX$US,TMUS$US,AMD$US,WFC$US,DIS$US,PM$US,TXN$US,AMGN$US,INTC$US,COP$US,INTU$US,VZ$US,CAT$US,NKE$US,MS$US,NEE$US,IBM$US,UPS$US,UNP$US,HON$US,RY$US,BMY$US,LOW$US,GE$US,QCOM$US,BA$US,SPGI$US,AMAT$US,NOW$US,AXP$US,TD$US,DE$US,BKNG$US,SYK$US,T$US,GS$US,SBUX$US,MDT$US,ELV$US,RTX$US,LMT$US,TJX$US,ISRG$US,SCHW$US,ADP$US,BLK$US,MMC$US,MDLZ$US,GILD$US,CVS$US,UBER$US,VRTX$US,CB$US,ADI$US,CI$US,ABNB$US,ETN$US,SLB$US,PGR$US,LRCX$US,UBS$US,ZTS$US,BX$US,C$US,BSX$US,BDX$US,SO$US,MU$US,MO$US,ATVI$US,ENB$US,CME$US,CNI$US,DUK$US,EOG$US,CP$US,FI$US,ITW$US,PANW$US,HCA$US,AON$US,SHOP$US,SNPS$US,CNQ$US,CHTR$US,FDX$US,SHW$US,NOC$US,MELI$US,APD$US,PYPL$US,WM$US,CDNS$US,CSX$US,ICE$US,KLAC$US,MPC$US,HUM$US,WDAY$US,STLA$US,CL$US,GD$US,EPD$US,MCO$US,MCK$US,MAR$US,SCCO$US,TRI$US,MNST$US,BNS$US,ORLY$US,ANET$US,OXY$US,EMR$US,BN$US,MMM$US,KKR$US,FCX$US,ROP$US,PSX$US,RACE$US,TGT$US,CMG$US,CTAS$US,APO$US,VLO$US,USB$US,NXPI$US,DELL$US,TEAM$US,AJG$US,F$US,PH$US,APH$US,SNOW$US,ECL$US,MET$US,PNC$US,LULU$US,STZ$US,TDG$US,MSI$US,RSG$US,KDP$US,HES$US,AZO$US,TT$US,FTNT$US,AFL$US,SRE$US,MRVL$US,GM$US,PCAR$US,CARR$US,SU$US,AIG$US,ODFL$US,ADSK$US,ET$US,HSY$US,EW$US,KHC$US,MCHP$US,KMB$US"), Set.of("tick", "quote"));

                // 等待接收消息
                System.out.println("Waiting for WebSocket messages...");
//                Thread.sleep(10000);

                // 检查连接状态
                System.out.println("WebSocket connected: " + client.isWebSocketConnected());

                System.in.read();

            } catch (Exception e) {
                System.err.println("WebSocket error: " + e.getMessage());
            } finally {
                // 关闭 WebSocket
                client.closeWebSocket();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
