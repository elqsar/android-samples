package cz.boris.demo.fragment;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.EFragment;

import cz.boris.demo.R;
import cz.boris.demo.activity.AnimationActivity;
import cz.boris.demo.activity.DrawingActivity;
import cz.boris.demo.activity.FragmentActivity;
import cz.boris.demo.activity.MainActivity;
import cz.boris.demo.activity.RestActivity;
import cz.boris.demo.activity.ServiceActivity;
import cz.boris.demo.activity.TabbedActivity;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@EFragment(R.layout.main_menu)
public class MainMenuFragment extends ListFragment {

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment_();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainMenuAdapter adapter = new MainMenuAdapter(getActivity(), 0);
        adapter.add(new MenuItem("Basics", MainActivity.get()));
        adapter.add(new MenuItem("Fragments and Loaders", FragmentActivity.get()));
        adapter.add(new MenuItem("Drawing view", DrawingActivity.get()));
        adapter.add(new MenuItem("REST activity", RestActivity.get()));
        adapter.add(new MenuItem("Annimation", AnimationActivity.get()));
        adapter.add(new MenuItem("Intent Service", ServiceActivity.get()));
        adapter.add(new MenuItem("Tabbed Activity", TabbedActivity.get()));
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        MenuItem item = (MenuItem) l.getItemAtPosition(position);
        startActivity(new Intent(getActivity(), item.clazz));

    }

    static class MainMenuAdapter extends ArrayAdapter<MenuItem> {

        public MainMenuAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MenuItem menuItem = getItem(position);
            if(convertView == null) {
                // too easy, do not need holder pattern here
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_menu_item, parent, false);
                TextView text = (TextView) convertView.findViewById(R.id.main_menu_item);
                text.setText(menuItem.title);
            }
            return convertView;
        }
    }

    static class MenuItem {
        public String title;
        public Class<?> clazz;

        MenuItem(String title, Class<?> clazz) {
            this.title = title;
            this.clazz = clazz;
        }
    }
}
