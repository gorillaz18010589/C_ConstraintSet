package android.rockchip.c_constraintset;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ConstraintSetManager {
    private ConstraintLayout cloneSet;
    private ConstraintSet mConstraintSet;
    private int id;

    public ConstraintSetManager(Builder builder) {
        this.cloneSet = builder.cloneSet;
        this.mConstraintSet = builder.mConstraintSet;
        this.id = builder.id;
    }

    public static class Builder {
        private ConstraintLayout cloneSet;
        private ConstraintSet mConstraintSet;
        private int id;

        public Builder(ConstraintLayout cloneSet, int id) {
            this.cloneSet = cloneSet;
            this.id = id;
            this.mConstraintSet = new ConstraintSet();
            this.mConstraintSet.clone(cloneSet);
            this.id = id;
        }

        public Builder clean(int viewId, int anchor) {
            mConstraintSet.clear(viewId, anchor);
            return this;
        }

        public Builder cleanByConstructorId(int anchor) {
            mConstraintSet.clear(this.id, anchor);
            return this;
        }

        public Builder connect(int startID, int startSide, int endID, int endSide) {
            mConstraintSet.connect(startID, startSide, endID, endSide);
            return this;
        }

        public Builder connectByConstructorId(int startSide, int endSide) {
            mConstraintSet.connect(this.id, startSide, this.id, endSide);
            return this;
        }

        public Builder applyTo() {
            mConstraintSet.applyTo(this.cloneSet);
            return this;
        }

        public ConstraintSetManager builder() {
            ConstraintSetManager constraintSetManager = new ConstraintSetManager(this);
            return constraintSetManager;
        }

    }
}
