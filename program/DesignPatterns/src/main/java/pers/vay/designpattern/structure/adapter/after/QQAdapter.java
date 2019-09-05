package pers.vay.designpattern.structure.adapter.after;

public class QQAdapter implements Weixin {
    private QQ qq;

    public QQAdapter(QQ qq) {
        this.qq = qq;
    }

    @Override
    public void sendWeixinMsg() {
        qq.sendQQMsg();
    }

}
