package com.example.animationdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.animation.BounceInterpolator;
public class PropertyAnimation extends AppCompatActivity {

    ImageView Object;
    Button btStart, btStart2, btKeyFame, btMultiAnim, btInterpolation, btReset, btTypeEvaluate, btStateList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        Object=findViewById(R.id.Object1);
        Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Object was clicked!!",Toast.LENGTH_SHORT).show();
            }
        });
        btReset=findViewById(R.id.btReset);
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.setScaleX(1);
                Object.setScaleY(1);
                Object.setRotation(0);
                Object.setAlpha(1f);
                Object.setTranslationX(0);
                Object.setTranslationY(0);
                Object.setTranslationZ(0);
                Object.setRotationX(0);
                Object.setRotationY(0);
            }
        });
        //Value animator
        Add_ValueAnimator((View)(Object));
        //Object animator là 1 sub class của value animator
        SetObjectAnimator((View)(Object));
        //Kết hợp nhiều hiệu ứng
        MultiAnimator((View)(Object));
        // Property Animation được khai báo bằng file xml
        Add_XML_PropertyAnimation((View)(Object));
        // Sử dụng key frame
        Add_KeyFrames((View)(Object));
        //Sử dụng interpolation
        Add_Interpolation((View)(Object));
    }
    void Add_Interpolation(View Object) {
        btInterpolation=findViewById(R.id.btInterpolation);
        btInterpolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(Object, "translationX", 200f);
                // Có thể import nhiều thư viện của android.view.animation như BounceInterpolator như trong ví dụ hoặc
                // CycleInterpolator, DecelerateInterpolator, OvershootInterpolator, ... (https://www.geeksforgeeks.org/interpolator-in-android-with-example/)
                // Hoặc có thể custom 1 class như sau
//                import android.view.animation.Interpolator;
//
//                public class MyInterpolator implements Interpolator {
//                    public MyInterpolator() {
//                    }
//
//                    public float getInterpolation(float t) {
//                        float x = 2.0f * t - 1.0f;
//                        return 0.5f * (x * x * x + 1.0f);
//                    }
//                }
                animator.setInterpolator(new BounceInterpolator());
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"Animation Completed !!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
    void MultiAnimator(View Object) {
        btMultiAnim = findViewById(R.id.btMultiAnimator);
        btMultiAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator bounceAnim= ValueAnimator.ofFloat(0f,100f);
                bounceAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        float animatedValue = (float)updatedAnimation.getAnimatedValue();
                        bounceAnim.setTarget(Object);
                        Object.setTranslationX(animatedValue);
                    }
                });
                ValueAnimator squashAnim1= ValueAnimator.ofFloat(0f,100f);
                squashAnim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        float animatedValue = (float)updatedAnimation.getAnimatedValue();
                        squashAnim1.setTarget(Object);
                        Object.setTranslationY(animatedValue);
                    }
                });
                ValueAnimator squashAnim2= ValueAnimator.ofFloat(0.5f,2f);
                squashAnim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        float animatedValue = (float)updatedAnimation.getAnimatedValue();
                        squashAnim1.setTarget(Object);
                        Object.setScaleX(animatedValue);
                        Object.setScaleY(animatedValue);
                    }
                });

                AnimatorSet bouncer = new AnimatorSet();
                bouncer.play(bounceAnim).before(squashAnim1);
                bouncer.play(squashAnim1).with(squashAnim2);
                ValueAnimator fadeAnim = ObjectAnimator.ofFloat(Object, "alpha", 1f, 0f);
                fadeAnim.setDuration(250);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(bouncer).before(fadeAnim);

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"Animation Completed !!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                animatorSet.start();
            }
        });

    }
    void Add_ValueAnimator(View Object) {
        btStart=findViewById(R.id.btValueAnimator);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator animation = ValueAnimator.ofFloat(0f ,100f);
                animation.setDuration(3000);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        float animatedValue = (float)updatedAnimation.getAnimatedValue();
                        // Có thể thêm các thuộc tính cần thay đổi ở đây
                        Object.setTranslationX(animatedValue);
                        Object.setTranslationY(animatedValue);
                        // Đổ bóng
                        Object.setTranslationZ(animatedValue);
                        // Điều chỉnh opacity
                        Object.setTransitionAlpha(animatedValue*1.f/100.f);
                        // Xoay 1 vòng theo chiều dọc
                        //btObject.setRotationX(animatedValue*360.f/100.f);
                        // Xoay 1 vòng theo chiều ngang
                        // btObject.setRotationY(animatedValue*360.f/100.f);
                        //Xoay tính theo độ
                        Object.setRotation(animatedValue*360.f/100.f);
                        //Phóng to (Tính theo %)
//                        btObject.setScaleX(animatedValue*2f/100.f);
//                        btObject.setScaleY(animatedValue*2f/100.f);
                        //Pivot (tính theo %) (Xoay object xung quanh trục)
//                        btObject.setPivotX(animatedValue*1f/100);
//                        btObject.setPivotY(animatedValue*1f/100);
                        // Thay đổi trực tiếp toạ độ điểm
//                        btObject.setX(animatedValue);
//                        btObject.setY(animatedValue);
                    }

                });
                animation.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"Animation complete !!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                //Có thể cho biết lặp bao nhiêu lần ở đây
                //animation.setRepeatCount(ValueAnimator.INFINITE);

                //TODO:thêm mấy cái hiệu ứng đẹp hơn, thêm cái listener ở đây
                //Khởi động animation
                animation.start();
            }
        });
    }
    void Add_KeyFrames(View Object) {
        btKeyFame=findViewById(R.id.btKeyFrame);
        btKeyFame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
                Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
                Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
                PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
                ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(Object, pvhRotation);
                rotationAnim.setDuration(5000);
                rotationAnim.start();
            }
        });

    }
    void SetObjectAnimator(View Object) {
        btStart2=findViewById(R.id.btObjectAnimator);
        btStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animation;
                //Single property
                //animation= ObjectAnimator.ofFloat(btObject, "translationX", 100f);
                // Có thể kết hợp nhiều thay đổi thuộc tính
                PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 100f);
                PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat(View.ROTATION, 360.f);
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 120f);
                animation = ObjectAnimator.ofPropertyValuesHolder(Object, pvhX, pvhY, rotate);
                animation.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"Animation complete !!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Toast.makeText(getApplicationContext(),"Repeat", Toast.LENGTH_SHORT).show();
                    }
                });
                animation.setRepeatCount(2);
                animation.setDuration(2000);
                animation.start();
                //Hoặc có thể khai báo object như thế này, thay thế hoàn toàn những dòng ở trên
                // đơn giản nhưng không có các listener nên không thể cài đặt sau khi thực hiện animation sẽ như thế nào
                //btObject.animate().x(50f).y(100f);
            }
        });
    }
    void Add_XML_PropertyAnimation(View Object) {
        btStart2=findViewById(R.id.btStart3);
        btStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
                        getApplicationContext(), R.animator.move);

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float progress = (float) animation.getAnimatedValue();
                        // Thêm các thay đổi ở đây
                        Object.setTranslationX(progress);
                        Object.setTranslationY(progress);
                    }
                });
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(), "Animation completed !!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                valueAnimator.start();
            }
        });
    }
}