package org.skypro.service;

import org.skypro.questions.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random randomQuestion = new Random();


    public JavaQuestionService() {
        questions.add(new Question("Логический тип переменных (boolean)", "Тип, в котором хранится информация в формате true/false (т. е. «истина/ложь»)."));
        questions.add(new Question("Цикл это?", "Конструкция языка, которая позволяет выполнять код многократно в зависимости от условий."));
        questions.add(new Question("Что выполняет оператор break ?", "Прерывает цикл в любой момент и не зависимо от условий."));
        questions.add(new Question("Массив это?", "Структура данных, которая позволяет хранить несколько значений одного типа."));
        questions.add(new Question("Почему нельзя сравнивать массивы через равенство ==", "Массивы являются объектами, поэтому сравнивать их через знак равенства нельзя."));
        questions.add(new Question("Метод это?", "Это именованные блоки кода, которые принадлежат определенным сущностям (обычно объектам) и выполняют с ними какие-то действия."));
        questions.add(new Question("Инкапсуляция это?", "Концепция, согласно которой мы не даем доступ к свойствам объекта, а получаем их значения через методы."));
        questions.add(new Question("Модификатор final?", "Модификатор, который позволяет объявлять константные поля в классе."));
        questions.add(new Question("Что такое OutOfMemoryError?", "Ошибка времени выполнения в языке программирования Java, которая возникает, когда виртуальная машина Java (JVM) не может выделить память для создания новых объектов, поскольку пространство кучи заполнено и больше нет места для хранения новых объектов."));
        questions.add(new Question("Класс это?", "Шаблон, определяющий состояние и поведение объектов. Он содержит переменные экземпляра (состояние) и методы (поведение), которые определяют, что объекты могут делать."));
        questions.add(new Question("Объект это?", "Это экземпляр класса. Когда вы создаете объект, он получает свою собственную копию переменных экземпляра класса."));
        questions.add(new Question("когда используется ключевое слово `this`?", "Оно используется для ссылки на текущий объект внутри класса."));
        questions.add(new Question("Модификаторы доступа это?", "Это ключевые слова, которые определяют уровень доступа к классам, переменным и методам."));
    }

    @Override
    public Question add(String question, String answer) {
        Question w = new Question(question, answer);
        questions.add(w);
        return w;
    }

    @Override
    public Question remove(String question, String answer) {
        Question w = new Question(question, answer);
        if (!questions.remove(w)) {
            throw new NoSuchElementException("Вопрос не найден.");
        }
        return w;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) throw new IllegalStateException();
        List<Question> list = new ArrayList<>(questions);
        return list.get(randomQuestion.nextInt(list.size()));
    }
}
