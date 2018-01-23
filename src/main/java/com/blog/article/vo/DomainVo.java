package com.blog.article.vo;

public class DomainVo {

    private String url;

    private String code;

    private String state;
    private Integer type ;
    private Integer number;
    private String houzhui;

    private Boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHouzhui() {
        return houzhui;
    }

    public void setHouzhui(String houzhui) {
        this.houzhui = houzhui;
    }
}
