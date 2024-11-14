package com.ms.edu.vo;

/**
 * ClassName: CourseVO
 * Package: com.ms.edu.vo
 * Description:
 *
 * @Author ms
 * @Create 2024/6/14 16:55
 * @Version 1.0
 */
public class CourseVO {

    private String keyWards;

    private long startPrice;

    private long endPrice;

    public String getKeyWards() {
        return keyWards;
    }

    public void setKeyWards(String keyWards) {
        this.keyWards = keyWards;
    }

    public long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(long startPrice) {
        this.startPrice = startPrice;
    }

    public long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(long endPrice) {
        this.endPrice = endPrice;
    }
}
