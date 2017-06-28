package xaut.schoolapp.com.model;

/**
 * Created by Administrator on 06/15.
 */

public class SchoolData
{
    String mOrganizationNo;
    String mOrganizationName;
    String mCreateSchoolTime;
    String mRegionA;
    String mRegionB;
    String mRegionC;
    String mRegionD;
    String mRegionE;
    String mSchoolTypeGroup;
    String mIsExistDoubleLanguage;
    String mIsNation;
    String mEmail;
    String mOfficeTelephone;
    String mZipcode;
    String mCustomOwner;
    String mFax;
    String mWebsite;
    String mOrganizationAddress;
    String mJj;
    String mRy;
    String mSzll;

    public SchoolData(String organizationNo,
                      String organizationName,
                      String createSchoolTime,
                      String regionA,
                      String regionB,
                      String regionC,
                      String regionD,
                      String RegionE,
                      String schoolTypeGroup,
                      String isExistDoubleLanguage,
                      String isNation,
                      String email,
                      String officeTelephone,
                      String zipcode,
                      String customOwner,
                      String fax,
                      String website,
                      String organizationAddress,
                      String jj,
                      String ry,
                      String szll)
    {
        super();
        mOrganizationNo = organizationNo;
        mOrganizationName = organizationName;
        mCreateSchoolTime = createSchoolTime;
        mRegionA = regionA;
        mRegionB = regionB;
        mRegionC = regionC;
        mRegionD = regionD;
        mRegionE = RegionE;
        mSchoolTypeGroup = schoolTypeGroup;
        mIsExistDoubleLanguage = isExistDoubleLanguage;
        mIsNation = isNation;
        mEmail = email;
        mOfficeTelephone = officeTelephone;
        mZipcode = zipcode;
        mCustomOwner = customOwner;
        mFax = fax;
        mWebsite = website;
        mOrganizationAddress = organizationAddress;
        mJj = jj;
        mRy = ry;
        mSzll = szll;
    }

    public String getmOrganizationNo()
    {
        if (mOrganizationNo == "")
        {
            return "暂无数据";
        }
        return mOrganizationNo;
    }

    public String getmOrganizationName()
    {
        if (mOrganizationName == "")
        {
            return "暂无数据";
        }
        return mOrganizationName;
    }

    public String getmCreateSchoolTime()
    {
        if (mCreateSchoolTime == "")
        {
            return "暂无数据";
        }
        return mCreateSchoolTime;
    }

    public String getmRegionA()
    {
        if (mRegionA == "")
        {
            return "暂无数据";
        }
        return mRegionA;
    }

    public String getmRegionB()
    {
        if (mRegionB == "")
        {
            return "暂无数据";
        }
        return mRegionB;
    }

    public String getmRegionC()
    {
        if (mRegionC == "")
        {
            return "暂无数据";
        }
        return mRegionC;
    }

    public String getmRegionD()
    {
        if (mRegionD == "")
        {
            return "暂无数据";
        }
        return mRegionD;
    }

    public String getmRegionE()
    {
        if (mRegionE == "")
        {
            return "暂无数据";
        }
        return mRegionE;
    }

    public String getmSchoolTypeGroup()
    {
        if (mSchoolTypeGroup == "")
        {
            return "暂无数据";
        }
        return mSchoolTypeGroup;
    }

    public String getmIsExistDoubleLanguage()
    {
        if (mIsExistDoubleLanguage == "")
        {
            return "暂无数据";
        }
        return mIsExistDoubleLanguage;
    }

    public String getmIsNation()
    {
        if (mIsNation == "")
        {
            return "暂无数据";
        }
        return mIsNation;
    }

    public String getmEmail()
    {
        if (mEmail == "")
        {
            return "暂无数据";
        }
        return mEmail;
    }

    public String getmOfficeTelephone()
    {
        if (mOfficeTelephone == "")
        {
            return "暂无数据";
        }
        return mOfficeTelephone;
    }

    public String getmZipcode()
    {
        if (mZipcode == "")
        {
            return "暂无数据";
        }
        return mZipcode;
    }

    public String getmCustomOwner()
    {
        if (mCustomOwner == "")
        {
            return "暂无数据";
        }
        return mCustomOwner;
    }

    public String getmFax()
    {
        if (mFax == "")
        {
            return "暂无数据";
        }
        return mFax;
    }

    public String getmWebsite()
    {
        if (mWebsite == "")
        {
            return "暂无数据";
        }
        return mWebsite;
    }

    public String getmOrganizationAddress()
    {
        if (mOrganizationAddress == "")
        {
            return "暂无数据";
        }
        return mOrganizationAddress;
    }

    public String getmJj()
    {
        if (mJj == "")
        {
            return "暂无数据";
        }
        return mJj;
    }

    public String getmRy()
    {
        if (mRy == "")
        {
            return "暂无数据";
        }
        return mRy;
    }

    public String getmSzll()
    {
        if (mSzll == "")
        {
            return "暂无数据";
        }
        return mSzll;
    }


}
