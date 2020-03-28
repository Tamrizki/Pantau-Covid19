package tam.pa.pantaucorona.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tam.pa.pantaucorona.R;
import tam.pa.pantaucorona.adapter.LocalAdapter;
import tam.pa.pantaucorona.api.ApiCorona;
import tam.pa.pantaucorona.model.Attributes;
import tam.pa.pantaucorona.model.DataCoronaLocal;

public class LocalFragment extends Fragment {

    public LocalFragment() {
        // Required empty public constructor
    }
    ProgressDialog progressDoalog;
    private List<Attributes> attributesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LocalAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_local, container, false);
        init(v);
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Memuat data...");
        progressDoalog.show();
        Retrofit retrofit = new retrofit2.Retrofit
                .Builder()
                .baseUrl(ApiCorona.URL_LOCAL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiCorona apiCorona = retrofit.create(ApiCorona.class);
        Call<List<DataCoronaLocal>> call =apiCorona.local();
        GetAPI(call);

        return v;
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
    }

    private void GetAPI(Call<List<DataCoronaLocal>> call) {
        call.enqueue(new Callback<List<DataCoronaLocal>>() {
            @Override
            public void onResponse(Call<List<DataCoronaLocal>> call, Response<List<DataCoronaLocal>> response) {
                progressDoalog.dismiss();
                Log.d("asda", "panjang = "+response.body().get(1).getAttributes());
                getArray(response.body());
            }

            @Override
            public void onFailure(Call<List<DataCoronaLocal>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d("asda", "gagal");
            }
        });
    }

    private void getArray(List<DataCoronaLocal> body) {
        for (int i = 0; i < body.size() ; i++) {
            attributesList.add(new Attributes(body.get(i).getAttributes().getFID(),
                    body.get(i).getAttributes().getKodeProvi(),
                    body.get(i).getAttributes().getProvinsi(),
                    body.get(i).getAttributes().getKasusPosi(),
                    body.get(i).getAttributes().getKasusSemb(),
                    body.get(i).getAttributes().getKasusMeni()));
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LocalAdapter(getActivity(), attributesList);
        recyclerView.setAdapter(adapter);
    }
}
