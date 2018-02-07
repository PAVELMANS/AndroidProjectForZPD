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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        formulasListView = (ListView) findViewById(R.id.formulasListView);
        thisContext = this;

        switch (getIntent().getExtras().getByte("lv.anitra.pavels.formulupalgs.SUBJECT")) {
            case 0:
                subject = res.getString(R.string.math);
                names = res.getStringArray(R.array.mathName);
                break;
            case 1:
                subject = res.getString(R.string.physics);
                names = res.getStringArray(R.array.physName);
                break;
            case 2:
                subject = res.getString(R.string.chemistry);
                names = res.getStringArray(R.array.chemName);
                break;
            default:
                subject = "ERROR";
        }
        subjectTextView.setText(subject);

        ItemAdapter itemAdapter = new ItemAdapter(this, names);
        formulasListView.setAdapter(itemAdapter);

        formulasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), FormulaActivity.class);
                intent.putExtra("lv.anitra.pavels.INDEX", i);
                intent.putExtra("lv.anitra.pavels.SUBJECT", subject);
                startActivity(intent);
            }
        });
    }

}
