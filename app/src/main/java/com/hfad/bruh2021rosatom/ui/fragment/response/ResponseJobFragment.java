package com.hfad.bruh2021rosatom.ui.fragment.response;//package com.hfad.bruh2021rosatom.ui.fragment.response;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.cardview.widget.CardView;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.Collections;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import com.hfad.bruh2021rosatom.R;
//import com.hfad.bruh2021rosatom.model.ModelResponseJob;
//import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
//import com.hfad.bruh2021rosatom.ui.app.App;
//import com.hfad.bruh2021rosatom.ui.fragment.main.ScrollableFragment;
//
//
//public class ResponseJobFragment extends Fragment implements ScrollableFragment {
//
//    private RecyclerView recyclerView;
//    private CardView loadingCardView;
//
//    private ResponsesAdapter responsesAdapter;
//
//    private List<ModelResponseJob.JobResponse> responses;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_job, container, false);
//
//        recyclerView = view.findViewById(R.id.recycler_view);
//
//        loadingCardView = view.findViewById(R.id.progressbar_container);
//
//        responsesAdapter = new ResponsesAdapter(Collections.EMPTY_LIST);
//        responsesAdapter.setListener(model -> {
//            ((MainActivity) getActivity()).setFragment(ResponseDetailsFragment.newInstance(model), true);
//        });
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
//        recyclerView.setAdapter(responsesAdapter);
//
//        App.api.getResponsesJob().enqueue(new Callback<ModelResponseJob>() {
//            @Override
//            public void onResponse(Call<ModelResponseJob> call, Response<ModelResponseJob> response) {
//                loadingCardView.setVisibility(View.GONE);
//                responses = response.body().getJobResponses();
//                Log.e("TAG", "onResponse: " + responses.size());
//                responsesAdapter.setItems(responses);
//            }
//
//            @Override
//            public void onFailure(Call<ModelResponseJob> call, Throwable t) {
//                Log.e("TAG", "onFailure: " ,t);
//                loadingCardView.setVisibility(View.GONE);
//
//            }
//        });
//
//        return view;
//    }
//
//
//    @Override
//    public void scrollTop() {
//        recyclerView.smoothScrollBy(0, 0);
//    }
//
//}
