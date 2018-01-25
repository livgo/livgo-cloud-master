package com.livgo.cloud.common.util.image;


import com.livgo.cloud.common.util.http.HttpClient;
import com.livgo.cloud.common.util.image.GIF.GifEncoder;
import com.livgo.cloud.common.util.lang.RandomUtil;
import com.livgo.cloud.common.util.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 具体用于实现生成验证码图片的方法
 */
public final class CaptchaUtil {
    private final static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    protected static Font font = new Font("Verdana", Font.ITALIC | Font.BOLD, 28);   // 字体
    //指定所以的字符
    public static String CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * 创建PNG图片验证码
     *
     * @param randomStr 验证码
     * @param width     图片宽度
     * @param height    图片高度
     * @param file      文件位置
     * @return
     */
    public static boolean createPngCaptcha(String randomStr, int width, int height, String file) {
        char[] strs = randomStr.toCharArray();
        try (OutputStream out = new FileOutputStream(file)) {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bi.getGraphics();
            AlphaComposite ac3;
            Color color;
            int len = strs.length;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            for (int i = 0; i < 15; i++) {
                color = RandomUtil.getRandomColor(150, 250);
                g.setColor(color);
                g.drawOval(RandomUtil.getRandomNum(width), RandomUtil.getRandomNum(height), 5 + RandomUtil.getRandomNum(10), 5 + RandomUtil.getRandomNum(10));
            }
            g.setFont(font);
            int h = height - ((height - font.getSize()) >> 1),
                    w = width / len,
                    size = w - font.getSize() + 1;
            for (int i = 0; i < len; i++) {
                // 指定透明度
                ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
                g.setComposite(ac3);
                // 对每个字符都用随机颜色
                color = new Color(20 + RandomUtil.getRandomNum(110), 30 + RandomUtil.getRandomNum(110), 30 + RandomUtil.getRandomNum(110));
                g.setColor(color);
                g.drawString(strs[i] + "", (width - (len - i) * w) + size, h - 4);
            }
            ImageIO.write(bi, "png", out);
            out.flush();
            return true;
        } catch (IOException e) {
            LogUtil.error(logger, e);
            return false;
        }
    }

    /**
     * 创建GIF图片验证码
     *
     * @param randomStr 验证码
     * @param width     图片宽度
     * @param height    图片高度
     * @param file      文件位置
     * @return
     */
    public static boolean createGifCaptcha(String randomStr, int width, int height, String file) {
        char[] rands = randomStr.toCharArray();
        int len = rands.length;
        try (OutputStream out = new FileOutputStream(file)) {
            // gif编码类，这个利用了洋人写的编码类，所有类都在附件中
            GifEncoder gifEncoder = new GifEncoder();
            //生成字符
            gifEncoder.start(out);
            gifEncoder.setQuality(180);
            gifEncoder.setDelay(100);
            gifEncoder.setRepeat(0);
            BufferedImage frame;
            Color fontcolor[] = new Color[len];
            for (int i = 0; i < len; i++) {
                fontcolor[i] = new Color(20 + RandomUtil.getRandomNum(110), 20 + RandomUtil.getRandomNum(110), 20 + RandomUtil.getRandomNum(110));
            }
            for (int i = 0; i < len; i++) {
                frame = graphicsImage(fontcolor, rands, i, width, height);
                gifEncoder.addFrame(frame);
                frame.flush();
            }
            gifEncoder.finish();
            return true;
        } catch (FileNotFoundException e) {
            LogUtil.error(logger, e);
        } catch (IOException e) {
            LogUtil.error(logger, e);
        }
        return false;
    }


    /**
     * 创建PNG图片验证码
     *
     * @param strlen 验证码字符数
     * @param width  图片宽度
     * @param height 图片高度
     * @param file   文件位置
     * @return
     */
    public static boolean createPngCaptcha(int strlen, int width, int height, String file) {
        String random = RandomUtil.getRandomString(RandomUtil.ALL_TYPE, strlen);
        if (CaptchaUtil.createPngCaptcha(random, width, height, file)) {
            return true;
        }
        return false;
    }

    /**
     * 创建GIF图片验证码
     *
     * @param strlen 验证码字符数
     * @param width  图片宽度
     * @param height 图片高度
     * @param file   文件位置
     * @return
     */
    public static boolean createGifCaptcha(int strlen, int width, int height, String file) {
        String random = RandomUtil.getRandomString(RandomUtil.ALL_TYPE, strlen);
        if (CaptchaUtil.createGifCaptcha(random, width, height, file)) {
            return true;
        }
        return false;
    }


    /**
     * 获取透明度,从0到1,自动计算步长
     *
     * @return float 透明度
     */
    private static float getAlpha(int i, int j, int len) {
        int num = i + j;
        float r = (float) 1 / len, s = (len + 1) * r;
        return num > len ? (num * r - s) : num * r;
    }

    /**
     * 画随机码图
     *
     * @param fontcolor 随机字体颜色
     * @param strs      字符数组
     * @param flag      透明度使用
     * @return BufferedImage
     */
    private static BufferedImage graphicsImage(Color[] fontcolor, char[] strs, int flag, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //或得图形上下文
        //Graphics2D g2d=image.createGraphics();
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        //利用指定颜色填充背景
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        AlphaComposite ac3;
        int len = strs.length;
        int h = height - ((height - font.getSize()) >> 1);
        int w = width / len;
        g2d.setFont(font);
        for (int i = 0; i < len; i++) {
            ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha(flag, i, len));
            g2d.setComposite(ac3);
            int j = RandomUtil.getRandomNum(fontcolor.length);
            g2d.setColor(fontcolor[j]);
            g2d.drawOval(RandomUtil.getRandomNum(width), RandomUtil.getRandomNum(height), 5 + RandomUtil.getRandomNum(10), 5 + RandomUtil.getRandomNum(10));
            g2d.drawString(strs[i] + "", (width - (len - i) * w) + (w - font.getSize()) + 1, h - 4);
        }
        g2d.dispose();
        return image;
    }
}
