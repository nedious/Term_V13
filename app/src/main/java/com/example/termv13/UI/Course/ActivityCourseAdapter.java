//package com.example.termv13.UI.Course;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.termv13.R;
//import com.example.termv13.entities.AssessmentEntity;
////import com.example.termv13.assessments.AssessmentEditActivity;
//
//import java.util.List;
//
//public class ActivityCourseAdapter extends RecyclerView.Adapter<ActivityCourseAdapter.AssessmentViewHolder> {
//
//    public List<AssessmentEntity> mAssessments;
//
//    private final LayoutInflater mInflater;
//    private final Context context;
//
//    public ActivityCourseAdapter(Context context) {
//        mInflater = LayoutInflater.from(context);
//        this.context = context;
//    }
//
//    class AssessmentViewHolder extends RecyclerView.ViewHolder {
//        private final TextView assessmentItemView;
//
//        private AssessmentViewHolder(View itemView){
//            super(itemView);
//            assessmentItemView = itemView.findViewById(R.id.assessment_item_text_view);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    final AssessmentEntity currentAssessment = mAssessments.get(position);
//                    Intent intent = new Intent(context, AssessmentEditActivity.class);
//                    intent.putExtra("assessmentID", currentAssessment.getAssessmentID());
//                    intent.putExtra("courseID", currentAssessment.getCourseID());
//                    intent.putExtra("termID", CourseEditAssessmentListActivity.termID);
//                    context.startActivity(intent);
//                }
//            });
//        }
//    }
//
//    @Override
//    public AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = mInflater.inflate(R.layout.assessment_list_item, parent, false);
//        return new AssessmentViewHolder(itemView);
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
//        if (mAssessments != null) {
//            final AssessmentEntity currentAssessment = mAssessments.get(position);
//            holder.assessmentItemView.setText(currentAssessment.getAssessmentTitle());
//        }
//        else {
//            holder.assessmentItemView.setText("No title");
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mAssessments != null){
//            return mAssessments.size();
//        }
//        else
//        return 0;
//    }
//
//    public void setAssessments(List<AssessmentEntity> assessments) {
//        mAssessments = assessments;
//        notifyDataSetChanged();
//    }
//
//    public AssessmentEntity getAssessmentAt(int position) {
//        return mAssessments.get(position);
//    }
//}
