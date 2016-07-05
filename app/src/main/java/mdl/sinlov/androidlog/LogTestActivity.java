package mdl.sinlov.androidlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mdl.sinlov.android.log.ALog;
import mdl.sinlov.android.log.ALogLevel;
import mdl.sinlov.android.log.ALogPrinter;

public class LogTestActivity extends AppCompatActivity {

    @BindView(R.id.tv_log_test_result)
    TextView tvLogTestResult;
    @BindView(R.id.el_log_test_content)
    ExpandableListView elLogTestContent;
    private ArrayList<String> groupArray;
    private ArrayList<List<String>> childArray;
    private LogTestAdapter adapter;

    private String jsonData;
    private String xmlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test);
        ButterKnife.bind(this);
        initData();
        initView();
        bindListener();
    }

    private void initTestData() {
        jsonData = "{\"titleImg\":\"\",\"updateDate\":0,\"modelImg\":\"\",\"searchNum\":" +
                "0,\"testStatusDate\":\"\",\"icon\":\"http://7xq9mm.com1.z0.glb.clouddn.com" +
                "/o_1akl5n1lljqfb761fgv5a6qr12n.png\",\"giftCount\":0,\"language\":\"中文\"," +
                "\"publicDate\":\"2016-06-07 18:25:39\",\"type\":\"网游\",\"ipaName\":\"\",\"" +
                "platform\":\"android\",\"screenshots\":[\"http://7xq9mm.com1.z0.glb.clouddn.c" +
                "om/o_1akl5n4vt165e1d7cj1519ma1qsk2s.jpg\",\"http://7xq9mm.com1.z0.glb.clouddn." +
                "com/o_1akl5n7m445a1ejo11n61vul1hr531.jpg\",\"http://7xq9mm.com1.z0.glb.clouddn" +
                ".com/o_1akl5napq175s13vbsnl14t31r2236.jpg\",\"http://7xq9mm.com1.z0.glb.clouddn" +
                ".com/o_1akl5ngbp1enmipj1b9f5mjkla3b.jpg\",\"http://7xq9mm.com1.z0.glb.clouddn.c" +
                "om/o_1akl5nioncd91ddf1q4196e123c3g.jpg\"],\"videoCount\":0,\"downloadNum\":7,\"r" +
                "eviewCount\":0,\"ipaPath\":\"\",\"testStatus\":\"\",\"qrApkPath\":\"http://7xq9" +
                "mm.com1.z0.glb.clouddn.com/0eaa9c87430845c198b701b6db748027\",\"clickNum\":0,\"" +
                "newsCount\":0,\"indexBanner\":\"\",\"apkSize\":322.2,\"id\":\"57569ee8e4b063" +
                "553a8ff2f8\",\"tag\":\"角色扮演\",\"brief\":\"紫龙互娱旗下《青丘狐传说》手游惊艳亮" +
                "相，唐人影视强档剧集正版授权，湖南卫视开年大作同步联动，祖龙明星团队研发，360度真3D大" +
                "世界、全息无限制城战,自定义情缘恋爱系统，打造最唯美仙侠3DMMO手游！\\r\\n\",\"gameI" +
                "d\":\"2016060718160800004\",\"serveCount\":0,\"apkName\":\"com.zlongame." +
                "qqh.wdj.CAMERA360\",\"filePath\":\"http://7xq9mm.com1.z0.glb.clouddn.c" +
                "om/o_1akllp7dp1d8i8b0hrh12r219te2d.apk\",\"recommendServerDate\":\"\"," +
                "\"guideCount\":0,\"updateTime\":1465354588,\"userId\":\"73\",\"version\"" +
                ":\"11\",\"commentCount\":0,\"ipaSize\":0,\"onlineDate\":1465354588,\"i" +
                "ndexRecommend\":\"http://7xq9mm.com1.z0.glb.clouddn.com/o_1aklt7ih6162ji" +
                "n9togra47eg2d.jpg\",\"indexBigs\":\"http://7xq9mm.com1.z0.glb.clouddn." +
                "com/o_1aklt7ls411avurj14k4164219lb2i.jpg\",\"size\":\"322MB\",\"grade\"" +
                ":0,\"name\":\"青丘狐传说\",\"subjectImg\":\"\",\"recommendServer\":\"\",\"" +
                "dtlImg\":\"\",\"username\":\"1206938012@qq.com\"}";

        xmlData = "<script id=\"tucao_back_betaBox_219\" type=\"text/template\">\n" +
                "    <div class=\"vr-betaBox back-betaBox\" style=\"height:219px\">\n" +
                "        <a href=\"javascript:void(0)\" class=\"beta-return\"></a>\n" +
                "        <div class=\"betaForm ht-200\">\n" +
                "            <div class=\"beta-ico02\">\n" +
                "            </div>\n" +
                "            <h4>\n" +
                "                不满意原因\n" +
                "            </h4>\n" +
                "            <form action=\"\" method=\"get\">\n" +
                "                <p><span><input type=\"checkbox\">不太相关</span><span><input type=\"checkbox\">不是我想要的结果</span><span><input type=\"checkbox\">居然是死链</span><span><input type=\"checkbox\">虚假信息</span><span><input type=\"checkbox\">其它</span></p>\n" +
                "                <div class=\"f-input\">\n" +
                "                <span class=\"vr-value-tips\">\n" +
                "                    细说槽点，一经采用，以礼相送！\n" +
                "                </span>\n" +
                "                    <textarea rows=\"4\" style=\"resize:none;\" maxlength=\"300\"></textarea>\n" +
                "                </div>\n" +
                "                <div class=\"btn-area\">\n" +
                "                    <a href=\"javascript:void(0)\">\n" +
                "                        提交\n" +
                "                    </a>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</script>";
    }

    private void initData() {
        initTestData();
        ALog.initTag();
        groupArray = new ArrayList<>();
        childArray = new ArrayList<List<String>>();
        groupArray.add("Base Logger");
        groupArray.add("JSON or XML");
        groupArray.add("Change Log level");

        List<String> baseLoggerList = new ArrayList<>();
        baseLoggerList.add("Logger v");
        baseLoggerList.add("Logger d");
        baseLoggerList.add("Logger i");
        baseLoggerList.add("Logger w");
        baseLoggerList.add("Logger e");
        baseLoggerList.add("Logger wtf");

        List<String> jsonXMLLoggerList = new ArrayList<>();
        jsonXMLLoggerList.add("json");
        jsonXMLLoggerList.add("xml");

        List<String> changeTagLoggerList = new ArrayList<>();
        changeTagLoggerList.add("full");
        changeTagLoggerList.add("none");
        changeTagLoggerList.add("only warning error");
        changeTagLoggerList.add("change to warning error");

        childArray.add(baseLoggerList);
        childArray.add(jsonXMLLoggerList);
        childArray.add(changeTagLoggerList);
    }

    private void initView() {
        adapter = new LogTestAdapter(this, groupArray, childArray);
        elLogTestContent.setAdapter(adapter);
    }

    private void showResult(String info) {
        tvLogTestResult.setText(info);
    }

    private void bindListener() {
        elLogTestContent.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        filterBaseLogger(groupPosition, childPosition);
                        break;
                    case 1:
                        filterJsonAndXML(childPosition);
                        break;
                    case 2:
                        filterChangeSetting(groupPosition, childPosition);
                }
                return false;
            }

            private void filterChangeSetting(int groupPosition, int childPosition) {
                switch (childPosition) {
                    case 0:
                        ALog.initTag().logLevel(ALogLevel.FULL);
                        ALog.i("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 1:
                        ALog.initTag().logLevel(ALogLevel.NONE);
                        ALog.i("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 2:
                        ALog.initTag().logLevel(ALogLevel.ONLY_WARNING_ERROR);
                        ALog.i("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 3:
                        ALog.initTag().logLevel(ALogLevel.CHANGE_TO_WARNING_ERROR);
                        ALog.i("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                }
            }

            private void filterJsonAndXML(int childPosition) {
                switch (childPosition) {
                    case 0:
                        ALog.json(jsonData);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 1:
                        ALog.xml(xmlData);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                }
            }

            private void filterBaseLogger(int groupPosition, int childPosition) {
                switch (childPosition) {
                    case 0:
                        ALog.v("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 1:
                        ALog.d("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 2:
                        ALog.i("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 3:
                        ALog.w("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 4:
                        ALog.e("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                    case 5:
                        ALog.wtf("groupPosition: " + groupPosition + " |childPosition: " + childPosition);
                        showResult(ALogPrinter.getLogMessage());
                        break;
                }
            }
        });
    }
}
