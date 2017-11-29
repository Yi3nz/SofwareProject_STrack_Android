package sarah.nci.ie.reminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    String caText;
    String date;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //
        Intent intent = getIntent();
        caText = intent.getStringExtra(Intent_Constants.INTENT_CA_DATA);
        position = intent.getIntExtra(Intent_Constants.INTENT_ITEM_POSITION, -1);

        EditText caData = (EditText)findViewById(R.id.eTitle);
        caData.setText(""); //Set default text = null when enter editActivity
    }

    //SaveButton - SaveAll
    public void saveAllClick(View v){
        //Define again in MainActivity
        String changeCaTitleText = ((EditText)findViewById(R.id.eTitle)).getText().toString();

        //Back to main activity
        Intent intent = new Intent();
        intent.putExtra(Intent_Constants.INTENT_CHANGED_CA, changeCaTitleText);
        intent.putExtra(Intent_Constants.INTENT_ITEM_POSITION, position);
        setResult(Intent_Constants.INTENT_RESULT_CODE_TWO,intent);
        finish();
    }
}
