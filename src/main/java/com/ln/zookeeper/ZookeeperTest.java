package com.ln.zookeeper;

//import org.apache.log4j.spi.LoggerFactory;
//import org.slf4j.impl.StaticLoggerBinder;
import org.apache.zookeeper.*;

import java.io.IOException;
/**
 * Created by liangnan on 17-2-20.
 */
public class ZookeeperTest {
    public static void main(String[] args){
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 10000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("发生了什么呢" + event.getType().toString()) ;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(zooKeeper == null){
            return;
        }
        zooKeeper.getState();
        // 创建一个目录节点
        try {
            zooKeeper.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
            zooKeeper.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(new String(zooKeeper.getData("/testRootPath",false,null)));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
