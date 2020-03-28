package tam.pa.pantaucorona.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tam.pa.pantaucorona.R;
import tam.pa.pantaucorona.model.Attributes;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.viewHolder> {
    private Context context;
    private List<Attributes> attributesList;

    public LocalAdapter(Context context, List<Attributes> attributesList) {
        this.context = context;
        this.attributesList = attributesList;
    }

    @NonNull
    @Override
    public LocalAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cl_info_prof, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalAdapter.viewHolder holder, int position) {
        Attributes data = attributesList.get(position);
        holder.tv_provinsi.setText(data.getProvinsi());
        holder.tv_positif.setText(data.getKasusPosi().toString());
        holder.tv_sembuh.setText(data.getKasusSemb().toString());
        holder.tv_meninggal.setText(data.getKasusMeni().toString());
    }

    @Override
    public int getItemCount() {
        return attributesList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView tv_provinsi,
                tv_positif,
                tv_sembuh,
                tv_meninggal;
        private View v;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            tv_provinsi = v.findViewById(R.id.tv_provinsi);
            tv_positif = v.findViewById(R.id.tv_positif);
            tv_sembuh = v.findViewById(R.id.tv_sembuh);
            tv_meninggal = v.findViewById(R.id.tv_meninggal);
        }
    }
}
