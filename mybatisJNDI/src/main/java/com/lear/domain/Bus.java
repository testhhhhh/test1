package com.lear.domain;

public class Bus {
    /**
     * 当java里的实体类属性名与数据库里的列表名不一致时
     */
    private int busId;//java区分大小写，但是windows下的mysql是不区分大小写的，所以如果实体与数据库只是字母大小写不一致也可以被封装起来，但Linux下的mysql严格区分大小写
    private String type;
    private String number;

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Bus{" +
                "busid=" + busId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
