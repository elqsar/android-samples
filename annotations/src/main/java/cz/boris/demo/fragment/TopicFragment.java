package cz.boris.demo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import cz.boris.demo.R;
import cz.boris.demo.data.DB;

/**
 * Created by Boris Musatov on 2.3.14.
 */
@EFragment(R.layout.topic_fragment)
public class TopicFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    
    @ViewById(R.id.topic_name_edit)
    EditText topicName;
    @ViewById(R.id.topic_description_edit)
    EditText topicDescription;
    @ViewById(R.id.topic_list)
    ListView topicList;

    @Bean
    DB database;
    SimpleCursorAdapter adapter;

    public static TopicFragment newInstance(Bundle bundle) {
        TopicFragment_ fragment = new TopicFragment_();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @AfterInject
    public void setupBeans() {
        database.open();
    }

    @AfterViews
    public void setup() {
        String[] from = new String[]{ID, NAME, DESCRIPTION};
        int[] to = new int[]{R.id.topic_id, R.id.topic_name, R.id.topic_description};
        adapter = new SimpleCursorAdapter(getActivity(), R.layout.topic_row, null, from, to, 0);
        topicList.setAdapter(adapter);
        topicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView text = (TextView) view.findViewById(R.id.topic_id);
                        Toast.makeText(getActivity(), text.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        getLoaderManager().initLoader(0, null, this);
    }

    @Click(R.id.save_topic)
    public void saveTopic() {
        if(checkInputValidity()) {
            database.addTopic(topicName.getText().toString(), topicDescription.getText().toString());
            if (getLoaderManager().getLoader(0).isStarted()) {
                getLoaderManager().getLoader(0).forceLoad();
            }
            topicName.setText("");
            topicDescription.setText("");
        } else {
            Toast.makeText(getActivity(), getString(R.string.invalid_info_message), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkInputValidity() {
        return !TextUtils.isEmpty(topicName.getText().toString()) &&
           !TextUtils.isEmpty(topicDescription.getText().toString());
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new TopicCursorLoader(getActivity(), database);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        database.close();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    static class TopicCursorLoader extends CursorLoader {

        DB db;

        public TopicCursorLoader(Context context, DB db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            Cursor cursor = db.getAll("topics");
            return cursor;
        }
    }
}
