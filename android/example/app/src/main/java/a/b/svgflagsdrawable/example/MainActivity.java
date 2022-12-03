package a.b.svgflagsdrawable.example;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import a.b.svgflagsdrawable.FlagView;

public class MainActivity extends Activity {
    TextView title;
    FrameLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        root = findViewById(R.id.container);
       strategyStart();
    }


    private void strategyStart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        ListView listView = new ListView(getApplicationContext());
                        listView.setAdapter(new ExampleFlafPitoryList(getApplicationContext()));
                        root.addView(listView);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                strategyPictory((int) l);
                            }
                        });
                    }
                });
            }
        }).start();
        title.setText(R.string.app_name);



    }

    private void strategyPictory(int l) {
        title.setText(FlagView.getAliases(getApplicationContext())[l]);
        root.removeAllViews();
        FlagView flv = new FlagView(getApplicationContext());
        flv.setLoadFlag(FlagView.getValues(getApplicationContext())[l]);
        TextView view = new TextView(getApplicationContext());
        view.setBackgroundColor(getResources().getColor(R.color.purple_700));
        FrameLayout.LayoutParams  lp = new FrameLayout.LayoutParams(-2,-2);
        view.setPadding(20,20,20,20);
        lp.leftMargin = 20;
        lp.topMargin = 20;
        view.setLayoutParams(lp);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP , 20);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.removeAllViews();
                strategyStart();
            }
        });
        view.setText("Back");
        root.addView(flv);
        root.addView(view );
    }
}