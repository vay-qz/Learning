package qz.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerThread extends Thread {

    private Selector selector;

    private DealThread dealThread;

    @Override
    public void run() {
        try {
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                SelectionKey key = socketChannel.register(selector, SelectionKey.OP_WRITE);
                dealThread = new DealThread();
                dealThread.start();
            }
        } catch (IOException e) {
        }
    }

    public boolean closeSelector(){
        dealThread.interrupt();
        return dealThread.isInterrupted();
    }

    class DealThread extends Thread{

        @Override
        public void run() {
            while(true) {
                // 判断是否有事件准备好
                int readyChannels = 0;
                try {
                    readyChannels = selector.select();
                } catch (IOException e) {
                    System.out.println("被外部中断");
                }
                if(readyChannels == 0) continue;

                // 遍历
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                while(keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if(key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                        System.out.println("a connection was accepted by a ServerSocketChannel.");
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                        System.out.println(" a connection was established with a remote server");
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                        System.out.println("a channel is ready for reading");
                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                        System.out.println("a channel is ready for writing.");
                    }
                    keyIterator.remove();
                }
            }
        }
    }
}
