package com.opensource.usedb.dao;

import com.opensource.usedb.entity.PaymentChannel;

public interface PaymentChannelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    int insert(PaymentChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    int insertSelective(PaymentChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    PaymentChannel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PaymentChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_channel
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PaymentChannel record);


    PaymentChannel getChannelByPaycode(String payCode);
}