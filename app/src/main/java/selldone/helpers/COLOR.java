package selldone.helpers;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class COLOR {

    public static final int WHITE = 0xffffffff;
    public static final int BLACK = 0xff000000;

    public static final int RED = 0xfff44336;
    public static final int PINK = 0xffe91e63;
    public static final int PURPLE = 0xff9c27b0;
    public static final int DEEP_PURPLE = 0xff673ab7;
    public static final int INDIGO = 0xff3f51b5;
    public static final int BLUE = 0xff2196f3;
    public static final int LIGHT_BLUE = 0xff03a9f4;
    public static final int CYAN = 0xff00bcd4;
    public static final int TEAL = 0xff009688;
    public static final int GREEN = 0xff4caf50;
    public static final int LIGHT_GREEN = 0xff8bc34a;
    public static final int LIME = 0xffcddc39;
    public static final int YELLOW = 0xffffeb3b;
    public static final int AMBER = 0xffffc107;
    public static final int ORANGE = 0xffff9800;
    public static final int DEEP_ORANGE = 0xffff5722;
    public static final int BROWN = 0xff795548;
    public static final int GREY = 0xff9e9e9e;
    public static final int BLUE_GREY = 0xff;


    public static final int TEXT_BLACK_DIVIDER = 0x1f000000;
    public static final int TEXT_BLACK_HINT = 0x42000000;
    public static final int TEXT_BLACK_SECONDARY_TEXT = 0x8a000000;
    public static final int TEXT_BLACK_TEXT = 0xde000000;

    public static final int TEXT_WHITE_DIVIDER = 0x1fffffff;
    public static final int TEXT_WHITE_HINT = 0x42ffffff;
    public static final int TEXT_WHITE_SECONDARY_TEXT = 0x8affffff;
    public static final int TEXT_WHITE_TEXT = 0xdeffffff;

    public static final int RED_50 = 0xFFfde0dc;
    public static final int RED_100 = 0xFFf9bdbb;
    public static final int RED_200 = 0xFFf69988;
    public static final int RED_300 = 0xFFf36c60;
    public static final int RED_400 = 0xFFe84e40;
    public static final int RED_500 = 0xFFe51c23;
    public static final int RED_600 = 0xFFdd191d;
    public static final int RED_700 = 0xFFd01716;
    public static final int RED_800 = 0xFFc41411;
    public static final int RED_900 = 0xFFb0120a;
    public static final int RED_A100 = 0xFFff7997;
    public static final int RED_A200 = 0xFFff5177;
    public static final int RED_A400 = 0xFFff2d6f;
    public static final int RED_A700 = 0xFFe00032;

    public static final int PINK_50 = 0xFFfce4ec;
    public static final int PINK_100 = 0xFFf8bbd0;
    public static final int PINK_200 = 0xFFf48fb1;
    public static final int PINK_300 = 0xFFf06292;
    public static final int PINK_400 = 0xFFec407a;
    public static final int PINK_500 = 0xFFe91e63;
    public static final int PINK_600 = 0xFFd81b60;
    public static final int PINK_700 = 0xFFc2185b;
    public static final int PINK_800 = 0xFFad1457;
    public static final int PINK_900 = 0xFF880e4f;
    public static final int PINK_A100 = 0xFFff80ab;
    public static final int PINK_A200 = 0xFFff4081;
    public static final int PINK_A400 = 0xFFf50057;
    public static final int PINK_A700 = 0xFFc51162;

    public static final int PURPLE_50 = 0xFFf3e5f5;
    public static final int PURPLE_100 = 0xFFe1bee7;
    public static final int PURPLE_200 = 0xFFce93d8;
    public static final int PURPLE_300 = 0xFFba68c8;
    public static final int PURPLE_400 = 0xFFab47bc;
    public static final int PURPLE_500 = 0xFF9c27b0;
    public static final int PURPLE_600 = 0xFF8e24aa;
    public static final int PURPLE_700 = 0xFF7b1fa2;
    public static final int PURPLE_800 = 0xFF6a1b9a;
    public static final int PURPLE_900 = 0xFF4a148c;
    public static final int PURPLE_A100 = 0xFFea80fc;
    public static final int PURPLE_A200 = 0xFFe040fb;
    public static final int PURPLE_A400 = 0xFFd500f9;
    public static final int PURPLE_A700 = 0xFFaa00ff;

    public static final int DEEP_PURPLE_50 = 0xFFede7f6;
    public static final int DEEP_PURPLE_100 = 0xFFd1c4e9;
    public static final int DEEP_PURPLE_200 = 0xFFb39ddb;
    public static final int DEEP_PURPLE_300 = 0xFF9575cd;
    public static final int DEEP_PURPLE_400 = 0xFF7e57c2;
    public static final int DEEP_PURPLE_500 = 0xFF673ab7;
    public static final int DEEP_PURPLE_600 = 0xFF5e35b1;
    public static final int DEEP_PURPLE_700 = 0xFF512da8;
    public static final int DEEP_PURPLE_800 = 0xFF4527a0;
    public static final int DEEP_PURPLE_900 = 0xFF311b92;
    public static final int DEEP_PURPLE_A100 = 0xFFb388ff;
    public static final int DEEP_PURPLE_A200 = 0xFF7c4dff;
    public static final int DEEP_PURPLE_A400 = 0xFF651fff;
    public static final int DEEP_PURPLE_A700 = 0xFF6200ea;

    public static final int INDIGO_50 = 0xFFe8eaf6;
    public static final int INDIGO_100 = 0xFFc5cae9;
    public static final int INDIGO_200 = 0xFF9fa8da;
    public static final int INDIGO_300 = 0xFF7986cb;
    public static final int INDIGO_400 = 0xFF5c6bc0;
    public static final int INDIGO_500 = 0xFF3f51b5;
    public static final int INDIGO_600 = 0xFF3949ab;
    public static final int INDIGO_700 = 0xFF303f9f;
    public static final int INDIGO_800 = 0xFF283593;
    public static final int INDIGO_900 = 0xFF1a237e;
    public static final int INDIGO_A100 = 0xFF8c9eff;
    public static final int INDIGO_A200 = 0xFF536dfe;
    public static final int INDIGO_A400 = 0xFF3d5afe;
    public static final int INDIGO_A700 = 0xFF304ffe;

    public static final int BLUE_50 = 0xFFe7e9fd;
    public static final int BLUE_100 = 0xFFd0d9ff;
    public static final int BLUE_200 = 0xFFafbfff;
    public static final int BLUE_300 = 0xFF91a7ff;
    public static final int BLUE_400 = 0xFF738ffe;
    public static final int BLUE_500 = 0xFF5677fc;
    public static final int BLUE_600 = 0xFF4e6cef;
    public static final int BLUE_700 = 0xFF455ede;
    public static final int BLUE_800 = 0xFF3b50ce;
    public static final int BLUE_900 = 0xFF2a36b1;
    public static final int BLUE_A100 = 0xFFa6baff;
    public static final int BLUE_A200 = 0xFF6889ff;
    public static final int BLUE_A400 = 0xFF4d73ff;
    public static final int BLUE_A700 = 0xFF4d69ff;

    public static final int LIGHT_BLUE_50 = 0xFFe1f5fe;
    public static final int LIGHT_BLUE_100 = 0xFFb3e5fc;
    public static final int LIGHT_BLUE_200 = 0xFF81d4fa;
    public static final int LIGHT_BLUE_300 = 0xFF4fc3f7;
    public static final int LIGHT_BLUE_400 = 0xFF29b6f6;
    public static final int LIGHT_BLUE_500 = 0xFF03a9f4;
    public static final int LIGHT_BLUE_600 = 0xFF039be5;
    public static final int LIGHT_BLUE_700 = 0xFF0288d1;
    public static final int LIGHT_BLUE_800 = 0xFF0277bd;
    public static final int LIGHT_BLUE_900 = 0xFF01579b;
    public static final int LIGHT_BLUE_A100 = 0xFF80d8ff;
    public static final int LIGHT_BLUE_A200 = 0xFF40c4ff;
    public static final int LIGHT_BLUE_A400 = 0xFF00b0ff;
    public static final int LIGHT_BLUE_A700 = 0xFF0091ea;

    public static final int CYAN_50 = 0xFFe0f7fa;
    public static final int CYAN_100 = 0xFFb2ebf2;
    public static final int CYAN_200 = 0xFF80deea;
    public static final int CYAN_300 = 0xFF4dd0e1;
    public static final int CYAN_400 = 0xFF26c6da;
    public static final int CYAN_500 = 0xFF00bcd4;
    public static final int CYAN_600 = 0xFF00acc1;
    public static final int CYAN_700 = 0xFF0097a7;
    public static final int CYAN_800 = 0xFF00838f;
    public static final int CYAN_900 = 0xFF006064;
    public static final int CYAN_A100 = 0xFF84ffff;
    public static final int CYAN_A200 = 0xFF18ffff;
    public static final int CYAN_A400 = 0xFF00e5ff;
    public static final int CYAN_A700 = 0xFF00b8d4;

    public static final int TEAL_50 = 0xFFe0f2f1;
    public static final int TEAL_100 = 0xFFb2dfdb;
    public static final int TEAL_200 = 0xFF80cbc4;
    public static final int TEAL_300 = 0xFF4db6ac;
    public static final int TEAL_400 = 0xFF26a69a;
    public static final int TEAL_500 = 0xFF009688;
    public static final int TEAL_600 = 0xFF00897b;
    public static final int TEAL_700 = 0xFF00796b;
    public static final int TEAL_800 = 0xFF00695c;
    public static final int TEAL_900 = 0xFF004d40;
    public static final int TEAL_A100 = 0xFFa7ffeb;
    public static final int TEAL_A200 = 0xFF64ffda;
    public static final int TEAL_A400 = 0xFF1de9b6;
    public static final int TEAL_A700 = 0xFF00bfa5;

    public static final int GREEN_50 = 0xFFd0f8ce;
    public static final int GREEN_100 = 0xFFa3e9a4;
    public static final int GREEN_200 = 0xFF72d572;
    public static final int GREEN_300 = 0xFF42bd41;
    public static final int GREEN_400 = 0xFF2baf2b;
    public static final int GREEN_500 = 0xFF259b24;
    public static final int GREEN_600 = 0xFF0a8f08;
    public static final int GREEN_700 = 0xFF0a7e07;
    public static final int GREEN_800 = 0xFF056f00;
    public static final int GREEN_900 = 0xFF0d5302;
    public static final int GREEN_A100 = 0xFFa2f78d;
    public static final int GREEN_A200 = 0xFF5af158;
    public static final int GREEN_A400 = 0xFF14e715;
    public static final int GREEN_A700 = 0xFF12c700;

    public static final int LIGHT_GREEN_50 = 0xFFf1f8e9;
    public static final int LIGHT_GREEN_100 = 0xFFdcedc8;
    public static final int LIGHT_GREEN_200 = 0xFFc5e1a5;
    public static final int LIGHT_GREEN_300 = 0xFFaed581;
    public static final int LIGHT_GREEN_400 = 0xFF9ccc65;
    public static final int LIGHT_GREEN_500 = 0xFF8bc34a;
    public static final int LIGHT_GREEN_600 = 0xFF7cb342;
    public static final int LIGHT_GREEN_700 = 0xFF689f38;
    public static final int LIGHT_GREEN_800 = 0xFF558b2f;
    public static final int LIGHT_GREEN_900 = 0xFF33691e;
    public static final int LIGHT_GREEN_A100 = 0xFFccff90;
    public static final int LIGHT_GREEN_A200 = 0xFFb2ff59;
    public static final int LIGHT_GREEN_A400 = 0xFF76ff03;
    public static final int LIGHT_GREEN_A700 = 0xFF64dd17;

    public static final int LIME_50 = 0xFFf9fbe7;
    public static final int LIME_100 = 0xFFf0f4c3;
    public static final int LIME_200 = 0xFFe6ee9c;
    public static final int LIME_300 = 0xFFdce775;
    public static final int LIME_400 = 0xFFd4e157;
    public static final int LIME_500 = 0xFFcddc39;
    public static final int LIME_600 = 0xFFc0ca33;
    public static final int LIME_700 = 0xFFafb42b;
    public static final int LIME_800 = 0xFF9e9d24;
    public static final int LIME_900 = 0xFF827717;
    public static final int LIME_A100 = 0xFFf4ff81;
    public static final int LIME_A200 = 0xFFeeff41;
    public static final int LIME_A400 = 0xFFc6ff00;
    public static final int LIME_A700 = 0xFFaeea00;

    public static final int YELLOW_50 = 0xFFfffde7;
    public static final int YELLOW_100 = 0xFFfff9c4;
    public static final int YELLOW_200 = 0xFFfff59d;
    public static final int YELLOW_300 = 0xFFfff176;
    public static final int YELLOW_400 = 0xFFffee58;
    public static final int YELLOW_500 = 0xFFffeb3b;
    public static final int YELLOW_600 = 0xFFfdd835;
    public static final int YELLOW_700 = 0xFFfbc02d;
    public static final int YELLOW_800 = 0xFFf9a825;
    public static final int YELLOW_900 = 0xFFf57f17;
    public static final int YELLOW_A100 = 0xFFffff8d;
    public static final int YELLOW_A200 = 0xFFffff00;
    public static final int YELLOW_A400 = 0xFFffea00;
    public static final int YELLOW_A700 = 0xFFffd600;

    public static final int AMBER_50 = 0xFFfff8e1;
    public static final int AMBER_100 = 0xFFffecb3;
    public static final int AMBER_200 = 0xFFffe082;
    public static final int AMBER_300 = 0xFFffd54f;
    public static final int AMBER_400 = 0xFFffca28;
    public static final int AMBER_500 = 0xFFffc107;
    public static final int AMBER_600 = 0xFFffb300;
    public static final int AMBER_700 = 0xFFffa000;
    public static final int AMBER_800 = 0xFFff8f00;
    public static final int AMBER_900 = 0xFFff6f00;
    public static final int AMBER_A100 = 0xFFffe57f;
    public static final int AMBER_A200 = 0xFFffd740;
    public static final int AMBER_A400 = 0xFFffc400;
    public static final int AMBER_A700 = 0xFFffab00;

    public static final int ORANGE_50 = 0xFFfff3e0;
    public static final int ORANGE_100 = 0xFFffe0b2;
    public static final int ORANGE_200 = 0xFFffcc80;
    public static final int ORANGE_300 = 0xFFffb74d;
    public static final int ORANGE_400 = 0xFFffa726;
    public static final int ORANGE_500 = 0xFFff9800;
    public static final int ORANGE_600 = 0xFFfb8c00;
    public static final int ORANGE_700 = 0xFFf57c00;
    public static final int ORANGE_800 = 0xFFef6c00;
    public static final int ORANGE_900 = 0xFFe65100;
    public static final int ORANGE_A100 = 0xFFffd180;
    public static final int ORANGE_A200 = 0xFFffab40;
    public static final int ORANGE_A400 = 0xFFff9100;
    public static final int ORANGE_A700 = 0xFFff6d00;

    public static final int DEEP_ORANGE_50 = 0xFFfbe9e7;
    public static final int DEEP_ORANGE_100 = 0xFFffccbc;
    public static final int DEEP_ORANGE_200 = 0xFFffab91;
    public static final int DEEP_ORANGE_300 = 0xFFff8a65;
    public static final int DEEP_ORANGE_400 = 0xFFff7043;
    public static final int DEEP_ORANGE_500 = 0xFFff5722;
    public static final int DEEP_ORANGE_600 = 0xFFf4511e;
    public static final int DEEP_ORANGE_700 = 0xFFe64a19;
    public static final int DEEP_ORANGE_800 = 0xFFd84315;
    public static final int DEEP_ORANGE_900 = 0xFFbf360c;
    public static final int DEEP_ORANGE_A100 = 0xFFff9e80;
    public static final int DEEP_ORANGE_A200 = 0xFFff6e40;
    public static final int DEEP_ORANGE_A400 = 0xFFff3d00;
    public static final int DEEP_ORANGE_A700 = 0xFFdd2c00;

    public static final int BROWN_50 = 0xFFefebe9;
    public static final int BROWN_100 = 0xFFd7ccc8;
    public static final int BROWN_200 = 0xFFbcaaa4;
    public static final int BROWN_300 = 0xFFa1887f;
    public static final int BROWN_400 = 0xFF8d6e63;
    public static final int BROWN_500 = 0xFF795548;
    public static final int BROWN_600 = 0xFF6d4c41;
    public static final int BROWN_700 = 0xFF5d4037;
    public static final int BROWN_800 = 0xFF4e342e;
    public static final int BROWN_900 = 0xFF3e2723;
    public static final int BROWN_A100 = 0xFFffd180;
    public static final int BROWN_A200 = 0xFFffab40;
    public static final int BROWN_A400 = 0xFFff9100;
    public static final int BROWN_A700 = 0xFFff6d00;

    public static final int GREY_50 = 0xFFfafafa;
    public static final int GREY_100 = 0xFFf5f5f5;
    public static final int GREY_200 = 0xFFeeeeee;
    public static final int GREY_300 = 0xFFe0e0e0;
    public static final int GREY_400 = 0xFFbdbdbd;
    public static final int GREY_500 = 0xFF9e9e9e;
    public static final int GREY_600 = 0xFF757575;
    public static final int GREY_700 = 0xFF616161;
    public static final int GREY_800 = 0xFF424242;
    public static final int GREY_900 = 0xFF212121;
    public static final int GREY_1000 = 0xFF000000;
    public static final int GREY_1001 = 0xFFffffff;

    public static final int LIGHT_GREY_50 = 0xFFeceff1;
    public static final int LIGHT_GREY_100 = 0xFFcfd8dc;
    public static final int LIGHT_GREY_200 = 0xFFb0bec5;
    public static final int LIGHT_GREY_300 = 0xFF90a4ae;
    public static final int LIGHT_GREY_400 = 0xFF78909c;
    public static final int LIGHT_GREY_500 = 0xFF607d8b;
    public static final int LIGHT_GREY_600 = 0xFF546e7a;
    public static final int LIGHT_GREY_700 = 0xFF455a64;
    public static final int LIGHT_GREY_800 = 0xFF37474f;
    public static final int LIGHT_GREY_900 = 0xFF263238;

    public static final int TEXT_FOR_RED_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_RED_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_RED_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_PINK_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PINK_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PINK_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_PURPLE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PURPLE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PURPLE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PURPLE_300 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_PURPLE_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_PURPLE_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_DEEP_PURPLE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_300 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_PURPLE_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_INDIGO_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_INDIGO_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_INDIGO_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_INDIGO_300 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_INDIGO_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_INDIGO_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_BLUE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BLUE_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BLUE_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_LIGHT_BLUE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_BLUE_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_CYAN_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_CYAN_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_CYAN_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_CYAN_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_CYAN_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_CYAN_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_CYAN_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_TEAL_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_TEAL_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_TEAL_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_TEAL_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_TEAL_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_TEAL_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_TEAL_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_GREEN_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREEN_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREEN_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREEN_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREEN_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREEN_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREEN_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_LIGHT_GREEN_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_600 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_700 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREEN_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_LIME_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_600 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_700 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_800 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIME_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIME_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_YELLOW_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_600 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_700 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_800 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_900 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_YELLOW_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_AMBER_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_600 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_700 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_800 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_900 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_AMBER_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_ORANGE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_600 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_700 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_ORANGE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_ORANGE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_A400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_ORANGE_A700 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_DEEP_ORANGE_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_A200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_DEEP_ORANGE_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_BROWN_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BROWN_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BROWN_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BROWN_300 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_A100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_BROWN_A200 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_A400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_BROWN_A700 = TEXT_WHITE_TEXT;

    public static final int TEXT_FOR_GREY_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_400 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_500 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_GREY_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREY_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREY_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREY_900 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREY_1000 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_GREY_1001 = TEXT_BLACK_TEXT;

    public static final int TEXT_FOR_LIGHT_GREY_50 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_100 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_200 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_300 = TEXT_BLACK_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_400 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_500 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_600 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_700 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_800 = TEXT_WHITE_TEXT;
    public static final int TEXT_FOR_LIGHT_GREY_900 = TEXT_WHITE_TEXT;


    public static final GradientDrawable gradientDrawable_play = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.TEAL, COLOR.LIME});
    public static final GradientDrawable gradientDrawable_pause = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.AMBER_900, COLOR.YELLOW_800});

    public static final GradientDrawable gradientDrawable_stop = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.RED_800, COLOR.DEEP_ORANGE});

    public static final GradientDrawable gradientDrawable_error = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.DEEP_PURPLE, COLOR.PINK});


    public static final GradientDrawable gradientDrawable_destroy = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.BLUE_800, COLOR.CYAN});


    public final static int Corner_Dialog_mm = 3;


    public final static GradientDrawable dialog_YEllow = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.YELLOW_900, COLOR.AMBER_900});

    public final static GradientDrawable dialog_RED = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.RED, COLOR.RED_900});


    public final static GradientDrawable dialog_PINK = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.PINK, COLOR.PURPLE});

    public final static GradientDrawable dialog_GREEN = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.TEAL, COLOR.GREEN});

    public final static GradientDrawable dialog_BLUE = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
            new int[]{COLOR.CYAN_800, COLOR.BLUE});

    static {
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
        float px_4mm = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, Corner_Dialog_mm, dm);

        float[] radi = {px_4mm, px_4mm, px_4mm, px_4mm, 0, 0, 0, 0};
        dialog_YEllow.setCornerRadii(radi);
        dialog_PINK.setCornerRadii(radi);
        dialog_GREEN.setCornerRadii(radi);
        dialog_BLUE.setCornerRadii(radi);
        dialog_RED.setCornerRadii(radi);
    }
}