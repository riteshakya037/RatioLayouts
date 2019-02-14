[ ![Download](https://api.bintray.com/packages/riteshakya037/maven/ratiolayout/images/download.svg) ](https://bintray.com/riteshakya037/maven/ratiolayout/_latestVersion)

# Depricated
With introduction of [ConstraintLayout](https://developer.android.com/training/constraint-layout/index.html) you don't have to write either a single line of code or use third-parties.

Here's the example of how to keep 1:1 aspect ratio for your layout using ConstraintLayout:

    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <View
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_marginEnd="0dp"
            android:layout_marginStart="0dp"
            android:layout_marginTop="0dp"
            android:background="@android:color/black"
            app:layout_constraintDimensionRatio="H,1:1"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">

       </View>

    </android.support.constraint.ConstraintLayout>


Ratio Layouts
==============================

<img src="screenshots/Header.png?raw=true" width="600" height="356">

A collection of `ViewGroups` which can have a constant width to height ratio.

Demo
===========================

[Ratio Layouts (APK)](sample/sample-debug.apk)

<img src="screenshots/FixedLayouts.png?raw=true" width="600" height="356">

Assign a ratio and never worry about your views looking out of propotions.


Installation
===============================

Gradle

```
dependencies {
    compile "com.ritesh:ratiolayout:${latestVersion}"
}
```

Usage
===========================

Define 'app' namespace on root view in your layout

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

Include this library in your layout
```
<com.ritesh.ratiolayout.RatioRelativeLayout
        android:id="@+id/activity_main_ratio_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:fixed_attribute="WIDTH"
        app:horizontal_ratio="1"
        app:vertical_ratio="1">
 ```
 
####  Supported Attributs

| XML Attribut        | Programmatical Getters           | Description  |
| ------------- |:-------------:| ---------:|
| app:fixed_attribute      | getFixedAttribute()     | Set one side of the layout as fixed, calculating the other based on this |
| app:horizontal_ratio      | getHorizontalRatio()     | Horizontal aspect ratio. |
| app:vertical_ratio      | getVerticalRatio()     | Vertical aspect ratio. |
        
####  Supported Layouts
 
* RatioFrameLayout
* RatioGridLayout
* RatioLinearLayout
* RatioRelativeLayout
* RatioTableLayout

####  Supported Java Setters
 
* setRatio(float horizontalRatio, float verticalRatio) - Sets ratios
* setRatio(FixedAttribute fixedAttribute, float horizontalRatio, float verticalRatio) - Sets ratios along with Fixed Side.
 
Contact me
===========================

If you have a better idea or way on this project, please let me know, thanks :)

[Email](mailto:riteshakya037@gmail.com)

License
===========================

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
