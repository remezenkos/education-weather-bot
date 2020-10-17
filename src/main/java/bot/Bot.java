package bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import service.impl.WeatherServiceImpl;

import java.util.List;

public class Bot extends TelegramLongPollingBot {

    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        String user_info = update.getMessage().getText();
        var cityName = update.getMessage().getText();
        System.out.println("City name: " + cityName);
        System.out.println(update.toString());

        var service = new WeatherServiceImpl();

        var sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(service.getByCityName(cityName).toString());

        KeyboardRow firstkeyboardRow = new KeyboardRow();
        firstkeyboardRow.add("Hi");

        KeyboardRow firstkeyboardRow3 = new KeyboardRow();
        firstkeyboardRow.add("Hello!");

        KeyboardRow firstkeyboardRow2 = new KeyboardRow();
        firstkeyboardRow.add("Hey");


        KeyboardRow secondkeyboardRow = new KeyboardRow();
        secondkeyboardRow.add("bye");


        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setKeyboard(List.of(firstkeyboardRow, secondkeyboardRow, firstkeyboardRow3,firstkeyboardRow2));
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);


        execute(sendMessage);

    }

    @SneakyThrows
    public synchronized void sendMsg(String chatId, String msg) {
        var sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);

        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return "education_weather_bot";
    }

    @Override
    public String getBotToken() {
        return "1114077020:AAHuNCWUe-NaJNsuXYJsgtrDluRA06RWKlM";
    }
}
