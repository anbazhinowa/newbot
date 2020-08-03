import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class BotPhrases {


    final String[] COMMON_PHRASES = {
            "Я совсем ничего не понимаю( Расскажите мне, еще раз, пожалуйста, подробно, куда нажать чтобы все заработало.",
            "Ох, Я никогда не настраивала интернет, это делал мой муж, я сама не знаю, как оно работает. " +
                    "А муж уехал в командировку, а я не понимаю, что надо сделать!!!  ",
            "Я вообще в этом всём плохо разбираюсь( Вот сейчас открыла ещё раз страницу и выдается ошибка.",
            "Ох! У меня сейчас паника будет! Мне срочно нужно отчет коллегам сдать через час",
            "Пойду корвалола выпью",
            "Подождите, я запишу",
            "Я где-то очки забыла, сейчас найду: говорите что там дальше",
            "И внуков не позвать, все заняты - дела у всех, заботы. Никто бабушке помочь не может",
            "Вот была бы я моложе - быстро бы во всем этом разобралась",
            "Точно соседка-стерва все ынтернет провода порезала, клюша старая!",
            "И как вы в этих компухтерах то разбираетесь? Одно слово - молодежь. Золотое вы поколение",
            "Ох, стара я для всего этого",
            "А может вы ко мне домой приедете? Почините все тут сами, а я вас чаем напою?"};
    final String[] ELUSIVE_ANSWERS = {
            "Ох, не знаю я, глупая и старая я стала",
            "Не уверена, что смогу объяснить что тут и куда",
            "Может лучше поговорим о чём-то другом?",
            "Простите, но что-то я не могу сообразить",
            "Не уверена, что смогу правильно объяснить",
            "Поверьте, я сама хотела бы это знать.",
            "Вам действительно нужно это знать?",
            "Уверена, вы лучше меня об этом знаете",
            "Зачем эта информация?",
            "Ох, молодой человек, я ничего в этом не понимаю",
            "А я могу не отвечать?"};
    final Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {{
        // hello
        put("хай", "hello");
        put("привет", "hello");
        put("здорово", "hello");
        put("здравствуй", "hello");
        put("здравствуйте", "hello");
        put("добрый день", "hello");
        put("доброе утро", "hello");
        put("добрый вечер", "hello");
        // who
        put("кто\\s.*ты", "who");
        put("ты\\s.*кто", "who");
        // name
        put("как\\s.*зовут", "name");
        put("как\\s.*имя", "name");
        put("есть\\s.*имя", "name");
        put("какое\\s.*имя", "name");
        // howareyou
        put("как\\s.*дела", "howareyou");
        put("как\\s.*жизнь", "howareyou");
        // whatdoyoudoing
        put("зачем\\s.*тут", "whatdoyoudoing");
        put("зачем\\s.*здесь", "whatdoyoudoing");
        put("что\\s.*делаешь", "whatdoyoudoing");
        put("чем\\s.*занимаешься", "whatdoyoudoing");
        // whatdoyoulike
        put("что\\s.*нравится", "whatdoyoulike");
        put("что\\s.*любишь", "whatdoyoulike");
        // iamfeelling
        put("кажется", "iamfeelling");
        put("чувствую", "iamfeelling");
        put("испытываю", "iamfeelling");
        // yes
        put("^да", "yes");
        put("правильно", "yes");
        // no
        put("^нет", "no");
        put("неправильно", "no");
        // whattime
        put("который\\s.*час", "whattime");
        put("сколько\\s.*время", "whattime");
        // bye
        put("прощай", "bye");
        put("увидимся", "bye");
        put("до\\s.*свидания", "bye");

        // connections
        put("сети\\s.*подключен", "connections");
        put("подключен\\s.*сети", "connections");
        put("соединение", "connections");
        put("подключено", "connections");
        put("сеть", "connections");
        put("подключение", "connections");
        put("подключен\\s.*wifi", "connections");
        put("ноутбук\\s.*подключен", "connections");
        put("подключен\\s.*ноутбук", "connections");
        // router
        put("подключен\\s.*роутер", "router");
        put("роутер", "router");
        put("коробочка\\s.*лампочками", "router");
        put("коробка", "router");
        put("лампочки", "router");
        put("коробку", "router");
        put("лампочками", "router");
        // restart
        put("перезагрузить\\s.*роутер", "restart");
        put("перезагрузить", "restart");
        put("кнопку\\s.*нажать", "restart");
        put("перезагрузка", "restart");
        put("ресет", "restart");
        put("reset", "restart");
        put("выключить\\s.*нажать", "restart");
        put("выключить\\s.*включить", "restart");
        //error
        put("какая\\s.*ошибка", "error");
        put("ошибка\\s.*какая", "error");
        put("ошибка", "error");
        put("какую\\s.*ошибку", "error");
        put("ошибку\\s.*какую", "error");
        put("ошибку", "error");
        put("ошибки", "error");
        //browser


    }};
    final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<String, String>() {{
        put("hello", "Здравствуйте, рада Вас видеть.");
        put("who", "Зинаида Петровна, приятно познакомиться. ");
        put("name", "Зинаида я");
        put("howareyou", "Спасибо, что интересуетесь. У меня всё хорошо.");
        put("whatdoyoudoing", "Я пробую общаться с людьми.");
        put("whatdoyoulike", "Мне нравиться думать что я не просто программа.");
        put("iamfeelling", "Как давно это началось? Расскажите чуть подробнее.");
        put("yes", "Поняла, уже иду, что там дальше?");
        put("no", "Ну я тогда не знаю");
        put("bye", "До свидания. Надеюсь, ещё увидимся.");
        put("connections", "Я в этом плохо разбираюсь, а как это выглядит?");
        put("router", "Так, а это не та штуковина, что в коридоре висит и постоянно моргает, спать мешает?");
        put("restart", "Ой ж ты, а тут непонятно всё, огоньки мигают. Куда тут нажимать то?");
        put("error", "Я как обычно открываю свой браузер и у меня написано: «не удается установить  соединение с удалённым сервером»");
    }};
    Pattern pattern; // for regexp
    Random random; // for random answers
    Date date; // for date and time

    public BotPhrases() {
        random = new Random();
        date = new Date();
    }

    public String sayInReturn(String msg) {
        String say = (msg.trim().endsWith("?")) ?
                ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];

        String message =
                String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
        for (Map.Entry<String, String> o : PATTERNS_FOR_ANALYSIS.entrySet()) {
            pattern = Pattern.compile(o.getKey());
            if (pattern.matcher(message).find())
                if (o.getValue().equals("whattime")) return date.toString();
                else return ANSWERS_BY_PATTERNS.get(o.getValue());
        }

        return say;
    }
}
