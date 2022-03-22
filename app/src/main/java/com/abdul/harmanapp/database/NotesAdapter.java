package com.abdul.harmanapp.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdul.harmanapp.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    NotesDao mNotesDao;

    public NotesAdapter(NotesDao notesDao) {
        mNotesDao = notesDao;

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eachNoteRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_row,parent,false);
        return new NoteViewHolder(eachNoteRow);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.tvTitle.setText(mNotesDao.getRow(position)[0]);
        holder.tvSubTitle.setText(mNotesDao.getRow(position)[1]);


    }

    @Override
    public int getItemCount() {
        return mNotesDao.getNoRows();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvSubTitle;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubTitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }
}
