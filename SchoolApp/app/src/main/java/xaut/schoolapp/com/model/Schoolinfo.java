package xaut.schoolapp.com.model;

import java.io.Serializable;

/**
 * Created by xiaoleilei on 2017/5/7.
 */

public class Schoolinfo implements Serializable {
    /*表schoolEntity*/
    public double x; //经度
    public double y; //纬度
    public String organizationNo; //学校编码
    public String organizationName; //学校名称
    /*表schoolBusinessRelation*/
    public String regionA;
    public String regionB;
    public String regionC ;
    public String regionD; 
    public String regionE ;
    public String schoolTypeGroup; //学校类型分组
    /*表schoolDetail*/
    public String email; 
    public String officeTelephone; 
    public String zipcode;

    public Schoolinfo(){
        super();
    }

    public Schoolinfo(String customOwner, String email, String officeTelephone, String organizationName, String organizationNo, String regionA, String regionB, String regionC, String regionD, String regionE, String schoolTypeGroup, double x, double y, String zipcode) {
        this.customOwner = customOwner;
        this.email = email;
        this.officeTelephone = officeTelephone;
        this.organizationName = organizationName;
        this.organizationNo = organizationNo;
        this.regionA = regionA;
        this.regionB = regionB;
        this.regionC = regionC;
        this.regionD = regionD;
        this.regionE = regionE;
        this.schoolTypeGroup = schoolTypeGroup;
        this.x = x;
        this.y = y;
        this.zipcode = zipcode;
    }

    public String getCustomOwner() {
        return customOwner;
    }

    public void setCustomOwner(String customOwner) {
        this.customOwner = customOwner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationNo() {
        return organizationNo;
    }

    public void setOrganizationNo(String organizationNo) {
        this.organizationNo = organizationNo;
    }

    public String getRegionA() {
        return regionA;
    }

    public void setRegionA(String regionA) {
        this.regionA = regionA;
    }

    public String getRegionB() {
        return regionB;
    }

    public void setRegionB(String regionB) {
        this.regionB = regionB;
    }

    public String getRegionC() {
        return regionC;
    }

    public void setRegionC(String regionC) {
        this.regionC = regionC;
    }

    public String getRegionD() {
        return regionD;
    }

    public void setRegionD(String regionD) {
        this.regionD = regionD;
    }

    public String getRegionE() {
        return regionE;
    }

    public void setRegionE(String regionE) {
        this.regionE = regionE;
    }

    public String getSchoolTypeGroup() {
        return schoolTypeGroup;
    }

    public void setSchoolTypeGroup(String schoolTypeGroup) {
        this.schoolTypeGroup = schoolTypeGroup;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String customOwner ;
}
