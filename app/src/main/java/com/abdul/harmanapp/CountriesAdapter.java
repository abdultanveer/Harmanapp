package com.abdul.harmanapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesVH> {//4

    public  static  String TAG = CountriesAdapter.class.getSimpleName();
    String[] mCountries;//8
    public CountriesAdapter(String[] countries) {
        mCountries = countries;//8a
    }

    @NonNull
    @Override
    public CountriesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//6
        Log.i(TAG,"aamir ahmed is buying a  row plank from market");//9
        View row_plank = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);//10
        return new CountriesVH(row_plank); //aamir is giving the newly bought plank to ameen //10a
    }

    @Override
    public int getItemCount() {//6
        Log.i(TAG,"abhijeet counting the no of items in the data");//9

        return mCountries.length;//11
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesVH holder, int position) {//6
        Log.i(TAG,"akshat jain is writing on a row plank");//9
        holder.tvRow.setText(mCountries[position]);//13


    }

    //this is the box holding the planks -- ameen patel
    class CountriesVH extends RecyclerView.ViewHolder {//5
        TextView tvRow;//12

        public CountriesVH(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG,"ameen receive a row plank in box");//9
            tvRow = itemView.findViewById(R.id.tvRow);//12a
        }
    }
}
