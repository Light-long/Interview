package com.tx.juc.latch;

// 枚举要有getter setter 构造函数
public enum Country {
    ONE(1,"齐国"),TWO(2,"楚国"),
    THREE(3,"燕国"),FOUR(4,"赵国"),
    FIVE(5,"魏国"),SIX(6,"韩国");

    // 通过编号获取国家名称
    public static String getNameByIndex(int index) {
        Country[] values = Country.values();
        for (Country value : values) {
            if (index == value.getId()) {
                return value.getCountryName();
            }
        }
        return null;
    }

    private Integer id;
    private String countryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    Country(Integer id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

}
