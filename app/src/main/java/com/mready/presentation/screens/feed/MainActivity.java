package com.mready.presentation.screens.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.mready.R;
import com.mready.models.Item;
import com.mready.models.PublicRepositories;
import com.mready.presentation.screens.feed.MainContract;
import com.mready.presentation.screens.feed.MainPresenter;
import com.mready.presentation.screens.feed.OnRepoClickListener;
import com.mready.presentation.screens.feed.RepoAdapter;
import com.mready.presentation.screens.single_repo.SingleRepoActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnRepoClickListener {

    private RecyclerView rvRepos;
    private RepoAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRepos = findViewById(R.id.rvRepos);
        adapter = new RepoAdapter(this);
        presenter = new MainPresenter(this);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        presenter.getRepos();
    }

    @Override
    public void onRepoClick(Item item) {
        startActivity(SingleRepoActivity.makeIntent(this, item));

    }

    @Override
    public void showRepos(PublicRepositories result) {
        adapter.setItems(result.getItems());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
