package com.gavin.test.playwright;

public class Course {
    private Integer studentId;
    private Integer courseId;
    private String courseName;
    private String courseCoverImg;
    private Integer teachingPlanCourseId;
    private Integer teachPlanId;
    private Integer periodId;
    private Integer learnStatus;
    private Integer term;
    private Integer score;
    private Object coverImg;
    private Boolean isCurrent;
    private Integer maintenanceFreeSettingflag;
    private Integer maintenanceFreeSettingScore;
    private Object scoreLevel;
    private Boolean withoutUsualScore;
    private Boolean allowLearn;
    private Integer computedMaintenanceFreeScore;
    private String learnStatusName;

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCoverImg() {
        return this.courseCoverImg;
    }

    public void setCourseCoverImg(String courseCoverImg) {
        this.courseCoverImg = courseCoverImg;
    }

    public Integer getTeachingPlanCourseId() {
        return this.teachingPlanCourseId;
    }

    public void setTeachingPlanCourseId(Integer teachingPlanCourseId) {
        this.teachingPlanCourseId = teachingPlanCourseId;
    }

    public Integer getTeachPlanId() {
        return this.teachPlanId;
    }

    public void setTeachPlanId(Integer teachPlanId) {
        this.teachPlanId = teachPlanId;
    }

    public Integer getPeriodId() {
        return this.periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Integer getLearnStatus() {
        return this.learnStatus;
    }

    public void setLearnStatus(Integer learnStatus) {
        this.learnStatus = learnStatus;
    }

    public Integer getTerm() {
        return this.term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(Object coverImg) {
        this.coverImg = coverImg;
    }

    public Boolean getCurrent() {
        return this.isCurrent;
    }

    public void setCurrent(Boolean current) {
        this.isCurrent = current;
    }

    public Integer getMaintenanceFreeSettingflag() {
        return this.maintenanceFreeSettingflag;
    }

    public void setMaintenanceFreeSettingflag(Integer maintenanceFreeSettingflag) {
        this.maintenanceFreeSettingflag = maintenanceFreeSettingflag;
    }

    public Integer getMaintenanceFreeSettingScore() {
        return this.maintenanceFreeSettingScore;
    }

    public void setMaintenanceFreeSettingScore(Integer maintenanceFreeSettingScore) {
        this.maintenanceFreeSettingScore = maintenanceFreeSettingScore;
    }

    public Object getScoreLevel() {
        return this.scoreLevel;
    }

    public void setScoreLevel(Object scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    public Boolean getWithoutUsualScore() {
        return this.withoutUsualScore;
    }

    public void setWithoutUsualScore(Boolean withoutUsualScore) {
        this.withoutUsualScore = withoutUsualScore;
    }

    public Boolean getAllowLearn() {
        return this.allowLearn;
    }

    public void setAllowLearn(Boolean allowLearn) {
        this.allowLearn = allowLearn;
    }

    public Integer getComputedMaintenanceFreeScore() {
        return this.computedMaintenanceFreeScore;
    }

    public void setComputedMaintenanceFreeScore(Integer computedMaintenanceFreeScore) {
        this.computedMaintenanceFreeScore = computedMaintenanceFreeScore;
    }

    public String getLearnStatusName() {
        return this.learnStatusName;
    }

    public void setLearnStatusName(String learnStatusName) {
        this.learnStatusName = learnStatusName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "studentId=" + this.studentId +
                ", courseId=" + this.courseId +
                ", courseName='" + this.courseName + '\'' +
                ", courseCoverImg='" + this.courseCoverImg + '\'' +
                ", teachingPlanCourseId=" + this.teachingPlanCourseId +
                ", teachPlanId=" + this.teachPlanId +
                ", periodId=" + this.periodId +
                ", learnStatus=" + this.learnStatus +
                ", term=" + this.term +
                ", score=" + this.score +
                ", coverImg=" + this.coverImg +
                ", isCurrent=" + this.isCurrent +
                ", maintenanceFreeSettingflag=" + this.maintenanceFreeSettingflag +
                ", maintenanceFreeSettingScore=" + this.maintenanceFreeSettingScore +
                ", scoreLevel=" + this.scoreLevel +
                ", withoutUsualScore=" + this.withoutUsualScore +
                ", allowLearn=" + this.allowLearn +
                ", computedMaintenanceFreeScore=" + this.computedMaintenanceFreeScore +
                ", learnStatusName='" + this.learnStatusName + '\'' +
                '}';
    }
}
