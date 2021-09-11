# 加油吧学霸君

本产品是为了解决市面上教育类app资源很丰富但资源的管理与筛选较为欠缺的问题和大部分教学平台缺少学习方法以及经验交流的功能的问题而设计出来的app

## 包含的功能点

- 登录/注册
- 主界面：主界面涉及五项功能：推荐、我的课程、我的笔记、个人中心、发布

- 点开的视频或笔记详细内容界面

## 效果图如下：

![登录注册](https://github.com/Ferguson-fang/AMap/blob/main/app/image/login.gif)

![主界面](https://github.com/Ferguson-fang/AMap/blob/main/app/image/home.gif)

![子项目](https://github.com/Ferguson-fang/AMap/blob/main/app/image/itemdetail.gif)

# 方法实现

### 基类BaseActivity和BaseFragment

```kotlin
/**
 * ClassName: BaseActivity
 * Description:所有Activity的基类
 * */

 abstract class BaseActivity : AppCompatActivity(),AnkoLogger/*继承AnkoLogger用于日至打印*/{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initListener()
        initData()

    }
    /**
     * 初始化数据
     * */
    open fun initData() {

    }
    /**
     * 与adapter和listener相关的操作
     * */
    open fun initListener() {

    }

    /**
     * 获取布局ID
     * */
    abstract fun getLayoutId(): Int
     
     
     /**
 * ClassName: BaseFragment
 * Description:所有Fragment的基类
 * */
abstract class BaseFragment : Fragment() ,AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    /**
     * 获取布局id
     * */
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    /**
     * 初始化数据
     * */
    open fun initData() {
    }

    /**
     * 与adapter和listener相关的操作
     * */
    open fun initListener() {

    }

    open fun init() {

    }
```

### Util类

*　下拉刷新

```kotlin
object UiRefreshUtil {
    /**
     * 下拉刷新
     *
     * @param offset 数据偏移量
     * @param size   返回数据的条目个数
     * @return url
     */
    fun <T>refreshItem(activity: FragmentActivity?,adapter: T,refreshId : SwipeRefreshLayout){
        refreshId.setColorSchemeResources(R.color.vpi__bright_foreground_holo_light)
        refreshId.setOnRefreshListener {
            thread {
                activity?.runOnUiThread {
                    Thread.sleep(2000)
                    refreshId.isRefreshing = false
                }
            }
        }
    }

    fun <T>refreshItem(activity: BaseActivity,adapter: T,refreshId : SwipeRefreshLayout){
        refreshId.setColorSchemeResources(R.color.vpi__bright_foreground_holo_light)
        refreshId.setOnRefreshListener {
            thread {
                activity?.runOnUiThread {
                    Thread.sleep(2000)
                    refreshId.isRefreshing = false
                }
            }
        }
    }

}
```

* 管理fragment的util类

  ```kotlin
  /**
   * 管理fragment的util类
   * */
  class FragmentUtil private constructor(){//私有化构造方法
      private val commendFragment by lazy { CommendFragment() }
      private val courseFragment by lazy { CourseFragment() }
      private val addFragment by lazy { AddFragment() }
      private val markdownFragment by lazy { MarkdownFragment() }
      private val mineFragment by lazy { MineFragment() }
      companion object{
      /**
       * 单例类
       * by lazy懒加载，创建时只创建一次
       * 且线程安全
       * */
          val fragmentUtil by lazy { FragmentUtil() }
      }
      /**
       * 根据tabid获取对应的fragment
       * */
      fun getFragment(tabId : Int) : BaseFragment?{
          when(tabId){
              R.id.tab_home -> return commendFragment
              R.id.tab_course -> return courseFragment
              R.id.tab_add -> return addFragment
              R.id.tab_markdown -> return markdownFragment
              R.id.tab_mine -> return mineFragment
          }
          return null
      }
  
  }
  ```

  

###　轮播图banner实现

在gradle中添加banner 依赖  （具体请参考 https://github.com/youth5201314/banner  ）

```
implementation 'com.youth.banner:banner:2.2.2'
```

布局xml中加入banner标签

```xml
<com.youth.banner.Banner
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="160dp" />
```

创建DataBean  （放数据的）



```kotlin
class DataBean {
    var imageRes: Int? = null
    var imageUrl: String? = null
    var title: String?
    var viewType: Int

constructor(imageRes: Int?, title: String?, viewType: Int) {
    this.imageRes = imageRes
    this.title = title
    this.viewType = viewType
}
 
constructor(imageUrl: String?, title: String?, viewType: Int) {
    this.imageUrl = imageUrl
    this.title = title
    this.viewType = viewType
}
 
companion object {
 
    //测试数据，如果图片链接失效请更换
    val testData3: List<DataBean>
        get() {
            val list: MutableList<DataBean> = ArrayList()
            list.add(
                DataBean(
                    "https://img.zcool.cn/community/013de756fb63036ac7257948747896.jpg",
                    null,
                    1
                )
            )
            list.add(
                DataBean(
                    "https://img.zcool.cn/community/01639a56fb62ff6ac725794891960d.jpg",
                    null,
                    1
                )
            )
            list.add(
                DataBean(
                    "https://img.zcool.cn/community/01270156fb62fd6ac72579485aa893.jpg",
                    null,
                    1
                )
            )
            list.add(
                DataBean(
                    "https://img.zcool.cn/community/01233056fb62fe32f875a9447400e1.jpg",
                    null,
                    1
                )
            )
            list.add(
                DataBean(
                    "https://img.zcool.cn/community/016a2256fb63006ac7257948f83349.jpg",
                    null,
                    1
                )
            )
            return list
        }
}
```

}

在activity代码中调用


        

```kotlin
 var banner:Banner<DataBean,BannerImageAdapter<DataBean>> = findViewById(R.id.banner)
 
 banner.setAdapter(object : BannerImageAdapter<DataBean>(DataBean.testData3) {
        override fun onBindView(holder: BannerImageHolder, data: DataBean, position: Int, size: Int) {
            //图片加载自己实现
            Glide.with(holder.itemView)
                .load(data.imageUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                .into(holder.imageView) } 
    }).addBannerLifecycleObserver(this).setIndicator(CircleIndicator(this))
```



### 视频播放器实现

在gradle中添加视频播放器 依赖 

```
implementation 'cn.jzvd:jiaozivideoplayer:7.5.0'
```

布局xml中加入banner标签

```xml
<cn.jzvd.JzvdStd
                android:id="@+id/video_item_content"
                android:layout_width="match_parent"
                android:layout_height="500dp"
                android:background="#000"/>
```

在activity中启动视频播放器

```kotlin
private fun initVideo(){
        val item = intent.getSerializableExtra("item") as ItemBean
        video_item_content.setUp("https://photovideo.photo.qq.com/1074_0b537xcaymia5eaenojuqbqtf7iebssaad2a.f0.mp4?dis_k=517b02ace59e07e88af02cad6c78fa9f&dis_t=1630990773&vuin=834929497"
            , item.title)
        video_item_content.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"))

    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
```





### 登录

判断用户登录是否成功

```kotlin
  lateinit var userViewModel : User
    lateinit var sp : SharedPreferences


private fun loginBtnListener(){
        phoneNumberLogin_loginBtn.setOnClickListener {
            if("" == phoneNumberLogin_phone.text.toString()
                || "" == phoneNumberLogin_password.text.toString()){
                Toast.makeText(this,"登入失败，用户名或密码为空",
                    Toast.LENGTH_SHORT).show()
            }else {
                if("19823690607" == phoneNumberLogin_phone.text.toString()
                    &&"160506" == phoneNumberLogin_password.text.toString()){
                    //用户名密码正确
                    userViewModel.count = phoneNumberLogin_phone.text.toString()
                    userViewModel.password = phoneNumberLogin_password.text.toString()
                    userViewModel.isLogin = true
                    userViewModel.isRemember = phoneNumberLogin_checkbox.isChecked

                    sp.edit{
                        putString("countReserved",userViewModel.count)
                        putString("passwordReserved",userViewModel.password)
                        putBoolean("isRememberReserved",userViewModel.isRemember)
                        putBoolean("isLoginReserved",userViewModel.isLogin)
                    }
                    finish()
                }else {
                    //用户名密码错误
                    Toast.makeText(this,"登入失败，用户不存在或密码不正确",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
```

# 待提升的地方

1. 除了后端跑路没得到数据接口以外，还有很多功能没有做出来，比如评论功能，还有拿到用户数据后怎么记录用户的点赞，关注和浏览记录等
2. 逃避了解决滑动冲突的问题，在发现使用了carouselview制作的轮播图与viewpager有滑动冲突后，只是简单的将carouselview换成了banner来解决问题
3. 没有解决在主界面启动一个新的activity后fragment会被注销的问题
4. 没有制作成功recycler view子item左滑出现删除选项的设计，改成了长按删除
5. 很多公共的方法没有抽象成一个类，导致每次重复写很多相同的代码（意识到的时候已经晚了）
6. 没有使用MVP或是MVVM架构
