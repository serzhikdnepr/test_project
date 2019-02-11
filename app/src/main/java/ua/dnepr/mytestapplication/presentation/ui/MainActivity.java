package ua.dnepr.mytestapplication.presentation.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.presentation.ui.fragments.EmailedFragment;
import ua.dnepr.mytestapplication.presentation.ui.fragments.SharedFragment;
import ua.dnepr.mytestapplication.presentation.ui.fragments.ViewedFragment;


public class MainActivity extends MvpAppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_emailed:
                    selectTab(getString(R.string.title_emailed));
                    return true;
                case R.id.navigation_shared:
                    selectTab(getString(R.string.title_shared));
                    return true;
                case R.id.navigation_viewed:
                    selectTab(getString(R.string.title_viewed));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_emailed);
    }

    private void selectTab(String tab) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment currentFragment = null;
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f.isVisible()) {
                    currentFragment = f;
                    break;
                }
            }
        }
        Fragment newFragment = fm.findFragmentByTag(tab);

        if (currentFragment != null && newFragment != null && currentFragment == newFragment)
            return;

        FragmentTransaction transaction = fm.beginTransaction();
        if (newFragment == null) {
            transaction.add(R.id.container, getFragment(tab), tab);
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }

        if (newFragment != null) {
            transaction.show(newFragment);
        }
        transaction.commitNow();
    }

    private Fragment getFragment(String tab) {
        if (tab.equalsIgnoreCase(getString(R.string.title_emailed))) {
            return EmailedFragment.newInstance();
        } else if (tab.equalsIgnoreCase(getString(R.string.title_shared))) {
            return SharedFragment.newInstance();
        } else if (tab.equalsIgnoreCase(getString(R.string.title_viewed))) {
            return ViewedFragment.newInstance();
        } else {
            return EmailedFragment.newInstance();
        }
    }
}
