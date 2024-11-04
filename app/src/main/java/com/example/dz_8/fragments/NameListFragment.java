package com.example.dz_8.fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dz_8.MainActivity;
import com.example.dz_8.R;
import com.example.dz_8.models.NameModel;

import java.util.ArrayList;
import java.util.List;

public class NameListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_list, container, false);

        GridView gridView = view.findViewById(R.id.name_grid_view);

        // Отримуємо список імен
        MainActivity activity = (MainActivity) getActivity();
        List<String> names = new ArrayList<>();
        for (NameModel model : activity.nameList) {
            names.add(model.getName());
        }

        // Заповнюємо GridView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, names);
        gridView.setAdapter(adapter);

        // Обробник кліку на ім'я
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names.get(position);

                // Передаємо ім'я в NameDetailFragment
                Bundle bundle = new Bundle();
                bundle.putString("name", selectedName);

                NameDetailFragment detailFragment = new NameDetailFragment();
                detailFragment.setArguments(bundle);

                // Замінюємо фрагмент
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
