package com.example.assignment2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * 02/02/2017
 * Christopher Jones
 * i7467340
 * This class contains the drawing of the Netgrid, the scrambling of the grid and the GestureDetector needed for the user
 * to rotate the grid clockwise to complete the puzzle.
 * The game difficulty changes depending on what the integer 'gridSize' is and a message will appear when the player has completed the puzzle
 * successfully.
 */

public class GameView extends View {
    public static int gridSize = 5; // Default Grid Size == 5
    private final GestureDetector mGestureDetector;
    private NetwalkGrid netwalkGrid = new NetwalkGrid(gridSize, gridSize); // Netwalk Grid (5x5 by Default)
    int score; // Score integer
    //int highScore;
    Paint scorePaint = new Paint(); // Score Paint
    //Paint highScorePaint = new Paint(); // Highscore Paint

    public GameView(Context context) {
        super(context);
        init();
        mGestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void init() {
        int randomNumber;
        scorePaint.setColor(Color.WHITE);
        scorePaint.setStyle(Paint.Style.FILL);
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(80);

        //highScorePaint.setColor(Color.WHITE);
        //highScorePaint.setStyle(Paint.Style.FILL);
        //highScorePaint.setColor(Color.BLACK);
        //highScorePaint.setTextSize(80);


        for (int row = 0; row < gridSize; row++) { // Scrambling the grid
            for (int col = 0; col < gridSize; col++) {
                Random rand = new Random();
                randomNumber = rand.nextInt(4);
                for (int i = 0; i < randomNumber; i++) {
                    netwalkGrid.rotateRight(col, row); // Rotating each component right randomly
                }
            }
        }
    }

    public Bitmap getImage(int gridElement) {
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.err); //error image, if this appears a resource is missing.

        // Connected Servers - Single Pipes
        if (gridElement == 84) { // Connected Server - Up == 84
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.st);
            return bitmap;
        }
        if (gridElement == 81) { // Connected Server - Down == 81
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sb);
            return bitmap;
        }
        if (gridElement == 88) { // Connected Server - Left == 88
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sl);
            return bitmap;
        }
        if (gridElement == 82) { // Connected Server - Right == 82
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sr);
            return bitmap;
        }


        // Connected Servers - Straight Pipes
        if (gridElement == 85) { // Connected Server - Up, Down == 85
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stb);
            return bitmap;
        }
        if (gridElement == 90) { // Connected Server - Left, Right == 90
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.slr);
            return bitmap;
        }


        // Connected Pipes - Corner Pipes
        if (gridElement == 86) { // Connected Server - Up, Right == 86
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.str);
            return bitmap;
        }
        if (gridElement == 92) { // Connected Server - Up, Left == 92
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stl);
            return bitmap;
        }
        if (gridElement == 89) { // Connected Server - Down, Left == 89
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sbl);
            return bitmap;
        }
        if (gridElement == 83) { // Connected Server - Down, Right == 83
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sbr);
            return bitmap;
        }


        // Connected Pipes - Triple Pipes
        if (gridElement == 94) { // Server - Up, Left, Right == 94
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stlr);
            return bitmap;
        }
        if (gridElement == 93) { // Server - Up, Down, Left == 93
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stbl);
            return bitmap;
        }
        if (gridElement == 91) { // Server - Down, Left, Right == 91
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sblr);
            return bitmap;
        }
        if (gridElement == 87) { // Server - Up, Down, Right == 87
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stbr);
            return bitmap;
        }

        // Connected Pipes - Quadruple Pipes
        if (gridElement == 95) { // Server - Up, Down, Left, Right == 95
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.stblr);
            return bitmap;
        }


        // Connected Nodes
        if (gridElement == 100) { // Node - Up - Connected == 100
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.nct);
            return bitmap;
        }
        if (gridElement == 97) { // Node - Down - Connected == 97
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ncb);
            return bitmap;
        }
        if (gridElement == 104) { // Node - Left - Connected == 104
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ncl);
            return bitmap;
        }
        if (gridElement == 98) { // Node - Right - Connected == 98
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ncr);
            return bitmap;
        }


        // Unconnected Nodes
        if (gridElement == 36) { // Node - Up - Unconnected == 36
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.nut);
            return bitmap;
        }
        if (gridElement == 33) { // Node - Down - Unconnected == 33
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.nub);
            return bitmap;
        }
        if (gridElement == 40) { // Node - Left - Unconnected == 40
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.nlu);
            return bitmap;
        }
        if (gridElement == 34) { // Node - Right - Unconnected == 34
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.nur);
            return bitmap;
        }


        // Connected Straight Pipes
        if (gridElement == 69) { // Pipe - Vertical - Connected == 69
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.clr);
            return bitmap;
        }
        if (gridElement == 74) { // Pipe - Horizontal - Connected == 74
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctb);
            return bitmap;
        }


        // Unconnected Straight Pipes
        if (gridElement == 5) { // Pipe - Vertical - Unconnected == 5
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utb);
            return bitmap;
        }
        if (gridElement == 10) { // Pipe - Horizontal - Unconnected == 10
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ulr);
            return bitmap;
        }


        // Connected Corner Pipes
        if (gridElement == 70) { // CP - Up, Right - Connected == 70
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctr);
            return bitmap;
        }
        if (gridElement == 76) { // CP - Up Left - Connected == 76
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctl);
            return bitmap;
        }
        if (gridElement == 73) { // CP - Left, Down - Connected == 73
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cbl);
            return bitmap;
        }
        if (gridElement == 67) { // CP - Down, Right - Connected == 67
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cbr);
            return bitmap;
        }


        // Unconnected Corner Pipes
        if (gridElement == 6) { // CP - Up, Right - Unconnected == 6
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utr);
            return bitmap;
        }
        if (gridElement == 12) { // CP - Up, Left - Unconnected == 12
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utl);
            return bitmap;
        }
        if (gridElement == 9) { // CP - Down, Left - Unconnected == 9
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ubl);
            return bitmap;
        }
        if (gridElement == 3) { // CP - Down, Right - Unconnected == 3
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ubr);
            return bitmap;
        }


        // Connected Triple Pipes
        if (gridElement == 78) { // TP - Up, Left, Right - Connected == 78
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctlr);
            return bitmap;
        }
        if (gridElement == 77) { // TP - Up, Left, Down - Connected == 77
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctbl);
            return bitmap;
        }
        if (gridElement == 75) { // TP - Down, Left, Right - Connected == 75
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.cblr);
            return bitmap;
        }

        if (gridElement == 71) { // TP - Up, Down, Right - Connected == 71
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctbr);
            return bitmap;
        }

        // Unconnected Triple Pipes
        if (gridElement == 14) { // TP - Up, Left, Right - Unconnected == 14
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utlr);
            return bitmap;
        }
        if (gridElement == 13) { // TP - Up, Left, Down - Unconnected == 13
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utbl);
            return bitmap;
        }
        if (gridElement == 11) { // TP - Down, Left, Right - Unconnected == 11
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ublr);
            return bitmap;
        }
        if (gridElement == 7) { // TP - Up, Right, Down - Unconnected == 7
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utbr);
            return bitmap;
        }

        // Connected Quadruple Pipe
        if (gridElement == 79) { // Connected Top, Bottom, Left, Right == 79
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ctblr);
            return bitmap;
        }

        // Unconnected Quadruple Pipe
        if (gridElement == 15) { // Unconnected Top, Bottom, Left, Right == 15
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.utblr);
            return bitmap;
        }
        return bitmap;
    }


    public void onDraw(Canvas canvas) {
        float drawWidth = getWidth() / netwalkGrid.getRows();
        double x = (getWidth() * 0.05);
        double x1 = (getWidth());
        double y = (getHeight() * 0.95);
        canvas.drawText("Score: " + score, (int) x, (int) y, scorePaint);
        //canvas.drawText("High Score: " + highScore, (int) x, (int)y, highScorePaint);

        for (int drawRow = 0; drawRow < netwalkGrid.getRows(); drawRow++) {
            for (int drawCol = 0; drawCol < netwalkGrid.getColumns(); drawCol++) {
                int image = netwalkGrid.getGridElem(drawCol, drawRow); //Gets the generated grid element.
                System.out.println(); // Creates new line
                canvas.drawBitmap(getImage(image), null, new Rect(drawCol * (int) drawWidth, drawRow * (int) drawWidth, (drawCol + 1) *
                        (int) drawWidth, (drawRow + 1) * (int) drawWidth), null); // Draws out the bitmap
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int col;
            int row;

            float width = getWidth() / netwalkGrid.getColumns();
            col = x / (int) width;
            row = y / (int) width;

            if (row < netwalkGrid.getRows() && col < netwalkGrid.getColumns()) {
                netwalkGrid.rotateRight(col, row); // Rotates the object 90 degrees
                score++; // Increments the score integer every time the user touches a component
            }

            if (score > 70) {
                MainActivity.mediaPlayer3.start(); // Starts music
                MainActivity.mediaPlayer.stop(); // Stops existing music
            }

            if (netwalkGrid.endGame() && score < 71) {
                Toast.makeText(getContext(), "Game completed!\n" + "You completed the puzzle in " + score + " turns!", Toast.LENGTH_SHORT).show(); // Shows message indicating the player has completed the puzzle
                MainActivity.mediaPlayer1.start(); // Starts music
                MainActivity.mediaPlayer.stop(); // Stops music if running
                MainActivity.mediaPlayer3.stop(); // Stop music if running
            }
            invalidate();
            return true;
        }
    }

}