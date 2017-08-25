# Select
可以动态指定View选中和非选中的时候展示状态

## 简单Demo
![](http://thumbsnap.com/i/Usz4FkxC.gif?0825)<br>

1. 自定义view
```java
public class CustomTabView extends SDSelectViewAuto
{
    public TextView tv_title;
    public View view_underline;

    public CustomTabView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_custom_tab, this, true);
        tv_title = (TextView) findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);

        addAutoView(tv_title, view_underline); //设置根据选中状态变化的view
    }
}
```
2. 代码中设置选中和非选中的展示状态
```java
view_tab = (CustomTabView) findViewById(R.id.view_tab);
view_tab.getViewConfig(view_tab.tv_title) //获得tv_title对应的配置config
        .setTextColorNormal(Color.parseColor("#616161")) //正常字体颜色
        .setTextColorSelected(Color.parseColor("#f57c00")) //选中字体颜色

        .setTextSizeNormal(40) //正常字体大小
        .setTextSizeSelected(60) //选中字体大小

        .setAlphaNormal(0.2f) //正常透明度
        .setAlphaSelected(1.0f); //选中透明度

view_tab.getViewConfig(view_tab.view_underline) //获得view_underline对应的配置config
        .setBackgroundColorSelected(Color.parseColor("#f57c00")) //选中背景颜色

        .setVisibilityNormal(View.INVISIBLE) //正常可见状态
        .setVisibilitySelected(View.VISIBLE); //选中可见状态
        
view_tab.setSelected(false); //设置为未选中
```
## SDSelectViewConfig目前支持的配置
* textColor       
TextView字体颜色
* textSize        (TextView字体大小)
* imageResId      (ImageView资源图片)
* background      (View的背景，支持颜色，Drawable，或者图片资源id)
* alpha           (View的透明度)
* width           (View的宽度)
* height          (View的高度)
* visibility      (View的可见状态)
