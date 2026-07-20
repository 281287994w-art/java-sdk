package io.itick.sdk.model;

import java.math.BigDecimal;
import java.util.List;

public class Depth {//symbol 标的代码
    private String s;
    //ask 卖盘
    private List<DepthItem> a;
    //bid 买盘
    private List<DepthItem> b;

    public static class DepthItem {
        //position 档位
        private int po;
        //price	价格
        private BigDecimal p;
        //volume	挂单量
        private BigDecimal v;
        // order_num	订单数量
        private Long o;

        public int getPo() {
            return po;
        }

        public void setPo(int po) {
            this.po = po;
        }

        public BigDecimal getP() {
            return p;
        }

        public void setP(BigDecimal p) {
            this.p = p;
        }

        public BigDecimal getV() {
            return v;
        }

        public void setV(BigDecimal v) {
            this.v = v;
        }

        public Long getO() {
            return o;
        }

        public void setO(Long o) {
            this.o = o;
        }
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public List<DepthItem> getA() {
        return a;
    }

    public void setA(List<DepthItem> a) {
        this.a = a;
    }

    public List<DepthItem> getB() {
        return b;
    }

    public void setB(List<DepthItem> b) {
        this.b = b;
    }
}
