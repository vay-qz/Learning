package pers.vay.designpattern.structure.adapter.after;

public class WeixinImpl implements Weixin {
    @Override
    public void sendWeixinMsg() {
        System.out.println("send by weixin");
    }

}
