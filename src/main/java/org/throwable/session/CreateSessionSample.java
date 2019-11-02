package org.throwable.session;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author throwable
 * @version v1.0
 * @description 1.使用静态工程方法创建客户端
 * @since 2017/4/22 12:01
 */
public class CreateSessionSample extends BaseConnectionInfo {

    public static void main(String[] args) throws Exception {
        // 1.拒绝策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        // 2.使用静态工程方法创建客户端
        CuratorFramework client =
                CuratorFrameworkFactory.newClient(
                        connectionInfo,
                        5000,
                        3000,
                        retryPolicy);
        client.start();
        System.out.println("client.start ... ");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
