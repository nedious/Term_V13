package com.example.termv13.UI.Term;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.termv13.R;
import com.example.termv13.entities.CourseEntity;
import com.example.termv13.entities.TermEntity;

import java.util.List;

public class ActivityTermAdapter extends RecyclerView.Adapter<ActivityTermAdapter.TermViewHolder> {

    public List<TermEntity> mTerms;
    private List<CourseEntity> mCourses;

    private final LayoutInflater mInflater;
    private final Context context;



    public ActivityTermAdapter(Context context) {
        mInflater = LayoutInflater.from(context); // inflater is used to inflate our list item layout
        this.context = context;
    }

    public class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView termItemView;
        private final TextView courseItemList;

        public TermViewHolder(@NonNull View itemView){
            super(itemView);
            termItemView = itemView.findViewById(R.id.term_item_text_view);
            courseItemList = itemView.findViewById(R.id.term_course_list);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick (View v) {
                    int position = getAdapterPosition();
                    final TermEntity currentTerm = mTerms.get(position);
                    Intent intent = new Intent(context, ActivityTermDetail.class); // go to new intent, term details activity
//                    Intent intent = new Intent(context, TermEditCourseListActivity.class); // go to new intent, term details activity

                    intent.putExtra("termID", currentTerm.getTermID());
                    intent.putExtra("termTitle", currentTerm.getTermTitle()); // could delete
//                    intent.putExtra("courseName", currentTerm.getCourseName()); // could delete
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }

    }

    @NonNull
    @Override
    public ActivityTermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ActivityTermAdapter.TermViewHolder holder, int position) {

        if(mTerms != null) {
            TermEntity currentTerm = mTerms.get(position);
            String termTitle = currentTerm.getTermTitle();

            holder.termItemView.setText((currentTerm.getTermTitle()));

//            String filteredCourseEntityList = "";
//            for(CourseEntity course: mCourses) {
//                if (course.getTermID() == currentTerm.getTermID())
//                    filteredCourseEntityList = filteredCourseEntityList + course.getCourseTitle() + "\n";
//            }
//            if (filteredCourseEntityList != "")
//                holder.courseItemList.setText(filteredCourseEntityList);
//            else
//                holder.courseItemList.setVisibility(View.GONE);

        } else {
            holder.termItemView.setText("no text");
        }
    }

    @Override
    public int getItemCount() {
        if (mTerms != null)
            return mTerms.size();
        else return 0;
    }

    public void setTerms(List<TermEntity> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }

    public void setCourses(List<CourseEntity> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }

    public TermEntity getTermAt(int position) {
        return mTerms.get(position);
    }

}















