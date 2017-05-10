package bluetooth.inuker.com.grassinvain.controller.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import bluetooth.inuker.com.grassinvain.R;
import bluetooth.inuker.com.grassinvain.common.util.CommonUtil;
import bluetooth.inuker.com.grassinvain.common.util.MConstants;
import bluetooth.inuker.com.grassinvain.controller.fragment.RegisFragmentOne;
import bluetooth.inuker.com.grassinvain.controller.fragment.RegisFragmentTwe;
import bluetooth.inuker.com.grassinvain.controller.fragment.RegisFragmentthree;
import bluetooth.inuker.com.grassinvain.network.body.UserInfo;
import bluetooth.inuker.com.grassinvain.network.model.RequestModel.UserBody;
import bluetooth.inuker.com.grassinvain.network.model.UserModel;
import bluetooth.inuker.com.grassinvain.network.model.callback.Callback;

public class RegisteredActivity extends FragmentActivity implements View.OnClickListener {



    private ViewPager regis_viewpager;
    private ArrayList<Fragment> fragment;
    private RegisFragmentOne regisFragmentOne;
    private FragmentManager supportFragmentManager;
    private RegisFragmentTwe regisFragmentTwe;
    private RegisFragmentthree regisFragmentthree;
    private TextView lunboDot1, lunboDot2, lunboDot3;
    private LinearLayout startZhuce;
    private ImageView regisBack;
    private String imagePath;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        userModel = new UserModel(this);
        supportFragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {
        /**
         * 返回事件
         */

        regisBack = (ImageView) findViewById(R.id.Regis_back);
        regisBack.setOnClickListener(this);
        /**
         * 初始化三个小圆点
         */
        lunboDot1 = (TextView) findViewById(R.id.lunbo_dot1);
        lunboDot2 = (TextView) findViewById(R.id.lunbo_dot2);
        lunboDot3 = (TextView) findViewById(R.id.lunbo_dot3);

        /**
         * 注册按钮
         */
        startZhuce = (LinearLayout) findViewById(R.id.start_zhuce);
        /**
         * 注册按钮响应事件
         */
        startZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String yanzhengmaString = ((RegisFragmentOne) fragment.get(0)).getTuijianrenString();
                String zijirenString = ((RegisFragmentOne) fragment.get(0)).getZijirenString();
                String tuijianrenString = ((RegisFragmentOne) fragment.get(0)).getYanzhengmaString();

                String shurumimaString = ((RegisFragmentTwe) fragment.get(1)).getShurumimaString();
                String querenmimaString = ((RegisFragmentTwe) fragment.get(1)).getQuerenmimaString();

                String personIdCardString = ((RegisFragmentthree) fragment.get(2)).getPersonIdCardString();


                perform();
            }
        });
        regis_viewpager = (ViewPager) findViewById(R.id.regis_viewpager);
        fragment = new ArrayList<>();
        regisFragmentOne = new RegisFragmentOne();
        regisFragmentTwe = new RegisFragmentTwe();
        regisFragmentthree = new RegisFragmentthree();
        fragment.add(regisFragmentOne);
        fragment.add(regisFragmentTwe);
        fragment.add(regisFragmentthree);
        regis_viewpager.setOffscreenPageLimit(fragment.size());//卡片数量
        regis_viewpager.setPageMargin(5);//两个卡片之间的距离，单位dp
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(supportFragmentManager, fragment);
        regis_viewpager.setAdapter(myFragmentPagerAdapter);
        regis_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (0 == position) {
                    lunboDot1.setBackgroundResource(R.drawable.icon_back_blue);
                    lunboDot2.setBackgroundResource(R.drawable.icon_back_write);
                    lunboDot3.setBackgroundResource(R.drawable.icon_back_write);
                    startZhuce.setVisibility(View.INVISIBLE);
                }
                if (1 == position) {

                    String yanzhengmaString = ((RegisFragmentOne) fragment.get(0)).getTuijianrenString();
                    String zijirenString = ((RegisFragmentOne) fragment.get(0)).getZijirenString();
                    String tuijianrenString = ((RegisFragmentOne) fragment.get(0)).getYanzhengmaString();

                    if (null == yanzhengmaString || null == tuijianrenString || null == zijirenString) {
                        lunboDot1.setBackgroundResource(R.drawable.icon_back_write);
                    }else {
                        lunboDot1.setBackgroundResource(R.mipmap.regisok);
                    }
                    lunboDot2.setBackgroundResource(R.drawable.icon_back_blue);
                    lunboDot3.setBackgroundResource(R.drawable.icon_back_write);
                    startZhuce.setVisibility(View.INVISIBLE);
                }
                if (2 == position) {

                    String yanzhengmaString = ((RegisFragmentOne) fragment.get(0)).getTuijianrenString();
                    String zijirenString = ((RegisFragmentOne) fragment.get(0)).getZijirenString();
                    String tuijianrenString = ((RegisFragmentOne) fragment.get(0)).getYanzhengmaString();
                    String shurumimaString = ((RegisFragmentTwe) fragment.get(1)).getShurumimaString();
                    String querenmimaString = ((RegisFragmentTwe) fragment.get(1)).getQuerenmimaString();
                    if (null == shurumimaString || null == querenmimaString){
                        lunboDot2.setBackgroundResource(R.drawable.icon_back_write);
                    }else {
                        lunboDot2.setBackgroundResource(R.mipmap.regisok);
                    }
                    if (null == yanzhengmaString || null == tuijianrenString || null == zijirenString) {
                        lunboDot1.setBackgroundResource(R.drawable.icon_back_write);
                    }else {
                        lunboDot1.setBackgroundResource(R.mipmap.regisok);
                    }

                    startZhuce.setVisibility(View.VISIBLE);
                    lunboDot3.setBackgroundResource(R.drawable.icon_back_blue);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     *  发起  注册请求
     */
    private void perform() {

        UserBody userBody = new UserBody();

        userModel.register(userBody, new Callback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo userInfo) {

            }

            @Override
            public void onFailure(int resultCode, String message) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Regis_back:
                finish();
                break;
        }
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> listFragments;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> al) {
            super(fm);
            listFragments = al;
        }

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragments.get(position);
        }

        @Override
        public int getCount() {
            return listFragments.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == MConstants.PHOTO_REQUEST_SELECT) {
                if (data != null) {
                    Uri uri = data.getData();
                    if (uri == null) {
                        return;
                    }
                    File file = null;
                    if (uri.toString().contains(MConstants.MEDIAFROM_TYPE_CONTENT)) {
                        imagePath = CommonUtil.getRealPathFromUri(this, uri);
                        file = new File(imagePath);
                    } else if (uri.toString().contains(MConstants.MEDIAFROM_TYPE_FILE)) {
                        try {
                            file = new File(new URI(uri.toString()));
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }

                    if (file != null) {

                        ((RegisFragmentthree)(fragment.get(2))).setImageIdcard(imagePath);

                    }
                }
            }
        }
    }
}
