package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.BlueSoldier;
import zelda.enemy.WhiteSoldier;
import zelda.engine.Game;
import zelda.items.Bush;
import zelda.items.Guard;
import zelda.character.Direction;

/**
 *
 *
 */
public final class HyruleScene extends ZeldaScene {

    private final Rectangle hatch = new Rectangle(904, 166, 1, 1);

    private final Rectangle exitDown = new Rectangle(672, 1013, 290, 20);

    private final Rectangle stairs = new Rectangle(713, 215, 14, 14);

    private final Rectangle door = new Rectangle(497, 247, 30, 30);

    private final Rectangle forrestExit = new Rectangle(121, 1000, 50, 20);

    private final Polygon wall, wall1, castlewall1, tree, tree2, castlewall2, castlewall3, downwall, downwall1;

    private final Polygon bush1, bush2, bush3, garden, garden1, garden3, balk; //lantern1, lantern2, lantern3, lantern4, lantern5, lantern6, lantern7, lantern8;

    public HyruleScene(Game game, String entrance) {

        super(game, "/images/hyrule.png", "HyruleScene");

        exits.add(exitDown);
        exits.add(hatch);
        exits.add(stairs);
        exits.add(door);
        exits.add(forrestExit);
        /*
        int[] wxpos = {385, 398, 398, 385};
        int[] wypos = {497, 497, 511, 511};
        
        lantern1 = new Polygon(wxpos, wypos, wypos.length);
        
        int[] txpos = {336, 350, 350, 336};
        int[] typos = {497, 497, 511, 511};
        
        lantern2 = new Polygon(txpos, typos, typos.length);
        
        int[] uxpos = {385, 398, 398, 385};
        int[] uypos = {464, 464, 480, 480};
        
        lantern3 = new Polygon(uxpos, uypos, uypos.length);
        
        int[] axpos = {336, 350, 350, 336};
        int[] aypos = {464, 464, 480, 480};
        
        lantern4 = new Polygon(axpos, aypos, aypos.length);
        
        int[] sxpos = {385, 398, 398, 385};
        int[] sypos = {431, 431, 449, 449};
        
        lantern5 = new Polygon(sxpos, sypos, sypos.length);
        
        int[] hxpos = {336, 350, 350, 336};
        int[] hypos = {431, 431, 449, 449};
        
        lantern6 = new Polygon(hxpos, hypos, hypos.length);
        
        int[] lxpos = {385, 398, 398, 385};
        int[] lypos = {398, 398, 418, 418};
        
        lantern7 = new Polygon(lxpos, lypos, lypos.length);
        
        int[] vxpos = {336, 350, 350, 336};
        int[] vypos = {398, 398, 418, 418};
        
        lantern8 = new Polygon(vxpos, vypos, vypos.length);
         */
        int[] dxpos = {
            342, 346, 369, 388, 396, 396, 339
        };
        int[] dypos = {
            290, 347, 357, 349, 334, 294, 294
        };

        for (int i = 0; i < dypos.length; i++) {
            dypos[i] += 20;
        }
        tree = new Polygon(dxpos, dypos, dypos.length);

        int[] nxpos = {
            632, 676, 686, 682, 683, 677, 679, 678, 667, 662, 659, 650, 637, 636, 626, 629, 627, 645
        };
        int[] nypos = {
            288, 286, 313, 327, 332, 336, 345, 349, 347, 347, 355, 348, 349, 341, 335, 330, 299, 284
        };

        for (int i = 0; i < nypos.length; i++) {
            nypos[i] += 20;
        }

        tree2 = new Polygon(nxpos, nypos, nypos.length);

        int[] cxpos = {
            40, 42, 465, 464, 457, 464, 476, 473, 462, 462, 272, 272, 284, 285, 270, 272, 336, 338, 361, 363, 389, 390,
            426, 426, 450, 454, 472, 473, 485, 485, 451, 369, 366, 241, 241, 34
        };
        int[] cypos = {
            904, 889, 887, 713, 713, 628, 627, 567, 567, 545, 541, 461, 461, 338, 334, 166, 166, 243, 245, 258, 257,
            240, 240, 260, 259, 240, 238, 270, 270, 164, 161, 160, 115, 114, 358, 898
        };

        for (int i = 0; i < cypos.length; i++) {
            cypos[i] += 20;
        }
        castlewall2 = new Polygon(cxpos, cypos, cypos.length);

        int[] fxpos = {
            561, 562, 750, 752, 738, 739, 752, 751, 736, 735, 705, 704, 688, 687, 687, 702, 704, 672, 672, 664, 662,
            634, 633, 633, 597, 597, 599, 599, 578, 577, 577, 570, 570, 552, 552, 538, 538, 576, 575, 656, 657, 781,
            784, 768, 768, 782, 781, 593
        };
        int[] fypos = {
            562, 545, 543, 465, 463, 337, 336, 168, 168, 187, 187, 169, 167, 240, 246, 247, 260, 261, 243, 243, 257,
            257, 247, 240, 239, 256, 265, 368, 368, 266, 259, 259, 242, 242, 276, 277, 163, 161, 193, 191, 113, 114,
            355, 358, 414, 417, 563, 564
        };

        for (int i = 0; i < fypos.length; i++) {
            fypos[i] += 20;
        }

        castlewall3 = new Polygon(fxpos, fypos, fypos.length);

        int[] expos = {
            476, 563, 561, 637, 638, 843, 845, 830, 832, 847, 845, 829, 830, 845, 849, 804, 793, 473
        };
        int[] eypos = {
            619, 615, 674, 675, 638, 636, 547, 543, 463, 460, 337, 336, 155, 153, 52, 55, 572, 567
        };

        for (int i = 0; i < eypos.length; i++) {
            eypos[i] += 20;
        }

        castlewall1 = new Polygon(expos, eypos, eypos.length);

        int[] gxpos = {
            848, 870, 872, 878, 887, 883, 891, 888, 898, 908, 918, 930, 934, 932, 933, 939, 937, 945, 951, 953, 937,
            937, 905, 905, 920, 919, 906, 905, 919, 921, 938, 1015, 1014, 975, 974, 938, 892, 561, 560, 829, 837, 835,
            841, 841, 855, 861, 870, 885, 885, 892, 889, 895, 908, 956, 961, 992, 990, 919, 576, 577, 908, 961, 1011,
            1013, 961, 962, 990, 992, 965, 888, 877, 849
        };
        int[] gypos = {
            53, 55, 47, 47, 73, 75, 82, 91, 91, 98, 92, 95, 91, 86, 80, 77, 73, 50, 50, 183, 185, 199, 200, 212, 212,
            295, 297, 310, 310, 615, 630, 629, 672, 675, 667, 667, 713, 712, 883, 886, 900, 908, 913, 922, 922, 935,
            924, 926, 916, 910, 904, 887, 886, 935, 988, 988, 921, 850, 846, 776, 772, 727, 724, 593, 570, 245, 210, 42,
            15, 15, 9, 9
        };

        for (int i = 0; i < gypos.length; i++) {
            gypos[i] += 20;
        }
        wall = new Polygon(gxpos, gypos, gypos.length);

        int[] ixpos = {
            34, 92, 117, 44, 35,
        };
        int[] iypos = {
            932, 950, 1006, 1000, 932,
        };

        downwall = new Polygon(ixpos, iypos, iypos.length);

        int[] zxpos = {
            181, 210, 211, 638, 668, 180
        };
        int[] zypos = {
            1004, 992, 956, 953, 1010, 1008
        };

        downwall1 = new Polygon(zxpos, zypos, zypos.length);

        int[] jxpos = {
            426, 445, 446, 426, 426
        };
        int[] jypos = {
            281, 281, 350, 350, 285
        };

        for (int i = 0; i < jypos.length; i++) {
            jypos[i] += 20;
        }
        bush1 = new Polygon(jxpos, jypos, jypos.length);

        int[] kxpos = {
            426, 444, 446, 424, 426,
        };
        int[] kypos = {
            379, 378, 412, 414, 379,
        };

        for (int i = 0; i < kypos.length; i++) {
            kypos[i] += 20;
        }
        bush2 = new Polygon(kxpos, kypos, kypos.length);

        int[] mxpos = {
            425, 444, 445, 427, 426
        };
        int[] mypos = {
            443, 443, 483, 483, 442
        };

        for (int i = 0; i < mypos.length; i++) {
            mypos[i] += 20;
        }
        bush3 = new Polygon(mxpos, mypos, mypos.length);

        int[] oxpos = {
            751, 735, 737, 751, 752
        };
        int[] oypos = {
            263, 260, 248, 248, 261
        };
        for (int i = 0; i < oypos.length; i++) {
            oypos[i] += 20;
        }

        balk = new Polygon(oxpos, oypos, oypos.length);

        int[] pxpos = {
            666, 679, 681, 701, 703, 682, 682, 665, 665, 679, 681, 681, 666, 665
        };
        int[] pypos = {
            409, 410, 394, 394, 466, 467, 458, 456, 441, 441, 427, 423, 421, 411
        };
        for (int i = 0; i < pypos.length; i++) {
            pypos[i] += 20;
        }

        garden = new Polygon(pxpos, pypos, pypos.length);

        int[] qxpos = {
            610, 630, 631, 641, 646, 646, 634, 633, 645, 645, 633, 631, 610, 610
        };
        int[] qypos = {
            394, 393, 408, 409, 412, 423, 423, 441, 441, 454, 455, 461, 462, 396
        };

        for (int i = 0; i < qypos.length; i++) {
            qypos[i] += 20;
        }

        garden1 = new Polygon(qxpos, qypos, qypos.length);

        int[] rxpos = {
            577, 597, 598, 578, 578
        };
        int[] rypos = {
            491, 491, 511, 512, 495
        };

        for (int i = 0; i < rypos.length; i++) {
            rypos[i] += 20;
        }

        garden3 = new Polygon(rxpos, rypos, rypos.length);

        int[] xpos = {
            563, 637, 637, 562
        };
        int[] ypos = {
            684, 683, 673, 671
        };

        for (int i = 0; i < ypos.length; i++) {
            ypos[i] += 20;
        }

        wall1 = new Polygon(xpos, ypos, ypos.length);
        /*
        solids.add(lantern1);
        solids.add(lantern2);
        solids.add(lantern3);
        solids.add(lantern4);
        solids.add(lantern5);
        solids.add(lantern6);
        solids.add(lantern7);
        solids.add(lantern8);
         */
        solids.add(balk);
        solids.add(garden);
        solids.add(garden1);
        solids.add(garden3);
        solids.add(bush1);
        solids.add(bush2);
        solids.add(bush3);
        solids.add(tree);
        solids.add(tree2);
        solids.add(castlewall2);
        solids.add(castlewall1);
        solids.add(castlewall3);
        solids.add(wall);
        solids.add(wall1);
        solids.add(downwall);
        solids.add(downwall1);

        gameObjects.add(new Bush(game, 657, 540));
        gameObjects.add(new Bush(game, 673, 540));
        gameObjects.add(new Bush(game, 689, 540));
        gameObjects.add(new Bush(game, 721, 304));
        gameObjects.add(new Bush(game, 721, 320));
        gameObjects.add(new Bush(game, 705, 304));
        gameObjects.add(new Bush(game, 705, 320));
        gameObjects.add(new Bush(game, 284, 526));
        gameObjects.add(new Bush(game, 284, 542));
        gameObjects.add(new Bush(game, 289, 223));
        gameObjects.add(new Bush(game, 305, 223));

        gameObjects.add(new Bush(game, 881, 144));
        gameObjects.add(new Bush(game, 897, 144));
        gameObjects.add(new Bush(game, 913, 144));
        gameObjects.add(new Bush(game, 881, 160));
        gameObjects.add(new Bush(game, 881, 176));
        gameObjects.add(new Bush(game, 897, 176));
        gameObjects.add(new Bush(game, 913, 176));
        gameObjects.add(new Bush(game, 913, 160));
        gameObjects.add(new Bush(game, 895, 942));

        gameObjects.add(new Bush(game, 694, 941));
        gameObjects.add(new Bush(game, 710, 941));
        gameObjects.add(new Bush(game, 710, 957));
        gameObjects.add(new Bush(game, 694, 957));

        gameObjects.add(new Bush(game, 843, 503));
        gameObjects.add(new Bush(game, 843, 519));
        gameObjects.add(new Bush(game, 843, 535));

        gameObjects.add(new Bush(game, 652, 676));
        gameObjects.add(new Bush(game, 668, 676));
        gameObjects.add(new Bush(game, 684, 676));
        gameObjects.add(new Bush(game, 700, 676));
        gameObjects.add(new Bush(game, 716, 676));

        gameObjects.add(new Bush(game, 652, 692));
        gameObjects.add(new Bush(game, 668, 692));
        gameObjects.add(new Bush(game, 684, 692));
        gameObjects.add(new Bush(game, 700, 692));
        gameObjects.add(new Bush(game, 716, 692));

        gameObjects.add(game.getLink());
        gameObjects.add(new BlueSoldier(game, 502, 800, Direction.DOWN, 40));
        gameObjects.add(new BlueSoldier(game, 880, 228, Direction.DOWN, 75));
        gameObjects.add(new BlueSoldier(game, 477, 484, Direction.DOWN, 50));
        gameObjects.add(new BlueSoldier(game, 520, 484, Direction.DOWN, 50));
        gameObjects.add(new BlueSoldier(game, 236, 918, Direction.RIGHT, 50));

        gameObjects.add(new WhiteSoldier(game, 833, 710, Direction.LEFT));
        gameObjects.add(new WhiteSoldier(game, 622, 528, Direction.DOWN));
        gameObjects.add(new WhiteSoldier(game, 293, 293, Direction.DOWN));

        gameObjects.add(new Guard(game, 438, 715, Direction.LEFT));
        gameObjects.add(new Guard(game, 995, 636, Direction.RIGHT));
        gameObjects.add(new Guard(game, 995, 666, Direction.RIGHT));

        if (!game.getSong().equals("/sounds/overworld.mp3")) {
            game.stopMusic();
            game.playMusic("/sounds/overworld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {

        //throw new UnsupportedOperationException("Not supported yet.");
        if (exit == hatch) {
            game.setScene(new HiddenScene(game, "HyruleSceneHatch"));
        }
        if (exit == exitDown) {
            game.setScene(new HouseScene(game, "HyruleScene"));
        }
        if (exit == stairs) {
            game.setScene(new HiddenScene(game, "HyruleSceneStairs"));
        }
        if (exit == door) {
            game.setScene(new CastleScene(game, "HyruleScene"));
        }
        if (exit == forrestExit) {
            game.setScene(new ForrestScene(game, "HyruleScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {

        if (entrance.equals("HouseScene")) {
            moveScene(524, 623);

            game.getLink().setXHardCore(309);
            game.getLink().setYHardCore(349);
        }

        if (entrance.equals("HiddenScene")) {
            moveScene(463, 44);

            game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(200);
        }

        if (entrance.equals("ForrestScene3")) {
            moveScene(1, 623);

            game.getLink().setXHardCore(139);
            game.getLink().setYHardCore(341);
        }

        if (entrance.equals("CastleScene")) {
            moveScene(251, 88);

            game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(200);
        }
    }
}
