package io.itick.sdk.model;

import java.math.BigDecimal;

public class Quote {
    //	symbol标的代码
    private String s;
    // last_done 最新价
    private BigDecimal ld;
    // open 开盘价
    private BigDecimal o;
    // prev_close 昨收价
    private BigDecimal p;
    // high 最高价
    private BigDecimal h;
    // low 最低价
    private BigDecimal l;
    // timestamp 最新成交的时间戳
    private Long t;
    // volume 成交量
    private BigDecimal v;
    //turnover 成交额
    private BigDecimal tu;
    // trade_status 标的交易状态，详见 TradeStatusEnum
    private Short ts;
    //turnover 涨跌额
    private BigDecimal ch;
    //turnover 涨跌幅百分比
    private BigDecimal chp;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public BigDecimal getLd() {
        return ld;
    }

    public void setLd(BigDecimal ld) {
        this.ld = ld;
    }

    public BigDecimal getO() {
        return o;
    }

    public void setO(BigDecimal o) {
        this.o = o;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
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

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
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

    public Short getTs() {
        return ts;
    }

    public void setTs(Short ts) {
        this.ts = ts;
    }

    public BigDecimal getCh() {
        return ch;
    }

    public void setCh(BigDecimal ch) {
        this.ch = ch;
    }

    public BigDecimal getChp() {
        return chp;
    }

    public void setChp(BigDecimal chp) {
        this.chp = chp;
    }
}
