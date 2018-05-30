# About
可以动态指定View选中和非选中的时候展示状态

# Gradle
`implementation 'com.fanwe.android:select:1.2.0-rc1'`

# 简单Demo
![](http://thumbsnap.com/i/mYc3jx69.gif?0915)<br>

如果对自定义View的父类无要求可以直接继承FSelectView<br>
如果自定义View已经继承了别的View，则可以通过FSelectViewContainer来管理View的选中状态，具体见FSelectView内部实现<br>

1. 自定义View
```java
public class CustomTab extends FSelectView
{
    public CustomTab(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public TextView tv_title;
    public View view_underline;

    private void init()
    {
        setContentView(R.layout.view_custom_tab);
        tv_title = findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);
    }
}
```
2. 代码中设置选中和非选中的展示状态
```java
public class MainActivity extends AppCompatActivity
{
    private CustomTab mCustomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomTab = findViewById(R.id.view_tab);

        mCustomTab.config(mCustomTab.tv_title).configTextView(new SelectConfig.PropertiesIniter<TextViewProperties>()
        {
            @Override
            public void init(TextViewProperties normal, TextViewProperties selected)
            {
                normal.setTextColor(Color.parseColor("#616161"))
                        .setTextSize(40)
                        .setAlpha(0.2f);

                selected.setTextColor(Color.parseColor("#f57c00"))
                        .setTextSize(60)
                        .setAlpha(1.0f);
            }
        });

        mCustomTab.config(mCustomTab.view_underline).configView(new SelectConfig.PropertiesIniter<ViewProperties>()
        {
            @Override
            public void init(ViewProperties normal, ViewProperties selected)
            {
                normal.setVisibility(View.INVISIBLE);

                selected.setBackgroundColor(Color.parseColor("#f57c00"))
                        .setVisibility(View.VISIBLE);
            }
        });
        mCustomTab.config(mCustomTab).configView(new SelectConfig.PropertiesIniter<ViewProperties>()
        {
            @Override
            public void init(ViewProperties normal, ViewProperties selected)
            {
                normal.setWidth(150).setHeight(300);

                selected.setWidth(300);
            }
        });

        mCustomTab.setSelected(false);
    }

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
```
# 目前支持的配置
* textColor       
TextView字体颜色

* textSize        
TextView字体大小

* imageResId      
ImageView资源图片

* background
View的背景

* alpha           
View的透明度

* width           
View的宽度

* height          
View的高度

* visibility      
View的可见状态
