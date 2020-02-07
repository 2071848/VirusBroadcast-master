package com.jxwifi.seer;

/**
 * 测试数据
 */
public class Constants {

    /**
     * 数据比例，真实数据过大个人PC无法计算，需要等比收缩推演数据，20万倍
     */
    public static final int scale=200000;

    /**
     * 中国总人数14亿
     */
    public static final int TOTAL_PERSON_SIZE = 1400000000/scale;
    /**
     * 初始感染数量
     */
    public static int ORIGINAL_COUNT=30000/scale;
    /**
     * 传播率
     */
    public static float BROAD_RATE = 0.8f;
    /**
     * 潜伏时间
     */
    public static float SHADOW_TIME = 140;
    /**
     * 医院收治响应时间
     */
    public static int HOSPITAL_RECEIVE_TIME=10;
    /**
     * 医院床位数量
     */
    public static int BED_COUNT=1000000/scale;//医院床位
    /**
     * 流动意向平均值
     */
    public static float U =0.99f;


}
