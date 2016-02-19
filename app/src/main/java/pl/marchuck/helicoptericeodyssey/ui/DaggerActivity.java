package pl.marchuck.helicoptericeodyssey.ui;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import pl.marchuck.helicoptericeodyssey.R;
import pl.marchuck.helicoptericeodyssey.dagger.App;
import pl.marchuck.helicoptericeodyssey.model.Character;
import pl.marchuck.helicoptericeodyssey.network.SWApi;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class DaggerActivity extends AppCompatActivity {

    public static final String TAG = DaggerActivity.class.getSimpleName();

    @Inject
    SWApi swapi;

    @Inject
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        App.getAppComponent(this).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapi.getCharacter(1)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<pl.marchuck.helicoptericeodyssey.model.Character>() {
                            @Override
                            public void call(Character character) {
                                Toast.makeText(DaggerActivity.this, "received "
                                        + character.name, Toast.LENGTH_SHORT).show();
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                Log.e(TAG, "error: " + throwable.getMessage());
                                throwable.printStackTrace();
                            }
                        });
            }
        });
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vibrator.vibrate(500);
                return false;
            }
        });
    }
}
