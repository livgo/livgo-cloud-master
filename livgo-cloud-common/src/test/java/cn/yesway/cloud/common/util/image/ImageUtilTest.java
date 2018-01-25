package com.livgo.cloud.common.util.image;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class ImageUtilTest {

    public static void main(String[] args) {
        CaptchaUtil.createPngCaptcha("abc", 100, 50, "d:/pngCaptcha.png");
        CaptchaUtil.createGifCaptcha("abc", 100, 50, "d:/gifCaptcha.gif");
    }
}
