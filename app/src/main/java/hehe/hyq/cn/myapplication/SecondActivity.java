package hehe.hyq.cn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bm.library.Info;
import com.bm.library.PhotoView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<Integer> list;

    private Observable<Integer> createObservable() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < 5; i++) {
                        int temp = new Random().nextInt(10);
                        if (temp > 8) {
                            subscriber.onError(new Throwable("value>8"));
                            break;
                        } else {
                            subscriber.onNext(temp);
                        }

                        if (i == 4) {
                            subscriber.onCompleted();

                        }
                    }
                }
            }
        });
    }

    private Observable<Integer> rangeObservable() {
        return Observable.range(5, 10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        loadImage();
        loadRxJava();

        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    private void loadRxJava() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );
    }

    private void loadImage() {
        PhotoView photoView = (PhotoView) findViewById(R.id.img);
        photoView.enable();
        Info info = photoView.getInfo();
        photoView.animaFrom(info);
    }

    public void click(View view) {
        createObservable().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError" + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext" + integer);
            }
        });
    }

    public void range(View view) {
        rangeObservable().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError" + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext" + integer);
            }
        });
    }

    private Observable<Long> deferObserver(){
        return  Observable.defer(new Func0<Observable<Long>>() {
            @Override
            public Observable<Long> call() {
                return Observable.just(System.currentTimeMillis());
            }
        });
    }
    private Observable<Long> justObserver(){
        return Observable.just(System.currentTimeMillis());
    }
    public void defer(View view){
        deferObserver().subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long time) {
                System.out.println("defer:"+time);
            }
        });
    }

    public void just(View view){
        justObserver().subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long time) {
                System.out.println("just:"+time);
            }
        });
    }
    private Integer[] arrays={1,2,3,4};


    private  Observable<Integer> FromArray(){
        return Observable.from(arrays);
    }

    private Observable<Integer> FromIterable(){
        return Observable.from(list);
    }

    public void from1(View view){
        FromArray().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer i) {
                System.out.println("FromArray:"+i);
            }
        });
    }

    public void from2(View view){
        FromIterable().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer i) {
                System.out.println("FromList"+i);
            }
        });
    }


}
