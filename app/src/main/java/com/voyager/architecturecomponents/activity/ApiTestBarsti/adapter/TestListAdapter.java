package com.voyager.architecturecomponents.activity.ApiTestBarsti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.voyager.architecturecomponents.R;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestListAdapterHolder> {

    class TestListAdapterHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumbnail2;
        private final TextView tvThumbName2;

        private TestListAdapterHolder(View itemView) {
            super(itemView);
            ivThumbnail2 = itemView.findViewById(R.id.ivThumbnail2);
            tvThumbName2 = itemView.findViewById(R.id.tvThumbName2);
        }
    }

    private final LayoutInflater mInflater;
    private ArrayList<TestList> mTestList; // Cached copy of words

    public TestListAdapter(Context context,ArrayList<TestList> mTestList) {
        this.mTestList =mTestList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TestListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_items, parent, false);
        return new TestListAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TestListAdapterHolder holder, int position) {
        if (mTestList != null) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(mTestList);

            System.out.println(" -----------TestListAdapter onBindViewHolder   "+jsonString);
            TestList current = mTestList.get(position);
            holder.tvThumbName2.setText(current.getName());
            if (current.getImage_url() != null) {
                Glide.with(holder.ivThumbnail2.getContext())
                        .load(current.getImage_url())
                        .into(holder.ivThumbnail2);
            }else {

            }

        } else {
            // Covers the case of data not being ready yet.
            holder.tvThumbName2.setText("No Word");
        }
    }

    public void setTestList(ArrayList<TestList> testList){
        mTestList = testList;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTestList != null)
            return mTestList.size();
        else return 0;
    }
}