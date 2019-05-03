package lv.anitra.pavels.formulupalgs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context thisContext;
    ListView formulasListView;
    String[] names;
    TextView subjectTextView;
    String subject;
    int subj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Resources res = getResources();
        subj = extras.getInt("lv.anitra.pavels.SUBJECT", -1);
        switch (subj) {
            case 2:
                subject = res.getString(R.string.chemistry);
                names = res.getStringArray(R.array.chemName);
                break;
            case 1:
                subject = res.getString(R.string.physics);
                names = res.getStringArray(R.array.physName);
                break;
            case 0:
                subject = res.getString(R.string.math);
                names = res.getStringArray(R.array.mathName);
                break;
            default:
                subject = "ERROR";
        }

        subjectTextView = (TextView) findViewById(R.id.subjectTextView);
        formulasListView = (ListView) findViewById(R.id.formulasListView);
        subjectTextView.setText(subject);
        thisContext = this;

        ItemAdapter itemAdapter = new ItemAdapter(this, names);
        formulasListView.setAdapter(itemAdapter);

        formulasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), FormulaActivity.class);
                intent.putExtra("lv.anitra.pavels.SUBJECT", subj);
                intent.putExtra("lv.anitra.pavels.INDEX", i);
                startActivity(intent);
            }
        });
    }

}
