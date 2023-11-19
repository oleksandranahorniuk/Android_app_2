package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidapp.classes.Film
import com.example.androidapp.classes.Fight
import com.example.androidapp.classes.Drama
import com.example.androidapp.classes.Fantasy
import com.example.androidapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var adapter: FilmAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Film>()
        list.add(Drama("Червоне і чорне", "Роман", "У фільмі «Титанік» йшов з гавані в свій єдиний рейс корабель, зроблений з сучасним досягненням техніки. Його " +
                "вважали непотоплюваним. Велетень взяв на свій борт аристократів зі слугами, багатіїв-промисловців і бідняків-" +
                "іммігрантів. У кінокартині одночасно розвиваються дві паралельні любовні лінії. У першому класі і в третьому.", R.drawable.red_and_black))
        list.add(Fight("Злочин і покарання", "Роман", "Історія протистояння солдата Кайла Різа і кіборга-термінатора, прибулих в 1984-й рік з " +
                "пост-апокаліптичного майбутнього, де світом правлять машини-вбивці, а людство " +

                "перебуває на межі вимирання. Мета кіборга: вбити дівчину на ім'я Сара Коннор, чий ще " +
                "ненароджений син до 2029 року виграє війну людства з машинами. Мета Різа: " +
                "врятувати Сару і зупинити Термінатора будь-що.", R.drawable.crime))
        list.add(Fantasy("Чорний Ворон", "Історична повість", "Сюжет обертається довкола легендарного антигероя Чорного Адама. Провівши понад 5000 років у в'язниці, " +
                "центральний персонаж виходить на волю, щоб зіткнутися із проблемами, які приготували йому інші. Адам - справжній " +
                "ворог Шазама, відомого супергероя, з яким він бореться вже багато років. Але чи вдасться йому здійснити задумане, " +
                "передавши свої сили стародавньому чаклунові, чи він знову зазнає поразки від прихильників Ліги справедливості?",
            R.drawable.red_and_black
        ))
        list.add(Fight("Чорна рада", "Історичний роман", "Капітани зорельота Дейв і Френк отримують відповідальне завдання — дослідити " +
                "особливий район у космосі, щоби дізнатися наміри інопланетних істот, які стежать за " +
                "нашою планетою. Екіпаж корабля разом із комп’ютером ХЕЛ-9000 чекає маса " +
                "несподіванок." , R.drawable.chornaRada))

        adapter = FilmAd(){ food, position ->
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(food.name, food.description, food.image))
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

//        binding.buttonTo2.setOnClickListener{
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment("Something", "Something", 1))
//        }
    }
}
