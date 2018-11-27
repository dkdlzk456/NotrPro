package hkit.kr.notrpro;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
final int AAA =10;
final int BBB=100;
    int index;
Button addButton;
ListView memoListView;
    /*String[] memos = {
            "메모 리스트1",
            "메모 리스트2",
            "메모 리스트3",
            "메모 리스트4",
            "메모 리스트5"
    };*/
    List<String> memos;
    ArrayAdapter<String> memoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memos = new ArrayList<>();
        memos.add("메모 리스트1");
        memos.add("메모 리스트2");
        memos.add("메모 리스트3");
        memos.add("메모 리스트4");
        memos.add("메모 리스트5");

        addButton = findViewById(R.id.addButton);
        memoListView = findViewById(R.id.memoListView);

        addButton.setOnClickListener(addListener);
        memoListView.setOnItemClickListener(OnItemClickListener);

        memoAdapter = new ArrayAdapter<>(
                getBaseContext(), android.R.layout.simple_list_item_1, memos
        );
        memoListView.setAdapter(memoAdapter);
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == AAA) {
            if (resultCode == Activity.RESULT_OK) {
                String memo = data.getStringExtra("memo");//MemoAddActivity에서 입력된 값을 전달 받음
                memos.add(memo); //리스트에 새로운 메모를 하나 추가함
                memoAdapter.notifyDataSetChanged(); //화면을 다시 업데이트 시키는 함수 *외우기
            }
        }
        if(requestCode==BBB){
        if(resultCode == Activity.RESULT_OK) {
            String memo = data.getStringExtra("memo");//
            memos.set(index, memo);
            memoAdapter.notifyDataSetChanged();
        }
        }
    }

    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MemoAddActivity.class);
            startActivity(intent);
            startActivityForResult(intent, 10);
        }
    };
    AdapterView.OnItemClickListener OnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            String memo = memos.get(position);
            Toast.makeText(getBaseContext(), "memo: "+memo, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MemoModifyActivity.class);
                intent.putExtra("memo",memo);

            startActivityForResult(intent,100);
            index = position;

        }
    };
}
