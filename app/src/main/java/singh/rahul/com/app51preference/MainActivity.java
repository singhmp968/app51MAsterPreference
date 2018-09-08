package singh.rahul.com.app51preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNumber1;
    TextView txtNumbe2;
    TextView txtNumber3;
    Typeface fontNumber1,fontNumber2,fontNumber3;
    String textView1Size,textView2Size,textView3Size;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txtNumber1 = (TextView) findViewById(R.id.TextNumber1);
    txtNumbe2 = (TextView) findViewById(R.id.txtNumber2);
    txtNumber3 = (TextView)findViewById(R.id.txtNumber3);

    fontNumber1 = Typeface.createFromAsset(getAssets(),"fonts/Chunkfive.otf");
    fontNumber2 = Typeface.createFromAsset(getAssets(),"fonts/FontleroyBrown.ttf");
    fontNumber3 = Typeface.createFromAsset(getAssets(),"Wonderbar Demo.otf");

    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
    }

    public  void specifytheSizeForTheTextView1(){
        textView1Size = sharedPreferences.getString("FONT_SIZE_TEXT1","20");
        txtNumber1.setTextSize(Float.parseFloat(textView1Size));
    }

    public  void specifytheSizeForTheTextView2(){
        textView1Size = sharedPreferences.getString("FONT_SIZE_TEXT2","20");
        txtNumber1.setTextSize(Float.parseFloat(textView2Size));
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"This onResume Method",Toast.LENGTH_SHORT).show();
   specifyTheFontForTextView1();
   specifyTheFontForTextView2();
    specifyTheFontForTextView3();


        specifyTheSizeForTextView1();
        specifyTheSizeForTextView2();
        specifyTheSizeForTextView3();
    }


    public void specifyTheFontForTextView1()
    {
        boolean fontNumber1ForText1Value;
        boolean fontNumber2ForText1Value;
        boolean fontNumber3ForText1Value;


        fontNumber1ForText1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT",false);
        fontNumber2ForText1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT1",false);
        fontNumber3ForText1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT1",false);

        if(fontNumber1ForText1Value){
            txtNumber1.setTypeface(fontNumber1);
        } else if(fontNumber2ForText1Value)
        {
            txtNumber1.setTypeface(fontNumber2);
        }else if(fontNumber3ForText1Value)
        {
            txtNumber1.setTypeface(fontNumber3);
        }

    }
    public void specifyTheFontForTextView2(){
        boolean fontNumber1ForText2Value;
        boolean  fontNumber2ForText2Value;
        boolean fontNumber3ForText2Value;
        fontNumber1ForText2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT",false);
        fontNumber2ForText2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT1", false);
        fontNumber3ForText2Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT1",false);

      if(fontNumber1ForText2Value) {
          txtNumbe2.setTypeface(fontNumber1);
      }else if(fontNumber2ForText2Value){
          txtNumbe2.setTypeface(fontNumber2);
      } else if(fontNumber3ForText2Value){
          txtNumbe2.setTypeface(fontNumber3);

      }


    }
    public void specifyTheFontForTextView3() {
        boolean fontNumber1ForText3Value;
        boolean fontNumber2ForText3Value;
        boolean fontNumber3ForText3Value;
        fontNumber1ForText3Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT", false);
        fontNumber2ForText3Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT1", false);
        fontNumber3ForText3Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT1", false);

        if (fontNumber1ForText3Value) {
            txtNumbe2.setTypeface(fontNumber1);
        } else if (fontNumber2ForText3Value) {
            txtNumbe2.setTypeface(fontNumber2);
        } else if (fontNumber3ForText3Value) {
            txtNumbe2.setTypeface(fontNumber3);

        }
    }

    public void specifyTheSizeForTextView1() {


        textView1Size = sharedPreferences.getString("FONT_SIZE_TEXT1", "20");

        txtNumber1.setTextSize(Float.parseFloat(textView1Size));

    }


    public void specifyTheSizeForTextView2() {


        textView2Size = sharedPreferences.getString("FONT_SIZE_TEXT2", "20");
        txtNumbe2.setTextSize(Float.parseFloat(textView2Size));

    }



    public void specifyTheSizeForTextView3() {

        textView3Size = sharedPreferences.getString("FONT_SIZE_TEXT3", "20");
        txtNumber3.setTextSize(Float.parseFloat(textView3Size));

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

 int id = item.getItemId();
 switch(id)
 {
     case R.id.settings:

         Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
         startActivity(intent);
         break;
 }

        return super.onOptionsItemSelected(item);
    }
}
