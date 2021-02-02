package com.ahuan.sso.model;

import java.io.Serializable;

/***
 * 
* @ClassName: UserInfo  
* @Description: 
* @author huan  
* @date 2020年1月17日  
*
 */
public class UserInfo  implements Serializable {

    private static final long serialVersionUID = 1229707672168440127L;
    
    private Long userId;
    private String userNo;
    private String userName;
    private Long deptId;
    private String deptName;
    private Short sex;
    private String ownRoles;
    private Long currentSiteId;
    private String currentSiteName;
    private Long platformId;
    private Long groupId;
    private String fullPath;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getOwnRoles() {
        return ownRoles;
    }

    public void setOwnRoles(String ownRoles) {
        this.ownRoles = ownRoles;
    }

    public Long getCurrentSiteId() {
        return currentSiteId;
    }

    public void setCurrentSiteId(Long currentSiteId) {
        this.currentSiteId = currentSiteId;
    }

    public String getCurrentSiteName() {
        return currentSiteName;
    }

    public void setCurrentSiteName(String currentSiteName) {
        this.currentSiteName = currentSiteName;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public String toString() {
        return "UserInfo [userId=" + userId + ", userNo=" + userNo + ", userName=" + userName + ", deptId=" + deptId
            + ", deptName=" + deptName + ", sex=" + sex + ", ownRoles=" + ownRoles + ", currentSiteId=" + currentSiteId
            + ", currentSiteName=" + currentSiteName + ", platformId=" + platformId + ", groupId=" + groupId
            + ", fullPath=" + fullPath + "]";
    }
}