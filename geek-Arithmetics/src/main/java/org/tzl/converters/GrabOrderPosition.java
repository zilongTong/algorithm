/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: GrabOrderPosition.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-27 10 : 53:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-27 10 : 53:24> <version>   <desc>
 */

package org.tzl.converters;

import java.io.Serializable;
import java.util.Date;

public class GrabOrderPosition implements Serializable {
    private Long positionId;

    private Long userId;

    private Integer userGrade;

    private Integer validRecommendTotal;

    private Integer taskCycleDay;

    private Integer grabOrderTotal;

    private Date enrollBeginTime;

    private Date taskBeginTime;

    private Date taskEndTime;

    private Integer status;

    private Long createUserId;

    private Long updateUserId;

    private Date createTime;

    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_grab_order_position
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.position_id
     *
     * @return the value of tb_grab_order_position.position_id
     *
     * @mbggenerated
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.position_id
     *
     * @param positionId the value for tb_grab_order_position.position_id
     *
     * @mbggenerated
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.user_id
     *
     * @return the value of tb_grab_order_position.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.user_id
     *
     * @param userId the value for tb_grab_order_position.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.user_grade
     *
     * @return the value of tb_grab_order_position.user_grade
     *
     * @mbggenerated
     */
    public Integer getUserGrade() {
        return userGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.user_grade
     *
     * @param userGrade the value for tb_grab_order_position.user_grade
     *
     * @mbggenerated
     */
    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.valid_recommend_total
     *
     * @return the value of tb_grab_order_position.valid_recommend_total
     *
     * @mbggenerated
     */
    public Integer getValidRecommendTotal() {
        return validRecommendTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.valid_recommend_total
     *
     * @param validRecommendTotal the value for tb_grab_order_position.valid_recommend_total
     *
     * @mbggenerated
     */
    public void setValidRecommendTotal(Integer validRecommendTotal) {
        this.validRecommendTotal = validRecommendTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.task_cycle_day
     *
     * @return the value of tb_grab_order_position.task_cycle_day
     *
     * @mbggenerated
     */
    public Integer getTaskCycleDay() {
        return taskCycleDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.task_cycle_day
     *
     * @param taskCycleDay the value for tb_grab_order_position.task_cycle_day
     *
     * @mbggenerated
     */
    public void setTaskCycleDay(Integer taskCycleDay) {
        this.taskCycleDay = taskCycleDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.grab_order_total
     *
     * @return the value of tb_grab_order_position.grab_order_total
     *
     * @mbggenerated
     */
    public Integer getGrabOrderTotal() {
        return grabOrderTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.grab_order_total
     *
     * @param grabOrderTotal the value for tb_grab_order_position.grab_order_total
     *
     * @mbggenerated
     */
    public void setGrabOrderTotal(Integer grabOrderTotal) {
        this.grabOrderTotal = grabOrderTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.enroll_begin_time
     *
     * @return the value of tb_grab_order_position.enroll_begin_time
     *
     * @mbggenerated
     */
    public Date getEnrollBeginTime() {
        return enrollBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.enroll_begin_time
     *
     * @param enrollBeginTime the value for tb_grab_order_position.enroll_begin_time
     *
     * @mbggenerated
     */
    public void setEnrollBeginTime(Date enrollBeginTime) {
        this.enrollBeginTime = enrollBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.task_begin_time
     *
     * @return the value of tb_grab_order_position.task_begin_time
     *
     * @mbggenerated
     */
    public Date getTaskBeginTime() {
        return taskBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.task_begin_time
     *
     * @param taskBeginTime the value for tb_grab_order_position.task_begin_time
     *
     * @mbggenerated
     */
    public void setTaskBeginTime(Date taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.task_end_time
     *
     * @return the value of tb_grab_order_position.task_end_time
     *
     * @mbggenerated
     */
    public Date getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.task_end_time
     *
     * @param taskEndTime the value for tb_grab_order_position.task_end_time
     *
     * @mbggenerated
     */
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.status
     *
     * @return the value of tb_grab_order_position.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.status
     *
     * @param status the value for tb_grab_order_position.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.create_user_id
     *
     * @return the value of tb_grab_order_position.create_user_id
     *
     * @mbggenerated
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.create_user_id
     *
     * @param createUserId the value for tb_grab_order_position.create_user_id
     *
     * @mbggenerated
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.update_user_id
     *
     * @return the value of tb_grab_order_position.update_user_id
     *
     * @mbggenerated
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.update_user_id
     *
     * @param updateUserId the value for tb_grab_order_position.update_user_id
     *
     * @mbggenerated
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.create_time
     *
     * @return the value of tb_grab_order_position.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.create_time
     *
     * @param createTime the value for tb_grab_order_position.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_grab_order_position.update_time
     *
     * @return the value of tb_grab_order_position.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_grab_order_position.update_time
     *
     * @param updateTime the value for tb_grab_order_position.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}