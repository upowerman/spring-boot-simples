package com.yunus.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sun.font.FontDesignMetrics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {

    private BufferedImage createImage(int width, Font font, String comment) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        // 计算行高
        int fontHeight = metrics.getHeight();
        // 计算comment在font 字体下的总长度
        int fontLength = getTotalLength(font, comment);
        // 实际生成的水印文字，实际文字行数
        Double textLineCount = Math.ceil(Integer.valueOf(fontLength).doubleValue() / Integer.valueOf(width).doubleValue());
        // 总体点评字体
        Font font2 = new Font(font.getName(), font.getStyle(), font.getSize() + 4);
        FontDesignMetrics metrics2 = FontDesignMetrics.getMetrics(font2);
        // 计算总体点评行高
        int tempHeight = metrics2.getHeight();
        int height = fontHeight * textLineCount.intValue() + fontHeight / 2 + tempHeight * 2;
        // 创建图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics.setFont(font);
        graphics.setColor(Color.RED);
        // 写文字
        int x = 0;
        int y = tempHeight;
        graphics.setFont(font2);
        graphics.drawString("总体点评:", x, y);
        StringBuffer sb = new StringBuffer();
        int znCharWidth = getZNCharWidth(font);
        graphics.setFont(font);
        int tempLineLen = 0;//单行字符总长度临时计算
        y += tempHeight;
        x += getZNCharWidth(font) * 2;
        for (int i = 0; i < comment.length(); i++) {
            int charLength = getTotalLength(font, String.valueOf(comment.charAt(i)));
            tempLineLen += charLength;
            //长度已经满一行,进行文字叠加
            if (tempLineLen + znCharWidth >= width) {
                y += fontHeight;
                graphics.drawString(sb.toString(), x, y);
                //清空内容,重新追加
                sb.delete(0, sb.length());
                tempLineLen = 0;
                x = 0;
            }
            sb.append(comment.charAt(i));
        }
        //最后叠加余下的文字
        y += fontHeight;
        graphics.drawString(sb.toString(), x, y);
        graphics.dispose();
        return bufferedImage;
    }

    /**
     * 计算文字的在该字体下的总长度
     *
     * @param font 字体
     * @param str  计算的文字
     * @return
     */
    private int getTotalLength(Font font, String str) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < str.length(); i++) {
            width += metrics.charWidth(str.charAt(i));
        }
        return width;
    }

    private int getZNCharWidth(Font font) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = metrics.charWidth('中');
        return width;
    }

    public static void main(String[] args) throws IOException {
        String str = "{'x1': 50, 'y1': 475, 'x2': 611, 'y2': 1077}";
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("x1"));
    }

}
