package pers.vay.designpattern.structure.adapter.before;

public class QQImpl implements QQ, Weixin{

    @Override
    public void sendQQMsg() {
        System.out.println("send by qq");
    }

    @Override
    public void sendWeixinMsg() {
        this.sendQQMsg();
    }

}
