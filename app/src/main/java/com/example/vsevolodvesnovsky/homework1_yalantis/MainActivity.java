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


public class MainActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewOnClickListener {

    private Toolbar mToolbar;
    private ArrayList <Uri> mUriTxt;
    private RecyclerView mRecyclerView;
    private TextView mDepartment, mIssueState, mIssueCreatedTitle, mIssueCreatedValue, mIssueRegisteredTitle;
    private TextView mIssueRegisteredValue, mIssueSolveUpTitle, mIssueSolveUpValue, mIssueResponsibleTitle;
    private TextView mIssueResponsibleValue, mIssueTextValue;


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
        mIssueTextValue = (TextView) findViewById(R.id.tvIssueTextValue);

        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        //getSupportActionBar().setTitle("СЕ-1257218"); in case if we need set title by code

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
        mUriTxt.add(Uri.parse("http://reklama-city.sk/files/sides/4963bc673810acc041181408487695fb.jpg"));
        mUriTxt.add(Uri.parse("http://kursktv.ru/sites/default/files/styles/galleryformatter_slide/public/lyuk.jpg?itok=8rhtASJb"));

        MyRecAdapter mAdapterPhoto;
        mAdapterPhoto = new MyRecAdapter(mUriTxt, this, this);

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
        String myNameElement;
        
        myNameElement = "Not coded element";

        switch(view.getId()) {
            case R.id.mToolbar:
                myNameElement = getResources().getResourceEntryName(R.id.mToolbar);
                break;

            case R.id.tvDepartment:
                myNameElement = getResources().getResourceEntryName(R.id.tvDepartment);
                break;

            case R.id.tvIssueState:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueState);
                break;

            case R.id.tvIssueCreated:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueCreated);
                break;

            case R.id.tvIssueCreatedValue:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueCreatedValue);
                break;

            case R.id.tvIssueRegistered:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueRegistered);
                break;

            case R.id.tvIssueRegisteredValue:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueRegisteredValue);
                break;

            case R.id.tvIssueSolveUp:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueSolveUp);
                break;

            case R.id.tvIssueSolveUpValue:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueSolveUpValue);
                break;

            case R.id.tvIssueResponsible:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueResponsible);
                break;

            case R.id.tvIssueResponsibleValue:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueResponsibleValue);
                break;

            case R.id.tvIssueTextValue:
                myNameElement = getResources().getResourceEntryName(R.id.tvIssueTextValue);
                break;
        }
        showNameInToast(myNameElement);
    }

    @Override
    public void onImageViewClick(String imageName) {
        Toast.makeText(this, imageName , Toast.LENGTH_LONG).show();
    }
}

