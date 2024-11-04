package com.example.dz_8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dz_8.fragments.NameListFragment;
import com.example.dz_8.models.NameModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<NameModel> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізація даних
        initializeNameList();

        // Відображення NameListFragment при старті програми
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new NameListFragment())
                    .commit();
        }
    }

    private void initializeNameList() {
        nameList = new ArrayList<>();
        nameList.add(new NameModel("Олександр", "23 квітня", "Захисник людей, походить від давньогрецького \"Александр\", що означає захисник чоловіків."));
        nameList.add(new NameModel("Анастасія", "4 січня", "Воскресіння, жіночий варіант імені Анастасій, що означає \"воскреслий\"."));
        nameList.add(new NameModel("Марія", "21 вересня", "Госпожа, походить від давньоєврейського слова 'мірьям', що означає 'кохана', 'гіркота' або 'побожність'."));
        nameList.add(new NameModel("Дмитро", "8 листопада", "Присвячений богині Деметрі, значення імені походить від грецького \"деметріос\" - належний Деметрі, богині землі."));
        nameList.add(new NameModel("Вікторія", "7 листопада", "Перемога, жіноче ім'я латинського походження, означає 'переможниця'."));
        nameList.add(new NameModel("Максим", "19 серпня", "Найбільший, походить від латинського слова 'максимус', що означає 'найбільший'."));
        nameList.add(new NameModel("Ольга", "24 липня", "Свята, ім'я скандинавського походження, означає 'свята', 'мудра'."));
        nameList.add(new NameModel("Іван", "7 липня", "Благодать Божа, походить від єврейського 'йоханан', що означає 'Бог є милосердний'."));
        nameList.add(new NameModel("Катерина", "7 грудня", "Чиста, походить від грецького 'катхарос', що означає 'чистий', 'невинний'."));
        nameList.add(new NameModel("Михайло", "19 вересня", "Хто як Бог, походить від давньоєврейського 'Мікаель', що означає 'хто подібний до Бога'."));
        nameList.add(new NameModel("Людмила", "26 вересня", "Мила людям, походить від слов'янського кореня 'люд' та 'мила'."));
        nameList.add(new NameModel("Світлана", "2 квітня", "Світло, слов'янське ім'я, що означає 'світла', 'ясна'."));
        nameList.add(new NameModel("Тетяна", "25 січня", "Упорядниця, ім'я грецького походження, яке означає 'упорядниця', 'засновниця'."));
        nameList.add(new NameModel("Юрій", "6 травня", "Хлібороб, походить від грецького 'георгос', що означає 'хлібороб'."));
        nameList.add(new NameModel("Андрій", "13 грудня", "Мужній, походить від грецького 'андреас', що означає 'мужній'."));
    }

    public NameModel getNameModelByName(String name) {
        for (NameModel model : nameList) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
