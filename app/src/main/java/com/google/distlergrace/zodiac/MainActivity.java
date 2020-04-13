package com.google.distlergrace.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    //Program Constants
    final int       MINMONTH    = 1;
    final int       MAXMONTH    = 12;
    final String    OORMONTH    = "Month Input Out Of Range!\nMonth Must Be Between " +
                                  MINMONTH + " and " + MAXMONTH;

    final int       MAXYEAR     = Calendar.getInstance().get(Calendar.YEAR);
    final int       MINYEAR     = MAXYEAR - 130;
    final String    OORYEAR     = "Year Input Out Of Range!\nYear Must Be Between " +
                                  MINYEAR + " and " + MAXYEAR;
    final int       MINDAY      = 1;
    int             MAXDAY;
    final String    OORDAY      = "Day Input Out Of Range!\nDay Must Be Between " +
                                  MINDAY + " and " + MAXDAY;

    //Widget Variables
    EditText    editTextBirthMonth;
    EditText    editTextBirthDay;
    EditText    editTextBirthYear;
    Button      buttonValidate;
    Button      buttonClear;
    Button      buttonZodiac;

    //Non-Widget Variables
    int     birthMonth;
    int     birthDay;
    int     birthYear;
    String  inputtedDate;
    String  day;
    Toast   t;
    String  astrologicalSign;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBirthMonth  = findViewById(R.id.editTextBirthMonth);
        editTextBirthDay    = findViewById(R.id.editTextBirthDay);
        editTextBirthYear   = findViewById(R.id.editTextBirthYear);
        buttonValidate      = findViewById(R.id.buttonValidate);
        buttonClear         = findViewById(R.id.buttonClear);
        buttonZodiac        = findViewById(R.id.buttonZodiac);

        buttonValidate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean keepGoing = validateMonth();

                if (keepGoing)
                {
                    keepGoing = validateYear();
                }

                if (keepGoing)
                {
                    keepGoing = validateDay();
                }

                if (keepGoing)
                {
                    validateDOW();
                    validateSign();
                    buttonZodiac.setEnabled(true);
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clearAll();
            }
        });

        buttonZodiac.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle extras = new Bundle();
                extras.putInt("birthMonth", birthMonth);
                extras.putInt("birthDay", birthDay);
                extras.putString("astrologicalSign", astrologicalSign);

                Intent intent = new Intent(getApplicationContext(), ZodiacSign.class);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }

    private boolean validateMonth()
    {
        try
        {
            birthMonth  = Integer.parseInt(editTextBirthMonth.getText().toString());

            while ((birthMonth < MINMONTH) || (birthMonth > MAXMONTH))
            {
                birthMonth = 0;
                editTextBirthMonth.setText("");
                editTextBirthMonth.requestFocus();
                throw new NumberFormatException();
            }

            return true;

        }
        catch (NumberFormatException nfe)
        {
            Toast t = Toast.makeText(getApplicationContext(),
                                     OORMONTH,
                                     Toast.LENGTH_LONG);
            t.show();

            return false;
        }
    }

    private boolean validateYear()
    {
        try
        {
            birthYear  = Integer.parseInt(editTextBirthYear.getText().toString());

            while ((birthYear < MINYEAR) || (birthYear > MAXYEAR))
            {
                birthYear = 0;
                editTextBirthYear.setText("");
                editTextBirthYear.requestFocus();
                throw new NumberFormatException();
            }

            return true;

        }
        catch (NumberFormatException nfe)
        {
            Toast t = Toast.makeText(getApplicationContext(),
                                     OORYEAR,
                                     Toast.LENGTH_LONG);
            t.show();

            return false;
        }
    }

    private boolean validateDay()
    {
        if ((birthMonth == 1) || (birthMonth == 3) || (birthMonth == 5) || (birthMonth == 7) ||
                (birthMonth == 8) || (birthMonth == 10) || (birthMonth == 12))
        {
            MAXDAY = 31;
        }
        else if ((birthMonth == 4) || (birthMonth == 6) || (birthMonth == 9) || (birthMonth == 11))
        {
            MAXDAY = 30;
        }
        else if (birthMonth == 2)
        {
            MAXDAY = 28;
        }

        try
        {
            birthDay  = Integer.parseInt(editTextBirthDay.getText().toString());

            while ((birthDay < MINDAY) || (birthDay > MAXDAY))
            {
                birthDay = 0;
                editTextBirthDay.setText("");
                editTextBirthDay.requestFocus();
                throw new NumberFormatException();
            }

            return true;

        }
        catch (NumberFormatException nfe)
        {
            Toast t = Toast.makeText(getApplicationContext(),
                                     OORDAY,
                                     Toast.LENGTH_LONG);
            t.show();

            return false;
        }

    }

    private void validateDOW()
    {
        inputtedDate = birthDay + "/" + birthMonth + "/" + birthYear;
        //SimpleDateFormat format1 = new SimpleDateFormat("dd/M/yyyy").parse(inputtedDate);


        Calendar c = Calendar.getInstance();
        //c.setTime(inputtedDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);



        day = "You were born on a " + dayOfWeek + "!";
        t = Toast.makeText(getApplicationContext(),
                           day,
                           Toast.LENGTH_LONG);
        t.show();
    }

    private void validateSign()
    {
        if (birthMonth == 1)
        {
            if (birthDay <= 19)
            {
                astrologicalSign = "Capricorn";
            }
            else if (birthDay > 19)
            {
                astrologicalSign = "Aquarius";
            }
        }
        else if (birthMonth == 2)
        {
            if (birthDay <= 18)
            {
                astrologicalSign = "Aquarius";
            }
            else if (birthDay > 18)
            {
                astrologicalSign = "Pisces";
            }
        }
        else if (birthMonth == 3)
        {
            if (birthDay <= 20)
            {
                astrologicalSign = "Pisces";
            }
            else if (birthDay > 20)
            {
                astrologicalSign = "Aries";
            }
        }
        else if (birthMonth == 4)
        {
            if (birthDay <= 19)
            {
                astrologicalSign = "Aries";
            }
            else if (birthDay > 19)
            {
                astrologicalSign = "Taurus";
            }
        }
        else if (birthMonth == 5)
        {
            if (birthDay <= 20)
            {
                astrologicalSign = "Taurus";
            }
            else if (birthDay > 20)
            {
                astrologicalSign = "Gemini";
            }
        }
        else if (birthMonth == 6)
        {
            if (birthDay <= 20)
            {
                astrologicalSign = "Gemini";
            }
            else if (birthDay > 20)
            {
                astrologicalSign = "Cancer";
            }
        }
        else if (birthMonth == 7)
        {
            if (birthDay <= 22)
            {
                astrologicalSign = "Cancer";
            }
            else if (birthDay > 22)
            {
                astrologicalSign = "Leo";
            }
        }
        else if (birthMonth == 8)
        {
            if (birthDay <= 22)
            {
                astrologicalSign = "Leo";
            }
            else if (birthDay > 18)
            {
                astrologicalSign = "Virgo";
            }
        }
        else if (birthMonth == 9)
        {
            if (birthDay <= 22)
            {
                astrologicalSign = "Virgo";
            }
            else if (birthDay > 18)
            {
                astrologicalSign = "Libra";
            }
        }
        else if (birthMonth == 10)
        {
            if (birthDay <= 22)
            {
                astrologicalSign = "Libra";
            }
            else if (birthDay > 22)
            {
                astrologicalSign = "Scorpio";
            }
        }
        else if (birthMonth == 11)
        {
            if (birthDay <= 21)
            {
                astrologicalSign = "Scorpio";
            }
            else if (birthDay > 21)
            {
                astrologicalSign = "Sagittarius";
            }
        }
        else if (birthMonth == 12)
        {
            if (birthDay <= 21)
            {
                astrologicalSign = "Sagittarius";
            }
            else if (birthDay > 21)
            {
                astrologicalSign = "Capricorn";
            }
        }
    }

    private void clearAll()
    {
        editTextBirthMonth.setText("");
        editTextBirthDay.setText("");
        editTextBirthYear.setText("");
        editTextBirthMonth.requestFocus();
        buttonZodiac.setEnabled(false);
    }

}
