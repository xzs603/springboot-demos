package com.mttsui.multids.model;

/**
 * @Author: zsxu2
 * @Date 2018/7/9 19:15
 */
public class JoinOrg {

    private String id;

    private String orgType;

    private String loginname;

    private String password;

    private String domainCode;

    private String domainName;

    private String orgCode;

    private String orgName;

    private String regionIden;

    private String comments;

    private String bsDbName;

    private String bsDbIp;

    private String bsDbPort;

    private String bsDbSid;

    private String bsDbUser;

    private String bsDbPass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode == null ? null : domainCode.trim();
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getRegionIden() {
        return regionIden;
    }

    public void setRegionIden(String regionIden) {
        this.regionIden = regionIden == null ? null : regionIden.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getBsDbName() {
        return bsDbName;
    }

    public void setBsDbName(String bsDbName) {
        this.bsDbName = bsDbName == null ? null : bsDbName.trim();
    }

    public String getBsDbIp() {
        return bsDbIp;
    }

    public void setBsDbIp(String bsDbIp) {
        this.bsDbIp = bsDbIp == null ? null : bsDbIp.trim();
    }

    public String getBsDbPort() {
        return bsDbPort;
    }

    public void setBsDbPort(String bsDbPort) {
        this.bsDbPort = bsDbPort == null ? null : bsDbPort.trim();
    }

    public String getBsDbSid() {
        return bsDbSid;
    }

    public void setBsDbSid(String bsDbSid) {
        this.bsDbSid = bsDbSid == null ? null : bsDbSid.trim();
    }

    public String getBsDbUser() {
        return bsDbUser;
    }

    public void setBsDbUser(String bsDbUser) {
        this.bsDbUser = bsDbUser == null ? null : bsDbUser.trim();
    }

    public String getBsDbPass() {
        return bsDbPass;
    }

    public void setBsDbPass(String bsDbPass) {
        this.bsDbPass = bsDbPass == null ? null : bsDbPass.trim();
    }

    @Override
    public String toString() {
        return "JoinOrg{" +
                "id='" + id + '\'' +
                ", orgType='" + orgType + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", domainCode='" + domainCode + '\'' +
                ", domainName='" + domainName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", regionIden='" + regionIden + '\'' +
                ", comments='" + comments + '\'' +
                ", bsDbName='" + bsDbName + '\'' +
                ", bsDbIp='" + bsDbIp + '\'' +
                ", bsDbPort='" + bsDbPort + '\'' +
                ", bsDbSid='" + bsDbSid + '\'' +
                ", bsDbUser='" + bsDbUser + '\'' +
                ", bsDbPass='" + bsDbPass + '\'' +
                '}';
    }
}
