package xaut.schoolapp.com.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import xaut.schoolapp.com.schoolapp.R;

public class SchoolInfo extends AppCompatActivity {

    WebView wv_SchoolInfoView;

    String schoolNameStr = "西理工";
    String hostingTypeStr = "中共中央";
    String addressStr = "曲江";
    String faxStr = "12344444";
    String phoneStr = "45622222";
    String emailStr = "78922222@qq.com";
    String schoolInfoStr =
            "西安理工大学是陕西省重点建设的高水平大学，是国家中西部高等教育振兴计划——中西部高校基础能力建设工程实施院校。学校是我国西北地区水利水电、装备制造、印刷包装行业高级专门人才的重要培养基地和科研中心之一。现任党委书记周孝德、校长李孝廉。学校的前身是成立于1958年的北京机械学院和成立于1960年的陕西工业大学。北京机械学院由北京机器制造学校、北京工业管理学校和北京工业干部学校组建而成。三校的办学历史分别可追溯到成立于1945年的国立北平高级工业职业学校、成立于1937年的北平市立高级商科职业学校和1952年成立的沈阳工业干部学校。北京机械学院隶属第一机械工业部，1969年搬迁至陕西汉中，1972年迁至西安。陕西工业大学以交通大学（西安部分）的水利系、纺织系为主体，合并西安化工学院、陕西科技大学、西安机械专科学校等组建而成，水利系的办学历史可以追溯到创建于1895年的北洋大学土木工程系水利组。1972年，北京机械学院和陕西工业大学合并组建陕西机械学院，隶属第一机械工业部。1994年，学校经批准更名为西安理工大学。1998年，学校划转陕西省，管理体制调整为中央与陕西省共建，以陕西省管理为主。2002年，陕西省批准西安仪表工业学校整体并入西安理工大学。学校以1949年人民政府接管国立北平高级工业职业学校为建校年，5月1日为校庆日。";
    String honorStr = "水利工程为一级国家重点学科，水利水电工程、热能与动力工程、自动化为国家特色专业；给水排水专业全国13" +
            "名，水利水电学院在全国同等学院中排名第四。西安理工大学的热能与动力工程、自动化、材料科学与工程3个专业被确定为2007" +
            "年陕西普通高等学校第一类特色专业。教育部、财政部发文（教高函[2007]25号）《教育部、财政部关于批准2007" +
            "年度第一批高等学校特色专业建设点的通知》，西安理工大学水利水电工程被批准为2007年度第一批高等学校特色专业建设点。教育部、财政部发文（教高函[2007]31" +
            "号）《教育部、财政部关于批准2007年度第二批高等学校特色专业建设点的通知》，西安理工大学热能与动力工程、自动化2个专业被批准为2007" +
            "年度第二批高等学校特色专业建设点。自1999年陕西省学位办开展重点学科建设工作以来，该校10" +
            "个受陕西省重点学科建设经费资助的学科结合科学技术发展的新趋势和经济社会发展需要，积极拓宽学科领域，加大学科交叉与融合，充分发挥优势学科的作用，在加强自身建设与发展的同时，带动了相关学科的发展，形成了以重点学科为龙头、相关学科为支撑的“学科群”，发挥了重点学科示范和带动作用。";
    String facultyStr =
            "师资队伍建设是学校内涵建设的核心，是提高办学水平和办学质量的关键。近年来，学校按照“以人为本、优化结构、重视培养、广纳贤才、培育团队、成就名师”的队伍建设思路，通过实施学科（术）带头人、校杰出青年教师和校优秀青年教师等系列人才建设工程，积极培养、引进、凝聚高层次人才，已构建起了学科带头人、学术带头人、校杰出青年教师和校优秀青年教师组成的四级梯队格局。";
    String tSchoolNameStr = "西理工";
    String tBuildTimeStr = "2007-01-01";
    String tProvinceStr = "陕西";
    String tCityStr = "西安市";
    String tAreaStr = "雁塔区";
    String tStreetStr = "雁翔路";
    String tZipCodeStr = "710016";
    String tWebStr = "202.200.112.202";
    String tDoubleLanguageStr = "是";
    String tNationalSchoolStr = "否";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        init();
    }
    public void init(){
        wv_SchoolInfoView = (WebView) findViewById(R.id.wv_SchoolInfoView);


        wv_SchoolInfoView.getSettings().setJavaScriptEnabled(true);   //开启JavaScript支持
        wv_SchoolInfoView.getSettings().setUseWideViewPort(true);
        wv_SchoolInfoView.getSettings().setLoadWithOverviewMode(true);
        wv_SchoolInfoView.loadUrl("file:///android_asset/NewSchoolInfo.html");    //放在assets的html需加上


        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                wv_SchoolInfoView.loadUrl("javascript: ChangeInfo('" + schoolNameStr + "', '" +
                        hostingTypeStr + "', '" + addressStr + "', '" + faxStr + "', '" +
                        phoneStr + "', '" + emailStr + "', '" + schoolInfoStr + "', '" + honorStr
                        + "', '" + facultyStr + "', '" + tSchoolNameStr + "', '" + tBuildTimeStr
                        + "', '" + tProvinceStr + "', '" + tCityStr + "', '" + tAreaStr + "', '"
                        + tStreetStr + "', '" + tZipCodeStr + "', '" + tWebStr + "', '" +
                        tDoubleLanguageStr + "', '" + tNationalSchoolStr + "')");
            }
        }, 1000);
    }
}
