package com.jeanbarrossilva.h2o.ui.component.chart.bar;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

// Provided from StackOverflow at https://stackoverflow.com/a/63110305/10252241.
public class RoundedBarChartRenderer extends BarChartRenderer {
    private float radius = 0f;

    public RoundedBarChartRenderer(
        BarDataProvider chart,
        ChartAnimator animator,
        ViewPortHandler viewPortHandler
    ) {
        super(chart, animator, viewPortHandler);
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
        Transformer trans = mChart.getTransformer(dataSet.getAxisDependency());
        mShadowPaint.setColor(dataSet.getBarShadowColor());

        float phaseX = mAnimator.getPhaseX();
        float phaseY = mAnimator.getPhaseY();

        if (mBarBuffers != null) {
            BarBuffer buffer = mBarBuffers[index];
            buffer.setPhases(phaseX, phaseY);
            buffer.setDataSet(index);
            buffer.setBarWidth(mChart.getBarData().getBarWidth());
            buffer.setInverted(mChart.isInverted(dataSet.getAxisDependency()));
            buffer.feed(dataSet);
            trans.pointValuesToPixel(buffer.buffer);

            int colorQuantity = dataSet.getColors().size();
            boolean hasMoreThanOneColor = colorQuantity > 1;
            boolean hasOnlyOneColor = colorQuantity == 1;

            if (hasMoreThanOneColor) {
                for (int j = 0; j < buffer.size(); j += 4) {
                    if (!mViewPortHandler.isInBoundsLeft(buffer.buffer[j + 2])) {
                        continue;
                    }

                    if (!mViewPortHandler.isInBoundsRight(buffer.buffer[j])) {
                        break;
                    }

                    if (mChart.isDrawBarShadowEnabled()) {
                        if (radius > 0) {
                            c.drawRoundRect(
                                new RectF(
                                    buffer.buffer[j],
                                    mViewPortHandler.contentTop(),
                                    buffer.buffer[j + 2],
                                    mViewPortHandler.contentBottom()
                                ),
                                radius,
                                radius,
                                mShadowPaint
                            );
                        } else {
                            c.drawRect(
                                buffer.buffer[j],
                                mViewPortHandler.contentTop(),
                                buffer.buffer[j + 2],
                                mViewPortHandler.contentBottom(),
                                mShadowPaint
                            );
                        }
                    }

                    mRenderPaint.setColor(dataSet.getColor(j / 4));
                    if (radius > 0) {
                        Path path = RoundedRect(
                            buffer.buffer[j],
                            buffer.buffer[j + 1],
                            buffer.buffer[j + 2],
                            buffer.buffer[j + 3],
                            15,
                            15,
                            true,
                            true,
                            false,
                            false
                        );
                        c.drawPath(path, mRenderPaint);
                    } else
                        c.drawRect(
                            buffer.buffer[j],
                            buffer.buffer[j + 1],
                            buffer.buffer[j + 2],
                            buffer.buffer[j + 3],
                            mRenderPaint
                        );
                }
            } else if (hasOnlyOneColor) {
                mRenderPaint.setColor(dataSet.getColor());

                for (int j = 0; j < buffer.size(); j += 4) {
                    if (!mViewPortHandler.isInBoundsLeft(buffer.buffer[j + 2])) {
                        continue;
                    }

                    if (!mViewPortHandler.isInBoundsRight(buffer.buffer[j])) {
                        break;
                    }

                    if (mChart.isDrawBarShadowEnabled()) {
                        if (radius > 0) {
                            c.drawRoundRect(
                                new RectF(
                                    buffer.buffer[j],
                                    mViewPortHandler.contentTop(),
                                    buffer.buffer[j + 2],
                                    mViewPortHandler.contentBottom()
                                ),
                                radius,
                                radius,
                                mShadowPaint
                            );
                        } else {
                            c.drawRect(
                                buffer.buffer[j],
                                buffer.buffer[j + 1],
                                buffer.buffer[j + 2],
                                buffer.buffer[j + 3],
                                mRenderPaint
                            );
                        }
                    }

                    if (radius > 0) {
                        Path path = RoundedRect(
                            buffer.buffer[j],
                            buffer.buffer[j + 1],
                            buffer.buffer[j + 2],
                            buffer.buffer[j + 3],
                            15,
                            15,
                            true,
                            true,
                            false,
                            false
                        );
                        c.drawPath(path, mRenderPaint);
                    } else {
                        c.drawRect(
                            buffer.buffer[j],
                            buffer.buffer[j + 1],
                            buffer.buffer[j + 2],
                            buffer.buffer[j + 3],
                            mRenderPaint
                        );
                    }
                }
            }
        }

    }

    public static Path RoundedRect(
        float left,
        float top,
        float right,
        float bottom,
        float rx,
        float ry,
        boolean tl,
        boolean tr,
        boolean br,
        boolean bl
    ) {
        Path path = new Path();
        float width = right - left;
        float height = bottom - top;

        if (rx < 0) {
            rx = 0;
        }

        if (ry < 0) {
            ry = 0;
        }

        if (rx > width / 2) {
            rx = width / 2;
        }

        if (ry > height / 2) {
            ry = height / 2;
        }

        float widthMinusCorners = (width - (2 * rx));
        float heightMinusCorners = (height - (2 * ry));

        path.moveTo(right, top + ry);

        if (tr) {
            path.rQuadTo(0, -ry, -rx, -ry);
        } else {
            path.rLineTo(0, -ry);
            path.rLineTo(-rx, 0);
        }

        path.rLineTo(-widthMinusCorners, 0);

        if (tl) {
            path.rQuadTo(-rx, 0, -rx, ry);
        } else {
            path.rLineTo(-rx, 0);
            path.rLineTo(0, ry);
        }

        path.rLineTo(0, heightMinusCorners);

        if (bl) {
            path.rQuadTo(0, ry, rx, ry);
        } else {
            path.rLineTo(0, ry);
            path.rLineTo(rx, 0);
        }

        path.rLineTo(widthMinusCorners, 0);

        if (br) {
            path.rQuadTo(rx, 0, rx, -ry);
        } else {
            path.rLineTo(rx, 0);
            path.rLineTo(0, -ry);
        }

        path.rLineTo(0, -heightMinusCorners);
        path.close();

        return path;
    }
}