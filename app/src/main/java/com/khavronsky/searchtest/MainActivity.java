package com.khavronsky.searchtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    //region < - F I E L D S - >
    @BindView(R.id.et)
    EditText mET;

    @BindView(R.id.rv)
    RecyclerView mRV;

    RVAdapter rvAdapter;

    List<String> dataList = new ArrayList<>();

    List<String> resultList = new ArrayList<>();
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initList();
        rvAdapter = new RVAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRV.setLayoutManager(layoutManager);
        mRV.setAdapter(rvAdapter);
        mET.addTextChangedListener(this);
    }

    private void initList() {
        dataList.add("Австралия");
        dataList.add("Китай");
        dataList.add("Япония");
        dataList.add("Испания");
        dataList.add("Монако");
        dataList.add("Канада");
        dataList.add("Австрия");
        dataList.add("Великобритания");
        dataList.add("Венгрия");
        dataList.add("Бельгия");
        dataList.add("Италия");
        dataList.add("Сингапур");
        dataList.add("Малайзия");
        dataList.add("Япония");
        dataList.add("США");
        dataList.add("Мексика");
        dataList.add("Бразилия");
        dataList.add("Абу-Даби");


    }

    void search(CharSequence s) {
        resultList = new ArrayList<>(dataList);
        for (String str :
                dataList) {
            String str2 = str.toLowerCase();
            String s2 = String.valueOf(s).toLowerCase();
            if (!str2.contains(s2)) {
                resultList.remove(str);
            }
        }
        rvAdapter.setList(resultList);
    }

    //region < - TextWatcher IMPLEMENTATION - >
    @Override
    public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

    }

    @Override
    public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
        search(s);
    }

    @Override
    public void afterTextChanged(final Editable s) {

    }
    //endregion
}