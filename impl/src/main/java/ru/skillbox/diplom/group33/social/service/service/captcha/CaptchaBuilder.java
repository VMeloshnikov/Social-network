package ru.skillbox.diplom.group33.social.service.service.captcha;

import ru.skillbox.diplom.group33.social.service.Captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class CaptchaBuilder {

    private BufferedImage image;
    private Graphics2D graphics;
    private Captcha captcha;
    private String captchaString;


    public CaptchaBuilder createImage(int width, int height) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        int length = 6;
        char[] generateChars = new char[length];
        Random random = new Random();
        for (int i = 0; i < generateChars.length; i++) {
            int randomInt = random.nextInt(chars.length);
            generateChars[i] = chars[randomInt];
        }
        captchaString = new String(generateChars);

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();

        graphics.setColor(new Color(33, 164, 93));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(new Color(255, 255, 255));
        graphics.setFont(new Font("Osaka", Font.ITALIC, 20));
        graphics.drawString(captchaString, 5, 30);
        graphics.dispose();
        return this;
    }

    private CaptchaBuilder setText(int lineBeginX, int lineBeginY, int fontSize, String line) {
        graphics.drawLine(lineBeginX, lineBeginY, lineBeginX * 2, lineBeginY);
        graphics.setFont(new Font("Osaka", Font.ITALIC, fontSize));
        return this;
    }

    public Captcha build() {
        captcha = new Captcha();
        captcha.setImage(image);
        captcha.setCode(captchaString);
        return captcha;
    }

    public String randomLine() {
        return "";
    }

}
