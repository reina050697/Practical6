package com.edu.taruc.practical6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        checkBoxSmoker =(CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(getApplicationContext(),"Position: " + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view)
    {
        double premium = 0 ;
        int pos;
        pos = spinnerAge.getSelectedItemPosition();
        //TODO:Determine the basic premium
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();

        if(indexGender == R.id.radioButtonMale)
        {
            //TODO:Calculate premium of male
            switch(pos)
            {
                case 0:
                        premium = 50;
                        break;
                case 1:
                        premium = 55;
                        break;
                case 2:
                        premium = 110;
                        break;
                case 3:
                        premium = 170;
                        break;
                case 4:
                        premium = 220;
                        break;
                case 5:
                        premium = 210;
                        break;
                case 6:
                        premium = 200;
                        break;
                case 7:
                        premium = 250;
                        break;
            }
        }

        else
        {
            switch(pos)
            {
                case 0:
                    premium = 50;
                    break;
                case 1:
                    premium = 55;
                    break;
                case 2:
                    premium = 60;
                    break;
                case 3:
                    premium = 70;
                    break;
                case 4:
                    premium = 120;
                    break;
                case 5:
                    premium = 160;
                    break;
                case 6:
                    premium = 200;
                    break;
                case 7:
                    premium = 250;
                    break;
            }
        }

        if(checkBoxSmoker.isChecked())
        {
            //TODO: Calculate premium of smoker
            switch(pos)
            {
                case 0:
                    premium += premium;
                    break;
                case 1:
                    premium += premium;
                    break;
                case 2:
                    premium += premium;
                    break;
                case 3:
                    premium += 100;
                    break;
                case 4:
                    premium += 150;
                    break;
                case 5:
                    premium += 150;
                    break;
                case 6:
                    premium += 250;
                    break;
                case 7:
                    premium += 250;
                    break;
            }

        }

        textViewPremium.setText(getString(R.string.premium)+ " : " + premium);
    }

    public void resetPremium(View view)
    {
        //TODO:Clear UI and reset premium View
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("");
    }
}
