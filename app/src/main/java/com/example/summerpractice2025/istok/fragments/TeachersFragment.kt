package com.example.summerpractice2025.istok.fragments

import Teacher
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice2025.istok.R
import com.example.summerpractice2025.istok.adapters.TeachersAdapter
import com.example.summerpractice2025.istok.databinding.FragmentTeachersBinding

class TeachersFragment : Fragment() {
    private var _binding: FragmentTeachersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeachersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teachers = listOf(
            Teacher(
                "Арсланов Марат Мирзаевич",
                R.drawable.arslanov,
                "Арсик/Арс - лектор по алгему, главный босс первого курса. Грозный дед, но добрый (на лекциях). Когда заходит в аудиторию, надо встать. Хорошо преподаёт, но также хорошо и требует на экзамене, но если подготовитесь, то точно сдадите. На лекции нужно ходить, т.к всегда отмечает посещаемость.",
                "Экзамен: На экзамен заходите по восемь человек. На расписывание билета даётся ≈ 1.5 часа. Дальше он вызывает к себе людей по порядку захода(первый зашел-первый сдаешь).\n" +
                        "На экзамене лучше с ним не спорить(спорить можно только в случае, когда он допустил явную ошибку при решении вашей практики), скорее всего разозлится."),
            Teacher(
                "Калимуллин Искандер Шагитович",
                R.drawable.kalik,
                "Калик - лектор по дискре, душный моментами, любит курить и курить. К счастью, будет преподавать только в первом семестре. На лекциях не отмечает.",
                "Зачёт: Ближе к концу семестра вы будете писать коллоквиум - чисто написание теории по одной из тем, пройденных к новому году.\n" +
                        "Сдавать ему вы будете (скорее всего) только зачёт. Людей с большими баллами за коллоквиум он не опрашивает, только смотрит написанное.\n"
            ),
            Teacher(
                "Широкова Елена Александровна",
                R.drawable.shirokova,
                "Широкова - добрая женщина, на экзамене при большом желании можно списать, лекции скидывает в электронном формате, но понимают их единицы. На лекциях не отмечает.",
                "Экзамен:" +
                        "На экзамене собирает телефоны и кладет их на первую парту.\n" +
                        "Если на экзамене Широкова отобрала у вас второй телефон - не отчаивайтесь. Она просто положит его на парту со всеми телефонами, работу не заберет.\n" +
                        "После написания экзамена вы будете ждать ≈ 1 час в коридоре. В это время она проверяет ваши работы. После оглашает ваши результаты. Тех, чьи фамилии она не назвала, она приглашает в кабинет, чтобы задавать вопросы по билету.\n"
            ),
            Teacher(
                "Корнеева Наталья Николевна",
                R.drawable.korneeva,
                "Корнеева/Дискреева/Коноплеева - лектор по дискретной математике во втором семестре и практик у многих групп в 1 семестре. Очень добра как на лекциях/практиках, так и на экзамене. На экзамене задает много вопросов с целью поднять балл (то есть бояться вопросов не стоит). На лекции лучше ходить, т.к отмечает.",
                "Экзамен: очень схож с экзаменом у Арсланова (мехматовская школа). Заходите восьмерками, на расписывание дается 1.5 часа. Дальше каждый человек подходит к ней и рассказывает билет, отвечает на её вопросы.\n"
            ),
            Teacher(
                "Абрамский Михаил Михайлович",
                R.drawable.abr,
                "Абр - директор ИТИС и лектор по информатике у Джава потока. На лекциях его интересно слушать, но бывает иногда с ничего зол(будет чем-то грозить, но в итоге ничего страшного не произойдет). Обычно на лекциях не отмечает, но бывают исключения (если людей совсем мало).",
                "Экзамен: на экзамене добрейший человек. Очень лояльно проверяет теорию и еще более лояльно проверяет практику на листочках. \n" +
                        "Во втором семестре ваш практик по проге должен будет назвать Абрамскому 6 лучших студентов(по мнению практика). Первым трём на экзамене автоматически засчитываются два любых задания из тестовой части. Второй тройке засчитывает одно задание из теста.\n"),
            Teacher(
                "Хадиев Камиль Равилевич",
                R.drawable.hadiev,
                "Хадиев - лектор по предмету “Алгоритмы и структуры данных”. Вы его встретите впервые только во втором семестре. Спокойный препод, любит вставлять в презентации отсылки из фильмов. На лекциях не отмечает. Требует знание его ФИО",
                "Зачёт: " +
                        "на зачёте вы получаете рандомный билет с двумя задачами. На решение задач отводится 40 минут. Вы можете пользоваться ноутбуком. По прошествии 40 минут вызывает по очереди одного человека для проверки билета (очередь формируется по баллам за семестр).\n"
            )
        )

        binding.teachersRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.teachersRecyclerView.adapter = TeachersAdapter(teachers) { teacher ->
            val detailFragment = TeacherDetailFragment.newInstance(teacher)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.teachersRecyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}