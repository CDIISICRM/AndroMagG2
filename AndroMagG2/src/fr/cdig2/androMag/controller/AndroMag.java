package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.os.Bundle;
import fr.cdig2.androMag.R;

public class AndroMag extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
