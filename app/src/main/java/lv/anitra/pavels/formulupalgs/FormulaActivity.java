package lv.anitra.pavels.formulupalgs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class FormulaActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

        String fileName = "";
        wv = (WebView) findViewById(R.id.formula_page);
        wv.getSettings().setJavaScriptEnabled(true);
        //wv.getSettings().setBuiltInZoomControls(true);

        Bundle extras = getIntent().getExtras();
        Resources res = getResources();
        if (extras == null) {
            return;
        }
        int subj = extras.getInt("lv.anitra.pavels.SUBJECT", -1);
        int ind = extras.getInt("lv.anitra.pavels.INDEX", -1);
        switch (subj) {
            case 0:
                fileName = res.getStringArray(R.array.mathForm)[ind];
                break;
            case 1:
                fileName = res.getStringArray(R.array.physForm)[ind];
                break;
            case 2:
                fileName = res.getStringArray(R.array.chemForm)[ind];
                break;
        }

        wv.loadUrl("file:///android_asset/mathscribe/" + fileName);
    }
}
