/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: GrabOrderPositionModel.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-27 10 : 54:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-27 10 : 54:12> <version>   <desc>
 */

package org.tzl.converters;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：furong 日期：2016年9月27日 时间：上午11:42:59
 */
public class GrabOrderPositionModel implements Serializable {
    /**
     */
    private static final long serialVersionUID = -4786199391568917436L;

    @ApiField("positionId")
    private Long positionId;
    @ApiField("userId")
    private Long hrId;
    @ApiField("userGrade")
    private Integer requestUserGrade;
    @ApiField("validRecommendTotal")
    private Integer requestValidRecommendTotal;
    @ApiField("taskCycleDay")
    private Integer taskCycleDay;
    @ApiField("grabOrderTotal")
    private Integer grabOrderTotal;
    @ApiField("enrollBeginTime")
    private Date enrollBeginTime;
    @ApiField("taskBeginTime")
    private Date taskBeginTime;
    @ApiField("taskEndTime")
    private Date taskEndTime;
    @ApiField("status")
    private Integer status;

    private Boolean defunct;

    private int validRecommendTotal;

    private int seqNo = -1;

    private int enrolCount;

    private int grabStatus = -1;

    private long surplusEnrollTime;

    private long surplusTaskTime;

    public long getSurplusEnrollTime() {
        return surplusEnrollTime;
    }

    public void setSurplusEnrollTime(long surplusEnrollTime) {
        this.surplusEnrollTime = surplusEnrollTime;
    }

    public long getSurplusTaskTime() {
        return surplusTaskTime;
    }

    public void setSurplusTaskTime(long surplusTaskTime) {
        this.surplusTaskTime = surplusTaskTime;
    }

    public int getValidRecommendTotal() {
        return validRecommendTotal;
    }

    public void setValidRecommendTotal(int validRecommendTotal) {
        this.validRecommendTotal = validRecommendTotal;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public int getEnrolCount() {
        return enrolCount;
    }

    public void setEnrolCount(int enrolCount) {
        this.enrolCount = enrolCount;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Integer getRequestUserGrade() {
        return requestUserGrade;
    }

    public Long getHrId() {
        return hrId;
    }

    public void setHrId(Long hrId) {
        this.hrId = hrId;
    }

    public void setRequestUserGrade(Integer requestUserGrade) {
        this.requestUserGrade = requestUserGrade;
    }

    public Integer getRequestValidRecommendTotal() {
        return requestValidRecommendTotal;
    }

    public void setRequestValidRecommendTotal(Integer requestValidRecommendTotal) {
        this.requestValidRecommendTotal = requestValidRecommendTotal;
    }

    public Integer getTaskCycleDay() {
        return taskCycleDay;
    }

    public void setTaskCycleDay(Integer taskCycleDay) {
        this.taskCycleDay = taskCycleDay;
    }

    public Integer getGrabOrderTotal() {
        return grabOrderTotal;
    }

    public void setGrabOrderTotal(Integer grabOrderTotal) {
        this.grabOrderTotal = grabOrderTotal;
    }

    public Date getEnrollBeginTime() {
        return enrollBeginTime;
    }

    public void setEnrollBeginTime(Date enrollBeginTime) {
        this.enrollBeginTime = enrollBeginTime;
    }

    public Date getTaskBeginTime() {
        return taskBeginTime;
    }

    public void setTaskBeginTime(Date taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getGrabStatus() {
        return grabStatus;
    }

    public void setGrabStatus(int grabStatus) {
        this.grabStatus = grabStatus;
    }

    public Boolean getDefunct() {
        return defunct;
    }

    public void setDefunct(Boolean defunct) {
        this.defunct = defunct;
    }

}
