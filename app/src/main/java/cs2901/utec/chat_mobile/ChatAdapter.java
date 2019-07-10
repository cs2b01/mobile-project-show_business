package cs2901.utec.chat_mobile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    public JSONArray elements;
    private Context context;


    public ChatAdapter(JSONArray elements, Context context){
        this.elements = elements;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_line;
        TextView second_line;
        TextView third_line;
        TextView fourth_line;
        RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            first_line = itemView.findViewById(R.id.element_view_first_line);
            second_line = itemView.findViewById(R.id.element_view_second_line);
            third_line = itemView.findViewById(R.id.element_view_third_line);
            fourth_line = itemView.findViewById(R.id.element_view_fourth_line);
            container = itemView.findViewById(R.id.element_view_container);
        }
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        try {
            JSONObject element = elements.getJSONObject(position);

            final String bussiness_name = element.getString("bussiness_name");
            final String bussiness_description = element.getString("bussiness_description");
            final String bussiness_email = element.getString("bussiness_email");
            final String bussiness_number = element.getString("bussiness_number");
            holder.first_line.setText(bussiness_name);
            holder.second_line.setText(bussiness_description);
            holder.third_line.setText(bussiness_email);
            holder.fourth_line.setText(bussiness_number);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return elements.length();
    }
}