package tam.pa.pantaucorona.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import tam.pa.pantaucorona.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    public BookFragment() {
        // Required empty public constructor
    }
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView img_virus;
    private TextView text_desc;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book, container, false);
        init(v);
        collapsingToolbarLayout.setTitle("#DiRumahAja");
        collapsingToolbarLayout.setCollapsedTitleTextColor(getActivity().getResources().getColor(R.color.colorOrange));
        collapsingToolbarLayout.setExpandedTitleColor(getActivity().getResources().getColor(R.color.colorGray));
        img_virus.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate));
        text_desc.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        return v;
    }

    private void init(View v) {
        img_virus = v.findViewById(R.id.img_virus);
        collapsingToolbarLayout = v.findViewById(R.id.collapsingtoolbar);
        text_desc = v.findViewById(R.id.tv_desc);
    }
}
