import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class BotPhrases {

    //int counterOfMessages = 0;

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
    final Map<String, String> KEY_PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {{
        // hello
//        put("хай", "hello");
//        put("привет", "hello");
//        put("здорово", "hello");
//        put("здравствуй", "hello");
//        put("здравствуйте", "hello");
//        put("добрый день", "hello");
//        put("доброе утро", "hello");
//        put("добрый вечер", "hello");
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
        //findRouter
        put("коробочку", "findRouter");
        put("коробочка", "findRouter");
        put("коробка", "findRouter");
        put("коробку", "findRouter");
        put("оборудование", "findRouter");
        put("устройство", "findRouter");
        put("прибор", "findRouter");
        put("штуковина", "findRouter");
        // restart
        put("перезагрузить\\s.*роутер", "restart");
        put("перезагрузить", "restart");
        put("перезагрузка", "restart");
        put("ресет", "restart");
        put("reset", "restart");
        put("выключить\\s.*нажать", "restart");
        put("выключить\\s.*включить", "restart");
        put("перезагрузите\\s.*роутер", "restart");
        put("перезагрузите\\s.*его", "restart");
        //button
        put("кнопку\\s.*нажать", "button");
        put("кнопку\\s.*нажмите", "button");
        put("кнопку\\s.*сбоку", "button");
        put("кнопку\\s.*reset", "button");
        put("кнопку\\s.*ресет", "button");
        put("нажмите\\s.*кнопку", "button");
        put("нажмите\\s.*сбоку", "button");
        put("нажмите на\\s.*коробке", "button");
        put("нажмите\\s.*reset", "button");
        put("нажмите\\s.*ресет", "button");
        put("нажмите\\s.*роутере", "button");
        put("нажимайте\\s.*кнопку", "button");
        put("нажимайте\\s.*ресет", "button");
        put("нажимайте\\s.*reset", "button");
        //error
        put("какая\\s.*ошибка", "error");
        put("ошибка\\s.*какая", "error");
        put("ошибка", "error");
        put("какую\\s.*ошибку", "error");
        put("ошибку\\s.*какую", "error");
        put("ошибку", "error");
        put("ошибки", "error");
        //lamps
        put("с\\s.*лампочками", "lamps");
        put("лампочки", "lamps");
        put("лампочками", "lamps");
        put("лампочек", "lamps");
        put("огонечки", "lamps");
        put("огоньки", "lamps");
        put("индикатор", "lamps");
        //OS
        put("операционная система", "OS");
        put("система", "OS");
        put("Виндоуз", "OS");
        put("Windows", "OS");
        //computer
        put("компьютер", "computer");
        put("системник", "computer");
        put("какой\\s.*компьютер", "computer");
        put("компьютер\\s.*какой", "computer");
        //internetSettings
        put("значок интернета", "internetSettings");
        put("посмотрите\\s.*значок", "internetSettings");
        put("правом\\s.*углу", "internetSettings");
        put("значок\\s.*интернета", "internetSettings");
        put("волны\\s.*точкой", "internetSettings");
        put("волны\\s.*точечкой", "internetSettings");
        put("полосы\\s.*точкой", "internetSettings");
        put("полоски\\s.*точкой", "internetSettings");
        put("полосы\\s.*точечкой", "internetSettings");
        put("полоски\\s.*точечкой", "internetSettings");
        //browserPage
        put("не открывается сайт", "browserPage");
        put("не открывается\\s.*сайт", "browserPage");
        put("не открываются\\s.*сайты", "browserPage");
        put("открываются\\s.*сайты", "browserPage");
        put("открывается\\s.*сайт", "browserPage");
        put("открывается\\s.*яндекс", "browserPage");
        put("экране\\s.*сайт", "browserPage");
        // finish
        put("заработал?", "finish");
        put("заработал\\s.*интернет?", "finish");
        put("включился\\s.*интернет?", "finish");
        put("получилось?", "finish");
        //lastQuestions
        put("вопросы?", "lastQuestions");
        put("остались\\s.*вопросы?", "lastQuestions");
        put("остались\\s.*вопросы", "lastQuestions");
        put("есть\\s.*вопросы", "lastQuestions");
        //pishet
        put("пишет", "pishet");
        put("что\\s.*пишет", "pishet");
        //internetPayment
        put("оплата", "internetPayment");
        put("оплата\\s.*интернета", "internetPayment");
        put("оплатили\\s.*интернет", "internetPayment");
        put("оплаты\\s.*интернет", "internetPayment");
    }};
    final Map<String, String> ANSWERS_BY_KEYS = new HashMap<String, String>() {{
        //put("hello", "Здравствуйте");
        put("who", "Меня зовут Зинаида Петровна. ");
        put("name", "Зинаида");
        //put("howareyou", "Спасибо, что интересуетесь. У меня всё хорошо.");
        //put("whatdoyoudoing", "Я пробую общаться с людьми.");
        //put("whatdoyoulike", "Мне нравиться думать что я не просто программа.");
        //put("iamfeelling", "Как давно это началось? Расскажите чуть подробнее.");
        put("yes", "Поняла, уже иду, что там дальше?");
        put("no", "Ну я тогда не знаю");
        put("bye", "До свидания. Надеюсь, ещё увидимся.");
        put("connections", "Я в этом плохо разбираюсь, а как это выглядит?");
        put("router", "Роутер? А что это такое, я в этом совсем не разбираюсь?");
        put("findRouter", "Нашла в коридоре такую похожую коробку с антеннами, что мне с ней сделать?");
        put("restart", "Ой ж ты, а тут непонятно всё, огоньки мигают. Куда мне нужно нажать?");
        put("error", "Я нажимаю красную О, и у меня написано: «не удается установить соединение с удалённым сервером»");
        put("browserPage", "Ничего не открывается. Я как обычно открываю программку с красной О, а там ошибка.");
        put("lamps", "Да, тут все огоньки моргают, если честно, не понятно. Вроде, все как обычно");
        put("button", "Нажала два раза, теперь огоньки пропали и по одной начали моргать и прибавляться снова");
        put("OS", "да, компьютер на виндоус");
        put("computer", "ASUS вроде бы, на нем написано");
        put("internetSettings", "Нажала на него, там написано, подключение защищено Anna подключено, защищено и кнопка отключиться. " +
                "И такие же одинаковые внизу, только защищены и всё.");
        put("finish", "Ура! Получилось, теперь все заработало");
        put("lastQuestions", "Нет, спасибо огромное!");
        put("pishet", "Пишет, ERR_INTERNET_DISCONNECTED");
        put("internetPayment", "В аккаунт я заходила недавно и оплачивала на 2 месяца вперед");
    }};
    Pattern pattern; // for regexp
    Random random; // for random answers
    Date date; // for date and time

    public BotPhrases() {
        random = new Random();
        date = new Date();
    }
    int counterOfMessages = 0;
    public String sayInReturn(String msg) {

        String say = (msg.trim().endsWith("?")) ?
                ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];

        String message =
                String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
        for (Map.Entry<String, String> o : KEY_PATTERNS_FOR_ANALYSIS.entrySet()) {
            pattern = Pattern.compile(o.getKey());
            if (pattern.matcher(message).find()){
                counterOfMessages++;
            //if (o.getValue().equals("whattime")) return date.toString();
            return ANSWERS_BY_KEYS.get(o.getValue());
            } else if (counterOfMessages > 5){
                return "Ой, у меня все заработало почему-то! Спасибо вам большое!";
            }
        }

        return say;
    }
}
