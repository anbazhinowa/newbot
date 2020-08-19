
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Bot extends TelegramLongPollingBot {

    public static final String BOT_NAME = "";
    public static final String BOT_TOKEN = "";
    BotPhrases bot;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
    Map<Integer, String> names = new HashMap<>();

    public Bot() {
        bot = new BotPhrases();
    }

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void setButtons(SendMessage sendMessage) {
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRowFirst = new KeyboardRow();
        keyboardRowFirst.add(new KeyboardButton("СТАРТ"));

        keyboardRowList.add(keyboardRowFirst);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        // Тут будет то, что выполняется при получении сообщения
        Integer senderID = update.getMessage().getFrom().getId();
        Message msg = update.getMessage(); // Извлекаем текст сообщения из апдейта
        String text = msg.getText();

        if (msg.hasText() && text.trim().length() > 0) {
            try {
                if (text.equals("/start")) {
                    sendMsg(msg, "Привет! \n" + "\n" + "Давай немного расскажу про нас. Поддержка перешла на общение в чатике. " +
                            "Именно поэтому я решила пообщаться с кандидатами в телеграме. Очень важно отвечать быстро, " +
                            "очень грамотно и давать правильную консультацию. Ещё нам очень важно чувство стиля в переписке. " +
                            "Не шаблонные ответы, а с душой. \n" +
                            "\n" +
                            "Правила игры\n" +
                            "\n" +
                            "Предлагаю выбрать любую тему, например: не работает интернет. Представим, что я пользователь, " +
                            "который пишет тебе в чате, а ты попробуешь меня проконсультировать, от лица поддержки провайдера.\n" +
                            "\n" +
                            "Нажми на кнопку СТАРТ и мы начнём");
                }
                else if (text.equals("СТАРТ")) {
                    sendMsg(msg, "Здравствуйте!\n" +
                            "\n" +
                            "Спасите, я пришла домой, а на ноутбуке не работает вайфай! Что мне делать??");
                    //replyKeyboardRemove.getRemoveKeyboard();
                } else {
                    sendMsg(msg, bot.sayInReturn(text));

                    //replyKeyboardRemove.getRemoveKeyboard();
                    //bot.sayInReturn(text);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        //message.setText("");
        //msg.requestFocusInWindow();

//            switch (msg.getText()){
//                case "/setname":
//                    sendMsg(msg, "Представьтесь, пожалуйста");
//                    break;
//
//                case "/next":
//                    sendMsg(msg, "Для ознакомления с правилами, нажми /next");
//                    break;
//            }

        //String txt = msg.getText();

//    sendMsg(msg, "Текст приветствия!(Заменить) Нажми /setname чтобы представиться");
//        if(txt.contains("/setname"))
//
//    {
//        String name = update.getMessage().getText().replace("/setname", "").trim();
//        names.put(senderID, name);
//    }
//        if (txt.equals("/next")) {
//            sendMsg(msg, "Для ознакомления с правилами, нажми /next");
//        }

    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        boolean count = true;
        // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        //sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
        //Токен бота
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
        //возвращаем юзера
    }
}


