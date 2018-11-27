package hkit.kr.notrpro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoModifyActivity extends AppCompatActivity {

    EditText modifyEditText;
    Button modifyButton1;
    Button modifyButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_modify);

        modifyEditText = findViewById(R.id.modifyEditText);
        modifyButton1 = findViewById(R.id.modifyButton1);
        modifyButton2 = findViewById(R.id.modifyButton2);
        Intent intent = getIntent();
        String memo = intent.getStringExtra("memo");
        modifyEditText.setText(memo);

        modifyButton1.setOnClickListener(button1Listener);
        modifyButton2.setOnClickListener(button2Listener);
    }

    View.OnClickListener button1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String memo = modifyEditText.getText().toString();

            Intent data = new Intent();
            data.putExtra("memo", memo);
            setResult(Activity.RESULT_OK, data);
            finish();
        }
    };
    View.OnClickListener button2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        finish();
        }
    };
}
