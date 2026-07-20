package io.itick.sdk.model;

import java.math.BigDecimal;

public class Kline {
    // 成交金额
    private BigDecimal tu;
    // 该K线收盘价
    private BigDecimal c;
    // 时间戳
    private long t;
    // 成交数量
    private BigDecimal v;
    // 该K线最高价
    private BigDecimal h;
    // 该K线最低价
    private BigDecimal l;
    // 该K线开盘价
    private BigDecimal o;

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public BigDecimal getO() {
        return o;
    }

    public void setO(BigDecimal o) {
        this.o = o;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getL() {
        return l;
    }

    public void setL(BigDecimal l) {
        this.l = l;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }

    public BigDecimal getV() {
        return v;
    }

    public void setV(BigDecimal v) {
        this.v = v;
    }

    public BigDecimal getTu() {
        return tu;
    }

    public void setTu(BigDecimal tu) {
        this.tu = tu;
    }
}
