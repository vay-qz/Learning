package pers.vay.designpattern.structure.adapter;

public class QQImpl implements QQ {
    @Override
    public void sendQQMsg() {
        System.out.println("send by QQ");
    }

    public void sendWeixinMsg() {
        sendQQMsg();
    }

}
