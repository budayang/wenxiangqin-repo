//package diamond;
//
//import com.taobao.diamond.client.Diamond;
//import com.taobao.diamond.manager.ManagerListenerAdapter;
//
//import java.io.IOException;
//
//public class ConfigCenter {
//    private static final String dataId = "com.alibaba.ascp.finance.charge.container.infrastructure.diamond.CasSwitchListener";
//    private static final String groupId = "DEFAULT_GROUP";
//    private static String config = "";
//    private static void initConfig() {
//        try {
//            String configInfo = Diamond.getConfig(dataId, groupId, 3000);
//            System.out.println("dataId+group:" + configInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Diamond.addListener(dataId, groupId, new ManagerListenerAdapter() {
//            @Override
//            public void receiveConfigInfo(String configInfo) {
//                config = configInfo;
//                System.out.println(configInfo);
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        initConfig();
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static String getConfig() {
//        return config;
//    }
//}
