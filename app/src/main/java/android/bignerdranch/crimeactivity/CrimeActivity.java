package android.bignerdranch.crimeactivity;

//因为需要进行左右滑动换页，所以用CrimePagerActivity来代替CrimeActivity活动，此活动在项目中已经没有意思，不运行

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    //添加了一个通用超类，把重复代码封装为抽象类
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        *//*为什么需要进行fragment==null的判定
        因为当设备旋转或回收内存时，Android系统会销毁活动而后重建时，会调用onCreate(Bundle)方法
        活动被销毁时，它的FragmentManager会将fragment队列保存下来，这样，当活动重建时，FragmentManager会首先获取保存的队列，然后恢复到原来的状态
        *//*
        if(fragment == null){
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
    */

    private static final String EXTRA_CRIME_ID =
            "android.bignerdranch.crimeactivity.crime_id";


    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        //return new CrimeFragment();
        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
