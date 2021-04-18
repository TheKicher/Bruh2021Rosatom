package com.hfad.bruh2021rosatom.ui.fragment.response;//package com.hfad.bruh2021rosatom.ui.fragment.response;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.widget.Toolbar;
//
//import com.hfad.bruh2021rosatom.R;
//import com.hfad.bruh2021rosatom.model.ModelJob;
//import com.hfad.bruh2021rosatom.model.ModelJobResponseRequest;
//import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
//import com.hfad.bruh2021rosatom.ui.app.App;
//import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;
//
//public class CreateResponseFragment extends BaseFragment {
//
//    private static ModelJob model;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_create_response, container, false);
//
//        EditText editText = view.findViewById(R.id.letter);
//
//        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setOnMenuItemClickListener(menuItem -> {
//            ModelJobResponseRequest request = new ModelJobResponseRequest();
//            request.setUser("api/users/1");
//            request.setJob("api/jobs/" + model.getId());
//            request.setLetter(editText.getText().toString());
//            App.api.createJobResponse(request);
//            getParentFragmentManager().popBackStack();
//            return true;
//        });
//        toolbar.setNavigationOnClickListener(view1 -> {
//            getParentFragmentManager().popBackStack();
//        });
//        return view;
//    }
//
//    @Override
//    public int getStatusBarColorRes() {
//        return android.R.color.white;
//    }
//
//    @Override
//    public boolean isStatusBarLight() {
//        return true;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        ((MainActivity) getActivity()).setBottomNavigationViewVisibility(false);
//    }
//
//    public static CreateResponseFragment newInstance(ModelJob model) {
//        CreateResponseFragment.model = model;
//        return new CreateResponseFragment();
//    }
//}
