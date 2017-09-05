package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);

        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currWord = getItem(position);

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.tv_miwok_word);
        miwokTranslation.setText(currWord.getMiwokTranslation());

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.tv_default_word);
        defaultTranslation.setText(currWord.getDefaultTranslation());

        ImageView wordImage = (ImageView) listItemView.findViewById(R.id.img_layout_word);
        if (currWord.hasImage()) {
            wordImage.setImageResource(currWord.getImageResourceId());
            wordImage.setVisibility(View.VISIBLE);
        } else {
            wordImage.setVisibility(View.GONE);
        }

        View wordsLayout = listItemView.findViewById(R.id.ll_layout_text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        wordsLayout.setBackgroundColor(color);

        return listItemView;
    }
}
