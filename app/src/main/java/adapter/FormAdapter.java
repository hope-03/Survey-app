package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.form.R;

import java.util.ArrayList;

import model.Form;

public class FormAdapter extends RecyclerView.Adapter<FormViewHolder>{

    ArrayList<Form> forms;
    Context ctx;
    private OnClickListener onClickListener;
    public FormAdapter(Context ctx, ArrayList<Form> forms) {
        this.ctx = ctx;
        this.forms = forms;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View listItem = inflater.inflate(R.layout.list_item,parent,false);
        return new FormViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        Form form = forms.get(position);
        holder.road.setText(forms.get(position).getRoad());
        holder.link.setText(forms.get(position).getLink());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(position,form);
            }
        });
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Form model);
    }
    @Override
    public int getItemCount() {
        return forms.size();
    }
}

class FormViewHolder extends RecyclerView.ViewHolder{

    public TextView road,link;
    public FormViewHolder(@NonNull View itemView) {
        super(itemView);

        this.road = itemView.findViewById(R.id.formRoad);
        this.link = itemView.findViewById(R.id.formLink);
    }
}