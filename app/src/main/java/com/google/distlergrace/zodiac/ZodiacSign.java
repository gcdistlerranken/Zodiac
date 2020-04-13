package com.google.distlergrace.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ZodiacSign extends AppCompatActivity
{
    ImageView   imageViewSign;
    TextView    textViewSignName;
    TextView    textViewDescription;
    Button      buttonReturn;

    int         birthMonth;
    int         birthDay;
    String      astrologicalSign;
    String      description;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_sign);

        imageViewSign       = findViewById(R.id.imageViewSign);
        textViewSignName    = findViewById(R.id.textViewSignName);
        textViewDescription = findViewById(R.id.textViewDescription);
        buttonReturn        = findViewById(R.id.buttonReturn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null)
        {
            if (extras.containsKey("birthMonth"))
            {
                birthMonth = extras.getInt("birthMonth", 0);
            }

            if (extras.containsKey("birthDay"))
            {
                birthDay = extras.getInt("birthDay", 0);
            }

            if (extras.containsKey("astrologicalSign"))
            {
                astrologicalSign = extras.getString("astrologicalSign", "");
            }


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

            if (astrologicalSign == "Capricorn")
            {
                description = "You are generally hardworking, straightforward, loyal, " +
                              "stubborn, and uncontent until at the top.";

                imageViewSign.setImageResource(R.drawable.capicorn);
                textViewSignName.setText("Capricorn");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Aquarius")
            {
                description = "You generally set trends, are innovative, admired, distant, " +
                              "and eccentric.";

                imageViewSign.setImageResource(R.drawable.aquarius);
                textViewSignName.setText("Aquarius");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Pisces")
            {
                description = "You are generally alluring, free, sensual, sensitive, " +
                              "and can't function alone";

                imageViewSign.setImageResource(R.drawable.pisces);
                textViewSignName.setText("Pisces");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Aries")
            {
                description = "You are generally brave, independent, assertive, impulsive, " +
                              "and hate to be restricted";

                imageViewSign.setImageResource(R.drawable.aries);
                textViewSignName.setText("Aries");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Taurus")
            {
                description = "You generally have good taste, are sensual, down to earth, " +
                              "and stubborn.";

                imageViewSign.setImageResource(R.drawable.taurus);
                textViewSignName.setText("Taurus");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Gemini")
            {
                description = "You are generally dynamic, have many talents, like games, " +
                              "can be two-faced, and are mischievous.";

                imageViewSign.setImageResource(R.drawable.gemini);
                textViewSignName.setText("Gemini");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Cancer")
            {
                description = "You are generally sensitive, friend-oriented, practical, " +
                              "hate to argue, and forgives but doesn't forget.";

                imageViewSign.setImageResource(R.drawable.cancer);
                textViewSignName.setText("Cancer");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Leo")
            {
                description = "You are generally creative, popular, faithful, dominating, " +
                              "and have a lot of pride.";

                imageViewSign.setImageResource(R.drawable.leo);
                textViewSignName.setText("Leo");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Virgo")
            {
                description = "You are generally successful, creative, like to please, clever, " +
                              "and can lead others easily.";

                imageViewSign.setImageResource(R.drawable.virgo);
                textViewSignName.setText("Virgo");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Libra")
            {
                description = "You generally are adventurous, like the lavish things in life, " +
                              "and are indecisive.";

                imageViewSign.setImageResource(R.drawable.libra);
                textViewSignName.setText("Libra");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Scorpio")
            {
                description = "You are generally self-reliant, powerful, wise, dominant, " +
                              "and secretive.";

                imageViewSign.setImageResource(R.drawable.scorpio);
                textViewSignName.setText("Scorpio");
                textViewDescription.setText(description);
            }
            if (astrologicalSign == "Sagittarius")
            {
                description = "You are generally open-minded, an achiever, loving, and cold.";

                imageViewSign.setImageResource(R.drawable.sagittarius);
                textViewSignName.setText("Sagittarius");
                textViewDescription.setText(description);
            }

        }

        buttonReturn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
