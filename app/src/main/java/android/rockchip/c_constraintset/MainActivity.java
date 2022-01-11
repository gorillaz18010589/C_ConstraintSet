package android.rockchip.c_constraintset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout container;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move();
    }

    private void move() {
        container = findViewById(R.id.container);
        tvTest = findViewById(R.id.tvTest);
//        test(); //一般測試
        setMargin();
//        builderTest(); //builder測試


    }

    private void setMargin() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) tvTest.getLayoutParams();
        layoutParams.setMargins(dpToPx(0, this), dpToPx(600, this), 1200, 0);
        tvTest.setLayoutParams(layoutParams);
    }

    private void builderTest() {
        new ConstraintSetManager.Builder(container, R.id.tvTest)
                .cleanByConstructorId(ConstraintSet.TOP)
                .cleanByConstructorId(ConstraintSet.RIGHT)
                .connectByConstructorId(ConstraintSet.TOP, ConstraintSet.TOP)
                .connectByConstructorId(ConstraintSet.LEFT, ConstraintSet.LEFT)
                .applyTo()
                .builder();
    }

    private void test() {
        ConstraintSet textConstraintSet = new ConstraintSet();
        textConstraintSet.clone(container);
        //clean原本設定
        textConstraintSet.clear(R.id.tvTest, ConstraintSet.RIGHT);
        textConstraintSet.clear(R.id.tvTest, ConstraintSet.TOP);
        textConstraintSet.clear(R.id.tvTest);
        //移動到新的地方
        textConstraintSet.connect(R.id.tvTest, ConstraintSet.TOP, R.id.tvTest, ConstraintSet.TOP);
        textConstraintSet.connect(R.id.tvTest, ConstraintSet.LEFT, R.id.tvTest, ConstraintSet.LEFT);
        textConstraintSet.applyTo(container);
    }

    public int dpToPx(int dp, Context context) {

        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}