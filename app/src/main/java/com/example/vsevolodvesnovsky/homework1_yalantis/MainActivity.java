package com.example.vsevolodvesnovsky.homework1_yalantis;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar;
        ArrayList <Uri> uriTxt;
        RecyclerView recyclerView;

        findViewById(R.id.tvDepartment).setOnClickListener(this);
        findViewById(R.id.tvIssueState).setOnClickListener(this);
        findViewById(R.id.tvIssueCreated).setOnClickListener(this);
        findViewById(R.id.tvIssueCreatedValue).setOnClickListener(this);
        findViewById(R.id.tvIssueRegistered).setOnClickListener(this);
        findViewById(R.id.tvIssueRegisteredValue).setOnClickListener(this);
        findViewById(R.id.tvIssueSolveUp).setOnClickListener(this);
        findViewById(R.id.tvIssueSolveUpValue).setOnClickListener(this);
        findViewById(R.id.tvIssueResponsible).setOnClickListener(this);
        findViewById(R.id.tvIssueResponsibleValue).setOnClickListener(this);
        findViewById(R.id.tvIssueTextValue).setOnClickListener(this);

        toolBar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        //TODO getSupportActionBar().setTitle("СЕ-1257218"); in case if we need set title by code

        toolBar.setOnClickListener(this);

        uriTxt = new ArrayList<>();
        uriTxt.add(Uri.parse(getBaseContext().getString(R.string.url_photoExample1)));
        uriTxt.add(Uri.parse(getBaseContext().getString(R.string.url_photoExample2)));

        MyRecAdapter mAdapterPhoto = new MyRecAdapter(uriTxt, this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = (RecyclerView) findViewById(R.id.recView);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapterPhoto);

        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this, view.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();

    }
}

