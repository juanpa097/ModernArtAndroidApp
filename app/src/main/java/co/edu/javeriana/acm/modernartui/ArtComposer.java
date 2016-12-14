package co.edu.javeriana.acm.modernartui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ArtComposer extends AppCompatActivity {

    private static final String TAG = "Debug";
    private SeekBar mColorBar;

    private RectangleOneFragment mArtFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_composer);

        userInterfaceSetUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("TAG", item.toString());
        Log.d("TAG", "ENTER");
        AlertDialog.Builder alert = new AlertDialog.Builder(ArtComposer.this);
        alert.setTitle("Inspired by the works of Modern Art masters such as Piet Mondrian and Ben Nicholson");
        alert.setMessage("Click below to learn more!");
        alert.setPositiveButton("Visit MoMa!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String url = "https://www.moma.org/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        alert.setNegativeButton("Not Now",null);
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
        return true;
    }

    private void userInterfaceSetUp() {
        findViewById(R.id.activity_art_composer).getRootView().setBackgroundColor(Color.BLACK);
        mColorBar = (SeekBar) findViewById(R.id.colorBar);
        mArtFragment = (RectangleOneFragment) findViewById(R.id.art_fragment);
        mColorBar.setOnSeekBarChangeListener(mArtFragment.getInstaceOfCollorController());
    }




}
