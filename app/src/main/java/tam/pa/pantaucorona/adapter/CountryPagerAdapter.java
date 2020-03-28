package tam.pa.pantaucorona.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import tam.pa.pantaucorona.R;
import tam.pa.pantaucorona.model.DataCorona;

public class CountryPagerAdapter extends PagerAdapter {
    private Context context;
    private List<DataCorona> dataCoronas;

    public CountryPagerAdapter(Context context, List<DataCorona> dataCoronas) {
        this.context = context;
        this.dataCoronas = dataCoronas;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.cl_country,null);
        ImageView flag_id = v.findViewById(R.id.flag_id);
        TextView country_id = v.findViewById(R.id.country_id);
        TextView confirmed_id = v.findViewById(R.id.confirmed_id);

//        DataCorona data = dataCoronas.get(position);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load("https://www.countryflags.io/"+dataCoronas.get(position).getIso2()+"/shiny/64.png")
                .error(R.drawable.ic_launcher_background)
                .into(flag_id);
        confirmed_id.setText(dataCoronas.get(position).getConfirmed().toString());
        country_id.setText(dataCoronas.get(position).getCountryRegion());
        container.addView(v);

        return v;
    }

    @Override
    public int getCount() {
        return dataCoronas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
