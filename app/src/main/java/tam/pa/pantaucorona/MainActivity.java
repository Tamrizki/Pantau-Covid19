package tam.pa.pantaucorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tam.pa.pantaucorona.anim.DepthTransformation;
import tam.pa.pantaucorona.fragment.BookFragment;
import tam.pa.pantaucorona.fragment.HomeFragment;
import tam.pa.pantaucorona.fragment.LocalFragment;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        SetBottomNav();
    }

    private void init() {
        navigation =  findViewById(R.id.meowNav);
    }

    private void SetBottomNav() {
        navigation.add(new MeowBottomNavigation.Model(1, R.drawable.world));
        navigation.add(new MeowBottomNavigation.Model(2, R.drawable.indo));
        navigation.add(new MeowBottomNavigation.Model(3, R.drawable.virus_orange));
        navigation.show(1, false);
        navigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (navigation.getId()){

                }
                return null;
            }
        });
        navigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.viewPager, new HomeFragment())
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.viewPager, new LocalFragment())
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.viewPager, new BookFragment())
                                .commit();
                        break;
                }
                return null;
            }
        });
    }
}
