package com.darya.translator.Tools;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;


public class ActivityWithAnimation {

    public static final String ANIMATION_ITEM1 = "ITEM1";
    public static final String ANIMATION_ITEM2 = "ITEM2";
    public static final String ANIMATION_ITEM3 = "ITEM3";
    public static final String ANIMATION_ITEM4 = "ITEM4";
    public static final String ANIMATION_ITEM5 = "ITEM5";
    public static final String ANIMATION_ITEM6 = "ITEM6";
    public static final String ANIMATION_ITEM7 = "ITEM7";


    /// With TargetActivity
    public static final void set(Class<?> target, Context context, View view1) {
        Intent intent = new Intent(context, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Class<?> target, Context context, View view1, View view2) {
        Intent intent = new Intent(context, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Class<?> target, Context context, View view1, View view2, View view3) {
        Intent intent = new Intent(context, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Class<?> target, Context context, View view1, View view2, View view3, View view4) {
        Intent intent = new Intent(context, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3)
                    , new Pair<>(view4, ANIMATION_ITEM4));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Class<?> target, Context context, View view1, View view2, View view3, View view4, View view5) {
        Intent intent = new Intent(context, target);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3)
                    , new Pair<>(view4, ANIMATION_ITEM4)
                    , new Pair<>(view5, ANIMATION_ITEM5));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }


    /// With Intent

    public static final void set(Intent intent, Context context, View view1) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Intent intent, Context context, View view1, View view2) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Intent intent, Context context, View view1, View view2, View view3) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Intent intent, Context context, View view1, View view2, View view3, View view4) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3)
                    , new Pair<>(view4, ANIMATION_ITEM4));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static final void set(Intent intent, Context context, View view1, View view2, View view3, View view4, View view5) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(view1, ANIMATION_ITEM1)
                    , new Pair<>(view2, ANIMATION_ITEM2)
                    , new Pair<>(view3, ANIMATION_ITEM3)
                    , new Pair<>(view4, ANIMATION_ITEM4)
                    , new Pair<>(view5, ANIMATION_ITEM5));
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    //init View

    public static final void init(View view1) {
        ViewCompat.setTransitionName(view1, ANIMATION_ITEM1);
    }

    public static final void init(View view1, View view2) {
        ViewCompat.setTransitionName(view1, ANIMATION_ITEM1);
        ViewCompat.setTransitionName(view2, ANIMATION_ITEM2);
    }

    public static final void init(View view1, View view2, View view3) {
        ViewCompat.setTransitionName(view1, ANIMATION_ITEM1);
        ViewCompat.setTransitionName(view2, ANIMATION_ITEM2);
        ViewCompat.setTransitionName(view3, ANIMATION_ITEM3);
    }

    public static final void init(View view1, View view2, View view3, View view4) {
        ViewCompat.setTransitionName(view1, ANIMATION_ITEM1);
        ViewCompat.setTransitionName(view2, ANIMATION_ITEM2);
        ViewCompat.setTransitionName(view3, ANIMATION_ITEM3);
        ViewCompat.setTransitionName(view4, ANIMATION_ITEM4);
    }

    public static final void init(View view1, View view2, View view3, View view4, View view5) {
        ViewCompat.setTransitionName(view1, ANIMATION_ITEM1);
        ViewCompat.setTransitionName(view2, ANIMATION_ITEM2);
        ViewCompat.setTransitionName(view3, ANIMATION_ITEM3);
        ViewCompat.setTransitionName(view4, ANIMATION_ITEM4);
        ViewCompat.setTransitionName(view5, ANIMATION_ITEM5);
    }


}
