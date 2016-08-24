package pl.marchuck.helicoptericeodyssey.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import pl.marchuck.helicoptericeodyssey.R;
import pl.marchuck.helicoptericeodyssey.dagger.App;
import pl.marchuck.helicoptericeodyssey.rxcache.API;
import pl.marchuck.helicoptericeodyssey.rxcache.Repository;
import pl.marchuck.helicoptericeodyssey.rxcache.models.Poke;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DaggerActivity extends AppCompatActivity {

    public static final String TAG = DaggerActivity.class.getSimpleName();

//    @Inject
//    AlmondButter someAlmondButter;

//    @Inject
//    CashewSandwich sandwich;

//    SandwichComponent sandwichComponent;

//    @Inject
//    SWApi swapi;

//    @Inject
//    Vibrator vibrator;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @OnLongClick(R.id.fab)
    public boolean onLong() {
//        vibrator.vibrate(500);
        return false;
    }

    @OnClick(R.id.fab)
    public void clcks() {

        Repository repository = ((App) getApplication()).repository;
        API api = new API();

        repository.getMocks(api).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Poke>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }
                    @Override
                    public void onNext(Poke poke) {
                        Log.d(TAG, "onNext: ");
                        Toast.makeText(DaggerActivity.this, poke.toString(), Toast.LENGTH_LONG).show();
                    }
                });

//        swapi.getCharacter(1)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<pl.marchuck.helicoptericeodyssey.model.Character>() {
//                    @Override
//                    public void call(Character character) {
//                        Toast.makeText(DaggerActivity.this, "received "
//                                + character.name, Toast.LENGTH_SHORT).show();
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(TAG, "error: " + throwable.getMessage());
//                        throwable.printStackTrace();
//                    }
//                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        /*create the dependent butter for the sandwich here*/

//        ButterComponent butterComponent = DaggerButterComponent.builder().
//                butterModule(

//                        new ButterModule()
//                        new ButterModule((App) (this.getApplication()))
//                ).build();

        /*create a scope sandwichcomponent here */
//        sandwichComponent = DaggerSandwichComponent.builder()
//                .sandwichModule(new SandwichModule())
//                .butterComponent(butterComponent)
//                .build();
        //finally we have a sandwichComponent, lets inject our dependencies
//        sandwichComponent.inject(this);


        //   App.getAppComponent(this).inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override

    protected void onDestroy() {
        super.onDestroy();
        //not necessary but it clearly shows the scope being tied to lifecycle of activity
//        sandwichComponent = null;
    }

}
