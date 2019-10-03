package com.mready.presentation.screens.single_repo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mready.R;
import com.mready.models.Item;

import org.w3c.dom.Text;

public class SingleRepoActivity extends AppCompatActivity {
    public static final String REPO = "repo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_repo);
        final Item repo = getIntent().getParcelableExtra(REPO);
        TextView tvForks, tvWatchers, tvScore, tvReadme, tvTitle;
        tvForks = findViewById(R.id.forks_number);
        tvWatchers = findViewById(R.id.watchers_number);
        tvScore = findViewById(R.id.score_number);
        tvReadme = findViewById(R.id.read_me_content);
        tvTitle = findViewById(R.id.repo_title);

        tvForks.setText(String.valueOf(repo.getForks()));
        tvScore.setText(String.valueOf(repo.getScore()));
        tvWatchers.setText(String.valueOf(repo.getWatchers()));
        tvReadme.setText(String.valueOf(repo.getDescription()));
        tvTitle.setText(String.valueOf(repo.getName()));
    }

    public static Intent makeIntent(Context context, Item item) {
        Intent intent = new Intent(context, SingleRepoActivity.class);
        intent.putExtra(REPO, item);
        return intent;
    }
}
