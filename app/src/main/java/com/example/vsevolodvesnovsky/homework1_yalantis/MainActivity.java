package com.example.vsevolodvesnovsky.homework1_yalantis;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

//[Comment] Images must be bigger and must be same size.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ArrayList <Uri> mUriTxt;
    private RecyclerView mRecyclerView;
    private TextView mDepartment, mIssueState, mIssueCreatedTitle, mIssueCreatedValue, mIssueRegisteredTitle;
    private TextView mIssueRegisteredValue, mIssueSolveUpTitle, mIssueSolveUpValue, mIssueResponsibleTitle;
    private TextView mIssueResponsibleValue, mIssueTextValue; //[Comment] should be local


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDepartment = (TextView) findViewById(R.id.tvDepartment);
        mIssueState = (TextView) findViewById(R.id.tvIssueState);
        mIssueCreatedTitle = (TextView) findViewById(R.id.tvIssueCreated);
        mIssueCreatedValue = (TextView) findViewById(R.id.tvIssueCreatedValue);
        mIssueRegisteredTitle = (TextView) findViewById(R.id.tvIssueRegistered);
        mIssueRegisteredValue = (TextView) findViewById(R.id.tvIssueRegisteredValue);
        mIssueSolveUpTitle = (TextView) findViewById(R.id.tvIssueSolveUp);
        mIssueSolveUpValue = (TextView) findViewById(R.id.tvIssueSolveUpValue);
        mIssueResponsibleTitle = (TextView) findViewById(R.id.tvIssueResponsible);
        mIssueResponsibleValue = (TextView) findViewById(R.id.tvIssueResponsibleValue);
        mIssueTextValue = (TextView) findViewById(R.id.tvIssueTextValue); //[Comment] findViewById(R.id.tvIssueTextValue).setOnClickListener(this)

        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        //TODO getSupportActionBar().setTitle("СЕ-1257218"); in case if we need set title by code

        mToolbar.setOnClickListener(this);
        mDepartment.setOnClickListener(this);
        mIssueState.setOnClickListener(this);
        mIssueCreatedTitle.setOnClickListener(this);
        mIssueCreatedValue.setOnClickListener(this);
        mIssueRegisteredTitle.setOnClickListener(this);
        mIssueRegisteredValue.setOnClickListener(this);
        mIssueSolveUpTitle.setOnClickListener(this);
        mIssueSolveUpValue.setOnClickListener(this);
        mIssueResponsibleTitle.setOnClickListener(this);
        mIssueResponsibleValue.setOnClickListener(this);
        mIssueTextValue.setOnClickListener(this);

        mUriTxt = new ArrayList<>();
        mUriTxt.add(Uri.parse(getBaseContext().getString(R.string.url_photoExample1)));
        mUriTxt.add(Uri.parse(getBaseContext().getString(R.string.url_photoExample2)));

        MyRecAdapter mAdapterPhoto; //[Comment] MyRecAdapter adapterPhoto = new MyRecAdapter(mUriTxt, this);
        mAdapterPhoto = new MyRecAdapter(mUriTxt, this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recView);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapterPhoto);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showNameInToast (String elementName){
        Toast.makeText(this, elementName, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        //[Comment] Formatting
        Toast.makeText(this, view.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();

    }

}

