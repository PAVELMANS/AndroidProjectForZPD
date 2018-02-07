package lv.anitra.pavels.formulupalgs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button mathBtn;
    private Button physBtn;
    private Button chemBtn;

    private View.OnClickListener mathBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mathBtnClicked();
        }
    };
    private View.OnClickListener physBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            physBtnClicked();
        }
    };
    private View.OnClickListener chemBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chemBtnClicked();
        }
    };

    private void mathBtnClicked() {
        Intent moveTo = new Intent(getApplicationContext(), ListActivity.class);
        moveTo.putExtra("lv.anitra.pavels.SUBJECT", 0);
        startActivity(moveTo);
    }

    private void physBtnClicked() {
        Intent moveTo = new Intent(getApplicationContext(), ListActivity.class);
        moveTo.putExtra("lv.anitra.pavels.SUBJECT", 1);
        startActivity(moveTo);
    }

    private void chemBtnClicked() {
        Intent moveTo = new Intent(getApplicationContext(), ListActivity.class);
        moveTo.putExtra("lv.anitra.pavels.SUBJECT", 2);
        startActivity(moveTo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mathBtn = (Button) findViewById(R.id.mathButton);
        physBtn = (Button) findViewById(R.id.physButton);
        chemBtn = (Button) findViewById(R.id.chemButton);
        mathBtn.setOnClickListener(mathBtnClickListener);
        physBtn.setOnClickListener(physBtnClickListener);
        chemBtn.setOnClickListener(chemBtnClickListener);
    }

}
