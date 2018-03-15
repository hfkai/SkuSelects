package com.example.owner.skuselect.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.owner.skuselect.R;

public class ImageViewPlus extends ImageView {
    /**
     * android.widget.ImageView
     */
    public static final int TYPE_NONE = 0;
    /**
     * 圆形
     */
    public static final int TYPE_CIRCLE = 1;
    /**
     * 圆角矩形
     */
    public static final int TYPE_ROUNDED_RECT = 2;    
    
    private static final int DEFAULT_TYPE = TYPE_NONE;
    private static final int DEFAULT_BORDER_COLOR = Color.TRANSPARENT;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_RECT_ROUND_RADIUS = 0;
    
    private int mType;
    private int mBorderColor;
    private int mBorderWidth;
    private int mRectRoundRadius;
    
    private Paint mPaintBitmap = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaintBorder = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    private RectF mRectBorder = new RectF();
    private RectF mRectBitmap = new RectF();
    
    private Bitmap mRawBitmap;
    private BitmapShader mShader;
    private Matrix mMatrix = new Matrix();
    
    public ImageViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        //取xml文件中设定的参数
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ImageViewPlus);
        mType = ta.getInt(R.styleable.ImageViewPlus_type, DEFAULT_TYPE);
        mBorderColor = ta.getColor(R.styleable.ImageViewPlus_borderColor, DEFAULT_BORDER_COLOR);
        mBorderWidth = ta.getDimensionPixelSize(R.styleable.ImageViewPlus_borderWidths, dip2px(DEFAULT_BORDER_WIDTH));
        mRectRoundRadius = ta.getDimensionPixelSize(R.styleable.ImageViewPlus_rectRoundRadius, dip2px(DEFAULT_RECT_ROUND_RADIUS));
        ta.recycle();
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap rawBitmap = getBitmap(getDrawable());
        
        if (rawBitmap != null && mType != TYPE_NONE){
            int viewWidth = getWidth();
            int viewHeight = getHeight();
            int viewMinSize = Math.min(viewWidth, viewHeight);
            float dstWidth = mType == TYPE_CIRCLE ? viewMinSize : viewWidth;
            float dstHeight = mType == TYPE_CIRCLE ? viewMinSize : viewHeight;
            float halfBorderWidth = mBorderWidth / 2.0f;
            float doubleBorderWidth = mBorderWidth * 2;
            
            if (mShader == null || !rawBitmap.equals(mRawBitmap)){
                mRawBitmap = rawBitmap;
                mShader = new BitmapShader(mRawBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if (mShader != null){
                mMatrix.setScale((dstWidth - doubleBorderWidth) / rawBitmap.getWidth(), (dstHeight - doubleBorderWidth) / rawBitmap.getHeight());
                mShader.setLocalMatrix(mMatrix);
            }
            
            mPaintBitmap.setShader(mShader);
            mPaintBorder.setStyle(Paint.Style.STROKE);
            mPaintBorder.setStrokeWidth(mBorderWidth);
            mPaintBorder.setColor(mBorderWidth > 0 ? mBorderColor : Color.TRANSPARENT);
            
            if (mType == TYPE_CIRCLE){
                float radius = viewMinSize / 2.0f;
                canvas.drawCircle(radius, radius, radius - halfBorderWidth, mPaintBorder);
                canvas.translate(mBorderWidth, mBorderWidth);
                canvas.drawCircle(radius - mBorderWidth, radius - mBorderWidth, radius - mBorderWidth, mPaintBitmap);
            } else if (mType == TYPE_ROUNDED_RECT){
                mRectBorder.set(halfBorderWidth, halfBorderWidth, dstWidth - halfBorderWidth, dstHeight - halfBorderWidth);
                mRectBitmap.set(0.0f, 0.0f, dstWidth - doubleBorderWidth, dstHeight - doubleBorderWidth);
                float borderRadius = mRectRoundRadius - halfBorderWidth > 0.0f ? mRectRoundRadius - halfBorderWidth : 0.0f;
                float bitmapRadius = mRectRoundRadius - mBorderWidth > 0.0f ? mRectRoundRadius - mBorderWidth : 0.0f;
                canvas.drawRoundRect(mRectBorder, borderRadius, borderRadius, mPaintBorder);
                canvas.translate(mBorderWidth, mBorderWidth);
                canvas.drawRoundRect(mRectBitmap, bitmapRadius, bitmapRadius, mPaintBitmap);
            }
        } else {
            super.onDraw(canvas);
        }
    }

    private int dip2px(int dipVal)
    {
        float scale = getResources().getDisplayMetrics().density;
        return (int)(dipVal * scale + 0.5f);
    }
    
    private Bitmap getBitmap(Drawable drawable){
        if (drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        } else if (drawable instanceof ColorDrawable){
            Rect rect = drawable.getBounds();
            int width = rect.right - rect.left;
            int height = rect.bottom - rect.top;
            int color = ((ColorDrawable)drawable).getColor();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
            return bitmap;
        } else {
            return null;
        }
    }
}
