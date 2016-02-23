package pl.marchuck.helicoptericeodyssey.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import pl.marchuck.helicoptericeodyssey.R;
import pl.marchuck.helicoptericeodyssey.dagger.App;
import pl.marchuck.helicoptericeodyssey.dagger.Extra;
import pl.marchuck.helicoptericeodyssey.dagger.Normal;
import pl.marchuck.helicoptericeodyssey.network.SWApi;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.fab)
    FloatingActionButton fab1;
    @Bind(R.id.fab2)
    FloatingActionButton fab2;

    @Inject
    MediaPlayer mediaPlayer;

    @Inject
    @Extra
    SWApi swapi;

    @Inject
    @Normal
    SWApi swapi3;

    //default
    @Inject
    SWApi swapiOriginal;


    @OnClick(R.id.fab)
    public void fab1() {
        callSwapi(swapi);
    }

    @OnClick(R.id.fab2)
    public void fab2() {
        swapiOriginal.getCharacter(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<pl.marchuck.helicoptericeodyssey.model.Character>() {
                    @Override
                    public void call(pl.marchuck.helicoptericeodyssey.model.Character character) {
                        Log.d(TAG, "call: " + character.name);
                    }

                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "call: " + throwable.getMessage());
                    }
                });
    }

    @OnLongClick(R.id.fab)
    public boolean fab21() {
        callSwapi(swapi3);
        return false;
    }

    @OnLongClick(R.id.fab2)
    public boolean fab22() {
        if (mediaPlayer != null)
            mediaPlayer.start();
        else Toast.makeText(MainActivity.this, "Nullable mediaPlayer", Toast.LENGTH_SHORT).show();
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        App.getAppComponent(this).inject(this);

        setSupportActionBar(toolbar);
    }

    void callSwapi(SWApi swapi) {
        swapi.getCharacter2(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d(TAG, "call: " + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "call: " + throwable.getMessage());
                    }
                });
    }
}
