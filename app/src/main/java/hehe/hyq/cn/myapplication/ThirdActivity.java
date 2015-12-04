package hehe.hyq.cn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void click1(View view){
        Action1<String> action1=new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        Observable.just("hello,world").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+" -yanqiang";
            }
        }).subscribe(action1);

        
    }

}
