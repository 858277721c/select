# About
可以动态指定View选中和非选中的时候展示状态

## Gradle
`compile 'com.fanwe.android:select:1.0.6'`

## 简单Demo
![](http://thumbsnap.com/i/Usz4FkxC.gif?0825)<br>

1. xml布局
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical">

    <FrameLayout
        android:layout_width="50dp"
        android:layout_height="50dp">
        
        <TextView
            android:id="@+id/tv_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:gravity="center"
            android:text="标题"/>

        <View
            android:id="@+id/view_underline"
            android:layout_width="match_parent"
            android:layout_height="2dp"
            android:layout_gravity="bottom"/>
            
    </FrameLayout>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="onClickBtnChangeState"
        android:text="选中状态切换"/>

</LinearLayout>
```
2. 代码中设置选中和非选中的展示状态
```java
public class MainActivity extends AppCompatActivity
{
    private TextView mTvTitle;
    private View mViewUnderline;

    private SDSelectViewContainer mSelectViewContainer = new SDSelectViewContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mViewUnderline = findViewById(R.id.view_underline);

        mSelectViewContainer.config(mTvTitle) // 获得mTvTitle对应的config
                .setTextColorNormal(Color.parseColor("#616161")) // 正常字体颜色
                .setTextColorSelected(Color.parseColor("#f57c00")) // 选中字体颜色
                .setTextSizeNormal(40) // 正常字体大小
                .setTextSizeSelected(60) // 选中字体大小
                .setAlphaNormal(0.2f) // 正常透明度
                .setAlphaSelected(1.0f) // 选中透明度
                .setInvokeViewSelected(true) //设置选中状态变化的时候是否也触发View的setSelected方法，默认false
                .setSelected(false); //设置默认未选中

        mSelectViewContainer.config(mViewUnderline) // 获得mViewUnderline对应的config
                .setBackgroundColorSelected(Color.parseColor("#f57c00")) // 选中背景颜色
                .setVisibilityNormal(View.INVISIBLE) // 正常可见状态
                .setVisibilitySelected(View.VISIBLE) // 选中可见状态
                .setSelected(false); //设置默认未选中
    }

    public void onClickBtnChangeState(View view)
    {
        mSelectViewContainer.setSelected(!mTvTitle.isSelected()); //切换容器中所有View的选中状态
    }
}
```
## SDSelectViewConfig目前支持的配置
* textColor       
TextView字体颜色

* textSize        
TextView字体大小

* imageResId      
ImageView资源图片

* background      
View的背景，支持颜色，Drawable，或者图片资源id

* alpha           
View的透明度

* width           
View的宽度

* height          
View的高度

* visibility      
View的可见状态
