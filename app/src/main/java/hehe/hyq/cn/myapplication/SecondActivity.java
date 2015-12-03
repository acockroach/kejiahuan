package hehe.hyq.cn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bm.library.Info;
import com.bm.library.PhotoView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        loadImage();
    }

    private void loadImage() {
        PhotoView photoView= (PhotoView) findViewById(R.id.img);
        photoView.enable();
        Info info=photoView.getInfo();
        photoView.animaFrom(info);
    }
}
