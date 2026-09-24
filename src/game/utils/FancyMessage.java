package game.utils;

import edu.monash.fit2099.engine.displays.Display;

import java.util.TreeMap;

/**
 * Fancy messages used to print the game title
 * Font obtained from: <a href="https://patorjk.com/software/taag/#p=display&f=Georgia11&t=">link</a>
 * Font: Georgia11
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Ian Leong Zheng Yan
 */
public class FancyMessage {
    public static String TITLE =
            "`7MM\"\"\"YMM  `7MMF'      `7MM\"\"\"Yb. `7MM\"\"\"YMM  `7MN.   `7MF'    MMP\"\"MM\"\"YMM `7MMF'  `7MMF'`7MMF'`7MN.   `7MF' .g8\"\"\"bgd  \n" +
                    "  MM    `7    MM          MM    `Yb. MM    `7    MMN.    M      P'   MM   `7   MM      MM    MM    MMN.    M .dP'     `M  \n" +
                    "  MM   d      MM          MM     `Mb MM   d      M YMb   M           MM        MM      MM    MM    M YMb   M dM'       `  \n" +
                    "  MMmmMM      MM          MM      MM MMmmMM      M  `MN. M           MM        MMmmmmmmMM    MM    M  `MN. M MM           \n" +
                    "  MM   Y  ,   MM      ,   MM     ,MP MM   Y  ,   M   `MM.M           MM        MM      MM    MM    M   `MM.M MM.    `7MMF'\n" +
                    "  MM     ,M   MM     ,M   MM    ,dP' MM     ,M   M     YMM           MM        MM      MM    MM    M     YMM `Mb.     MM  \n" +
                    ".JMMmmmmMMM .JMMmmmmMMM .JMMmmmdP' .JMMmmmmMMM .JML.    YM         .JMML.    .JMML.  .JMML..JMML..JML.    YM   `\"bmmmdPY  \n";

    public static String YOU_DIED =
            "`YMM'   `MM' .g8\"\"8q. `7MMF'   `7MF'    `7MM\"\"\"Yb. `7MMF'`7MM\"\"\"YMM  `7MM\"\"\"Yb.   \n" +
                    "  VMA   ,V .dP'    `YM. MM       M        MM    `Yb. MM    MM    `7    MM    `Yb. \n" +
                    "   VMA ,V  dM'      `MM MM       M        MM     `Mb MM    MM   d      MM     `Mb \n" +
                    "    VMMP   MM        MM MM       M        MM      MM MM    MMmmMM      MM      MM \n" +
                    "     MM    MM.      ,MP MM       M        MM     ,MP MM    MM   Y  ,   MM     ,MP \n" +
                    "     MM    `Mb.    ,dP' YM.     ,M        MM    ,dP' MM    MM     ,M   MM    ,dP' \n" +
                    "   .JMML.    `\"bmmd\"'    `bmmmmd\"'      .JMMmmmdP' .JMML..JMMmmmmMMM .JMMmmmdP'   \n";

    // New fancy messages for the maps
    public static String GRAVESITE_PLAIN =

            "                                                                                                                                                               \n" +
                    "  .g8\"\"\"bgd `7MM\"\"\"Mq.        db `7MMF'   `7MF'`7MM\"\"\"YMM   .M\"\"\"bgd `7MMF'MMP\"\"MM\"\"YMM `7MM\"\"\"YMM      `7MM\"\"\"Mq.`7MMF'            db      `7MMF'`7MN.   `7MF' \n" +
                    ".dP'     `M   MM   `MM.      ;MM:  `MA     ,V    MM    `7  ,MI    \"Y   MM  P'   MM   `7   MM    `7        MM   `MM. MM             ;MM:       MM    MMN.    M  \n" +
                    "dM'       `   MM   ,M9      ,V^MM.  VM:   ,V     MM   d    `MMb.       MM       MM        MM   d          MM   ,M9  MM            ,V^MM.      MM    M YMb   M  \n" +
                    "MM            MMmmdM9      ,M  `MM   MM.  M'     MMmmMM      `YMMNq.   MM       MM        MMmmMM          MMmmdM9   MM           ,M  `MM      MM    M  `MN. M  \n" +
                    "MM.    `7MMF' MM  YM.      AbmmmqMA  `MM A'      MM   Y  , .     `MM   MM       MM        MM   Y  ,       MM        MM      ,    AbmmmqMA     MM    M   `MM.M  \n" +
                    "`Mb.     MM   MM   `Mb.   A'     VML  :MM;       MM     ,M Mb     dM   MM       MM        MM     ,M       MM        MM     ,M   A'     VML    MM    M     YMM  \n" +
                    "  `\"bmmmdPY .JMML. .JMM..AMA.   .AMMA. VF      .JMMmmmmMMM P\"Ybmmd\"  .JMML.   .JMML.    .JMMmmmmMMM     .JMML.    .JMMmmmmMMM .AMA.   .AMMA..JMML..JML.    YM  \n" +
                    "                                                                                                                                                               \n";

    public static String BELURAT_TOWER_SETTLEMENT =
            "`7MM\"\"\"Yp, `7MM\"\"\"YMM  `7MMF'    `7MMF'   `7MF'`7MM\"\"\"Mq.        db   MMP\"\"MM\"\"YMM             MMP\"\"MM\"\"YMM   .g8\"\"8q.`7MMF'     A     `7MF'`7MM\"\"\"YMM  `7MM\"\"\"Mq.       .M\"\"\"bgd `7MM\"\"\"YMM MMP\"\"MM\"\"YMM MMP\"\"MM\"\"YMM `7MMF'      `7MM\"\"\"YMM  `7MMM.     ,MMF'`7MM\"\"\"YMM  `7MN.   `7MF'MMP\"\"MM\"\"YMM \n" +
                    "  MM    Yb   MM    `7    MM        MM       M    MM   `MM.      ;MM:  P'   MM   `7             P'   MM   `7 .dP'    `YM.`MA     ,MA     ,V    MM    `7    MM   `MM.     ,MI    \"Y   MM    `7 P'   MM   `7 P'   MM   `7   MM          MM    `7    MMMb    dPMM    MM    `7    MMN.    M  P'   MM   `7 \n" +
                    "  MM    dP   MM   d      MM        MM       M    MM   ,M9      ,V^MM.      MM                       MM      dM'      `MM VM:   ,VVM:   ,V     MM   d      MM   ,M9      `MMb.       MM   d        MM           MM        MM          MM   d      M YM   ,M MM    MM   d      M YMb   M       MM      \n" +
                    "  MM\"\"\"bg.   MMmmMM      MM        MM       M    MMmmdM9      ,M  `MM      MM                       MM      MM        MM  MM.  M' MM.  M'     MMmmMM      MMmmdM9         `YMMNq.   MMmmMM        MM           MM        MM          MMmmMM      M  Mb  M' MM    MMmmMM      M  `MN. M       MM      \n" +
                    "  MM    `Y   MM   Y  ,   MM      , MM       M    MM  YM.      AbmmmqMA     MM                       MM      MM.      ,MP  `MM A'  `MM A'      MM   Y  ,   MM  YM.       .     `MM   MM   Y  ,     MM           MM        MM      ,   MM   Y  ,   M  YM.P'  MM    MM   Y  ,   M   `MM.M       MM      \n" +
                    "  MM    ,9   MM     ,M   MM     ,M YM.     ,M    MM   `Mb.   A'     VML    MM           ,,          MM      `Mb.    ,dP'   :MM;    :MM;       MM     ,M   MM   `Mb.     Mb     dM   MM     ,M     MM           MM        MM     ,M   MM     ,M   M  `YM'   MM    MM     ,M   M     YMM       MM      \n" +
                    ".JMMmmmd9  .JMMmmmmMMM .JMMmmmmMMM  `bmmmmd\"'  .JMML. .JMM..AMA.   .AMMA..JMML.         dg        .JMML.      `\"bmmd\"'      VF      VF      .JMMmmmmMMM .JMML. .JMM.    P\"Ybmmd\"  .JMMmmmmMMM   .JMML.       .JMML.    .JMMmmmmMMM .JMMmmmmMMM .JML. `'  .JMML..JMMmmmmMMM .JML.    YM     .JMML.    \n" +
                    "                                                                                        ,j                                                                                                                                                                                                            \n" +
                    "                                                                                       ,'                                                                                                                                                                                                            \n";

    public static String BELURAT_SEWERS =

            "                                                                                                                                                                     \n" +
                    "`7MM\"\"\"Yp, `7MM\"\"\"YMM  `7MMF'    `7MMF'   `7MF'`7MM\"\"\"Mq.        db   MMP\"\"MM\"\"YMM      .M\"\"\"bgd `7MM\"\"\"YMM `7MMF'     A     `7MF'`7MM\"\"\"YMM  `7MM\"\"\"Mq.   .M\"\"\"bgd \n" +
                    "  MM    Yb   MM    `7    MM        MM       M    MM   `MM.      ;MM:  P'   MM   `7     ,MI    \"Y   MM    `7   `MA     ,MA     ,V    MM    `7    MM   `MM. ,MI    \"Y \n" +
                    "  MM    dP   MM   d      MM        MM       M    MM   ,M9      ,V^MM.      MM          `MMb.       MM   d      VM:   ,VVM:   ,V     MM   d      MM   ,M9  `MMb.     \n" +
                    "  MM\"\"\"bg.   MMmmMM      MM        MM       M    MMmmdM9      ,M  `MM      MM            `YMMNq.   MMmmMM       MM.  M' MM.  M'     MMmmMM      MMmmdM9     `YMMNq. \n" +
                    "  MM    `Y   MM   Y  ,   MM      , MM       M    MM  YM.      AbmmmqMA     MM          .     `MM   MM   Y  ,    `MM A'  `MM A'      MM   Y  ,   MM  YM.   .     `MM \n" +
                    "  MM    ,9   MM     ,M   MM     ,M YM.     ,M    MM   `Mb.   A'     VML    MM          Mb     dM   MM     ,M     :MM;    :MM;       MM     ,M   MM   `Mb. Mb     dM \n" +
                    ".JMMmmmd9  .JMMmmmmMMM .JMMmmmmMMM  `bmmmmd\"'  .JMML. .JMM..AMA.   .AMMA..JMML.        P\"Ybmmd\"  .JMMmmmmMMM      VF      VF      .JMMmmmmMMM .JMML. .JMM.P\"Ybmmd\"  \n";


    public static String STAGEFRONT =
            ".M\"\"\"bgd MMP\"\"MM\"\"YMM   db       .g8\"\"\"bgd `7MM\"\"\"YMM  `7MM\"\"\"YMM `7MM\"\"\"Mq.   .g8\"\"8q. `7MN.   `7MF'MMP\"\"MM\"\"YMM \n" +
                    ",MI    \"Y P'   MM   `7  ;MM:    .dP'     `M   MM    `7    MM    `7   MM   `MM..dP'    `YM. MMN.    M  P'   MM   `7 \n" +
                    "`MMb.          MM      ,V^MM.   dM'       `   MM   d      MM   d     MM   ,M9 dM'      `MM M YMb   M       MM      \n" +
                    "  `YMMNq.      MM     ,M  `MM   MM            MMmmMM      MM\"\"MM     MMmmdM9  MM        MM M  `MN. M       MM      \n" +
                    ".     `MM      MM     AbmmmqMA  MM.    `7MMF' MM   Y  ,   MM   Y     MM  YM.  MM.      ,MP M   `MM.M       MM      \n" +
                    "Mb     dM      MM    A'     VML `Mb.     MM   MM     ,M   MM         MM   `Mb.`Mb.    ,dP' M     YMM       MM      \n" +
                    "P\"Ybmmd\"     .JMML..AMA.   .AMMA. `\"bmmmdPY .JMMmmmmMMM .JMML.     .JMML. .JMM. `\"bmmd\"' .JML.    YM     .JMML.     \n";

    public static TreeMap<String, String> fancyMsgMap = new TreeMap<String, String>() {{
        put("Gravesite Plain", FancyMessage.GRAVESITE_PLAIN);
        put("Belurat, Tower Settlement", FancyMessage.BELURAT_TOWER_SETTLEMENT);
        put("Belurat Sewers", FancyMessage.BELURAT_SEWERS);
        put("Stagefront", FancyMessage.STAGEFRONT);
        put("You Died", FancyMessage.YOU_DIED);
    }};

    /**
     * A method to print out the message based on the travel destination
     *
     * @param message The destination name of the fast travel
     */
    public static void printMessage(String message) {
        for (String line : FancyMessage.fancyMsgMap.get(message).split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}