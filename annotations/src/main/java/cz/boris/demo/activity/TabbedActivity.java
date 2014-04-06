package cz.boris.demo.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import cz.boris.demo.R;
import cz.boris.demo.fragment.AnimationFragment;
import cz.boris.demo.fragment.MainMenuFragment;
import cz.boris.demo.fragment.TopicFragment;

/**
 * Created by Boris Musatov on 31.3.2014.
 */
@EActivity(R.layout.fragment_container)
@OptionsMenu(R.menu.main)
public class TabbedActivity extends BaseActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        createTabs(bar);
        bar.setTitle("Tabbed example");
    }

    private void createTabs(ActionBar bar) {
        bar.addTab(createNewTab("Tab One"));
        bar.addTab(createNewTab("Tab Two"));
        bar.addTab(createNewTab("Tab Three"));
    }

    private ActionBar.Tab createNewTab(String name) {
        ActionBar.Tab tab = getActionBar().newTab();
        tab.setText(name);
        tab.setTabListener(this);
        return tab;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(tab.getText().equals("Tab One")) ft.replace(R.id.fragment_container, MainMenuFragment.newInstance());
        if(tab.getText().equals("Tab Two")) ft.replace(R.id.fragment_container, TopicFragment.newInstance(new Bundle()));
        if(tab.getText().equals("Tab Three")) ft.replace(R.id.fragment_container, AnimationFragment.newInstance());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
