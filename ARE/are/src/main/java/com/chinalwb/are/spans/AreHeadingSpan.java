package com.chinalwb.are.spans;

import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;

/**
 * Semantic heading span for h1-h6.
 */
public class AreHeadingSpan extends RelativeSizeSpan implements ParagraphStyle {

    private static final float[] HEADING_SIZES = {
            1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1f,
    };

    private final int mLevel;

    public AreHeadingSpan(int level) {
        super(HEADING_SIZES[clampLevel(level) - 1]);
        mLevel = clampLevel(level);
    }

    public int getLevel() {
        return mLevel;
    }

    private static int clampLevel(int level) {
        if (level < 1) {
            return 1;
        }
        if (level > 6) {
            return 6;
        }
        return level;
    }
}
