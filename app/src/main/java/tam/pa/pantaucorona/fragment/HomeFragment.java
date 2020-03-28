package tam.pa.pantaucorona.fragment;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tam.pa.pantaucorona.R;
import tam.pa.pantaucorona.adapter.CountryPagerAdapter;
import tam.pa.pantaucorona.anim.DepthTransformation;
import tam.pa.pantaucorona.api.ApiClient;
import tam.pa.pantaucorona.api.ApiCorona;
import tam.pa.pantaucorona.model.DataCorona;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    ProgressDialog progressDoalog;
    private List<DataCorona> listCountries = new ArrayList<>();
    private Calendar calendar;
    private TextView month_day_id,
            years_id,
            tv_active,
            tv_recovered,
            tv_deaths;
    private String sMonth ;
    private ViewPager viewPager;
    private int years, month, day;
    private DepthTransformation depthTransformation = new DepthTransformation();
    private RelativeLayout list_active, list_deaths, list_recovered;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        listDisable();
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Memuat data...");
        progressDoalog.show();

        getDate();
        SetMonth(month);
        month_day_id.setText(String.valueOf(day)+" "+sMonth);
        years_id.setText(String.valueOf(years));

        ApiCorona apiCorona = ApiClient.getRetrofit().create(ApiCorona.class);
        Call<List<DataCorona>> call =apiCorona.view();
        GetAPI(call);
        viewPager.setPageTransformer(true, depthTransformation);
        viewPager.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.arrow));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                tv_deaths.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.button_animation));
                tv_recovered.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.button_animation));
                tv_active.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.button_animation));

                list_active.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.list_active));
                list_recovered.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.list_recovered));
                list_deaths.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.list_deaths));

                tv_active.setText(listCountries.get(position).getActive().toString());
                tv_recovered.setText(listCountries.get(position).getRecovered().toString());
                tv_deaths.setText(listCountries.get(position).getDeaths().toString());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void listDisable() {
        list_recovered.setVisibility(View.GONE);
        list_deaths.setVisibility(View.GONE);
        list_active.setVisibility(View.GONE);
    }

    private void GetAPI(Call<List<DataCorona>> call) {
        call.enqueue(new Callback<List<DataCorona>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NotNull Call<List<DataCorona>> call, @NotNull Response<List<DataCorona>> response) {
                progressDoalog.dismiss();
                listVisible();
                getDataList(response.body());
                if (response.body()!=null){
                    tv_active.setText(response.body().get(0).getActive().toString());
                    tv_recovered.setText(response.body().get(0).getRecovered().toString());
                    tv_deaths.setText(response.body().get(0).getDeaths().toString());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<DataCorona>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void listVisible() {
        list_recovered.setVisibility(View.VISIBLE);
        list_deaths.setVisibility(View.VISIBLE);
        list_active.setVisibility(View.VISIBLE);
    }

    private void getDataList(List<DataCorona>dataCoronaList) {
        CountryPagerAdapter adapter = new CountryPagerAdapter(getActivity(), dataCoronaList);
        listCountries = dataCoronaList;
        viewPager.setAdapter(adapter);
    }

    private void getDate() {
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        years = calendar.get(Calendar.YEAR);
    }

    private void SetMonth(int month) {
        switch (month){
            case 0:
                sMonth = "January";
                break;
            case 1:
                sMonth = "February";
                break;
            case 2:
                sMonth = "March";
                break;
            case 3:
                sMonth = "April";
                break;
            case 4:
                sMonth = "May";
                break;
            case 5:
                sMonth = "June";
                break;
            case 6:
                sMonth = "July";
                break;
            case 7:
                sMonth = "August";
                break;
            case 8:
                sMonth = "September";
                break;
            case 9:
                sMonth = "October";
                break;
            case 10:
                sMonth = "November";
                break;
            case 11:
                sMonth = "December";
                break;
        }
    }

    private void init(View view) {
        years_id = view.findViewById(R.id.years_id);
        month_day_id = view.findViewById(R.id.month_day_id);
        viewPager = view.findViewById(R.id.viewPager);
        tv_active = view.findViewById(R.id.tv_active_number);
        tv_recovered = view.findViewById(R.id.tv_recovered_number);
        tv_deaths = view.findViewById(R.id.tv_deaths_number);
        list_active = view.findViewById(R.id.list_active);
        list_recovered = view.findViewById(R.id.list_recovered);
        list_deaths = view.findViewById(R.id.list_deaths);
    }
}
