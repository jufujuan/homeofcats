package jfj.homeofcars.Utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;


/**
 * 调节系统亮度的工具类(该类用于设置日间模式和夜间模式)
 * 鉴于汽车之家的两种模式并没有像小说阅读器那样的界面
 * 所以调节系统亮度即可
 * 思路如下:
 * 1.打开应用后, 获取手机原来的亮度值并保存它(可用于退出应用后恢复正常亮度)
 * 2.如果手机打开自动亮度调节则关闭自动调节, 然后设置合适的较低亮度
 * 3.将设置的亮度值应用到手机中
 * 4.最后,退出应用时利用保存的原亮度值恢复原来亮度, 并重新打开手机的自动亮度调节
 */
public class SystemBrightnessUtil {
    private Context mContext;
    private ContentResolver mContentResolver;

    public SystemBrightnessUtil(Context context) {
        mContext = context;
        mContentResolver=context.getContentResolver();
    }

    /**
     * 获取当前手机系统屏幕亮度
     */
    public int getSystemBrightness(){
        int brightnessValue=-1;
        try {
            /**
             * System.getInt获得当前系统设置里面现在设置
             */
            brightnessValue= System.getInt(mContentResolver, System.SCREEN_BRIGHTNESS);
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
        }
        return brightnessValue;
    }
    /**
     * 检测手机是否打开亮度自动调节开关
     */
    public boolean isAutoBrightness(){
        boolean autoBrightness=false;
        try {
            autoBrightness= System.getInt(mContentResolver, System.SCREEN_BRIGHTNESS_MODE)== System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
        }
        return autoBrightness;
    }
    /**
     * 停止自动调节亮度
     */
    public  void closeAutoBrightness(){
        Settings.System.putInt(mContentResolver, System.SCREEN_BRIGHTNESS_MODE, System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }
    /**
     * 设置系统自动调节亮度
     */
    public  void openAutoBrightness(){
        Settings.System.putInt(mContentResolver, System.SCREEN_BRIGHTNESS_MODE, System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }
    /**
     * 保存全局的亮度值设置
     * @param brightnessValue 将要保存的亮度值
     */
    public void saveBrightness(int brightnessValue){
        String screen_brightness=Settings.System.SCREEN_BRIGHTNESS;
        Uri uri=Settings.System.getUriFor(screen_brightness);
        Settings.System.putInt(mContentResolver,screen_brightness,brightnessValue);
        mContentResolver.notifyChange(uri,null);
    }
}
