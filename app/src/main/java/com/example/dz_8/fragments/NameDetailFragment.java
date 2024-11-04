package com.example.dz_8.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dz_8.MainActivity;
import com.example.dz_8.R;
import com.example.dz_8.models.NameModel;

public class NameDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_detail, container, false);

        TextView nameTextView = view.findViewById(R.id.name_text_view);
        TextView dateTextView = view.findViewById(R.id.date_text_view);
        TextView meaningTextView = view.findViewById(R.id.meaning_text_view);

        Button backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Повернення на попередній фрагмент
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Отримуємо ім'я з аргументів
        String name = getArguments().getString("name");

        // Отримуємо модель імені з MainActivity
        MainActivity activity = (MainActivity) getActivity();
        NameModel model = activity.getNameModelByName(name);

        if (model != null) {
            nameTextView.setText(model.getName());
            dateTextView.setText("Іменини: " + model.getDate());
            meaningTextView.setText("Значення: " + model.getMeaning());
        }

        return view;
    }
}
