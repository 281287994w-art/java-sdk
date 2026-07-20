package io.itick.sdk.model;

import java.math.BigDecimal;

public class Tick {
    //	symbol标的代码
    private String s;
    // last_done 最新价
    private BigDecimal ld;
    // timestamp 最新成交的时间戳
    private Long t;
    // volume 成交量
    private BigDecimal v;

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
}
