package hehe.hyq.cn.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.lidroid.xutils.HttpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(adapter);
        createAA();
        createCC();
        HttpUtils utils=new HttpUtils();
        createDD();

    }

    private void createDD() {
        System.out.println("dddd");
    }

    BaseAdapter adapter=new BaseAdapter() {
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView==null){
                view=View.inflate(MainActivity.this,R.layout.list_item,null);
            }else{
                view=convertView;
            }
            return view;
        }
    };
    private void createCC() {
        System.out.println("呵呵呵");
    }

    private void createBB() {
        System.out.println("请问你是逗比吗");
    }

    private void createAA() {
        System.out.println("呵呵呵");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        System.out.println("你是谁啊，补补");
        return super.onOptionsItemSelected(item);
    }
}
