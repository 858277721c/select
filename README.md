# About
可以动态指定View选中和非选中的时候展示状态

## Gradle
[![](https://jitpack.io/v/zj565061763/select.svg)](https://jitpack.io/#zj565061763/select)

## 简单Demo
![](http://thumbsnap.com/i/mYc3jx69.gif?0915)<br>

如果对自定义View的父类无要求可以直接继承SDSelectView<br>
如果自定义View已经继承了别的View，则可以通过SDSelectViewContainer来管理View的选中状态，具体见SDSelectView内部实现<br>

1. 自定义View
```java
public class CustomTab extends SDSelectView
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
        tv_title = (TextView) findViewById(R.id.tv_title);
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
        mCustomTab = (CustomTab) findViewById(R.id.view_tab);

        mCustomTab.configText(mCustomTab.tv_title) // 获得对应的config
                .setTextColorNormal(Color.parseColor("#616161"))
                .setTextColorSelected(Color.parseColor("#f57c00"))
                .setTextSizeNormal(40)
                .setTextSizeSelected(60)
                .setAlphaNormal(0.2f)
                .setAlphaSelected(1.0f)
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab.view_underline) // 获得对应的config
                .setBackgroundColorSelected(Color.parseColor("#f57c00"))
                .setVisibilityNormal(View.INVISIBLE)
                .setVisibilitySelected(View.VISIBLE)
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab) // 获得对应的config
                .setWidthNormal(150)
                .setWidthSelected(300)
                .setHeightNormal(300)
                .setSelected(false); //设置默认未选中
    }

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
```
## 目前支持的配置
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
